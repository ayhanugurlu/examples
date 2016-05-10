package com.au.example.inheritance.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.example.inheritance.model.Animal;
import com.au.example.inheritance.model.Bird;
import com.au.example.inheritance.model.Dog;
import com.au.example.inheritance.model.DogHouse;
import com.au.example.inheritance.model.Mammal;
import com.au.example.inheritance.model.Parrot;
import com.au.example.inheritance.model.Penguin;
import com.au.example.inheritance.model.Whale;
import com.au.example.inheritance.model.Zoo;


/**
 * Restfull servis inheritance example
 * 
 * 
 * @author ayhanu
 *
 */
@Path("/restInheritance")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RestInheritance {


	/**
	 * Animal objesi @RestCustomMapper 
	 * annotade edilginden @Class ekler
	 * 
	 * 
	 * @return
	 */
	@GET
	@Path("getAnimal")
	public Animal getAnimal() {
		Animal animal  =  new Animal();
		animal.setColor("green");
		animal.setHabitat("home");
		animal.setKnowledge("test");
		animal.setName("hasan");
		animal.setTopSpeed(5d);		
		return animal;

	}
	
	/**
	 * Dog objesi @RestCustomMapper 
	 * annotade edilmediğinden @Class eklemez
	 * 
	 * 
	 * @return
	 */
	@GET
	@Path("getDog")
	public Dog getDog() {
		Dog dog = new Dog();
		dog.setColor("green");		
		dog.setHabitat("home");
		dog.setKnowledge("bird");
		dog.setName("bird name");
		dog.setTopSpeed(5d);
		dog.setBarksAlot("hav hav");		
		return dog;

	}
	
	/**
	 * DogHouse objesi @RestCustomMapper 
	 * annotade edilmediğinden @Class ekler içindeki objelerede ekler
	 * 
	 * 
	 * @return
	 */
	@GET
	@Path("getDogHouse")
	public DogHouse getDogHouse() {
		DogHouse dogHouse = new DogHouse();
		Dog dog = new Dog();
		dog.setColor("green");		
		dog.setHabitat("home");
		dog.setKnowledge("bird");
		dog.setName("bird name");
		dog.setTopSpeed(5d);
		dog.setBarksAlot("hav hav");
		dogHouse.setDog(dog);
		return dogHouse;

	}
	
	
	/**
	 * Animal objesi @RestCustomMapper eklense bile
	 * donen asıl obje Parrot olduğundan @class eklemez 
	 * 
	 * @return
	 */
	@GET
	@Path("getAnimalParrot")
	public Animal getAnimalParrot() {
		Animal animal = null;
		Parrot p = new Parrot();
		p.setColor("green");
		p.setFlying(true);
		p.setHabitat("home");
		p.setKnowledge("test");
		p.setName("hasan");
		p.setTopSpeed(5d);
		p.setVocabulary("turk");
		animal = p;
		return animal;

	}
	
	

	
	
	@GET
	@Path("getParrot")
	public Parrot getParrot() {

		Parrot p = new Parrot();
		p.setColor("green");
		p.setFlying(true);
		p.setHabitat("home");
		p.setKnowledge("test");
		p.setName("hasan");
		p.setTopSpeed(5d);
		p.setVocabulary("turk");
		return p;

	}
	
	
	

	@GET
	@Path("getBird")
	public Bird getBird() {

		Bird bird = new Bird();
		bird.setColor("green");
		bird.setFlying(true);
		bird.setHabitat("home");
		bird.setKnowledge("test");
		bird.setName("hasan");
		bird.setTopSpeed(5d);		
		return bird;
	}
	
	
	/**
	 * @Class ekler Zoo objesi işaretlendiğinden 
	 * tum alt classlarada eklenir.
	 * 
	 * @return
	 */
	@GET
	@Path("getZoo")
	public Zoo getZoo() {

		Zoo zoo = new Zoo();
		List<Animal> animals = new ArrayList<Animal>();
		Animal animal = new Animal();
		animal.setColor("green");		
		animal.setHabitat("home");
		animal.setKnowledge("animal");
		animal.setName("animal name");
		animal.setTopSpeed(5d);
		animals.add(animal);		
		zoo.setAnimals(animals);
		
		List<Bird> birds = new ArrayList<Bird>();
		Bird bird = new Bird();
		bird.setColor("green");
		bird.setFlying(true);
		bird.setHabitat("home");
		bird.setKnowledge("bird");
		bird.setName("bird name");
		bird.setTopSpeed(5d);
		birds.add(bird);		
		zoo.setBirds(birds);
		
		
		
		List<Dog> dogs = new ArrayList<Dog>();
		Dog dog = new Dog();
		dog.setColor("green");		
		dog.setHabitat("home");
		dog.setKnowledge("bird");
		dog.setName("bird name");
		dog.setTopSpeed(5d);
		dog.setBarksAlot("hav hav");
		dogs.add(dog);		
		zoo.setDogs(dogs);
		
		
		List<Mammal> mammals = new ArrayList<Mammal>();
		Mammal mammal = new Mammal();
		mammal.setColor("green");		
		mammal.setHabitat("home");
		mammal.setKnowledge("bird");
		mammal.setName("bird name");
		mammal.setTopSpeed(5d);		
		mammals.add(mammal);		
		zoo.setMammals(mammals);
		
		
		List<Parrot> parrots = new ArrayList<Parrot>();
		Parrot parrot = new Parrot();
		parrot.setColor("green");		
		parrot.setHabitat("home");
		parrot.setKnowledge("bird");
		parrot.setName("bird name");
		parrot.setTopSpeed(5d);
		parrot.setFlying(true);
		parrots.add(parrot);		
		zoo.setParrots(parrots);
		
		
		
		List<Penguin> penguins = new ArrayList<Penguin>();
		Penguin penguin = new Penguin();
		penguin.setColor("green");		
		penguin.setHabitat("home");
		penguin.setKnowledge("bird");
		penguin.setName("bird name");
		penguin.setTopSpeed(5d);
		penguin.setFlying(false);
		penguins.add(penguin);		
		zoo.setPenguins(penguins);
		
		
		List<Whale> whales = new ArrayList<Whale>();
		Whale whale = new Whale();
		whale.setColor("green");		
		whale.setHabitat("home");
		whale.setKnowledge("bird");
		whale.setName("bird name");
		whale.setTopSpeed(5d);		
		whales.add(whale);		
		zoo.setWhales(whales);
		return zoo;
	}
	

}
