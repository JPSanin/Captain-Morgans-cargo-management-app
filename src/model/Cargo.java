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

public String receipt(){
String receipt="";
receipt+="\nThe cargo has been requested successfully, here is the receipt:\n";
receipt+="Base price: $"+basePrice+" \nDiscounted price: $"+finalPrice;
receipt+= "\nThe amount you have to pay is: $"+finalPrice+" \n";
return receipt;
}

//Use after a cargo is added to a trip

public void updateClientIncrease(){
int initialKilos=client.getTotalKilosTransported();
int finalKilos= initialKilos+weight;
client.setTotalKilosTransported(finalKilos);

double initialExpenses=client.getTotalExpenses();
double finalExpenses= initialExpenses+finalPrice;
client.setTotalExpenses(finalExpenses);

}

//Getters and Setters

public String getName(){
return name;
}

public void setName(String name){
this.name=name;
}

public int getType(){
return type;
}

public void setType(int type){
this.type=type;
}

public int getWeight(){
return weight ;
}

public void setWeight(int weight){
this.weight=weight;
}

public int getNumberOfBoxes(){
return numberOfBoxes ;
}

public void setNumberOfBoxes(int numberOfBoxes){
this.numberOfBoxes=numberOfBoxes;
}

public double getBasePrice(){
return basePrice;
}

public void setBasePrice(double basePrice){
this.basePrice=basePrice;
}

public double getFinalPrice(){
return finalPrice;
}

public void setFinalPrice(double finalPrice){
this.finalPrice=finalPrice;
}
}