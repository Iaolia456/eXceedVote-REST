package com.github.ant2.exceedvote.dao.restful;

import java.util.ArrayList;
import java.util.List;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CommissionerDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Model;
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
	private CommissionerDao commissionDao;

	public RestDaoFactory() {
		eventDao = new RestEventDao();
		voterDao = new RestVoterDao();
		criterionDao = new RestCriterionDao();
		projectDao = new RestProjectDao();
		ballotDao = new RestBallotDao();
		userDao = new RestUserDao();
		commissionDao = new RestCommissionerDao();
	}

	private class RestDao<T extends Model> {
		protected String URL = "";
		protected int PORT = 8000;

		public void save(T t) {

		}

		public List<T> findAll() {
			return new ArrayList<T>();
		}

		public T find(int id) {
			return null;
		}

		public void remove(T t) {

		}
	}

	private class VoteEventPartDao<T extends Model & VoteEvent.Part> extends
	RestDao<T> {
		public List<T> findAllByEvent(VoteEvent event) {
			List<T> list = new ArrayList<T>();
			for (T t : findAll()) {
				if (t.getVoteEvent().equals(event)) {
					list.add(t);
				}
			}
			return list;
		}
	}

	private class RestEventDao extends RestDao<VoteEvent> implements EventDao {

	}

	private class RestVoterDao extends RestDao<Voter> implements VoterDao {
		@Override
		public List<Voter> findAllByEvent(VoteEvent event) {
			return null;
		}

		@Override
		public Voter findByUser(User u) {
			return null;
		}

	}

	private class RestCriterionDao extends VoteEventPartDao<Criterion>
	implements CriterionDao {
	}

	private class RestProjectDao extends VoteEventPartDao<Project> implements
	ProjectDao {
	}

	private class RestBallotDao extends RestDao<Ballot> implements
	BallotDao {

		@Override
		public List<Ballot> findAllByVoterAndCriterion(Voter voter,
				Criterion criterion) {
			List<Ballot> list = new ArrayList<Ballot>();
			for (Ballot ballot : findAll()) {
				if (ballot.getVoter().equals(voter)
						&& ballot.getCriterion().equals(criterion)) {
					list.add(ballot);
				}
			}
			return list;
		}

		@Override
		public List<Ballot> findAllByEvent(VoteEvent event) {
			List<Ballot> list = new ArrayList<Ballot>();
			for (Ballot ballot : findAll()) {
				if (ballot.getCriterion().getVoteEvent() == event) {
					list.add(ballot);
				}
			}
			return list;
		}
	}

	private class RestUserDao extends RestDao<User> implements UserDao {
		@Override
		public User findByUserName(String user) {
			for (User u : findAll()) {
				if (u.getUsername().equals(user)) return u;
			}
			return null;
		}

	}

	private class RestCommissionerDao extends RestDao<Commissioner>
	implements CommissionerDao {
		@Override
		public Commissioner findByUser(User user) {
			for (Commissioner c : findAll()) {
				if (c.getUser() == user) return c;
			}
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

	@Override
	public CommissionerDao getCommissionerDao() {
		return commissionDao;
	}

}
