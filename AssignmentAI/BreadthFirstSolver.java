package AssignmentAI;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class defines a simple queue-based breadth first solver.
 * 
 * @author Marcello
 */

public class BreadthFirstSolver extends AbstractSolver {
	private Queue<State> queue = new LinkedList<State>();

	protected void addState(State s) {
		if (!queue.contains(s))
			queue.offer(s);
	}
	
	protected boolean hasElements() {
		return !queue.isEmpty();
	}

	protected State nextState() {
		return queue.remove();
	}
	
	protected void clearOpen() {
		queue.clear();
	}

}
