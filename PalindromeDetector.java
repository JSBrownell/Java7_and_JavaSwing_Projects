//Brownell, Jessica
//CSIT 890
//Lab Assignment 10 - Chapter 16
//Palindrome Detector
//December 1, 2015

//N.B.  This code works with phrases with white space but no punctuation such as "Madam Im Adam".
//	It does not work with the correctly-punctuated version, "Madam, I'm Adam."


import javax.swing.JOptionPane;

public class PalindromeDetector {

    public static void main(String[] args) {
	boolean palindrome;

	while (true) {
	    String userInput = JOptionPane.showInputDialog("Please enter a string: ");
	    if (userInput == null)
		break;
	    String inputString = prepString(userInput);

	    palindrome = isPalindrome(inputString);

	    JOptionPane.showMessageDialog(null,
		    "The original string _ " + userInput + (palindrome ? " _ is" : " _ is not") + " a palindrome.");
	}
    }// end main

    public static String prepString(String str) {
	//This method makes all characters lower case and clears white spaces (although not punctuation)
	//before string is passed to isPalindrome method
	
	String lcString = "";
	char temp;
	for (int i = 0; i < str.length(); i++) {
	    temp = Character.toLowerCase(str.charAt(i));
	    lcString += temp;
	}
	lcString = lcString.replaceAll("\\s+", "");
	return lcString;
    }// end prepString()

    public static boolean isPalindrome(String str) {
	boolean yesItIs;
	if (str.length() < 2) {
	    yesItIs = true;
	    return yesItIs;
	}	
	else {
	    if ((str.charAt(0)) == str.charAt(str.length()-1)){
		yesItIs = isPalindrome(str.substring(1, str.length()-1));
	    }
	    else{
		yesItIs = false;}
		return yesItIs;	    
	}	  
    }// end isPalindrome()
}// end class body





