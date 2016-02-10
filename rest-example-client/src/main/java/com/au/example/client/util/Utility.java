package com.au.example.client.util;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;

import com.au.example.client.util.filter.DtoClientRequestFilter;
import com.au.example.client.util.filter.DtoClientResponceFilter;
import com.au.example.client.util.filter.ExceptionResponceFilter;

public class Utility {
	
	

	public static <T> T createClient(Class<T> t, String url) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		DtoClientRequestFilter dtoClientRequestFilter = new DtoClientRequestFilter();
		DtoClientResponceFilter dtoClientResponceFilter = new DtoClientResponceFilter();
		client.register(dtoClientRequestFilter);
		client.register(dtoClientResponceFilter);
		ResteasyWebTarget target = client.target(url);		
		return target.proxy(t);
	}
	
	
	
	public static <T> T createClientExceptionFilter(Class<T> t, String url) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ExceptionResponceFilter exceptionResponceFilter = new ExceptionResponceFilter();		
		client.register(exceptionResponceFilter);		
		ResteasyWebTarget target = client.target(url);		
		return target.proxy(t);
	}

	public static <T> T createClienteTyped(Class<T> t, String url) {

		ResteasyJacksonProvider resteasyJacksonProvider = new ResteasyJacksonProvider();
		ObjectMapper mapper = new ObjectMapper();
		TypeResolverBuilder<?> typeResolver = new CustomTypeResolverBuilder();
		typeResolver.init(JsonTypeInfo.Id.CLASS, null);
		typeResolver.inclusion(JsonTypeInfo.As.PROPERTY);
		typeResolver.typeProperty("@CLASS");
		mapper.setDefaultTyping(typeResolver);

		mapper.configure(org.codehaus.jackson.JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
		resteasyJacksonProvider.setMapper(mapper);
		ResteasyClient client = new ResteasyClientBuilder().build();

		client.register(resteasyJacksonProvider);
		ResteasyWebTarget target = client.target(url);
		return target.proxy(t);
	}

	static class CustomTypeResolverBuilder extends ObjectMapper.DefaultTypeResolverBuilder {

		public CustomTypeResolverBuilder() {

			super(ObjectMapper.DefaultTyping.NON_FINAL);
		}

		@Override
		public boolean useForType(JavaType t) {

			return true;
		}
	}

}
