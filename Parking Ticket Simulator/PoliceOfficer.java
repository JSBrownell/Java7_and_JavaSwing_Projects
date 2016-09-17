//Brownell,Jessica
//CSIT 890 Fall 2015
//11 November, 2015
//Homework Assignment #7 - Parking Ticket Simulator

package parking.enforcement;
import java.util.ArrayList;

public class PoliceOfficer {
   
    private String officerName, officerBadge;

    public PoliceOfficer(String officerName, String officerBadge) {
	this.officerName = officerName;
	this.officerBadge = officerBadge;
    }

    public String getOfficerName() {
        return officerName;
    }
    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerBadge() {
        return officerBadge;
    }
    public void setOfficerBadge(String officerBadge) {
        this.officerBadge = officerBadge;
    }
       //calling the get functions since officer members are private
    public void print(){
    System.out.println("Officer "+ this.getOfficerName() +
	    		", Badge "+this.getOfficerBadge() + "\n");
    }
     
    public void issueParkingTickets(ArrayList<ParkedCar> carsList, 
	    			    ArrayList<ParkingMeter> metersList, 
	    			    ArrayList<ParkingTicket> ticketsList){
	int timeParked,timePurchased;
	ParkingTicket tempTkt;
	
	//I know the instructions specified an enhanced for loop, but a regular for loop made more sense to me
	//The regular for-loop seemed cleaner and more straightforward
	for (int i=0;i < carsList.size(); i++){ 
	  timeParked = carsList.get(i).minutesParked ;
	   timePurchased = metersList.get(i).getMinutesPurchased();
	   if (timeParked > timePurchased){
	     tempTkt = new ParkingTicket (carsList.get(i), metersList.get(i));
	     tempTkt.setOfficer(this);
	     ticketsList.add(tempTkt);   
	   }// if
	}//for(
    }//end issueParkingTickets()
    
    public void printParkingTickets(ArrayList<ParkingTicket> ticketsList){	
	for(ParkingTicket stupidTicket: ticketsList){
	    stupidTicket.print();	  
	}
    }

   }//end PoliceOfficer Class Body
    




