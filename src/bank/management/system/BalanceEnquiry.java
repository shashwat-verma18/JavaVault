package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton deposit, back;
    String cardNo;
    JTextField amount;
    BalanceEnquiry(String cardNo) {
        this.cardNo = cardNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 800);
        add(image);

        long sum=0;

        try{
            Conn c = new Conn();
            String query = "select * from bank where cardNo = '"+cardNo+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("type").equals("CREDIT")) {
                    sum += Long.parseLong(rs.getString("amount"));
                }
                else {
                    sum -= Long.parseLong(rs.getString("amount"));
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs "+sum);
        text.setForeground(Color.white);
        text.setFont(new Font("Courier New", Font.BOLD, 14));
        text.setBounds(190, 205, 500, 35);
        image.add(text);

        back = new JButton("BACK");
        back.setBounds(392, 453, 180, 30);
        back.setFont(new Font("Courier New", Font.BOLD, 15));
        back.addActionListener(this);
        image.add(back);

        setSize(1000, 800);
        setLocation(250, 20);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(cardNo).setVisible(true);
        }
    }
}
