
package com.au.example.inheritance.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.au.example.inheritance.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Animal_QNAME = new QName("http://model.inheritance.example.au.com", "animal");
    private final static QName _Bird_QNAME = new QName("http://model.inheritance.example.au.com", "bird");
    private final static QName _Dog_QNAME = new QName("http://model.inheritance.example.au.com", "dog");
    private final static QName _DogHouse_QNAME = new QName("http://model.inheritance.example.au.com", "dogHouse");
    private final static QName _Mammal_QNAME = new QName("http://model.inheritance.example.au.com", "mammal");
    private final static QName _Parrot_QNAME = new QName("http://model.inheritance.example.au.com", "parrot");
    private final static QName _Penguin_QNAME = new QName("http://model.inheritance.example.au.com", "penguin");
    private final static QName _Whale_QNAME = new QName("http://model.inheritance.example.au.com", "whale");
    private final static QName _Zoo_QNAME = new QName("http://model.inheritance.example.au.com", "zoo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.au.example.inheritance.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Animal }
     * 
     */
    public Animal createAnimal() {
        return new Animal();
    }

    /**
     * Create an instance of {@link Bird }
     * 
     */
    public Bird createBird() {
        return new Bird();
    }

    /**
     * Create an instance of {@link Dog }
     * 
     */
    public Dog createDog() {
        return new Dog();
    }

    /**
     * Create an instance of {@link DogHouse }
     * 
     */
    public DogHouse createDogHouse() {
        return new DogHouse();
    }

    /**
     * Create an instance of {@link Mammal }
     * 
     */
    public Mammal createMammal() {
        return new Mammal();
    }

    /**
     * Create an instance of {@link Parrot }
     * 
     */
    public Parrot createParrot() {
        return new Parrot();
    }

    /**
     * Create an instance of {@link Penguin }
     * 
     */
    public Penguin createPenguin() {
        return new Penguin();
    }

    /**
     * Create an instance of {@link Whale }
     * 
     */
    public Whale createWhale() {
        return new Whale();
    }

    /**
     * Create an instance of {@link Zoo }
     * 
     */
    public Zoo createZoo() {
        return new Zoo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Animal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "animal")
    public JAXBElement<Animal> createAnimal(Animal value) {
        return new JAXBElement<Animal>(_Animal_QNAME, Animal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bird }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "bird")
    public JAXBElement<Bird> createBird(Bird value) {
        return new JAXBElement<Bird>(_Bird_QNAME, Bird.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Dog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "dog")
    public JAXBElement<Dog> createDog(Dog value) {
        return new JAXBElement<Dog>(_Dog_QNAME, Dog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DogHouse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "dogHouse")
    public JAXBElement<DogHouse> createDogHouse(DogHouse value) {
        return new JAXBElement<DogHouse>(_DogHouse_QNAME, DogHouse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mammal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "mammal")
    public JAXBElement<Mammal> createMammal(Mammal value) {
        return new JAXBElement<Mammal>(_Mammal_QNAME, Mammal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Parrot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "parrot")
    public JAXBElement<Parrot> createParrot(Parrot value) {
        return new JAXBElement<Parrot>(_Parrot_QNAME, Parrot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Penguin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "penguin")
    public JAXBElement<Penguin> createPenguin(Penguin value) {
        return new JAXBElement<Penguin>(_Penguin_QNAME, Penguin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Whale }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "whale")
    public JAXBElement<Whale> createWhale(Whale value) {
        return new JAXBElement<Whale>(_Whale_QNAME, Whale.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zoo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.inheritance.example.au.com", name = "zoo")
    public JAXBElement<Zoo> createZoo(Zoo value) {
        return new JAXBElement<Zoo>(_Zoo_QNAME, Zoo.class, null, value);
    }

}
