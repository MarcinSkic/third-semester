import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        var calculator = new CalculatorWindow();
        JFrame ramka = new JFrame("Kalkulator");
        ramka.setContentPane(calculator.mainPanel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.pack();
        ramka.setVisible(true);
    }
}
