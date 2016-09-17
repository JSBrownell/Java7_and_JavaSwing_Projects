//Brownell,Jessica
//CSIT 890 Fall 2015
//11 November, 2015
//Homework Assignment #7 - Parking Ticket Simulator
 
package parking.enforcement;

public class ParkingTicket {
    
    ParkedCar vehicle;
    ParkingMeter meter;
    PoliceOfficer officer;

    public ParkingTicket(ParkedCar vehicle, ParkingMeter meter) {
	this.vehicle = vehicle;
	this.meter = meter;
    }
  
    public PoliceOfficer getOfficer() {
        return officer;
    }

    public void setOfficer(PoliceOfficer officer) {
        this.officer = officer;
    }
    
    public void print(){
	this.vehicle.print();
	this.meter.print();
	this.officer.print();
    }

 

}//end ParkingTicket Class Body	
