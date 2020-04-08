package model;
import java.util.*;

public class Ship{

//Ship constants
private final static boolean LEAVES=true;
private final static boolean STAYS=false;
private final static int MAX_WEIGHT=28000;
private final static int MIN_WEIGHT=12000;
private final static int MIN_CARGOS=2;

//Ship atributes
private ArrayList<Trip> trips;

//Constructor
public Ship(){
trips= new ArrayList<Trip>();
}

public void addTrip(Trip trip){
trips.add(trip);
}

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

public ArrayList<Trip> getTrips(){
return(trips);
}
}