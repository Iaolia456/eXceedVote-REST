package com.github.ant2.exceedvote.dao.restful;

import java.util.List;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

public class RestDaoFactory implements DaoFactory{
	private EventDao eventDao;
	private VoterDao voterDao;
	private CriterionDao criterionDao;
	private ProjectDao projectDao;
	private BallotDao ballotDao;
	private UserDao userDao;

	public RestDaoFactory() {
		eventDao = new RestEventDao();
		voterDao = new RestVoterDao();
		criterionDao = new RestCriterionDao();
		projectDao = new RestProjectDao();
		ballotDao = new RestBallotDao();
		userDao = new RestUserDao();
	}

	private class RestEventDao implements EventDao {
		@Override
		public List<VoteEvent> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void save(VoteEvent newEvent) {
			// TODO Auto-generated method stub
			
		}
	}

	private class RestVoterDao implements VoterDao {
		@Override
		public List<Voter> findAllByEvent(VoteEvent event) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void save(Voter voter) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Voter find(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voter> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Voter findByUser(User u) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove(Voter voter) {
			// TODO Auto-generated method stub
			
		}
	}

	private class RestCriterionDao implements CriterionDao {
		@Override
		public void save(Criterion criterion) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Criterion> findAllByEvent(VoteEvent event) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove(Criterion criterion) {
			// TODO Auto-generated method stub
			
		}
	}

	private class RestProjectDao implements	ProjectDao {
		@Override
		public void save(Project project) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Project> findAllByEvent(VoteEvent event) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove(Project project) {
			// TODO Auto-generated method stub
			
		}
	}

	private class RestBallotDao implements BallotDao {
		@Override
		public List<Ballot> findAllByVoterAndCriterion(Voter voter,
				Criterion criterion) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void save(Ballot ballot) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove(Ballot ballot) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Ballot> findAllByEvent(VoteEvent event) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	private class RestUserDao implements UserDao {
		@Override
		public void save(User user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public User findByUserName(String user) {
			// TODO Auto-generated method stub
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

	@Override
	public UserDao getUserDao() {
		return userDao;
	}
}
