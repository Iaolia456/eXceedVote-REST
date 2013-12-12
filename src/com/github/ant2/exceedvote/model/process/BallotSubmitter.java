package com.github.ant2.exceedvote.model.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.VoteDao;
import com.github.ant2.exceedvote.model.domain.ContestantScore;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
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
		Criterion q = new Criterion();
		q.setId(criterion.getId());
		q.setName(criterion.getName());
		
		Set<Project> p = map.keySet();
		Project[] projects = p.toArray(new Project[map.size()]);
		List<Vote> votes = new ArrayList<Vote>();
		for (int i=0; i<map.size(); i++) {
			Vote vote = new Vote();
			ContestantScore score = new ContestantScore();
			score.setProjectId(projects[i].getId());
			score.setName(projects[i].getName());
			score.setScore(map.get(projects[i]).intValue());
			
			vote.setVote(1, q, voter, score);
			votes.add(vote);
		}
		
		ballotDao.save(votes);
	}

}
