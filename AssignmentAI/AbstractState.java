package AssignmentAI;

public abstract class AbstractState implements State {

	
	private State parent = null;
	private double distance = 0;
	
	public AbstractState() {
	}
	
	public AbstractState(State parent) {
		this.parent = parent;
		this.distance = parent.getDistance() + 1;
	}

	public State getParent() {
		return parent;
	}
	
	public double getDistance(){
		return distance;
	}

}