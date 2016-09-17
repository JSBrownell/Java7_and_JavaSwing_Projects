//Brownell,Jessica
//CSIT 890 Fall 2015
//11 November, 2015
//Homework Assignment #7 - Parking Ticket Simulator

package parking.enforcement;

public class ParkingMeter {

  private int minutesPurchased;

public ParkingMeter(int minutesPurchased) {
    this.minutesPurchased = minutesPurchased;
}

public int getMinutesPurchased() {
    return minutesPurchased;
}

public void setMinutesPurchased(int minutesPurchased) {
    this.minutesPurchased = minutesPurchased;
}
    
public void print(){
   System.out.println(this.getMinutesPurchased() + 
	   		" minutes purchased");
    
     
}





















}//end ParkingMeter Class Body
