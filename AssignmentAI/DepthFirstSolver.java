package AssignmentAI;

import java.util.Stack;

/**
 * This class defines a simple stack-based depth-first solver.
 * 
 * @author Marcello
 */
public class DepthFirstSolver extends AbstractSolver {
	
	private Stack<State> stack = new Stack<State>();

	protected void addState(State s) {
		if (!stack.contains(s))
			stack.push(s);
	}

	protected boolean hasElements() {
		return !stack.empty();
	}

	protected State nextState() {
		return stack.pop();
	}
	
	protected void clearOpen(){
		stack.clear();
	}
}