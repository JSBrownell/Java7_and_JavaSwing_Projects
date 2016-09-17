
//Brownell, Jessica
//CSIT 890
//Homework Assignment 10 - Chapter 16
//Sum of Numbers using Recursion
//December 9, 2015

import javax.swing.JOptionPane;

public class SumofNumbers {

    public static void main(String[] args) {

	int number, sum;

	String userInput = JOptionPane.showInputDialog("Please enter an integer: ");
	if (userInput == null)
	    System.exit(0);
	try {
	    number = Integer.parseInt(userInput);
	    if (number <= 0)
		throw new NumberFormatException();
	} catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(null, "A positive integer value is required.");
	    return;
	}

	sum = calcSum(number);

	JOptionPane.showMessageDialog(null, "The sum of all integers from 1 to " + userInput + " is  " + sum);

    }// end main

    static int calcSum(int num) {
	if (num == 0) {
	    return num;
	} else {
	    return num + calcSum(num - 1);
	}

	// for (int i= 0; i<=num; i++){
	// total +=i;}
	// return total;

    }// end calcSum()

}// end class body
