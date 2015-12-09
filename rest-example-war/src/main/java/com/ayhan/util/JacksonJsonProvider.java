package com.ayhan.util;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper defaultMapper;

    private final ObjectMapper specializedMapper;

    public JacksonJsonProvider() {

	defaultMapper = createDefaultMapper();
	specializedMapper = createSpecializedMapper();
    }

    private static ObjectMapper createDefaultMapper() {

	return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS).configure(JsonParser.Feature.ALLOW_COMMENTS, true)
		.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
		.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private static ObjectMapper createSpecializedMapper() {

	ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS).configure(JsonParser.Feature.ALLOW_COMMENTS, true)
		.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
		.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	TypeResolverBuilder<?> typeResolver = new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.NON_FINAL) {

	    @Override
	    public boolean useForType(JavaType t) {

		return true;
	    }
	};
	typeResolver.init(JsonTypeInfo.Id.CLASS, null);
	typeResolver.inclusion(JsonTypeInfo.As.PROPERTY);
	typeResolver.typeProperty("@CLASS");
	objectMapper.setDefaultTyping(typeResolver);
	objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	return objectMapper;
    }

    public ObjectMapper getContext(Class<?> objectType) {

	if (objectType.getAnnotation(RestCustomMapper.class) != null) {
	    return specializedMapper;
	} else {
	    return defaultMapper;
	}
    }
}