package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;

/**
 * The ProjectDao responsible for save and retrieve project to persistent unit.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface ProjectDao {
	/**
	 * Returns all project available in the specific event
	 * 
	 * @param event
	 *            the event that projects are belonging
	 * @return list of all projects available in this event
	 */
	List<Project> findAll();

	/**
	 * Returns project with matched id
	 * @param id project id
	 * @return project with id (id)
	 */
	Project findById(int id);
}
