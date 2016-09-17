//Brownell,Jessica
//CSIT 890 Fall 2015
//11 November, 2015
//Homework Assignment #7 - Parking Ticket Simulator

package parking.enforcement;

public class ParkedCar {
  
   public String carMake, carModel, carColor, carLicense; //making variables public because, well, they would be in the real world
   public int minutesParked;
    
    public ParkedCar(String carMake, String carModel, String carColor, String carLicense, int minutesParked) {
	this.carMake = carMake;
	this.carModel = carModel;
	this.carColor = carColor;
	this.carLicense = carLicense;
	this.minutesParked = minutesParked;
    }
      
    public int getMinutesParked() {
        return minutesParked;
    }

    public void setMinutesParked(int minutesParked) {
        this.minutesParked = minutesParked;
    }  

    public void print(){
	System.out.println(this.carMake + " " + this.carModel + " " +
				this.carColor + " " + this.carLicense +
				", parked for " + this.getMinutesParked() + " minutes");
    }
       
}// end ParkedCar Class Body
