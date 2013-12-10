package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Criterion;

/**
 * The CriterionDao class is responsible for saving a criterion and find all
 * criterion in the event
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface CriterionDao {
	/**
	 * Find all criterion that available in the specific event.
	 * 
	 * @param event
	 *            retrieve all criterion available for this event
	 * @return list of all criterion available for this event
	 */
	List<Criterion> findAll();
}
