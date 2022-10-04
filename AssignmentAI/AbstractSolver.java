package AssignmentAI;

	import java.lang.Iterable;
	import java.util.Set;
	import java.util.HashSet;
	import java.util.List;
	import java.util.LinkedList;

	/**
	 * This class implements Solver and provides functionality for automating state
	 * solving using a generic iterable interface.  The closed set is handled
	 * implicitly (defined as a HashSet), so states need to define a valid 
	 * hashCode() and equals() function for this solver to function correctly.
	 *  
	 * @author Marcello
	 */
	public abstract class AbstractSolver implements Solver {

		
		private Set<State> closed = new HashSet<State>();

		public List<State> solve(State initialState) {
			// Reset closed set
			closed.clear();
			clearOpen();
			addState(initialState);
			while (hasElements()) {
				State s = nextState();
				if (s.isSolution())
					return findPath(s);
				closed.add(s);
				Iterable<State> moves = s.getPossibleMoves();
				for (State move : moves)
					if (!closed.contains(move))
						addState(move);
			}
			return null;
		}

		public int getVisitedStateCount() {
			return closed.size();
		}

		private List<State> findPath(State solution) {
			LinkedList<State> path = new LinkedList<State>();
			while (solution != null) {
				path.addFirst(solution);
				solution = solution.getParent();
			}
			return path;
		}

		protected abstract boolean hasElements();

		protected abstract State nextState();

		protected abstract void addState(State s);
		
		protected abstract void clearOpen();

	}

