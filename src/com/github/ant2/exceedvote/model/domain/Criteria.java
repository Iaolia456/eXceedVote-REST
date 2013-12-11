package com.github.ant2.exceedvote.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="criteria")
@XmlAccessorType(XmlAccessType.FIELD)
public class Criteria {
	@XmlElement(name="criterion")
	private List<Criterion> criteria;
	
	public Criteria() {
		criteria = new ArrayList<Criterion>();
	}
	
	public List<Criterion> getCriteria() {
		return criteria;
	}
	
	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}
}
