//Brownell, Jessica
//CSIT 890, Fall 2015
//Homework Assignment 9
//December 2, 2015

//It's not the prettiest form in the world, nor is it the prettiest code in the world, but it works.
//Also, the instructions from the book seem too simplistic for calculating the total allowable expenses and comparing them to the actual.
//There's no consideration or allowance for airfare or event registration in the allowable, for example, so those costs automatically 'count against' the user.
//I think it's safe to say that this challenge was not written by an accountant.

package travel.expenses.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelExpenses extends JFrame {

    private final double PER_DIEM = 37.00;
    private final double PARKING_DAY = 10.00;
    private final double TAXI_DAY = 20.00;
    private final double LODGING_DAY = 95.00;
    private final double PER_MILE = 0.27;

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 300;

    private JPanel panel;

    private JLabel lblDays;
    private JLabel lblAir;
    private JLabel lblCar;
    private JLabel lblMiles;
    private JLabel lblParking;
    private JLabel lblTaxi;
    private JLabel lblReg;
    private JLabel lblLodging;
    private JLabel lblTotalExp;
    private JLabel lblTotalAllowable;
    private JLabel lblOverTotal;
    private JLabel lblUnderTotal;

    private JTextField txtDays;
    private JTextField txtAir;
    private JTextField txtCar;
    private JTextField txtMiles;
    private JTextField txtParking;
    private JTextField txtTaxi;
    private JTextField txtReg;
    private JTextField txtLodging;
    private JTextField txtTotalExp;
    private JTextField txtTotalAllowable;
    private JTextField txtOverTotal;
    private JTextField txtUnderTotal;

    private JButton calculate;
    // *******************************************

    public TravelExpenses() { // constructor

	setLayout (new GridLayout( 2,14));
	
	setTitle("Travel Expense Report");
	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	setLocation((1024 - WINDOW_WIDTH) / 2, (769 - WINDOW_HEIGHT) / 2);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	panel = new JPanel();
	panel.setLayout (new GridLayout(13,2));
	
	lblDays = new JLabel(" Enter number of days: ");
	lblAir = new JLabel(" Airfare: ");
	lblCar = new JLabel(" Rental car cost: ");
	lblMiles = new JLabel(" Mileage on personal car: ");
	lblParking = new JLabel(" Parking: ");
	lblTaxi = new JLabel(" Taxi: ");
	lblReg = new JLabel(" Event registration: ");
	lblLodging = new JLabel(" Lodging: ");
	lblTotalExp = new JLabel(" Total Expenses: ");
	lblTotalAllowable = new JLabel(" Total Allowable Expenses: ");
	lblOverTotal = new JLabel(" Amount owing (Over Allowable): ");
	lblUnderTotal = new JLabel(" Amount under (our shareholders thank you): ");

	txtDays = new JTextField(10);
	txtAir = new JTextField(10);
	txtCar = new JTextField(10);
	txtMiles = new JTextField(10);
	txtParking = new JTextField(10);
	txtTaxi = new JTextField(10);
	txtReg = new JTextField(10);
	txtLodging = new JTextField(10);
	txtTotalExp = new JTextField(10);
	txtTotalExp.setEditable(false);
	txtTotalAllowable = new JTextField(10);
	txtTotalAllowable.setEditable(false);
	txtOverTotal = new JTextField(10);
	txtOverTotal.setEditable(false);
	txtUnderTotal = new JTextField(10);
	txtUnderTotal.setEditable(false);
	
	calculate = new JButton("Calculate");
	
	panel.add(lblDays);
	panel.add(txtDays);
	panel.add(lblAir);
	panel.add(txtAir);
	panel.add(lblCar);
	panel.add(txtCar);
	panel.add(lblMiles);
	panel.add(txtMiles);
	panel.add(lblParking);
	panel.add(txtParking);
	panel.add(lblTaxi);
	panel.add(txtTaxi);
	panel.add(lblReg);
	panel.add(txtReg);
	panel.add(lblLodging);
	panel.add(txtLodging);
	panel.add(lblTotalExp);
	panel.add(txtTotalExp);
	panel.add(lblTotalAllowable);
	panel.add(txtTotalAllowable);
	panel.add(lblOverTotal);
	panel.add(txtOverTotal);
	panel.add(lblUnderTotal);
	panel.add(txtUnderTotal);
	panel.add(calculate);

	calculate.addActionListener(new CalculateButtonListener());
	
	this.getContentPane().add(panel);
	
	setVisible(true);

    }// end constructor

    public static void main(String[] args) {
	TravelExpenses mainWindow = new TravelExpenses();
    }
   
  
    private class CalculateButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

	    int days;
	    double air, car, miles, parking, taxi, reg, lodging;
	    double totalExp, totalAllowable;
	    double overTotal = 0.00;
	    double underTotal = 0.00;

	    try {
		days = Integer.parseInt(txtDays.getText());
		if (days <= 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtDays.requestFocus();
		JOptionPane.showMessageDialog(null, "Please enter a positive numeric value.");
		return;
	    }
	    try {
		air = Double.parseDouble(txtAir.getText());
		if (air < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtAir.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if no airfare purchased for trip.");
		return;
	    }
	    try {
		car = Double.parseDouble(txtCar.getText());
		if (air < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtCar.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if no car rented for this trip.");
		return;
	    }
	    try {
		miles = Double.parseDouble(txtMiles.getText());
		if (miles < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtMiles.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if private vehicle not used on this trip.");
		return;
	    }
	    try {
		parking = Double.parseDouble(txtParking.getText());
		if (parking < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtParking.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if there were no parking costs on this trip.");
		return;
	    }
	    try {
		taxi = Double.parseDouble(txtTaxi.getText());
		if (taxi < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtTaxi.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if no taxis were used on this trip.");
		return;
	    }
	    try {
		reg = Double.parseDouble(txtReg.getText());
		if (reg < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtReg.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if no event registration costs for this trip.");
		return;
	    }
	    try {
		lodging = Double.parseDouble(txtLodging.getText());
		if (lodging < 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		txtLodging.requestFocus();
		JOptionPane.showMessageDialog(null,
			"Please enter a positive numeric value or 0.00 if no lodging costs for this trip.");
		return;
	    }

	    totalExp = air + car + parking + taxi + reg + lodging;
	    if (miles > 0)
		totalExp += (miles * PER_MILE);
	    totalAllowable = days * (PER_DIEM + PARKING_DAY + TAXI_DAY + LODGING_DAY);

	    if (totalAllowable > totalExp) {
		underTotal = totalAllowable - totalExp;
		overTotal = 0.00;
	    }
	    if (totalAllowable < totalExp) {
		overTotal = totalExp - totalAllowable;
		underTotal = 0.00;
	    }
	    if (totalAllowable == totalExp) {
		overTotal = 0.00;
		underTotal = 0.00;
	    }

	    txtTotalExp.setText(String.format("$%, .2f", totalExp));
	    txtTotalAllowable.setText(String.format("$%, .2f", totalAllowable));
	    txtOverTotal.setText(String.format("$%, .2f", overTotal));
	    txtUnderTotal.setText(String.format("$%, .2f", underTotal));

	}// end ActionPerformed method

    }// end CalculateButtonListener()
}
