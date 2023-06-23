package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CashWithdrawal extends JFrame implements ActionListener {
    JButton withdraw, back;
    String cardNo;
    JTextField amount;
    CashWithdrawal(String cardNo) {
        this.cardNo = cardNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 800);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("Courier New", Font.BOLD, 16));
        text.setBounds(200, 205, 500, 35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Courier New", Font.BOLD, 15));
        amount.setBounds(180, 245, 390, 30);
        image.add(amount);


        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(392, 415, 180, 30);
        withdraw.setFont(new Font("Courier New", Font.BOLD, 15));
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        new CashWithdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(cardNo).setVisible(true);
        }
        else if(e.getSource()==withdraw){
            long sum=0;
            try {
                Conn c = new Conn();
                String query = "select * from bank where cardNo = '" + cardNo + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    if (rs.getString("type").equals("CREDIT")) {
                        sum += Long.parseLong(rs.getString("amount"));
                    } else {
                        sum -= Long.parseLong(rs.getString("amount"));
                    }
                }

                Date dt = new Date();

                String amt = amount.getText();

                long amtL = Long.parseLong(amt);
                if (sum >= amtL) {
                    String query1 = "insert into bank values('" + cardNo + "', '" + dt + "', 'DEBIT', '"+amt+"')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs "+amt+" Debited Successfully!");

                    setVisible(false);
                    new Transactions(cardNo).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }

            }catch (Exception e2){
                System.out.println(e2);
            }
        }

    }
}
