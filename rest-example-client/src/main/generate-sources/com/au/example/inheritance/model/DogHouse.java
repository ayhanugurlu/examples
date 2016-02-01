
package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dogHouse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dogHouse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://model.inheritance.example.au.com}dog" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dogHouse", propOrder = {
    "dog"
})
public class DogHouse {

    protected Dog dog;

    /**
     * Gets the value of the dog property.
     * 
     * @return
     *     possible object is
     *     {@link Dog }
     *     
     */
    public Dog getDog() {
        return dog;
    }

    /**
     * Sets the value of the dog property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dog }
     *     
     */
    public void setDog(Dog value) {
        this.dog = value;
    }

}
