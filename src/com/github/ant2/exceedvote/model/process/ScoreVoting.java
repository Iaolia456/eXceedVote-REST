package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;

/**
 * The new method of voting
 * The voter must rank each contestant from score 1 to 10
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class ScoreVoting implements VotingStrategy {

	private List<Project> projects;
	private int[] a;

	public ScoreVoting(List<Project> projects, int[] a) {
		this.projects = projects;
		this.a = a;
	}

	/**
	 * See @VotingStrategy
	 */
	@Override
	public boolean canDecrease(Project project) {
		int i = projects.indexOf(project);
		return a[i] > 0;
	}
	
	/**
	 * See @VotingStrategy
	 */
	@Override
	public boolean canIncrease(Project project) {
		int i = projects.indexOf(project);
		return a[i] < 10;
	}

	/**
	 * See @VotingStrategy
	 */
	@Override
	public void update(int[] a, int usedBallot) {
		this.a = a;
	}
}
