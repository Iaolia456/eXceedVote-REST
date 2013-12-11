package com.github.ant2.exceedvote.dao.restful;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoteDao;
import com.github.ant2.exceedvote.model.domain.ContestantScore;
import com.github.ant2.exceedvote.model.domain.Contestants;
import com.github.ant2.exceedvote.model.domain.Criteria;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Question;
import com.github.ant2.exceedvote.model.domain.Vote;
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
			Criteria criteria = res.accept(MediaType.APPLICATION_XML).get( Criteria.class );
			System.out.println("criteria " + criteria);
			System.out.println("criteria list " + criteria.getCriteria());
			return criteria.getCriteria();
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
			
			Vote myVote = res.accept(MediaType.APPLICATION_XML).get(Vote.class);

			Question q = new Question();
			q.setId(criterion.getId());
			q.setName(criterion.getName());
			
			if(myVote.getQuestion().getName().equals(q.getName())) return myVote;
			Contestants c = new Contestants();
			c.setContestants(new ArrayList<ContestantScore>());
			myVote.setVotedContestants(c);
			return myVote;
		}

		@Override
		public void save(Vote vote) {
			System.out.println(vote.getQuestion().getId());
			WebResource res = Messenger.createWebResource("api/v1/criterion/"+vote.getQuestion().getId()+"/vote");
			
			//TODO vote submit marshal result test code
			JAXBContext jc;
			try {
				jc = JAXBContext.newInstance(Vote.class);
		        Marshaller mar = jc.createMarshaller();
		        mar.marshal(vote, System.out);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
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
