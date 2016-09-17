//Brownell,Jessica
//CSIT 890 Fall 2015
//11 November, 2015
//Homework Assignment #7 - Parking Ticket Simulator

package parking.enforcement;
import java.util.ArrayList;

public class ParkingMain {
    public static void main(String[] args) {
	
	ArrayList <ParkedCar> carList = new ArrayList<>();  //will hold 5 ParkedCar objects per instructions, using default capacity
	ArrayList <ParkingMeter> meterList = new ArrayList<>(); //will hold 5 ParkingMeter objects per instructions, using default capacity
	ArrayList <ParkingTicket> ticketList = new ArrayList <>();  //will hold TBD ParkingTicket objects, using default capacity
	
	 //create 5 ParkedCar objects 
	ParkedCar car1 = new ParkedCar ("Honda", "Fit", "Silver", "G0K1NGS", 30);
	ParkedCar car2 = new ParkedCar ("Ford", "Escape", "Steel Blue", "G0K1NGS2", 60);
	ParkedCar car3 = new ParkedCar ("BMW", "M5", "Red", "ENT1TL3D", 200);
	ParkedCar car4 = new ParkedCar ("Lexus", "LX", "Black", "4LLM1NE", 300);
	ParkedCar car5 = new ParkedCar ("Mercedes", "E250", "White", "J4CK4SS", 180);
	//add them to ArrayList of ParkedCars
	carList.add(car1);
	carList.add(car2);
	carList.add(car3);
	carList.add(car4);
	carList.add(car5);
	 //create 5 ParkingMeter objects
	ParkingMeter meter1 = new ParkingMeter (60);
	ParkingMeter meter2 = new ParkingMeter (60);
	ParkingMeter meter3 = new ParkingMeter (90);
	ParkingMeter meter4 = new ParkingMeter (30);
	ParkingMeter meter5 = new ParkingMeter (60);
	//add them to ArrayList of ParkingMeters
	meterList.add(meter1);
	meterList.add(meter2);
	meterList.add(meter3);
	meterList.add(meter4);
	meterList.add(meter5);
	
	//Instantiating PoliceOfficer, passing officer's name and badge # to the PoliceOfficer constructor
	PoliceOfficer officerFriendly = new PoliceOfficer("Fred Friendly", "123ABC"); 
		
	officerFriendly.issueParkingTickets(carList, meterList, ticketList);
	officerFriendly.printParkingTickets(ticketList);	
  
    }//end main()
    
} //end ParkingMain Class Body
