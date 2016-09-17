//Brownell,Jessica
//CSIT 890 Fall 2015
//17 November, 2015
//Lab Assignment #8, Chapter 11 - Write to & Read from Binary File

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class FileArray {

    public static void main(String[] args) {

	final int ARRAY_SIZE = 10;
	int[] numbers = new int[ARRAY_SIZE];

	Random rand = new Random();
	for (int i = 0; i < ARRAY_SIZE; i++) {
	    numbers[i] = rand.nextInt(1000);
	    System.out.println(numbers[i]);
	}

	writeArray("numbers.dat", numbers);
	System.out.println("End of writeArray data.\n");

	int[] numbers2 = readArray("numbers.dat");
	System.out.println("Beginning of readArray data:");
	for (int num : numbers2) {
	    System.out.println(num + " ");
	}

    }// main() end

    public static void writeArray(String fileName, int[] array) {

	FileOutputStream fstream = null;
	try {
	    fstream = new FileOutputStream(fileName);
	} catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, "Unable to open the file for writing.");
	}

	DataOutputStream outputFile = new DataOutputStream(fstream);
	try {
	    for (int value : array) {
		outputFile.writeInt(value);
	    }
	    outputFile.close();
	} // try

	catch (IOException e) {
	    JOptionPane.showMessageDialog(null, "Unable to write to the file");
	}

    }// end writeArray()

    public static int[] readArray(String fileName) {
	FileInputStream instream = null;

	try {
	    instream = new FileInputStream(fileName);
	} catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, "Unable to open the file for reading.");
	}

	DataInputStream inputFile = new DataInputStream(instream);

	int number;
	boolean endOfFile = false;
	ArrayList<Integer> tempList = new ArrayList<>();
	while (!endOfFile) {
	    try {
		number = inputFile.readInt();
		tempList.add(number);
	    } catch (EOFException e) {
		endOfFile = true;
	    } catch (IOException e) {
		JOptionPane.showMessageDialog(null, "Unable to read from the file");
	    }
	} // end of while-loop
	
	//chose to add the try-catch around inputFile.close() rather than _throws_ to method header
	try {
	    inputFile.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	//while reading the data into an ArrayList & then copying it into an array is inefficient,
	//it seems _less_ inefficient and less error-prone than the other options involving opening, reading, and closing the file twice
	int[] tempArray = new int[tempList.size()];
	for (int i = 0; i < tempList.size(); i++) {
	    tempArray[i] = tempList.get(i);
	}

	return tempArray;

    }// end readAray()

}// class body end
