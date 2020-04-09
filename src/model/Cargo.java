package model;

public class Cargo{

// Cargo type constants
private final static int DANGEROUS= 1;
private final static int PERISHABLE= 2;
private final static int NONPERISHABLE= 3;

//Cargo weight constants
private final static int BOX_WEIGHT=100;

// Cargo price per kilogram constants
private final static int DANGEROUS_PRICE= 390;
private final static int PERISHABLE_PRICE= 250;
private final static int NONPERISHABLE_PRICE= 80;

// Cargo atributes
private String name;
private int type;
private int weight;
private int numberOfBoxes;
private double basePrice;
private double finalPrice;
private Client client;

// Constructor
 /** Constructor method for a Cargo <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a cargo and initializes its attributes<br>
	@param name, a name for the cargo, must be a String !=null or !=" "
	@param type, an int representing the cargo type 
	@param client, a client that has already been created
	*/
public Cargo(String name, int type, int numberOfBoxes, Client client){
this.name=name;
this.type=type;
this.numberOfBoxes=numberOfBoxes;
weight=numberOfBoxes*BOX_WEIGHT;
this.client=client;

switch(type){

case DANGEROUS:
basePrice=DANGEROUS_PRICE*weight;
break;

case PERISHABLE:
basePrice=PERISHABLE_PRICE*weight;
break;

case NONPERISHABLE:
basePrice=NONPERISHABLE_PRICE*weight;
break;
}


}

//Operational methods
 /** Method for calculating the final price of the cargo <br>
	<b> pre: </b>Use afte a cargo was created <br>
	<b> post: </b> Calculates the final price of the cargo<br>
	*/
public void calculateFinalPrice(){

switch(client.getClientType()){

case 1:
finalPrice=basePrice;
break;

case 2:
if(type==PERISHABLE){
finalPrice=basePrice-(basePrice*0.015);
}else{
finalPrice=basePrice;
}

break;

case 3:
if(type==PERISHABLE|| type==NONPERISHABLE){
finalPrice=basePrice-(basePrice*0.03);
}else{
finalPrice=basePrice;
}
break;

case 4:

finalPrice=basePrice-(basePrice*0.05);

break;
}
}

/** Method for showing cargo information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the cargo's information<br>	
	*/
public String printInfo(){
String cargoType="";
switch(type){

case DANGEROUS:
cargoType="Dangerous";
break;

case PERISHABLE:
cargoType="Perishable";
break;

case NONPERISHABLE:
cargoType="Non-Perishable";
break;
}
String info="Owner:"+client.getName()+" \nCargo name: "+name+" \nCargo type: "+cargoType+" \nWeight: "+weight+" kilograms"
+" \nNumber of Boxes: "+numberOfBoxes+" \nBase price: $"+basePrice+" \nDiscounted price: $"+finalPrice;

return info;

}

/** Method for showing cargo prices<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the cargo's receipt with the price to pay<br>	
	*/
public String receipt(){
String receipt="";
receipt+="\nThe cargo has been requested successfully, here is the receipt:\n";
receipt+="Base price: $"+basePrice+" \nDiscounted price: $"+finalPrice;
receipt+= "\nThe amount you have to pay is: $"+finalPrice+" \n";
return receipt;
}

//Use after a cargo is added to a trip
/** Method for updating the client's totals<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Updates the client's total weight transported and total expenses<br>	
	*/
public void updateClientIncrease(){
int initialKilos=client.getTotalKilosTransported();
int finalKilos= initialKilos+weight;
client.setTotalKilosTransported(finalKilos);

double initialExpenses=client.getTotalExpenses();
double finalExpenses= initialExpenses+finalPrice;
client.setTotalExpenses(finalExpenses);

}

//Getters and Setters

/** Getter method for accessing the cargo's name <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the cargo's name<br>
	@return a String with the name of the cargo
	*/
public String getName(){
return name;
}

/** Setter method for modifying the cargo's name<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the cargo's name<br>
	@param name, a String with the cargo's name
	*/
public void setName(String name){
this.name=name;
}

/** Getter method for accessing the cargo's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the cargo's type<br>
	@return an int representing the cargo's type
	*/
public int getType(){
return type;
}

/** Setter method for modifying the cargo's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the cargo's type<br>
	@param type, an int with the cargo's type
	*/
public void setType(int type){
this.type=type;
}

/** Getter method for accessing the cargo's weight <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the cargo's weight<br>
	@return an int with the cargo's weight
	*/
public int getWeight(){
return weight ;
}

/** Setter method for modifying the cargo's weight<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the cargo's weight<br>
	@param weight, an int with the cargo's weight
	*/
public void setWeight(int weight){
this.weight=weight;
}

/** Getter method for accessing the cargo's number of boxes <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the cargo's number of boxes<br>
	@return an int with the cargo's number of boxes
	*/
public int getNumberOfBoxes(){
return numberOfBoxes ;
}

/** Setter method for modifying the cargo's number of boxes<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the cargo's number of boxes<br>
	@param numberOfBoxes, an int with the cargo's number of boxes
	*/
public void setNumberOfBoxes(int numberOfBoxes){
this.numberOfBoxes=numberOfBoxes;
}

/** Getter method for accessing the cargo's base price <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the cargo's  base price<br>
	@return a double with the cargo's  base price
	*/
public double getBasePrice(){
return basePrice;
}

/** Setter method for modifying the cargo's  base price<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the cargo's  base price<br>
	@param basePrice, a double with the cargo's  base price
	*/
public void setBasePrice(double basePrice){
this.basePrice=basePrice;
}

/** Getter method for accessing the cargo's final price <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the cargo's  final price<br>
	@return a double with the cargo's  final price
	*/
public double getFinalPrice(){
return finalPrice;
}

/** Setter method for modifying the cargo's  final price<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the cargo's  final price<br>
	@param finaNOPrice, a double with the cargo's  final price
	*/
public void setFinalPrice(double finalPrice){
this.finalPrice=finalPrice;
}
}