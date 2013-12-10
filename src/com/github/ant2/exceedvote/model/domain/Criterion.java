package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A criterion which voter can vote for.
 * 
 * @author Artima Mahahemarat
 */

@XmlRootElement(name="criterion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Criterion {
	private int id;
	@XmlElement(name="question")
	private String name;
	private int type;

	/**
	 * Constructs a criterion.
	 */
	public Criterion() {
	}

	/**
	 * Returns criterion name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets criterion name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}
}
