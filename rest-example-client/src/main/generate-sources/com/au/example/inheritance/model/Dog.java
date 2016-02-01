
package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://model.inheritance.example.au.com}mammal"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="barksAlot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dog", propOrder = {
    "barksAlot"
})
public class Dog
    extends Mammal
{

    protected String barksAlot;

    /**
     * Gets the value of the barksAlot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarksAlot() {
        return barksAlot;
    }

    /**
     * Sets the value of the barksAlot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarksAlot(String value) {
        this.barksAlot = value;
    }

}
