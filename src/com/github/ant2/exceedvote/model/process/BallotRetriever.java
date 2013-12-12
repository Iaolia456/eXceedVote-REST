package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.ant2.exceedvote.dao.VoteDao;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Vote;

/**
 * BallotRetriever retrieves the ballot count from the database, makes it easier
 * to use by a client.
 * 
 * @author dtinth
 */
public class BallotRetriever {

	private Context context;
	private Criterion criterion;

	/**
	 * Constructs a new BallotRetriever
	 * 
	 * @param context
	 *            the context
	 * @param criterion
	 *            the criterion
	 */
	public BallotRetriever(Context context, Criterion criterion) {
		this.context = context;
		this.criterion = criterion;
	}

	/**
	 * Retrieves the map of ballot from project -> ballot.
	 * 
	 * @return the map
	 */
	public Map<Integer, Integer> retrieve() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		VoteDao ballotDao = context.getDaoFactory().getBallotDao();
		List<Vote> vote = ballotDao.findAllByCriterion(criterion);
		for (Vote v : vote) {
			map.put(v.getVotedContestant().getProjectId(), v.getVotedContestant().getScore());
		}
		return map;
	}
}
