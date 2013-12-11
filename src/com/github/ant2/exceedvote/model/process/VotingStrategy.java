package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.model.domain.Project;

public interface VotingStrategy {
	public boolean canDecrease(Project project);
	public boolean canIncrease(Project project);
	
	public void update(int[] a, int usedBallots);
}
