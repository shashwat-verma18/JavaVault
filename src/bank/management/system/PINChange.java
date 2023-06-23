package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PINChange extends JFrame implements ActionListener {

    JPasswordField oldPin, newPin, rePin;
    JButton changePIN,back;
    String cardNo;
    PINChange(String cardNo){
        this.cardNo = cardNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);

        JLabel text = new JLabel("Change PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("Courier New",Font.BOLD,20));
        text.setBounds(322,185,700,35);
        image.add(text);

        JLabel opin = new JLabel("Enter Old PIN");
        opin.setForeground(Color.white);
        opin.setFont(new Font("Courier New",Font.BOLD,16));
        opin.setBounds(180,215,500,35);
        image.add(opin);

        oldPin = new JPasswordField();
        oldPin.setFont(new Font("Courier New", Font.BOLD,15));
        oldPin.setBounds(180,240,390,30);
        image.add(oldPin);

        JLabel nPin = new JLabel("Enter New PIN");
        nPin.setForeground(Color.white);
        nPin.setFont(new Font("Courier New",Font.BOLD,16));
        nPin.setBounds(180,275,500,35);
        image.add(nPin);

        newPin = new JPasswordField();
        newPin.setFont(new Font("Courier New", Font.BOLD,15));
        newPin.setBounds(180,300,390,30);
        image.add(newPin);

        JLabel reenterPin = new JLabel("Re-Enter PIN");
        reenterPin.setForeground(Color.white);
        reenterPin.setFont(new Font("Courier New",Font.BOLD,16));
        reenterPin.setBounds(180,340,500,35);
        image.add(reenterPin);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Courier New", Font.BOLD,15));
        rePin.setBounds(180,365,390,30);
        image.add(rePin);

        changePIN = new JButton("CHANGE PIN");
        changePIN.setBounds(392,415,180,30);
        changePIN.setFont(new Font("Courier New",Font.BOLD,15));
        changePIN.addActionListener(this);
        image.add(changePIN);

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
        new PINChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(cardNo).setVisible(true);
        }
        if(e.getSource()==changePIN){
            String old = oldPin.getText();
            String nPin = newPin.getText();
            String rPin = rePin.getText();

            if(old.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Old PIN");
            }else{
                if(nPin.isEmpty())
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                else{
                    if(rPin.isEmpty())
                        JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    else{
                        if(nPin.equals(rPin)){
                            try{
                                Conn c = new Conn();
                                String query = "select pin from login where cardNo = '"+cardNo+"'";
                                ResultSet rs = c.s.executeQuery(query);
                                String sPin=null;
                                while (rs.next())
                                    sPin = rs.getString("pin");

                                if(sPin.equals(old)){
                                    String query2 = "update login set pin ='"+nPin+"' where cardNo = '"+cardNo+"'";
                                    c.s.executeUpdate(query2);

                                    JOptionPane.showMessageDialog(null,"PIN Changed Successfully !");
                                    setVisible(false);
                                    new Transactions(cardNo).setVisible(true);

                                }else
                                    JOptionPane.showMessageDialog(null,"Incorrect PIN !");
                            }catch (Exception e2){
                                System.out.println(e2);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"PIN doesn't Match !");
                        }
                    }
                }

            }
        }
    }
}
