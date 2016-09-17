//Brownell,Jessica
//CSIT 890 Fall 2015
//24 November, 2015
//Lab Assignment #9, Chapter 12 - Total Monthly Sales Tax Calculator

package state.county.sales.taxes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class MonthlySalesTax extends JFrame {

    private JPanel panel;
    private JLabel totalSalesLabel;
    private JLabel countyTaxLabel;
    private JLabel stateTaxLabel;
    private JLabel totalSalesTaxLabel;
    private JTextField totalSales;
    private JTextField countySalesTax;
    private JTextField stateSalesTax;
    private JTextField totalSalesTax;
    private JButton calculate; // source of the event

    private final double COUNTY_RATE = 0.02;
    private final double STATE_RATE = 0.04;
    private final int WINDOW_WIDTH = 320;
    private final int WINDOW_HEIGHT = 200;

    public MonthlySalesTax() {
	panel = new JPanel();

	totalSalesLabel = new JLabel("Enter Total Sales: ");
	countyTaxLabel = new JLabel("County Sales Tax: ");
	stateTaxLabel = new JLabel("State Sales Tax: ");
	totalSalesTaxLabel = new JLabel("Total Sales Tax:");

	totalSales = new JTextField(10);
	countySalesTax = new JTextField(10);
	countySalesTax.setEditable(false);
	stateSalesTax = new JTextField(10);
	stateSalesTax.setEditable(false);
	totalSalesTax = new JTextField(10);
	totalSalesTax.setEditable(false);

	calculate = new JButton("Calculate Sales Tax Amounts");

	// ----------------------------------

	panel.add(totalSalesLabel);
	panel.add(totalSales);
	panel.add(countyTaxLabel);
	panel.add(countySalesTax);
	panel.add(stateTaxLabel);
	panel.add(stateSalesTax);
	panel.add(totalSalesTaxLabel);
	panel.add(totalSalesTax);
	panel.add(calculate);

	calculate.addActionListener(new CalculateButtonListener());

	this.getContentPane().add(panel);

	setTitle("Monthly Sales Tax");
	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	setLocation((1024 - WINDOW_WIDTH) / 2, (769 - WINDOW_HEIGHT) / 2);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }

    public static void main(String[] args) {
	MonthlySalesTax mainWindow = new MonthlySalesTax();
    }

    private class CalculateButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    totalSales.setBackground(Color.WHITE);

	    String strTotalSales = totalSales.getText();
	    double sales = 0.0;
	    try {
		sales = Double.parseDouble(strTotalSales);
		if (sales <= 0)
		    throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
		totalSales.setBackground(Color.ORANGE);
		totalSales.requestFocus();
		JOptionPane.showMessageDialog(null, "Please enter a positive numeric value.");
		return;
	    }

	    double countyTaxAmount = sales * COUNTY_RATE;
	    double stateTaxAmount = sales * STATE_RATE;
	    double totalTaxAmount = countyTaxAmount + stateTaxAmount;

	    countySalesTax.setText(String.format("$%, .2f", countyTaxAmount));
	    stateSalesTax.setText(String.format("$%, .2f", stateTaxAmount));
	    totalSalesTax.setText(String.format("$%, .2f", totalTaxAmount));
	}// end ActionPerformed method
    }// end CalculateButtonListener class body

}// end MonthlySalesTax class body
