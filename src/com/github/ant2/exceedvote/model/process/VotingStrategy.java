package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.model.domain.Project;

/**
 * A strategy for voting
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public interface VotingStrategy {
	
	/**
	 * Check whether the score on selected project can be deducted or not
	 * @return true if the score can be deduct, false otherwise
	 */
	public boolean canDecrease(Project project);
	
	/**
	 * Check whether the score on selected project can be increase or not
	 * @return true if the score can be increase, false otherwise
	 */
	public boolean canIncrease(Project project);
	
	/**
	 * Update the current casted vote and used ballots
	 */
	public void update(int[] a, int usedBallots);
}
