
package com.au.example.inheritance.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for zoo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zoo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="animals" type="{http://model.inheritance.example.au.com}animal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="birds" type="{http://model.inheritance.example.au.com}bird" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dogs" type="{http://model.inheritance.example.au.com}dog" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="mammals" type="{http://model.inheritance.example.au.com}mammal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="parrots" type="{http://model.inheritance.example.au.com}parrot" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="penguins" type="{http://model.inheritance.example.au.com}penguin" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="whales" type="{http://model.inheritance.example.au.com}whale" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zoo", propOrder = {
    "animals",
    "birds",
    "dogs",
    "mammals",
    "parrots",
    "penguins",
    "whales"
})
public class Zoo {

    @XmlElement(nillable = true)
    protected List<Animal> animals;
    @XmlElement(nillable = true)
    protected List<Bird> birds;
    @XmlElement(nillable = true)
    protected List<Dog> dogs;
    @XmlElement(nillable = true)
    protected List<Mammal> mammals;
    @XmlElement(nillable = true)
    protected List<Parrot> parrots;
    @XmlElement(nillable = true)
    protected List<Penguin> penguins;
    @XmlElement(nillable = true)
    protected List<Whale> whales;

    /**
     * Gets the value of the animals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Animal }
     * 
     * 
     */
    public List<Animal> getAnimals() {
        if (animals == null) {
            animals = new ArrayList<Animal>();
        }
        return this.animals;
    }

    /**
     * Gets the value of the birds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bird }
     * 
     * 
     */
    public List<Bird> getBirds() {
        if (birds == null) {
            birds = new ArrayList<Bird>();
        }
        return this.birds;
    }

    /**
     * Gets the value of the dogs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dogs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDogs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dog }
     * 
     * 
     */
    public List<Dog> getDogs() {
        if (dogs == null) {
            dogs = new ArrayList<Dog>();
        }
        return this.dogs;
    }

    /**
     * Gets the value of the mammals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mammals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMammals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mammal }
     * 
     * 
     */
    public List<Mammal> getMammals() {
        if (mammals == null) {
            mammals = new ArrayList<Mammal>();
        }
        return this.mammals;
    }

    /**
     * Gets the value of the parrots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parrots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParrots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parrot }
     * 
     * 
     */
    public List<Parrot> getParrots() {
        if (parrots == null) {
            parrots = new ArrayList<Parrot>();
        }
        return this.parrots;
    }

    /**
     * Gets the value of the penguins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the penguins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPenguins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Penguin }
     * 
     * 
     */
    public List<Penguin> getPenguins() {
        if (penguins == null) {
            penguins = new ArrayList<Penguin>();
        }
        return this.penguins;
    }

    /**
     * Gets the value of the whales property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the whales property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWhales().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Whale }
     * 
     * 
     */
    public List<Whale> getWhales() {
        if (whales == null) {
            whales = new ArrayList<Whale>();
        }
        return this.whales;
    }

}
