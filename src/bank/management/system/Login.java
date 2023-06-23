package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinPassField;
    Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        JLabel label = new JLabel(i1);
        label.setBounds(200,0,150,120);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setForeground(Color.decode("#000080"));
        text.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        text.setBounds(340,45,400,50);
        add(text);

        JLabel cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Raleway",Font.PLAIN,25));
        cardNo.setBounds(190,150,150,30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(370,150,250,31);
        cardTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(cardTextField);

        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.PLAIN,25));
        pin.setBounds(190,220,150,30);
        add(pin);

        pinPassField = new JPasswordField();
        pinPassField.setBounds(370,220,250,31);
        pinPassField.setFont(new Font("Courier New",Font.BOLD,15));
        add(pinPassField);

        login = new JButton("SIGN IN");
        login.setBounds(215,300,150,40);
        login.setBackground(Color.decode("#38761d"));
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(435,300,150,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(235,360,320,40);
        signUp.setBackground(Color.decode("#cc0000"));
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);


        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);


    }
    public static void main(String[] args) {
        new Login();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinPassField.setText("");
        }
        else if(e.getSource() == login){

            String card = cardTextField.getText();
            String pin = pinPassField.getText();

            try{
                Conn c = new Conn();
                String query = "select * from login where cardNo = '"+card+"' and pin = '"+pin+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(card).setVisible(true);
                }else
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
            }catch (Exception e1){
                System.out.println(e1);
            }

        }
        else if(e.getSource() == signUp){
            setVisible(false);
            new SignUp1().setVisible(true);
        }
    }
}
