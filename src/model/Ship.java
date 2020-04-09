package model;
import java.util.*;

public class Ship{

//Ship constants
private final static boolean LEAVES=true;
private final static boolean STAYS=false;
private final static int MIN_WEIGHT=12000;
private final static int MIN_CARGOS=2;

//Ship attributes
private ArrayList<Trip> trips;

//Constructor
 /** Constructor method for ship <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a ship and initializes an array list of Trips<br>
	*/
public Ship(){
trips= new ArrayList<Trip>();
}

//Operational methods
 /** Method for adding trips <br>
	<b> pre: </b> <br>
	<b> post: </b> adds trip to the arraylist of trips <br>
	@param trip, a Trip object that has been created 
	*/
public void addTrip(Trip trip){
trips.add(trip);
}

 /** Method for verifying if the ship can travel <br>
	<b> pre: </b> <br>
	<b> post: </b> Verifies if the ship can travel or not<br>
	@return a boolean that indicates whether the ship can travel or not
	*/
public boolean travel(){
int i= trips.size()-1;
boolean travel=STAYS;
if(trips.get(i).getTotalWeight()>=MIN_WEIGHT || trips.get(i).numberOfCargos()>2){
travel=LEAVES;
}else{
travel=STAYS;
}
return travel;
}

//Getters and setters
/** Getter method for accessing the arraylist of trips <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the arraylist of trips<br>
	@return an arraylist of trips
	*/
public ArrayList<Trip> getTrips(){
return(trips);
}

}