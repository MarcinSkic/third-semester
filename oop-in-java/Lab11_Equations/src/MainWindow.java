import javax.swing.*;
import javax.xml.stream.events.StartDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private  JButton OBLICZButton;
    private JTextField textField7;
    private  JTextField textField8;

    public MainWindow() {
        OBLICZButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculate();
            }
        });
    }

    public static void main(String[] args) {
        var mainWindow = new MainWindow();
        JFrame ramka = new JFrame("Kalkulator");
        ramka.setContentPane(mainWindow.mainPanel);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.pack();
        ramka.setVisible(true);
    }

    public void Calculate(){
        double mat[][] = new double[2][3];
        mat[0][0] = Double.parseDouble(textField1.getText());
        mat[0][1] = Double.parseDouble(textField2.getText());
        mat[0][2] = Double.parseDouble(textField3.getText());
        mat[1][0] = Double.parseDouble(textField4.getText());
        mat[1][1] = Double.parseDouble(textField5.getText());
        mat[1][2] = Double.parseDouble(textField6.getText());
        double temp[][] = new double[2][2];
        getCofactor(mat,temp,3,2,3);
    }
    // Function to get cofactor of
    // mat[p][q] in temp[][]. n is
    // current dimension of mat[][]
    static void getCofactor(double mat[][], double temp[][],
                            int p, int q, int n) {
        int i = 0, j = 0;

        // Looping for each element of
        // the matrix
        for (int row = 0; row < n-1; row++) {
            for (int col = 0; col < n; col++) {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase
                    // row index and reset col
                    // index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant
    of matrix. n is current dimension of mat[][]. */
    static double determinantOfMatrix(double mat[][], int n) {
        double D = 0; // Initialize result

        // Base case : if matrix contains single
        // element
        if (n == 1)
            return mat[0][0];

        // To store cofactors
        double temp[][] = new double[mat.length][mat[0].length];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);

            // terms are to be added with
            // alternate sign
            sign = -sign;
        }

        return D;
    }
}
