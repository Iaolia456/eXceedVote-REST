package com.github.ant2.exceedvote.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A project which voter can vote for.
 * 
 * @author Artima Mahahemarat
 */

@XmlRootElement(name="contestant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project  {
	private int id;
	/** project name */
	private String name;
	/** project description */
	private String description;

	/**
	 * Constructs a project with name and description.
	 * 
	 * @param name
	 * @param description
	 */
	public Project(String name, String description) {
		this(name);
		setDescription(description);
	}

	public Project(String name) {
		this();
		setName(name);
	}

	public Project() {
	}

	/**
	 * Returns project name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns project description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets project name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets project description.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
