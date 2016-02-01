
package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bird complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bird"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://model.inheritance.example.au.com}animal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flying" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bird", propOrder = {
    "flying"
})
@XmlSeeAlso({
    Parrot.class,
    Penguin.class
})
public class Bird
    extends Animal
{

    protected Boolean flying;

    /**
     * Gets the value of the flying property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlying() {
        return flying;
    }

    /**
     * Sets the value of the flying property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlying(Boolean value) {
        this.flying = value;
    }

}
