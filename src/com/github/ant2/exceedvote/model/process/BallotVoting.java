package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Voter;

public class BallotVoting implements VotingStrategy {

	private List<Project> projects;
	private int[] a;
	private Voter voter;
	private int usedBallots;

	public BallotVoting(List<Project> projects, int[] a, Voter voter,
			int usedBallots) {
		this.projects = projects;
		this.a = a;
		this.voter = voter;
		this.usedBallots = usedBallots;
	}

	@Override
	public boolean canDecrease(Project project) {
		int i = projects.indexOf(project);
		return a[i] > 0;
	}

	@Override
	public boolean canIncrease(Project project) {
		return usedBallots < voter.getAllowedBallots();
	}

	@Override
	public void update(int[] a, int usedBallot) {
		this.a = a;
		this.usedBallots = usedBallot;
	}
}
