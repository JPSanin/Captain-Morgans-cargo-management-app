package model;
import java.util.*;

public class Client{

// Client level constants
private final static int BASIC= 1;
private final static int SILVER= 2;
private final static int GOLD= 3;
private final static int PLATINUM= 4;

//Client attributes
private String name;
private int registrationNumber;
private int clientType;
private int totalKilosTransported;
private double totalExpenses;
private Date expeditionDate;

//Constructor
 /** Constructor method for a Client <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a client and initializes its attributes<br>
	@param name, a name for the client, must be a String !=null or !=" "
	@param registrationNumber, a positive whole number 
	@param expeditionDate, a date object that has already been created
	*/
public Client(String name, int registrationNumber, Date expeditionDate){
this.name= name;
this.registrationNumber= registrationNumber;
clientType= BASIC;
this.expeditionDate=expeditionDate;
totalKilosTransported=0;
totalExpenses=0;
}


//Operational Methods
/** Method for leveling up the client type <br>
	<b> pre: </b> Must have payed successfully before using<br>
	<b> post: </b> Levels up the client if he fulfills the conditions <br>
	*/
//Always use after a cargo leaves/paid successfully
public void clientLevelUp(){
if(totalExpenses>5000000){
clientType=PLATINUM;
}else if(totalKilosTransported>55000||(totalExpenses>2000000 && totalExpenses<5000000)){
clientType=GOLD;
}else if(totalKilosTransported>35000 && totalKilosTransported< 55000){
clientType=SILVER;
}
}

/** Method for showing client information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the client's information<br>	
	*/
public String printInfo(){
String info= "\nName: "+ name+"\n";
info+= "Registration Number: "+ registrationNumber+"\n";
String typeText="";

if(clientType==1){
typeText="Basic";
}else if(clientType==2){
typeText="Silver";
}else if(clientType==3){
typeText="Gold";
}else if(clientType==4){
typeText="Platinum";
}
info+= "Client Type: "+typeText+"\n";
info+= "Expedition Date: "+expeditionDate.printDate()+"\n";
info+= "Total Kilos Transported: "+totalKilosTransported+"\n";
info+= "Total Expenses: "+totalExpenses+"\n";
return info; 
}


//Getters and Setters
/** Getter method for accessing the client's name <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's name<br>
	@return a String with the name of the client
	*/
public String getName(){
return name;
}

/** Setter method for modifying the client's name<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's name<br>
	@param name, a String with the client's name
	*/
public void setName(String name){
this.name=name;
}

/** Getter method for accessing the client's registration number<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's registration number<br>
	@return an int with the registration number of the client
	*/
public int getRegistrationNumber(){
return registrationNumber;
}

/** Setter method for modifying the client's registration number<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's registration number<br>
	@param registrationNumber, an int with the client's registration number
	*/
public void setRegistrationNumber(int registrationNumber){
this.registrationNumber=registrationNumber;
}

/** Getter method for accessing the client's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's type<br>
	@return an int representing the client's type
	*/
public int getClientType(){
return clientType;
}

/** Setter method for modifying the client's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's type<br>
	@param clientType, an int with the client's type
	*/
public void setClientType(int clientType){
this.clientType=clientType;
}

/** Getter method for accessing the client's total kilos transported<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's total kilos transported<br>
	@return an int with the total kilos transported by the client
	*/
public int getTotalKilosTransported(){
return totalKilosTransported;
}

/** Setter method for modifying the client's total kilos transported<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's total kilos transported<br>
	@param totalKilosTransported, an int with the client's total kilos transported
	*/
public void setTotalKilosTransported(int totalKilosTransported){
this.totalKilosTransported=totalKilosTransported;
}

/** Getter method for accessing the client's total expenses<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's total expenses<br>
	@return a double with the total expenses of the client
	*/
public double getTotalExpenses(){
return totalExpenses;
}

/** Setter method for modifying the client's total expenses<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's total expenses<br>
	@param totalExpenses, a double with the total expenses of the client
	*/
public void setTotalExpenses(double totalExpenses){
this.totalExpenses=totalExpenses;
}

}