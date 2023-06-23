package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton saving, fd, current, recDep;

    JCheckBox atm, netBank, mobileBank, email, cheque, stmt, agree;

    JButton submit, cancel;
    String formNo;
    SignUp3(String formNo){
        this.formNo = formNo;

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        JLabel label = new JLabel(i1);
        label.setBounds(130,0,150,120);
        add(label);

        JLabel formNo2 = new JLabel("Form No : "+formNo);
        formNo2.setFont(new Font("Courier New",Font.BOLD,14));
        formNo2.setBounds(680,5,600,50);
        add(formNo2);

        JLabel pDetails = new JLabel("Page 3 : Account Details");
        pDetails.setFont(new Font("Raleway",Font.BOLD,20));
        pDetails.setBounds(310,51,400,30);
        add(pDetails);

        JLabel type = new JLabel("Account Type : ");
        type.setFont(new Font("Raleway",Font.PLAIN,20));
        type.setBounds(100,150,200,30);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(300,180,200,30);
        saving.setFont(new Font("Courier New",Font.BOLD,15));
        saving.setBackground(Color.white);
        add(saving);

        fd = new JRadioButton("Fixed Deposit Account");
        fd.setBounds(550,180,250,30);
        fd.setFont(new Font("Courier New",Font.BOLD,15));
        fd.setBackground(Color.white);
        add(fd);

        current = new JRadioButton("Current Account");
        current.setBounds(300,210,200,30);
        current.setFont(new Font("Courier New",Font.BOLD,15));
        current.setBackground(Color.white);
        add(current);

        recDep = new JRadioButton("Recurring Deposit Account");
        recDep.setBounds(550,210,250,30);
        recDep.setFont(new Font("Courier New",Font.BOLD,15));
        recDep.setBackground(Color.white);
        add(recDep);

        ButtonGroup bg = new ButtonGroup();
        bg.add(saving);
        bg.add(fd);
        bg.add(current);
        bg.add(recDep);

        JLabel cardNo = new JLabel("Card Number : ");
        cardNo.setFont(new Font("Raleway",Font.PLAIN,20));
        cardNo.setBounds(100,260,200,30);
        add(cardNo);

        JLabel cardDetails = new JLabel("(Your 16-digit Card Number)");
        cardDetails.setFont(new Font("Raleway",Font.PLAIN,12));
        cardDetails.setBounds(100,277,200,30);
        add(cardDetails);

        JLabel cardNum = new JLabel(" XXXX-XXXX-XXXX-4184");
        cardNum.setFont(new Font("Courier New",Font.BOLD,15));
        cardNum.setBounds(300,263,200,30);
        add(cardNum);

        JLabel cardNumDetails = new JLabel(" It would appear on ATM Card / Cheque Book and Statements");
        cardNumDetails.setFont(new Font("Courier New",Font.PLAIN,12));
        cardNumDetails.setBounds(300,279,450,30);
        add(cardNumDetails);

        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.PLAIN,20));
        pin.setBounds(100,330,200,30);
        add(pin);

        JLabel pinDetails = new JLabel("(4-digit password)");
        pinDetails.setFont(new Font("Raleway",Font.PLAIN,12));
        pinDetails.setBounds(100,347,200,30);
        add(pinDetails);

        JLabel pinNum = new JLabel(" XXXX");
        pinNum.setFont(new Font("Courier New",Font.BOLD,15));
        pinNum.setBounds(300,332,200,30);
        add(pinNum);

        JLabel services = new JLabel("Services Required : ");
        services.setFont(new Font("Raleway",Font.PLAIN,20));
        services.setBounds(100,400,200,30);
        add(services);

        atm = new JCheckBox(" ATM Card");
        atm.setFont(new Font("Courier New",Font.BOLD,15));
        atm.setBounds(300,430,200,30);
        atm.setBackground(Color.white);
        add(atm);

        netBank = new JCheckBox(" Internet Banking");
        netBank.setFont(new Font("Courier New",Font.BOLD,15));
        netBank.setBounds(550,430,200,30);
        netBank.setBackground(Color.white);
        add(netBank);

        mobileBank = new JCheckBox(" Mobile Banking");
        mobileBank.setFont(new Font("Courier New",Font.BOLD,15));
        mobileBank.setBounds(300,465,200,30);
        mobileBank.setBackground(Color.white);
        add(mobileBank);

        email = new JCheckBox(" Email Alerts");
        email.setFont(new Font("Courier New",Font.BOLD,15));
        email.setBounds(550,465,200,30);
        email.setBackground(Color.white);
        add(email);

        cheque = new JCheckBox(" Cheque Book");
        cheque.setFont(new Font("Courier New",Font.BOLD,15));
        cheque.setBounds(300,500,200,30);
        cheque.setBackground(Color.white);
        add(cheque);

        stmt = new JCheckBox(" E-Statement");
        stmt.setFont(new Font("Courier New",Font.BOLD,15));
        stmt.setBounds(550,500,200,30);
        stmt.setBackground(Color.white);
        add(stmt);

        agree = new JCheckBox(" I hereby declare that the above entered details are true to the best of my knowledge");
        agree.setFont(new Font("Raleway",Font.BOLD,12));
        agree.setBounds(165,590,650,30);
        agree.setBackground(Color.white);
        add(agree);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,640,150,30);
        cancel.setFont(new Font("Courier New",Font.BOLD,15));
        cancel.setBackground(Color.decode("#38761d"));
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(470,640,150,30);
        submit.setFont(new Font("Courier New",Font.BOLD,15));
        submit.setBackground(Color.decode("#cc0000"));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.white);

        setSize(850,770);
        setVisible(true);
        setLocation(350,30);

    }
    public static void main(String[] args) {
        new SignUp3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){

            String accType="";
            if(saving.isSelected())
                accType = "Savings Account";
            else if(current.isSelected())
                accType = "Current Account";
            else if(fd.isSelected())
                accType = "Fixed Deposit Account";
            else if(recDep.isSelected())
                accType = "Recurring Deposit Account";

            String cardNum = null;
            String pass = null;
            try{
                while(true){
                    Random r = new Random();
                    cardNum = ""+Math.abs((r.nextLong()%90000000L)+5419190500000000L);
                    pass = ""+Math.abs((r.nextLong()%9000L)+1000L);

                    Conn c = new Conn();
                    String q = "select * from login where cardNo = '"+cardNum+"'";
                    ResultSet rs = c.s.executeQuery(q);
                    if(rs.next())
                        continue;
                    else
                        break;
                }

            }catch (Exception ex){
                System.out.println(ex);
            }


            String serReq="";
            if(atm.isSelected())
                serReq+=" ATM Card";
            if(netBank.isSelected())
                serReq+=" Internet Banking";
            if(mobileBank.isSelected())
                serReq+=" Mobile Banking";
            if(email.isSelected())
                serReq+=" Email Alerts";
            if(cheque.isSelected())
                serReq+=" Cheque Book";
            if(stmt.isSelected())
                serReq+=" E-Statement";


            try{
                if(accType=="")
                    JOptionPane.showMessageDialog(null,"Account Type is Required");

                if(agree.isSelected()) {

                    Conn c = new Conn();
                    String query1 = "update personalDetails set accType = '" + accType + "', services = '" + serReq + "' where formNo = '" + formNo + "'";
                    String query2 = "insert into login values('" + formNo + "', '" + cardNum + "', '" + pass + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNum + "\n PIN : " + pass);

                    setVisible(false);
                    new Deposit(cardNum).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please select the Terms and Conditions");

            }catch (Exception e2){
                System.out.println(e2);
            }
        }
        else if(e.getSource()==cancel) {

                try{
                    Conn c = new Conn();
                    String query = "delete from personalDetails where formNo = '"+formNo+"'";
                    c.s.executeUpdate(query);

                }catch (Exception e2){
                    System.out.println(e2);
                }

                setVisible(false);
                new Login().setVisible(true);
        }
    }
}
