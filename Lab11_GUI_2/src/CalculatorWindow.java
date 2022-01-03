import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class CalculatorWindow {

    public JPanel mainPanel;
    private JFormattedTextField number1TextField;
    private JFormattedTextField number2TextField;
    private JTextField result;
    private JButton doAddition;
    private JButton doSubtraction;
    private JButton doMultiplication;
    private JButton doDivision;

    public CalculatorWindow() {

        doAddition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!isTextCorrect()){
                    return;
                }

                var a = Float.parseFloat(number1TextField.getText());
                var b = Float.parseFloat(number2TextField.getText());

                result.setText((a+b)+"");
            }
        });
        doSubtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isTextCorrect()){
                    return;
                }
                var a = Float.parseFloat(number1TextField.getText());
                var b = Float.parseFloat(number2TextField.getText());

                result.setText((a-b)+"");
            }
        });
        doMultiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isTextCorrect()){
                    return;
                }
                var a = Float.parseFloat(number1TextField.getText());
                var b = Float.parseFloat(number2TextField.getText());

                result.setText((a*b)+"");
            }
        });
        doDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isTextCorrect()){
                    return;
                }
                var a = Float.parseFloat(number1TextField.getText());
                var b = Float.parseFloat(number2TextField.getText());

                if(b == 0) {
                    JOptionPane.showMessageDialog(mainPanel, "Zakaz dzielenia przez zero", "Ostrzezenie", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result.setText((a/b)+"");
            }
        });
    }

    private void createUIComponents() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);

        number1TextField = new JFormattedTextField(numberFormatter);
        number2TextField = new JFormattedTextField(numberFormatter);
    }

    boolean isTextCorrect(){
        if(number1TextField.getText().isEmpty() || number2TextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainPanel, "Brak liczb", "Ostrzezenie", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
}
