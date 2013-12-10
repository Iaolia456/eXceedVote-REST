package com.github.ant2.exceedvote.dao.restful;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.github.ant2.exceedvote.dao.*;
import com.github.ant2.exceedvote.model.domain.*;
import com.github.ant2.exceedvote.model.server.Messenger;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class RestDaoFactory implements DaoFactory{
	private CriterionDao criterionDao;
	private ProjectDao projectDao;
	private VoteDao ballotDao;

	public RestDaoFactory() {
		criterionDao = new RestCriterionDao();
		projectDao = new RestProjectDao();
		ballotDao = new RestVoteDao();
	}

	private class RestCriterionDao implements CriterionDao {
		@Override
		public List<Criterion> findAll() {
			WebResource res = Messenger.createWebResource("api/v1/criterion");
			List<Criterion> criteria = res.accept(MediaType.APPLICATION_XML).get( new GenericType<List<Criterion>>() { });
			return criteria;
		}
	}

	private class RestProjectDao implements	ProjectDao {
		@Override
		public List<Project> findAll() {
			WebResource res = Messenger.createWebResource("api/v1/contestant");
			List<Project> projects = res.accept(MediaType.APPLICATION_XML).get( new GenericType<List<Project>>() { });
			return projects;
		}
		
		@Override
		public Project findById(int id) {
			List<Project> projects = findAll();
			for (Project p : projects) {
				if (p.getId() == id) return p;
			}
			return null;
		}
	}

	private class RestVoteDao implements VoteDao {
		@Override
		public Vote findAllByCriterion(Criterion criterion) {
			WebResource res = Messenger.createWebResource("api/v1/myvote/1");
			MyVote myVote = res.accept(MediaType.APPLICATION_XML).get(MyVote.class);
			for (Vote v : myVote.getVotes()) {
				if(v.getCriterion() == criterion) return v;
			}
			return null;
		}

		@Override
		public void save(Vote vote) {
			WebResource res = Messenger.createWebResource("api/v1/criterion/"+vote.getCriterion().getId()+"/vote");
			ClientResponse resp = res.type(MediaType.APPLICATION_XML).post(ClientResponse.class, vote);
			System.out.println("casted vote, server return: " + resp.getStatus());
		}
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
	public VoteDao getBallotDao() {
		return ballotDao;
	}
}
