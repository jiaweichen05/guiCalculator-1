import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener
{
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,dec,neg,divide,multiply,minus,plus,enter,clear,del,random;
    private JTextField display;
    private JLabel disclaimer;
    private JPanel p1,p2,p3,p4,pLower,pBot;
    private int operatorLoc;
    private double firstDigit,secondDigit,result;
    private String symbol,title;

    public GUI ()
    {
        setTitle("Calculator");
        setUpButton();
        setUpJTextField();
        setUpJLabel();
        setUpJPanel();
        addComponents();
        setActionCommands();
        addActionListeners();
        setLayout(new FlowLayout() );
        add(p1);
        add(pBot);
        add(disclaimer);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    public GUI(String title)
    {
        this.title = title;
        setTitle(title);
        setUpButton();
        setUpJTextField();
        setUpJLabel();
        setUpJPanel();
        addComponents();
        setActionCommands();
        addActionListeners();
        setLayout(new FlowLayout() );
        add(p1);
        add(pBot);
        add(disclaimer);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public void actionPerformed( ActionEvent click)
    {
        String displayText = display.getText();
        String actionCommand = click.getActionCommand();
        switch (actionCommand){
            case "one":
                displayText += "1";
                break;
            case "two":
                displayText += "2";
                break;
            case "three":
                displayText += "3";
                break;
            case "four":
                displayText += "4";
                break;
            case "five":
                displayText += "5";
                break;
            case "six":
                displayText += "6";
                break;
            case "seven":
                displayText += "7";
                break;
            case "eight":
                displayText += "8";
                break;
            case "nine":
                displayText += "9";
                break;
            case "zero":
                displayText += "0";
                break;
            case "dec":
                displayText += ".";
                break;
            case "neg":
                displayText += "-";
                break;
            case "divide":
                displayText += "÷";
                break;
            case "multiply":
                displayText += "×";
                break;
            case "minus":
                displayText += "−";
                break;
            case "plus":
                displayText += "+";
                break;
            case "enter":
                if (!displayText.equals(""))
                {
                    parseString();
                    performSymbol();
                    displayText = Double.toString(result);
                }
                break;
            case "clear":
                displayText = "";
                break;
            case "delete":
                int displayTxtLast = displayText.length() - 1;
                displayText = displayText.substring(0, displayTxtLast);
                break;
            case "random":
                int random = (int) (Math.random() * 100) + 1;
                displayText += random;
                break;
        }
        display.setText(displayText);
        repaint();
    }

    private void setUpButton(){
        b1 = new JButton("1"); b2 = new JButton("2");
        b3 = new JButton("3"); b4 = new JButton("4");
        b5 = new JButton("5"); b6 = new JButton("6");
        b7 = new JButton("7"); b8 = new JButton("8");
        b9 = new JButton("9"); b0 = new JButton("0");
        dec = new JButton("."); neg = new JButton("-");
        divide = new JButton("÷");
        multiply = new JButton("×");
        minus = new JButton("−");
        plus = new JButton("+");
        enter = new JButton("enter");
        clear = new JButton("clear");
        del = new JButton("delete");
        random = new JButton("rand");
    }

    private void setUpJTextField(){
        display = new JTextField(20);
        display.setPreferredSize( new Dimension( 200, 40 ));
        display.setEditable(false);
    }

    private void setUpJLabel(){
        disclaimer = new JLabel("Disclaimer: Use two numbers and one operation");
        disclaimer.setFont(new Font("Verdana", Font.BOLD, 10));
    }

    private void setUpJPanel(){
        p1 = new JPanel(); p2 = new JPanel(); p3 = new JPanel();
        p4 = new JPanel(); pLower = new JPanel(); pBot = new JPanel();
        p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
        p3.setLayout(new GridLayout(4,1,2,2));
        p4.setLayout(new GridLayout(4,3,2,2));
        pLower.setLayout(new BoxLayout(pLower, BoxLayout.X_AXIS));
        pBot.setLayout(new BoxLayout(pBot,BoxLayout.Y_AXIS));
    }

    private void addComponents(){
        p1.add(display);
        p2.add(enter); p2.add(clear); p2.add(del); p2.add(random);
        p3.add(divide); p3.add(multiply); p3.add(minus); p3.add(plus);
        p4.add(b1); p4.add(b2); p4.add(b3); p4.add(b4); p4.add(b5); p4.add(b6); p4.add(b7); p4.add(b8); p4.add(b9); p4.add(b0); p4.add(dec); p4.add(neg);
        pLower.add(p3); pLower.add(p4);
        pBot.add(p2); pBot.add(pLower);
    }

    private void setActionCommands(){
        b1.setActionCommand("one");
        b2.setActionCommand("two");
        b3.setActionCommand("three");
        b4.setActionCommand("four");
        b5.setActionCommand("five");
        b6.setActionCommand("six");
        b7.setActionCommand("seven");
        b8.setActionCommand("eight");
        b9.setActionCommand("nine");
        b0.setActionCommand("zero");
        dec.setActionCommand("dec");
        neg.setActionCommand("neg");
        divide.setActionCommand("divide");
        multiply.setActionCommand("multiply");
        minus.setActionCommand("minus");
        plus.setActionCommand("plus");
        enter.setActionCommand("enter");
        clear.setActionCommand("clear");
        del.setActionCommand("delete");
        random.setActionCommand("random");
    }

    private void addActionListeners(){
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        dec.addActionListener(this);
        neg.addActionListener(this);
        divide.addActionListener(this);
        multiply.addActionListener(this);
        minus.addActionListener(this);
        plus.addActionListener(this);
        enter.addActionListener(this);
        clear.addActionListener(this);
        del.addActionListener(this);
        random.addActionListener(this);
    }

    public void parseString(){
        String displayText = display.getText();
        int displayTxtLength = displayText.length();
        boolean isSymbol = false;
        for (int i = 0; !isSymbol; i++)
        {
            String subSearch = displayText.substring(i, i+1);
            boolean isDivide = subSearch.equals("÷");
            boolean isMultiply = subSearch.equals("×");
            boolean isMinus = subSearch.equals("−");
            boolean isPlus = subSearch.equals("+");
            isSymbol = (isDivide || isMultiply || isMinus || isPlus);
            if (isSymbol)
            {
                operatorLoc = i;
                symbol = subSearch;
            }
        }
        String firstTDigit = displayText.substring(0, operatorLoc);
        String secondTDigit = displayText.substring(operatorLoc + 1, displayTxtLength);
        firstDigit = Double.parseDouble(firstTDigit);
        secondDigit = Double.parseDouble(secondTDigit);
    }
    private void performSymbol(){
        switch (symbol){
            case "÷":
                divide();
                break;
            case "×":
                multiply();
                break;
            case "−":
                minus();
                break;
            case "+":
                plus();
                break;
        }
    }
    private void multiply(){
        result = firstDigit * secondDigit;
    }
    private void divide(){
        result = firstDigit/secondDigit;
    }
    private void minus(){
        result = firstDigit - secondDigit;
    }
    private void plus(){
        result = firstDigit + secondDigit;
    }
    public String getTitle(){
        return title;
    }
    public void setGUITitle(String newTitle){
        title = newTitle;
        setTitle(title);
    }
}
