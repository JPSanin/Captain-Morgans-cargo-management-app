package model;
import java.util.*;

public class Trip{

// Cargo type constants
private final static int DANGEROUS= 1;
private final static int PERISHABLE= 2;
private final static int NONPERISHABLE= 3;

//Trip atributes
private int totalWeight;
private int totalBoxes;
private final static int MAX_WEIGHT=28000;
private ArrayList<Cargo> cargos;

//Constructor
/** Constructor method for a Trip<br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a trip and initializes its attributes<br>
	*/
public Trip(){
totalWeight=0;
totalBoxes=0;
cargos= new ArrayList<Cargo>();
}

//Operational methods

 /** Method for adding cargos <br>
	<b> pre: </b> <br>
	<b> post: </b> adds cargo to the arraylist of cargos if it can be added <br>
	@param cargo, a cargo object that has been created 
	@return an int indicating what happened with the cargo
	*/
public int addCargo(Cargo cargo){
int weight;
int type;
int added;
int counter;
weight= cargo.getWeight()+totalWeight;
type=cargo.getType();
added= 0;
counter=0;
if(weight>MAX_WEIGHT){
/*First case cargo could not be added
because it surpasses the weight limit
*/
added=1;	
}else{

switch (type){
	
case DANGEROUS:
for(int i=0; i<cargos.size(); i++){
if(cargos.get(i).getType()==PERISHABLE){
counter++;
}
}
if(counter>0){
/* Second case cargo could not be added
because there is already perishable cargo on the trip
*/
added=2;

}else{
/*Third case cargo added succesfully
*/
added=3;
cargo.updateClientIncrease(); 
cargos.add(cargo);

}
break;

case PERISHABLE:
for(int i=0; i<cargos.size(); i++){
if(cargos.get(i).getType()==DANGEROUS){
counter++;
}
}
if(counter>0){
/* Fourth case cargo could not be added
because there is already dangerous cargo on the trip
*/
added=4;
}else{
/*Third case cargo added succesfully
*/
added=3;
cargo.updateClientIncrease(); 
cargos.add(cargo);

}
break;

case NONPERISHABLE:
added=3;
cargo.updateClientIncrease(); 
cargos.add(cargo);
break;
}
}

/*
boolean added= false;
int weight= cargo.getWeight()+totalWeight;
if(weight>MAX_WEIGHT){
return added;	
}else{
added=true;
cargo.updateClientIncrease(); 
cargos.add(cargo);
return added;
}*/
return added;
}

 /** Method for calculating the total weight and boxes <br>
	<b> pre: </b>Use afte a cargo was added <br>
	<b> post: </b> Calculates the total weight and total boxes of the trip<br>
	*/
public void calculateTotalWeightAndBoxes(){
int i=cargos.size()-1;
totalWeight+=cargos.get(i).getWeight();
totalBoxes+=cargos.get(i).getNumberOfBoxes();
}

/** Method for showing the number of cargos on the trip <br>
	<b> pre: </b> <br>
	<b> post: </b> Shows the amounto of cargos on the trip<br>
	@return an int representing the amount of cargos on the trip
	*/
public int numberOfCargos(){
return cargos.size();
}

/** Method for showing trip information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the trip's information<br>	
	*/
public String printTripInfo(){
String amountOfCargos= "\nThe trip has: "+cargos.size()+" cargo(s)\n";
String info="There are "+totalWeight+" kilograms on this trip \n";
info+= "There are "+totalBoxes+" boxes on this trip \nCARGO(S):\n";
String finalInfo="";
for(int i=0; i<cargos.size(); i++){
info+=(i+1)+")\n"+ cargos.get(i).printInfo()+" \n";
}
finalInfo=amountOfCargos+info;

return finalInfo;
}

//Getters and Setters
/** Getter method for accessing the trip's total weight<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to trip's total weight<br>
	@return an int with the total weight on the trip
	*/
public int getTotalWeight(){
return totalWeight;
}

/** Setter method for modifying  the trip's total weight<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes  the trip's total weight<br>
	@param totalWeight, an int with  the trip's total weight
	*/
public void setTotalWeight(int totalWeight){
this.totalWeight=totalWeight;
}

/** Getter method for accessing the trip's total boxes<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to trip's total boxes<br>
	@return an int with the total boxes on the trip
	*/
public int getTotalBoxes(){
return totalBoxes;
}

/** Setter method for modifying  the trip's total boxes<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes  the trip's total boxes<br>
	@param totalBoxes, an int with  the trip's total boxes
	*/
public void setTotalBoxes(int totalBoxes){
this.totalBoxes=totalBoxes;
}

}