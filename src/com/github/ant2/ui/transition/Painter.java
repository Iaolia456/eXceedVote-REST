package com.github.ant2.ui.transition;

import java.awt.Graphics2D;

/**
 * A Painter interface is used by Transitions so they can paint something onto
 * the graphics. It may be the view of before transition, or after transition,
 * or something else.
 * 
 * @author dtinth
 */
public interface Painter {

	/**
	 * Paints itself into the graphics.
	 * 
	 * @param g
	 *            the graphics to paint into.
	 */
	void paint(Graphics2D g);

}
