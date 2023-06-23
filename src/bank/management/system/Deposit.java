package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    String cardNo;
    JTextField amount;
    Deposit(String cardNo){
        this.cardNo = cardNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("Courier New",Font.BOLD,16));
        text.setBounds(200,205,500,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Courier New", Font.BOLD,15));
        amount.setBounds(180,245,390,30);
        image.add(amount);


        deposit = new JButton("DEPOSIT");
        deposit.setBounds(392,415,180,30);
        deposit.setFont(new Font("Courier New",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(392,453,180,30);
        back.setFont(new Font("Courier New",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);

        setSize(1000,800);
        setLocation(250,20);
        setUndecorated(true);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(cardNo).setVisible(true);
        }
        else if(e.getSource() == deposit){
            String amt = amount.getText();
            Date dt = new Date();
            try{
                Conn c = new Conn();
                String query = "insert into bank values('"+cardNo+"', '"+dt+"', 'CREDIT', '"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amt+" Deposited Successfully!");

                setVisible(false);
                new Transactions(cardNo).setVisible(true);

            }catch (Exception e2){

            }
        }
    }
}
