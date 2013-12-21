package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * The old ballot voting method
 * The voter will have fixed amount of ballots and he/she will allocate
 * his/her ballot to each of contestants
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
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
		return usedBallots < voter.getAllowedBallots();
	}

	/**
	 * See @VotingStrategy
	 */
	@Override
	public void update(int[] a, int usedBallot) {
		this.a = a;
		this.usedBallots = usedBallot;
	}
}
