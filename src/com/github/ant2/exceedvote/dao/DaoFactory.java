package com.github.ant2.exceedvote.dao;

/**
 * Factory class for get all other Dao class.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface DaoFactory {

	/**
	 * Returns the CriterionDao object.
	 * 
	 * @return CriterionDao object
	 */
	CriterionDao getCriterionDao();

	/**
	 * Returns the ProjectDao object.
	 * 
	 * @return ProjectDao object
	 */
	ProjectDao getProjectDao();

	/**
	 * Returns the BallotDao object.
	 * 
	 * @return BallotDao object
	 */
	VoteDao getBallotDao();

}
