package com.github.ant2.exceedvote.dao.restful;

import java.util.List;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

public class RestDaoFactory implements DaoFactory{
	private EventDao eventDao;
	private VoterDao voterDao;
	private CriterionDao criterionDao;
	private ProjectDao projectDao;
	private BallotDao ballotDao;

	public RestDaoFactory() {
		eventDao = new RestEventDao();
		voterDao = new RestVoterDao();
		criterionDao = new RestCriterionDao();
		projectDao = new RestProjectDao();
		ballotDao = new RestBallotDao();
	}

	private class RestEventDao implements EventDao {
		@Override
		public List<VoteEvent> findAll() {
			return null;
		}

		@Override
		public void save(VoteEvent newEvent) {

		}
	}

	private class RestVoterDao implements VoterDao {
		@Override
		public List<Voter> findAllByEvent(VoteEvent event) {
			return null;
		}

		@Override
		public void save(Voter voter) {
			
		}

		@Override
		public Voter find(int id) {
			return null;
		}

		@Override
		public List<Voter> findAll() {
			return null;
		}

		@Override
		public void remove(Voter voter) {
			
		}
	}

	private class RestCriterionDao implements CriterionDao {
		@Override
		public void save(Criterion criterion) {
			
		}

		@Override
		public List<Criterion> findAllByEvent(VoteEvent event) {
			return null;
		}

		@Override
		public void remove(Criterion criterion) {
			
		}
	}

	private class RestProjectDao implements	ProjectDao {
		@Override
		public void save(Project project) {
			
		}

		@Override
		public List<Project> findAllByEvent(VoteEvent event) {
			return null;
		}

		@Override
		public void remove(Project project) {
			
		}
	}

	private class RestBallotDao implements BallotDao {
		@Override
		public List<Ballot> findAllByVoterAndCriterion(Voter voter,
				Criterion criterion) {
			return null;
		}

		@Override
		public void save(Ballot ballot) {
			
		}

		@Override
		public void remove(Ballot ballot) {
			
		}

		@Override
		public List<Ballot> findAllByEvent(VoteEvent event) {
			return null;
		}
	}

	@Override
	public EventDao getEventDao() {
		return eventDao;
	}

	@Override
	public VoterDao getVoterDao() {
		return voterDao;
	}

	@Override
	public CriterionDao getCriterionDao() {
		return criterionDao;
	}

	@Override
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	@Override
	public BallotDao getBallotDao() {
		return ballotDao;
	}
}
