package com.au.example.inheritance.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Zoo {
	
	private List<Animal> animals;
	
	private List<Bird> birds;
	
	private List<Dog> dogs;
	
	private List <Mammal> mammals;
	
	private List <Penguin> penguins;
	
	private List <Whale> whales;
	
	private List <Parrot> parrots;

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public List<Bird> getBirds() {
		return birds;
	}

	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public List<Mammal> getMammals() {
		return mammals;
	}

	public void setMammals(List<Mammal> mammals) {
		this.mammals = mammals;
	}

	public List<Penguin> getPenguins() {
		return penguins;
	}

	public void setPenguins(List<Penguin> penguins) {
		this.penguins = penguins;
	}

	public List<Whale> getWhales() {
		return whales;
	}

	public void setWhales(List<Whale> whales) {
		this.whales = whales;
	}

	public List<Parrot> getParrots() {
		return parrots;
	}

	public void setParrots(List<Parrot> parrots) {
		this.parrots = parrots;
	}
	
	
	
	

}
