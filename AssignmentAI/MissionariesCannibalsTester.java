package AssignmentAI;

import java.util.List;

public class MissionariesCannibalsTester {


private static void TestSolution(State initialState, AbstractSolver solver) {

System.out.println("Solving with " + solver);

List<State> solution = solver.solve(initialState);

System.out.println("Your outcome was "+solver.getVisitedStateCount());

System.out.println("Final Solution");

if (solution == null) {

System.out.println("There was no solution found ");

} else{

for (State answer : solution)

System.out.println("    "+answer);

}
}

private static void TestSolution(State initialState) {

TestSolution(initialState, new DepthFirstSolver());

TestSolution(initialState, new BreadthFirstSolver());

TestSolution(initialState, new BestFirstSolver());
}
public static void main(String[] args) {

TestSolution(new MissionariesCannibalsState());

}
}
