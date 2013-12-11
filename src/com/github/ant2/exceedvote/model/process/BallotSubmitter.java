package com.github.ant2.exceedvote.model.process;

import java.util.Map;

import com.github.ant2.exceedvote.dao.VoteDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Question;
import com.github.ant2.exceedvote.model.domain.Vote;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A Ballot Submitter that submits the ballots for a certain criterion.
 * 
 * @author dtinth
 */
public class BallotSubmitter {

	private Criterion criterion;
	private Context context;

	/**
	 * Constructs a new BallotSubmitter
	 * 
	 * @param context
	 *            the context
	 * @param criterion
	 *            the criterion
	 */
	public BallotSubmitter(Context context, Criterion criterion) {
		this.context = context;
		this.criterion = criterion;
	}

	/**
	 * Submits the votes.
	 * 
	 * @param map
	 *            map from project to integer
	 */
	//TODO submit code here
	public void submit(Map<Project, Integer> map) {
		DaoFactory df = context.getDaoFactory();
		VoteDao ballotDao = df.getBallotDao();

		Voter voter = context.getVoter();
		Question q = new Question();
		q.setId(criterion.getId());
		q.setName(criterion.getName());

		Vote vote = new Vote();
		vote.setVote(1, q, voter, map);
		ballotDao.save(vote);
	}

}
