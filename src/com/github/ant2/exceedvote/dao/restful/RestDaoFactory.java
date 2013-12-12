package com.github.ant2.exceedvote.dao.restful;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoteDao;
import com.github.ant2.exceedvote.model.domain.ContestantScore;
import com.github.ant2.exceedvote.model.domain.Criteria;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.MyVote;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Vote;
import com.github.ant2.exceedvote.model.domain.VoteToSubmit;
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
			WebResource res = Messenger.createWebResource("exceedvote/api/v1/criterion");
			Criteria criteria = res.accept(MediaType.APPLICATION_XML).get( Criteria.class );
			System.out.println("criteria " + criteria);
			System.out.println("criteria list " + criteria.getCriteria());
			return criteria.getCriteria();
		}
	}

	private class RestProjectDao implements	ProjectDao {
		@Override
		public List<Project> findAll() {
			WebResource res = Messenger.createWebResource("exceedvote/api/v1/contestant");
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
		public List<Vote> findAllByCriterion(Criterion criterion) {
			WebResource res = Messenger.createWebResource("exceedvote/api/v1/myvote");
			//TODO cannot handle multiple <vote> in one file (when using /myvote)
			MyVote myVote = res.accept(MediaType.APPLICATION_XML).get(MyVote.class);
			//Vote votes = res.accept(MediaType.APPLICATION_XML).get(Vote.class);
			Vote vote = new Vote();
			List<Vote> matchedVote = new ArrayList<Vote>();
			for (Vote v : myVote.getVotes()) {
				if (v.getCriterion().getName().equals(criterion.getName())) {
					matchedVote.add(v);
				}
			}
			
			ContestantScore c = new ContestantScore();
			vote.setVotedContestant(c);
			//if(matchedVote.size() == 0) matchedVote.add(vote);
			return matchedVote;
		}

		@Override
		public void save(List<Vote> votes) {
			//TODO still use hacky string building, due to the emergency api change.
			/*StringBuilder builder = new StringBuilder();
			builder.append("<vote>");
			builder.append("<contestants>");
			
			for (Vote v : votes) {
				builder.append("<contestant>");
				builder.append("<id>"+v.getVotedContestant().getProjectId()+"</id>");
				builder.append("<score>"+v.getVotedContestant().getScore()+"</score>");
				builder.append("</contestant>");
			}
			
			builder.append("</contestants>");
			builder.append("</vote>");*/
			
			WebResource res = Messenger.createWebResource("exceedvote/api/v1/criterion/"+votes.get(0).getCriterion().getId()+"/vote");
			
			VoteToSubmit submitVote = new VoteToSubmit();
			submitVote.setVote(votes);
			ClientResponse resp = res.type(MediaType.APPLICATION_XML).post(ClientResponse.class, submitVote);
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
