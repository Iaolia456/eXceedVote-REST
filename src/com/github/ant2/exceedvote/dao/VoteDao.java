package com.github.ant2.exceedvote.dao;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Vote;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * The BallotDao class is responsible for retrieving and saving ballot objects
 * to persistent unit.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface VoteDao {

	/**
	 * Retrieves all ballots that the voter already voted for all project in
	 * specific criterion.
	 * 
	 * @param voter
	 *            the owner of the ballots
	 * @param criterion
	 *            criterion that need to retrieve the ballots
	 * @return list of all ballots of this voter that voted for all project in
	 *         this criterion
	 */
	Vote findAllByCriterion(Criterion criterion);

	/**
	 * Saves the ballot to persistent unit.
	 * 
	 * @param vote
	 *            the vote needs to be saved
	 */
	void save(Vote vote);

}
