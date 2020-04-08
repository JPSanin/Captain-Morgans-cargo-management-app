package model;


public class Date{

//Date atributes

private int day;
private int month;
private int year;

//Constructor

public Date(int day,int month, int year){
this.day=day;
this.month= month;
this.year=year;
}

//Operational Methods

public String printDate(){
String niceDate;
niceDate=day+"/"+month+"/"+year;
return niceDate;
}

// Getters and Setters

public int getDay(){
return day;
}

public void setDay(int day){
this.day=day;
}

public int getMonth(){
return month;
}

public void setMonth(int month){
this.month=month;
}

public int getYear(){
return month;
}

public void setYear(int Year){
this.year=year;
}

}