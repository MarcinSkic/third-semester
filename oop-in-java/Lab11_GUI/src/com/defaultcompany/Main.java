package com.defaultcompany;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame ramka = new JFrame("Kalkulator");
        ramka.setContentPane(new Window().glownyPanel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.pack();
        ramka.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);

        aFormattedTextField = new JFormattedTextField(numberFormatter);
        bFormattedTextField = new JFormattedTextField(numberFormatter);
    }
}
