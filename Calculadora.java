import javax.swing.*;// Interfaces de Usuario
import java.awt.*;// Graficaos y diseño de la GUI
import java.awt.event.*;//para eventos de click

public class Calculadora extends JFrame implements ActionListener {


    private JTextField display; // Campo de texto de la entrada del usuario y el resultado
    private JButton[] numButtons, funcButtons;// Arreglo para guardar numeros 0-9 y funciones 
    private double num1 = 0, num2 = 0, resut = 0;
    private char operador;

    public Calculadora(){

        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        display = new JTextField();
        display.setBounds(50, 25,300,50);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setText("0");

        String[] funcLabels = {"+","-","x","÷",".","=","Del","C"};
        funcButtons = new JButton[funcLabels.length];

        for (int i = 0; i < funcLabels.length; i++){
            funcButtons[i] = new JButton(funcLabels[i]);
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            funcButtons[i].setFocusable(false);
        }

        numButtons = new JButton[10];
        
        for (int i = 0; i < 10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numButtons[i].setFocusable(false);
        }

        funcButtons[6].setBounds(50, 100,100,50);//Preciona "Del"
        funcButtons[7].setBounds(150, 100,100,50);// Preciona "C"

        JPanel panel = new JPanel(new GridLayout(4,4,10,10));
        String[] buttonOrder = {"1","2","3","+","4","5","6","-","7","8","9","x",".","0","=","÷"};
        for (String label : buttonOrder){
            if (label.matches("[0-9]")) panel.add(numButtons[Integer.parseInt(label)]);
            else{
                for (JButton button : funcButtons){
                    if(button.getText().equals(label)) panel.add(button);
                }
            }
        }

        panel.setBounds(50, 160,300,300);

        add(panel);
        add(display);
        add(funcButtons[6]);
        add(funcButtons[7]);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();
        if ("0123456789".contains(command)){
            display.setText(display.getText().equals("0") ? command : display.getText() + command);
        } else if (command.equals(".")) {
            if (!display.getText().contains(".")) display.setText(display.getText() + ".");
        } else if ("+-x÷".contains(command)){
            num1 = Double.parseDouble(display.getText());
            operador = command.charAt(0);
            display.setText("");
        } else if (command.equals("=")){
            num2 = Double.parseDouble(display.getText());
            switch (operador) {
                case '+' : resut = num1 + num2; break; //Suma
                case '-' : resut = num1 - num2; break; //Resta
                case 'x' : resut = num1 * num2; break; //Multiplicacion
                case '÷' : resut = (num2 != 0) ? num1 / num2: Double.NaN; break; //Division
            }
            display.setText(Double.isNaN(resut)? "Error": String.valueOf((resut == (long) resut) ? (long) resut : resut));
            num1 = resut;
        } else if (command.equals("C")){
            display.setText("0");
            num1 = num2 = resut = 0;
        } else if(command.equals("Del")){ // 
            display.setText(display.getText().length() > 1 ? display.getText().substring(0, display.getText().length() - 1): "0");

        }

    }

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        new Calculadora();
    }
}


