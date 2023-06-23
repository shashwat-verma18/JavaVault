package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton hundred, five_hundred, thousand, two_thousand, five_thousand, ten_thousand, back;
    String cardNo;
    FastCash(String cardNo){
        this.cardNo = cardNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setForeground(Color.white);
        text.setFont(new Font("Courier New",Font.BOLD,20));
        text.setBounds(231,205,700,35);
        image.add(text);

        hundred = new JButton("Rs. 100");
        hundred.setBounds(175,339,160,30);
        hundred.setFont(new Font("Courier New",Font.BOLD,15));
        hundred.addActionListener(this);
        image.add(hundred);

        five_hundred = new JButton("Rs. 500");
        five_hundred.setBounds(392,339,180,30);
        five_hundred.setFont(new Font("Courier New",Font.BOLD,15));
        five_hundred.addActionListener(this);
        image.add(five_hundred);

        thousand = new JButton("Rs. 1000");
        thousand.setBounds(175,377,160,30);
        thousand.setFont(new Font("Courier New",Font.BOLD,15));
        thousand.addActionListener(this);
        image.add(thousand);

        two_thousand = new JButton("Rs. 2000");
        two_thousand.setBounds(392,377,180,30);
        two_thousand.setFont(new Font("Courier New",Font.BOLD,15));
        two_thousand.addActionListener(this);
        image.add(two_thousand);

        five_thousand = new JButton("Rs. 5000");
        five_thousand.setBounds(175,415,160,30);
        five_thousand.setFont(new Font("Courier New",Font.BOLD,15));
        five_thousand.addActionListener(this);
        image.add(five_thousand);

        ten_thousand = new JButton("Rs. 10000");
        ten_thousand.setBounds(392,415,180,30);
        ten_thousand.setFont(new Font("Courier New",Font.BOLD,15));
        ten_thousand.addActionListener(this);
        image.add(ten_thousand);

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
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(cardNo).setVisible(true);
        }
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

            Date dt = new Date();

            if (e.getSource() == hundred) {
                if (sum >= 100) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '100')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs 100 Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }
            else if (e.getSource() == five_hundred) {
                if (sum >= 500) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '500')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs 500 Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }

            else if (e.getSource() == thousand) {
                if (sum >= 1000) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '1000')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs 1000 Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }
            else if (e.getSource() == two_thousand) {
                if (sum >= 2000) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '2000')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs 2000 Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }
            else if (e.getSource() == five_thousand) {
                if (sum >= 5000) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '5000')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs 5000 Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }
            else if (e.getSource() == ten_thousand) {
                if (sum >= 10000) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '10000')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs 10000 Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
            }

        }catch (Exception e2){
            System.out.println(e2);
        }
    }
}
