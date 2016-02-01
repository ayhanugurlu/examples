/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.au.example.inheritance.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.au.example.inheritance.model.Animal;
import com.au.example.inheritance.model.Bird;
import com.au.example.inheritance.model.Dog;
import com.au.example.inheritance.model.DogHouse;
import com.au.example.inheritance.model.Parrot;
import com.au.example.inheritance.model.Zoo;

@Path("/restInheritance")
public interface RestInheritance {

    @GET
    @Produces("application/json")
    @Path("/getAnimal")
    Animal getAnimal();

    @GET
    @Produces("application/json")
    @Path("/getAnimalParrot")
    Animal getAnimalParrot();

    @GET
    @Produces("application/json")
    @Path("/getBird")
    Bird getBird();

    @GET
    @Produces("application/json")
    @Path("/getDog")
    Dog getDog();

    @GET
    @Produces("application/json")
    @Path("/getDogHouse")
    DogHouse getDogHouse();

    @GET
    @Produces("application/json")
    @Path("/getParrot")
    Parrot getParrot();

    @GET
    @Produces("application/json")
    @Path("/getZoo")
    Zoo getZoo();

}