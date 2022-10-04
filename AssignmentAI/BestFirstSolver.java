package AssignmentAI;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class extends {@link BreadthFirstSolver} to add a heuristic-based
 * priority queue (instead of a vanilla queue).
 * 
 * @author Marcello
 */
 
// Calculate the f(x) for each state using the sum of distance
// and heuristic.

public class BestFirstSolver extends AbstractSolver {
	
	private PriorityQueue<State> queue = null;
	
	public BestFirstSolver() {
		queue = new PriorityQueue<State>(1,new Comparator<State>(){
			public int compare(State state1, State state2) {
				
				return Double.compare(state1.getDistance()+state1.getHeuristic(),
									  state2.getDistance()+state2.getHeuristic());
			}
		});
	}
	

	protected void addState(State states) {
		if (!queue.contains(states))
			queue.offer(states);
	}

	protected boolean hasElements() {
		return !queue.isEmpty();
	}

	protected State nextState() {
		return queue.remove();
	}
	
	protected void clearOpen(){
		queue.clear();
	}
}