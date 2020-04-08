package ui;
import model.*;
import java.util.Scanner;

/* 
pulir diagrama de clases y objetos, HACER UN RESUMENSISKI JAVADOC CHIMBO Y chaooo guarde mañana le
das duro papiriqui

 */

public class Menu{
	
//Menu option constants
private final static int TRIP=1;
private final static int TRIP_HISTORY=2;
private final static int CLIENT_INFO=3;
private final static int EXIT=4;

private final static int ADD_CARGO=1;
private final static int VIEW_INFO=2;
private final static int SEND_TRIP=3;


// Client name constants
private final static int SHELBY=0;
private final static int SOLOMONS=1;
private final static int CHANGRETTA=2;
private final static int SABINI=3;
private final static int KIMBER=4;
private final static int EXIT_CLIENTS=5;

private final static int SIZE=5;

/*Morgan will always have the same clients
this will ensure the correct functioning of
the program*/

private Client[] clients;

//Five company expedition dates
private Date[] dates;

//One ship
private Ship ship;
private int client;

public Menu(){

clients = new Client[SIZE];
dates = new Date[SIZE];

dates[SHELBY]= new Date(4,6,1919);
clients[SHELBY]= new Client("Shelby Company Ltd", 22350 ,dates[SHELBY]);

dates[SOLOMONS]= new Date(19,11,1921);
clients[SOLOMONS]= new Client("Solomons Export", 77679, dates[SOLOMONS]);

dates[CHANGRETTA]= new Date(23, 3, 1911);
clients[CHANGRETTA]= new Client("Changretta Exchange", 44501,dates[CHANGRETTA]);

dates[SABINI]= new Date(30,9,1915);
clients[SABINI]= new Client("Sabini Ships", 88921, dates[SABINI]);

dates[KIMBER]= new Date(12,8,1923);
clients[KIMBER]= new Client("Kimber Trading", 44230,dates[KIMBER]);

ship= new Ship();
client= 0;
}

public void showWelcome(){
System.out.println("\nWelcome Captain Morgan to your app, here you will be able to manage your clients' cargo \n");
}

public void mainMenu(){
System.out.println("Select the number that represents what you would like to do");
System.out.println("1) Create a Trip");
System.out.println("2) View trip history");
System.out.println("3) View client information");
System.out.println("4) Exit \n");
}

public int readOption(){
Scanner sc = new Scanner(System.in);
int option= sc.nextInt();
sc.nextLine();
return option;
}

public void tripsHistory(){
if(ship.getTrips().size()==0){
System.out.println("\nPlease create and carry out a trip to view history, as of now since there are \n"+
"no trips, no trip history can be shown, to create a trip select option 1) in the main menu\n");
}else{
System.out.println("\nYou have done "+ship.getTrips().size()+" trip(s):");
for(int i=0; i<ship.getTrips().size();i++){
System.out.println("Trip "+(i+1)+":"+ship.getTrips().get(i).printTripInfo());
}
}

}

public void showClients(){
// System.out.println("Please identify yourself, press the number that represents your enterprise\n");
System.out.println("1) Shelby Company Ltd");
System.out.println("2) Solomons Export");
System.out.println("3) Changretta Exchange");
System.out.println("4) Sabini Ships");
System.out.println("5) Kimber Trading");	
System.out.println("6) Exit \n");	
}

public void showClientInfo(){
do{
System.out.println("Select the client whose information you would like to view");
showClients();
client=readOption();
client-=1;
if(client>EXIT_CLIENTS){
System.out.println("\nPlease select a valid option\n");
}
}while(client>EXIT_CLIENTS);

if(client!=EXIT_CLIENTS){
System.out.println(clients[client].printInfo());	
}
}

public void tripConditions(){
System.out.println("Now that you have a trip remember the conditions that you established to avoid losses and for sanity reasons\n");
System.out.println("1) Dangerous cargo and Perishable cargo cannot travel on the same trip");
System.out.println("2) The ships maximum weight capacity is 28000 kilograms, therefore a trip cannot have\n"
+"a total weight more than 28000 kilograms");
System.out.println("3) The trip must have at least two cargos or more than a total weight of 12000 kilograms to travel\n");
}

public void createTrip(){
int option;
Trip newTrip;
newTrip=new Trip();
ship.addTrip(newTrip);
System.out.println("\nThe trip was created successfully\n");
tripConditions();
do{
tripMenu();
option= readOption();
switch(option){

case ADD_CARGO:
cargoInfo();
do{
System.out.println("Please select the owner of the cargo");
showClients();
client=readOption();
if(client>6){
System.out.println("\n Please select a valid option");
}
}while(client>6);

if(client!=6){
//Capture the int to decide if the cargo can be added or not
switch(newTrip.addCargo(requestCargo())){

case 1:
System.out.println("PAYMENT DENIED: \nThe cargo could not be added because with it the trip surpasses the weight limit");
int remainingWeight=28000-newTrip.getTotalWeight();
String remainingWeightText= "There are "+remainingWeight+" kilograms of remaining space, please send the ship or add lighter cargos\n";
System.out.println(remainingWeightText);
break;
case 2:
System.out.println("PAYMENT DENIED: \nThe cargo could not be added because there is already perishable cargo on the trip\n");
break;
case 3:
newTrip.calculateTotalWeightAndBoxes();
System.out.println("PAYMENT ACCEPTED: \nThe cargo was added to the trip successfully\n");
break;
case 4:
System.out.println("PAYMENT DENIED: \nThe cargo could not be added because there is already dangerous cargo on the trip\n");
break;
}
}

break;

case VIEW_INFO:
System.out.println(newTrip.printTripInfo());
break;

case SEND_TRIP:
if(newTrip.numberOfCargos()>0){
if(ship.travel()){
for(int i=0; i<SIZE; i++){
clients[i].clientLevelUp();
}
}else{
if(newTrip.numberOfCargos()<2){
System.out.println("\nThere are less than 2 cargos on the trip, so it cannot be sent\n"+
"please add more cargos to trip so it can be sent");
}else{
System.out.println("\nThe total weight of the trip is less than 12000 kilograms, so it cannot be sent\n"+
"please add more cargos to trip so it can be sent");
}
option=100;
}
}else{
System.out.println("\nPlease add cargo to a trip before trying to send it");
option=100;
}
break;
}
if(option>SEND_TRIP && option!=100){
System.out.println("\n Please select a valid option");
}
}while(option!=SEND_TRIP);
System.out.println("\nThe trip has been performed successfully\n");
}

public void tripMenu(){
System.out.println("1) Add cargo to trip");
System.out.println("2) View trip information");
System.out.println("3) Send trip");
}

public void cargoInfo(){
System.out.println("\nYou have decided to add a cargo, before you proceed here is a reminder of the terms you established Captain Morgan\n");
System.out.println("1) All cargos are stored in boxes");
System.out.println("2) Each box will always weigh 100 kilograms no matter what");
System.out.println("3) You cannot send partially full boxes, for example you cannot send half a box");
System.out.println("4) Therefore you will always send stuff in hundreds");
System.out.println("5) Each cargo has a name and a type");
System.out.println("6) The prices are per kilogram and depend on the type of cargo: \n"+
"Dangerous costs $390.00 \nPerishable costs $250.00 \nNon-Perishable costs $80.00\n");
}

public Cargo requestCargo(){
Scanner sc = new Scanner(System.in);
Scanner sc2 = new Scanner(System.in);
String name="";
int type;
int numberOfBoxes;
Cargo newCargo= new Cargo("",0,0,clients[SHELBY]);
System.out.println("\nType the name of the cargo:");
name=sc.nextLine();
do{
System.out.println("\nSelect the type of the cargo");
System.out.println("1) Dangerous");
System.out.println("2) Perishable");
System.out.println("3) Non-Perishable");
type=sc2.nextInt();
sc2.nextLine();
if(type>3){
System.out.println("Please select a valid option");
}
}while(type>3);
System.out.println("\nHow many boxes is the client shipping");
numberOfBoxes=sc2.nextInt();
sc2.nextLine();

switch(client){
	
case SHELBY+1:
newCargo= new Cargo(name,type,numberOfBoxes,clients[SHELBY]);
newCargo.calculateFinalPrice();
System.out.println(newCargo.receipt());
break;

case SOLOMONS+1:
newCargo= new Cargo(name,type,numberOfBoxes,clients[SOLOMONS]);
newCargo.calculateFinalPrice();
System.out.println(newCargo.receipt());
break;

case CHANGRETTA+1:
newCargo= new Cargo(name,type,numberOfBoxes,clients[CHANGRETTA]);
newCargo.calculateFinalPrice();
System.out.println(newCargo.receipt());
break;
	
case SABINI+1:
newCargo= new Cargo(name,type,numberOfBoxes,clients[SABINI]);
newCargo.calculateFinalPrice();
System.out.println(newCargo.receipt());
break;
	
case KIMBER+1:
newCargo= new Cargo(name,type,numberOfBoxes,clients[KIMBER]);
newCargo.calculateFinalPrice();
System.out.println(newCargo.receipt());
break;
	

}
return newCargo;	
}

public void doMenu(){
int selection;

do{
mainMenu();
selection=readOption();
switch(selection){
case TRIP:
createTrip();
break;

case TRIP_HISTORY:
tripsHistory();
break;

case CLIENT_INFO:
showClientInfo();

break;
}
if(selection>EXIT){
System.out.println("\nPlease select a valid option\n");
}
}while(selection != EXIT);
System.out.println("The program has closed successfully, until next time Captain Morgan :)");
}

public void start(){
showWelcome();
doMenu();
}

}