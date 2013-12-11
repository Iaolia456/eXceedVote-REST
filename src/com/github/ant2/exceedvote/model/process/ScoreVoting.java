package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;

public class ScoreVoting implements VotingStrategy {

	private List<Project> projects;
	private int[] a;

	public ScoreVoting(List<Project> projects, int[] a) {
		this.projects = projects;
		this.a = a;
	}

	@Override
	public boolean canDecrease(Project project) {
		int i = projects.indexOf(project);
		return a[i] > 0;
	}

	@Override
	public boolean canIncrease(Project project) {
		int i = projects.indexOf(project);
		return a[i] < 10;
	}

	@Override
	public void update(int[] a, int usedBallot) {
		this.a = a;
	}
}
