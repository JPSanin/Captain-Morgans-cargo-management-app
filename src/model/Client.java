package model;
import java.util.*;

public class Client{

// Client level constants
private final static int BASIC= 1;
private final static int SILVER= 2;
private final static int GOLD= 3;
private final static int PLATINUM= 4;

//Client atributes
private String name;
private int registrationNumber;
private int clientType;
private int totalKilosTransported;
private double totalExpenses;
private Date expeditionDate;

//Constructor

public Client(String name, int registrationNumber, Date expeditionDate){
this.name= name;
this.registrationNumber= registrationNumber;
clientType= BASIC;
this.expeditionDate=expeditionDate;
totalKilosTransported=0;
totalExpenses=0;
}

//Always use after a cargo leaves successfully

public void clientLevelUp(){
if(totalExpenses>5000000){
clientType=PLATINUM;
}else if(totalKilosTransported>55000||(totalExpenses>2000000 && totalExpenses<5000000)){
clientType=GOLD;
}else if(totalKilosTransported>35000 && totalKilosTransported< 55000){
clientType=SILVER;
}
}

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

public String getName(){
return name;
}

public void setName(String name){
this.name=name;
}

public int getRegistrationNumber(){
return registrationNumber;
}

public void setRegistrationNumber(int registrationNumber){
this.registrationNumber=registrationNumber;
}

public int getClientType(){
return clientType;
}

public void setClientType(int clientType){
this.clientType=clientType;
}

public int getTotalKilosTransported(){
return totalKilosTransported;
}

public void setTotalKilosTransported(int totalKilosTransported){
this.totalKilosTransported=totalKilosTransported;
}

public double getTotalExpenses(){
return totalExpenses;
}

public void setTotalExpenses(double totalExpenses){
this.totalExpenses=totalExpenses;
}

}