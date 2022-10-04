package AssignmentAI;

import java.util.HashSet;
import java.util.Set;
/**
 *  Jason Salazar
 * September 19, 2021 
 * CS 420 Artificial Intelligence
 */


public class MissionariesCannibalsState extends AbstractState {

enum Area {

	EAST {public Area getOpposite() {return WEST; } },

	WEST {public Area getOpposite() { return EAST; } };

	abstract public Area getOpposite();
}

private Area Cannibal1 = Area.EAST; private Area Cannibal2 = Area.EAST;
private Area Cannibal3 = Area.EAST; private Area Missionary1 = Area.EAST;
private Area Missionary2 = Area.EAST; private Area Missionary3 = Area.EAST;

// New default state where everyone starts on east side, also enabling a move state from a parent state

public MissionariesCannibalsState() {

}


public MissionariesCannibalsState(MissionariesCannibalsState parent,
Area Can1, Area Can2, Area Can3, Area Miss1, Area Miss2, Area Miss3) {
super(parent);

this.Cannibal1 = Can1; this.Cannibal2 = Can2;
this.Cannibal3 = Can3; this.Missionary1 = Miss1;
this.Missionary2 = Miss2; this.Missionary3 = Miss3;
}

 //Returns a set of all possible pathTaken from this state


@Override

public Iterable<State> getPossibleMoves() {

Set<State> pathTaken = new HashSet<State>();

// pathTaken displays the moves needed to complete the trip using getopposite


new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3, Missionary1, Missionary2.getOpposite(), Missionary3.getOpposite())
.safe(pathTaken); // Missionary2, Missionary3 

new MissionariesCannibalsState(this, Cannibal1.getOpposite(),
Cannibal2, Cannibal3, Missionary1.getOpposite(), Missionary2, Missionary3)
.safe(pathTaken); // Cannibal1, Missionary1

new MissionariesCannibalsState(this, Cannibal1.getOpposite(),
Cannibal3.getOpposite(), Cannibal2, Missionary1, Missionary2, Missionary3)
.safe(pathTaken);// Cannibal1, Cannibal3

new MissionariesCannibalsState(this, Cannibal1.getOpposite(),
Cannibal2, Cannibal3, Missionary1, Missionary2.getOpposite(), Missionary3)
.safe(pathTaken); // Cannibal1, Missionary2

new MissionariesCannibalsState(this, Cannibal1.getOpposite(),
Cannibal2, Cannibal3, Missionary1, Missionary2, Missionary3.getOpposite())
.safe(pathTaken); // Cannibal1, Missionary3

new MissionariesCannibalsState(this, Cannibal1.getOpposite(),
Cannibal2.getOpposite(), Cannibal3, Missionary1, Missionary2, Missionary3)
.safe(pathTaken);// Cannibal1, and Cannibal2

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2.getOpposite(), Cannibal3.getOpposite(), Missionary1, Missionary2, Missionary3)
.safe(pathTaken); // Cannibal2, Cannibal3

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2.getOpposite(), Cannibal3, Missionary1.getOpposite(), Missionary2, Missionary3)
.safe(pathTaken); // Cannibal2, Missionary1

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2.getOpposite(), Cannibal3, Missionary1, Missionary2.getOpposite(), Missionary3)
.safe(pathTaken); // Cannibal2,Missionary2

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2.getOpposite(), Cannibal3, Missionary1, Missionary2, Missionary3.getOpposite())
.safe(pathTaken);// Cannibal2, Missionary3

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3.getOpposite(), Missionary1.getOpposite(), Missionary2, Missionary3)
.safe(pathTaken); //Cannibal3, Missionary1

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3.getOpposite(), Missionary1, Missionary2.getOpposite(), Missionary3)
.safe(pathTaken); // Cannibal3, Missionary2

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3.getOpposite(), Missionary1, Missionary2, Missionary3.getOpposite())
.safe(pathTaken); // Cannibal3, Missionary3

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3, Missionary1.getOpposite(), Missionary2.getOpposite(), Missionary3)
.safe(pathTaken); // Missionary1,Missionary2

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3, Missionary1.getOpposite(), Missionary2, Missionary3.getOpposite())
.safe(pathTaken); // Missionary1, Missionary3

new MissionariesCannibalsState(this, Cannibal1.getOpposite(),
Cannibal2, Cannibal3, Missionary1, Missionary2, Missionary3)
.safe(pathTaken); // Cannibal1

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2.getOpposite(), Cannibal3, Missionary1, Missionary2, Missionary3)
.safe(pathTaken); // Cannibal2

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3.getOpposite(), Missionary1, Missionary2, Missionary3)
.safe(pathTaken);// Cannibal3

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3, Missionary1.getOpposite(), Missionary2, Missionary3)
.safe(pathTaken); // Missionary1

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3, Missionary1, Missionary2.getOpposite(), Missionary3)
.safe(pathTaken); // Missionary2

new MissionariesCannibalsState(this, Cannibal1,
Cannibal2, Cannibal3, Missionary1, Missionary2, Missionary3.getOpposite())
.safe(pathTaken); // Missionary3

return pathTaken;
}



private final void safe(Set<State> pathTaken) {

	// If Cannibals are more than Missionaries
	boolean unsafe= false;

	if((Cannibal1 != Cannibal2 || Cannibal1 != Cannibal3)) {
		if((Cannibal1 == Missionary1 && Cannibal1 == Missionary2 && Cannibal1 == Missionary3) || (Cannibal2 == Missionary1 && Cannibal2 == Missionary2 && Cannibal2 == Missionary3) ||
				(Cannibal3 == Missionary1 && Cannibal3 == Missionary2 && Cannibal3 == Missionary3)) {
			unsafe = true;
		} else {unsafe = false;}
		
	}
	// Cannibal1
	if((Cannibal1 != Cannibal2 && Cannibal1 != Cannibal3)) {
		if((Cannibal1 == Missionary1 && Cannibal1 == Missionary2) || (Cannibal1 == Missionary1 && Cannibal1 == Missionary3) || (Cannibal1 == Missionary2 && Cannibal1 == Missionary3)) {
			unsafe = true;
		} else {unsafe = false;}
		
	} 
	// Cannibal2
	if((Cannibal2 != Cannibal1 && Cannibal2 != Cannibal3)) {
		if((Cannibal2 == Missionary1 && Cannibal2 == Missionary2) || (Cannibal2 == Missionary1 && Cannibal2 == Missionary3) || (Cannibal2 == Missionary2 && Cannibal2 == Missionary2)) {
			unsafe = true;
		} else {unsafe = false;}
		
	} 
	// Cannibal3
	if((Cannibal3 != Cannibal1 && Cannibal3 != Cannibal2)) {
		if((Cannibal3 == Missionary1 && Cannibal3 == Missionary2) || (Cannibal3 == Missionary1 && Cannibal3 == Missionary3) || (Cannibal3 == Missionary2 && Cannibal3 == Missionary2)) {
			unsafe = true;
		} else {unsafe = false;}
		
	}

	if(!unsafe)
	pathTaken.add(this);
	}



//The solution is being checked for. It happens with everyone on the west side.

@Override
public boolean isSolution() {
return
Cannibal1==Area.WEST && Cannibal2==Area.WEST && Cannibal3==Area.WEST && Missionary1==Area.WEST && Missionary2==Area.WEST && Missionary3==Area.WEST;
}

public int hashCode() {
return (Cannibal1 == Area.EAST ? 1 : 0)+
(Cannibal2 == Area.EAST ? 1 : 0)+
(Cannibal3 == Area.EAST ? 1 : 0)+
(Missionary1 == Area.EAST ? 2 : 0)+
(Missionary2 == Area.EAST ? 2 : 0)+
(Missionary3 == Area.EAST ? 2 : 0);
}

// Checking both states equality

public boolean equals(Object i) {

	if (i==null || !(i instanceof MissionariesCannibalsState))

		return false;

	MissionariesCannibalsState equal = (MissionariesCannibalsState)i;

	return Cannibal1 == equal.Cannibal1 && Cannibal2 == equal.Cannibal2 &&	Cannibal3 == equal.Cannibal3 && Missionary1 == equal.Missionary1 && Missionary2 == equal.Missionary2 && Missionary3 == equal.Missionary3;
}


// Heuristic approximation of the number of pathTaken are required to complete the problem. 

@Override
public double getHeuristic() {
int h = 0;
if (Cannibal1 == Area.EAST) h++; if (Cannibal2 == Area.EAST) h++; if (Cannibal3 == Area.EAST) h++; if (Missionary1 == Area.EAST) h++; if (Missionary2 == Area.EAST) h++; if (Missionary3 == Area.EAST) h++;
return h;
}


public String toString() {
return 
(Cannibal1 == Area.EAST ? "Cannibal 1 " : " ")+
(Cannibal2 == Area.EAST ? "Cannibal 2 " : " ")+
(Cannibal3 == Area.EAST ? "Cannibal 3 " : " ")+
(Missionary1 == Area.EAST ? "Missionary 1 " : " ")+
(Missionary2 == Area.EAST ? "Missionary 2 " : " ")+
(Missionary3 == Area.EAST ? "Missionary 3 " : " ")+
          
(Cannibal1 == Area.WEST ? "Cannibal 1 " : " ")+
(Cannibal2 == Area.WEST ? "Cannibal 2 " : " ")+
(Cannibal3 == Area.WEST ? "Cannibal 3 " : " ")+
(Missionary1 == Area.WEST ? "Missionary 1 " : " ")+
(Missionary2 == Area.WEST ? "Missionary 2 " : " ")+
(Missionary3 == Area.WEST ? "Missionary 3 " : " ")+
           
           " (heuristics were "+getHeuristic()+")";
}
}
