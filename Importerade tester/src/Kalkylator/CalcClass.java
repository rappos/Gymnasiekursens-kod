// This is the original Calculator code without objects in a single class. not really efficient...
package Kalkylator;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class CalcClass
        extends JFrame
        implements ActionListener {
    JPanel[] row = new JPanel[6];
    JButton[] button = new JButton[21];
    String[] buttonString = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "/", "C", "v", "+/-", "=", "0", "Parabola", "x^y"};
    int[] dimW = {300, 45, 100, 90, 180};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
    Dimension parabolaDimension = new Dimension(dimW[4], dimH[0]);
    //formatting variables
    int var = 0;
    double x = 0;
    String stor = "";
    boolean initial = true;
    //variables for Parabola function
    int countEquals_parab = 0;
    double Angle = 0;
    double Vi = 0;
    double Vx = 0;
    double Vy = 0;
    double T_max = 0;
    double Y_displ = 0;
    double X_displ = 0;
    double h = 0;
    double k = 0;
    double a_parab = 0;
    boolean parabComplete = true;
    boolean parabola = false;
    DecimalFormat df = new DecimalFormat("#######.#####");
    //variables for addressing illegal typing issues
    boolean typeNum = true;
    boolean typeDot = true;
    JFrame frame; //for parabolaInstructions
    //original calculator variables
    boolean[] function = new boolean[5];
    double[] temporary = {0, 0}; //store on screen values
    double result = 0; //store result
    public JTextArea display = new JTextArea(1, 20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);

    CalcClass() {
        super("CalcClass");
        setDesign();
        setSize(380, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(6, 5);
        setLayout(grid);
        for(int i = 0; i < 5; i++) {
            function[i] = false;
        }
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        for(int i = 0; i < 6; i++) {
            row[i] = new JPanel();
        }
        row[0].setLayout(f1);
        for(int i = 1; i < 6; i++) {
            row[i].setLayout(f2);
        }
        for(int i = 0; i < 21; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        display.setFont(font);
        display.setEditable(false);
        display.setPreferredSize(displayDimension);
        for(int i = 0; i < 14; i++) {
            button[i].setPreferredSize(regularDimension);
        }
        for(int i = 14; i < 18; i++) {
            button[i].setPreferredSize(rColumnDimension);
        }
        button[18].setPreferredSize(zeroButDimension);
        button[19].setPreferredSize(parabolaDimension);
        button[20].setPreferredSize(rColumnDimension);
        row[0].add(display);
        add(row[0]);
        for(int i = 0; i < 4; i++) {
            row[1].add(button[i]);
        }
        row[1].add(button[14]);
        add(row[1]);
        for(int i = 4; i < 8; i++) {
            row[2].add(button[i]);
        }
        row[2].add(button[15]);
        add(row[2]);
        for(int i = 8; i < 12; i++) {
            row[3].add(button[i]);
        }
        row[3].add(button[16]);
        add(row[3]);
        row[4].add(button[18]);
        for(int i = 12; i < 14; i++) {
            row[4].add(button[i]);
        }
        row[4].add(button[17]);
        add(row[4]);
        row[5].add(button[19]);
        row[5].add(button[20]);
        add(row[5]);
        setVisible(true);
    }

    public void getSqrt() {
        stor = "";
        initial = true;
        try {
            double value = Double.parseDouble(display.getText());
            if(value == -100) {
                format("John's Girlfriend");
            } else {
                value = Math.sqrt(Double.parseDouble(display.getText())); //create a value for variable, and use Maths square root to find the value
                format(Double.toString(value)); //Sets display to new value
            }
        } catch(NumberFormatException e) {
        }
        typeDot = false;
        typeNum = false;
    }

    public void getPosNeg() {
        stor = "";
        initial = true;
        try {
            double value = Double.parseDouble(display.getText()); //again creating a variable for current value
            if(value != 0) { //if value is not equal to zero
                value = (-1) * value; //multiplied by -1 to change the sign
                format(Double.toString(value)); //Sets display to new value
            } else {
            }
        } catch(NumberFormatException e) {
        }
    }

    public void getResult() {
        temporary[1] = Double.parseDouble(display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            functions();
            clear();
            format(Double.toString(result));//display has a result
            for(int i = 0; i < 5; i++) {
                function[i] = false; //set all functions to false
            }
        } catch(NumberFormatException e) {
        }
        typeNum = false;
    }

    public void functions() {
        if(function[2] == true) { //multiplication 
            result = temporary[0] * temporary[1];
        } else if(function[3] == true) { //division
            result = temporary[0] / temporary[1];
        } else if(function[0] == true) { //addition
            result = temporary[0] + temporary[1];
        } else if(function[1] == true) { //subtraction;
            result = temporary[0] - temporary[1];
        } else if(function[4] == true) {
            result = Math.pow(temporary[0], temporary[1]);
        } else {
            result = temporary[1];
        }
    }

    double a_quadratic = 0;
    double b = 0;
    double c = 0;
    double x1 = 0;
    double x2 = 0;
    double discr = 0;
    int countEquals_quadratic = 0;

    public void quadraticFormula() {
        if(countEquals_parab == 0) {
            a_quadratic = Double.parseDouble(display.getText());
            clear();
            display.setText("b = ");
        }
        if(countEquals_parab == 1) {
            b = Double.parseDouble(display.getText());
            display.setText("c = ");
        }
        if(countEquals_parab == 2) {
            c = Double.parseDouble(display.getText());
            discr = (Math.pow(b, 2) - 4 * a_quadratic * c); //stores the value of the discriminant
            if(discr >= 0) {
                x1 = (-b + Math.sqrt(b * b - 4 * a_quadratic * c)) / (2 * a_quadratic);
                x2 = (-b - Math.sqrt(b * b - 4 * a_quadratic * c)) / (2 * a_quadratic);
            }
        }
    }

    public void parabolaButton() {
        double G = 9.81;
        if(countEquals_parab == 0) {
            Vi = Double.parseDouble(display.getText());
            clear();
            display.setText("Angle of release: ");
        }
        if(countEquals_parab == 1) {
            Angle = Double.parseDouble(display.getText());
            if((Angle > 90.0) || (Angle < 0.0)) {
                display.setText("Sorry, not a valid angle");
                countEquals_parab = 3;
            } else {
                Angle = (Math.PI / 180.0) * Angle;  //converting degrees into radians
                Vx = Vi * Math.cos(Angle); //Calculating x component
                Vy = Vi * Math.sin(Angle); //Calculating y component
                //Finding time
                T_max = Vy / G; //time to max height
                //Calculating vertex coordinates
                Y_displ = (Vy * Vy / (2 * G));
                X_displ = Vx * T_max;
                //finding a
                a_parab = (-Y_displ) / (X_displ * X_displ);
                display.setText("The equation of the parabola is \ny = " + df.format(a_parab) + "(x - " + df
                        .format(h) + ")^2 + " + df.format(k));
            }
        }
        if(countEquals_parab == 2) {
            display.setText("Time to get to max height = " + df.format(T_max));
        }
        if(countEquals_parab == 3) {
            clearFunction();
            countEquals_parab = -1;
            parabola = false;
            parabComplete = true;
        }
        countEquals_parab++;
    }

    public void var() {
        var++;
        if(var > 8) {
            var = 1;
        }
        if(var == 1) {
            format("x");
        }
    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
    }

    public void format(String get) {
        //get stores the incoming values temporarily
        //get is transferred to a new value for permanent storage
        //print the permanent storage value
        //new number is added, stored temporarily in get
        //get is added to permanent storage
        //print permanent storage value
        double spaceFix = 0;
        if(initial == true) {
            stor = get;
            initial = false;
        } else if(initial == false) {
            stor = stor + get;
        }
        spaceFix = stor.length() / 4;
        int numberOfSpaces = 56 - stor.length() + (int) spaceFix;
        String format = String.format("%" + numberOfSpaces + "s", stor);
        display.setText(format);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button[0]) {
            numberButtons("7");
        }
        if(ae.getSource() == button[1]) {
            numberButtons("8");
        }
        if(ae.getSource() == button[2]) {
            numberButtons("9");
        }
        if(ae.getSource() == button[3]) {
            operatorButtons(0); //add function[0]
        }
        if(ae.getSource() == button[4]) {
            numberButtons("4");
        }
        if(ae.getSource() == button[5]) {
            numberButtons("5");
        }
        if(ae.getSource() == button[6]) {
            numberButtons("6");
        }
        if(ae.getSource() == button[7]) {
            operatorButtons(1); //subtract function[1]
        }
        if(ae.getSource() == button[8]) {
            numberButtons("1");
        }
        if(ae.getSource() == button[9]) {
            numberButtons("2");
        }
        if(ae.getSource() == button[10]) {
            numberButtons("3");
        }
        if(ae.getSource() == button[11]) {
            operatorButtons(2); //multiplication function[2]
        }
        if(ae.getSource() == button[12]) {
            if(typeDot == false) {
            } else {
                numberButtons(".");
                typeDot = false;
            }
        }
        if(ae.getSource() == button[13]) {
            operatorButtons(3); //divide function[3]
        }
        if(ae.getSource() == button[14]) {
            clearFunction();
            parabola = false;
            parabComplete = true;
        }
        if(ae.getSource() == button[15]) {
            getSqrt();
        }
        if(ae.getSource() == button[16]) {
            getPosNeg();
        }
        if((ae.getSource() == button[17]) && display.getText().equals("")) {
        } else if((ae.getSource() == button[17]) && (parabola == false)) {
            getResult();
        } else if((ae.getSource() == button[17]) && (parabola == true)) {
            parabolaButton();
        }
        if(ae.getSource() == button[18]) {
            numberButtons("0");
        }
        if(ae.getSource() == button[19]) {
            clearFunction();
            parabolaInstructions();
            parabola = true;
            parabComplete = false;
            display.setText("Initial velocity: ");
        }
        if(ae.getSource() == button[20]) {
            operatorButtons(4);//powerFunction();
        }
    }

    public void parabolaInstructions() {
        //Create the dialog.
        final JDialog dialog = new JDialog(frame, "How to use the Parabola function");
        //Add contents to it. It must have a close button,
        //since some L&Fs (notably Java/Metal) don't provide one
        //in the window decorations for dialogs.
        JLabel label = new JLabel("<html><p align=center>" + "Step 1:  Type in the initial velocity and press the \"=\" button<br>" + "Step 2:  Type in the angle of Release (make sure that it is between 0 and 90)<br>" + "Step 3:  Press the \"=\" button to scroll through the results<br>" + "Step 4:  Profit");
        label.setHorizontalAlignment(JLabel.CENTER);
        Font font = label.getFont();
        label.setFont(label.getFont().deriveFont(font.PLAIN, 14.0f));
        JButton closeButton = new JButton("Ok");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        JPanel closePanel = new JPanel();
        closePanel.setLayout(new BoxLayout(closePanel, BoxLayout.LINE_AXIS));
        closePanel.add(Box.createHorizontalGlue());
        closePanel.add(closeButton);
        closePanel.setBorder(BorderFactory.
                createEmptyBorder(0, 0, 5, 5));
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(label, BorderLayout.CENTER);
        contentPane.add(closePanel, BorderLayout.PAGE_END);
        contentPane.setOpaque(true);
        dialog.setContentPane(contentPane);
        //Show it.
        dialog.setSize(new Dimension(400, 200));
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public void numberButtons(String i) {
        if(typeNum == false) {
            display.setText("");
            format(i);
        } else {
            format(i);
        }
        typeNum = true;
    }

    public void operatorButtons(int funct) {
        if(display.getText().equals("")) {
        } else {
            temporary[0] = Double.parseDouble(display.getText());
            function[funct] = true;
            clear();
        }
    }

    public void clearFunction() {
        clear();
        try {
            for(int i = 0; i < 5; i++) {
                function[i] = false;
            }
            for(int i = 0; i < 2; i++) {
                temporary[i] = 0;
            }
        } catch(NullPointerException e) {
        }
        //For parabola()
        Vi = 0;
        Vx = 0;
        Vy = 0;
        T_max = 0;
        Y_displ = 0;
        X_displ = 0;
        h = 0;
        k = 0;
        a_parab = 0;
    }

    public void clear() {
        display.setText("");
        stor = "";
        typeDot = true;
        initial = true;
    }

    public static void main(String[] arguments) {
        CalcClass c = new CalcClass();
    }
}