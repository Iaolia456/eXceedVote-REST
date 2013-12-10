package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoteDao;
import com.github.ant2.exceedvote.model.domain.ContestantScore;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;

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
	public Map<Project, Integer> retrieve() {
		HashMap<Project, Integer> map = new HashMap<Project, Integer>();
		VoteDao ballotDao = context.getDaoFactory().getBallotDao();
		ProjectDao projectDao = context.getDaoFactory().getProjectDao();
		List<ContestantScore> score = ballotDao.findAllByCriterion(criterion).getVotedContestants();
		for (ContestantScore s : score) {
			map.put(projectDao.findById(s.getProjectId()), s.getScore());
		}
		return map;
	}
}
