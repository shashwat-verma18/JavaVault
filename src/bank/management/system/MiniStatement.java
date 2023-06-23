package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class MiniStatement extends JFrame implements ActionListener {

    String cardNo;
    MiniStatement(String cardNo){

        this.cardNo = cardNo;

        setTitle("AUTOMATED TELLER MACHINE");

        String[][] trxn = new String[5][3];

        setLayout(null);

        String cardNum=cardNo;
        if(cardNum!="")
            cardNum=cardNum.substring(0,4)+"-"+cardNum.substring(4,8)+"-"+cardNum.substring(8,12)+"-"+cardNum.substring(12);

        try{
            Conn c = new Conn();
            String query = "select * from bank where cardNo = '"+cardNo+"' order by date DESC limit 5";
            ResultSet rs = c.s.executeQuery(query);
            int i=0;
            while(rs.next()){
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amt = rs.getString("amount");

                trxn[i][0] = date;
                trxn[i][1] = type;
                trxn[i][2] = amt;
                i++;
            }



        }catch (Exception ex){
            System.out.println(ex);
        }

        JLabel bank = new JLabel("Indian Bank");
        bank.setForeground(Color.decode("#000080"));
        bank.setFont(new Font("Courier New",Font.BOLD,20));
        bank.setBounds(180,12,600,50);
        add(bank);


        JLabel card = new JLabel("Card Number : "+cardNum);
        card.setFont(new Font("Raleway",Font.BOLD,13));
        card.setBounds(80,70,400,30);
        add(card);

        Date currDate = new Date();
        JLabel dt = new JLabel(""+currDate);
        dt.setFont(new Font("Raleway",Font.PLAIN,12));
        dt.setBounds(175,100,400,30);
        add(dt);

        JLabel name = new JLabel("Date");
        name.setFont(new Font("Courier New",Font.BOLD,15));
        name.setBounds(20,135,200,30);
        add(name);

        JLabel fname = new JLabel("Credit/Debit");
        fname.setFont(new Font("Courier New",Font.BOLD,15));
        fname.setBounds(210,135,200,30);
        add(fname);

        JLabel dob = new JLabel("Amount");
        dob.setFont(new Font("Courier New",Font.BOLD,15));
        dob.setBounds(380,135,200,30);
        add(dob);

        JLabel date1 = new JLabel(trxn[0][0].substring(0,19));
        date1.setFont(new Font("Courier New",Font.PLAIN,15));
        date1.setBounds(20,160,200,30);
        add(date1);

        JLabel type1 = new JLabel(trxn[0][1]);
        type1.setFont(new Font("Courier New",Font.PLAIN,15));
        type1.setBounds(240,160,200,30);
        add(type1);

        JLabel amt1 = new JLabel("₹"+trxn[0][2]);
        amt1.setFont(new Font("Courier New",Font.PLAIN,15));
        amt1.setBounds(380,160,200,30);
        add(amt1);

        JLabel date2 = new JLabel(trxn[1][0].substring(0,19));
        date2.setFont(new Font("Courier New",Font.PLAIN,15));
        date2.setBounds(20,180,200,30);
        add(date2);

        JLabel type2 = new JLabel(trxn[1][1]);
        type2.setFont(new Font("Courier New",Font.PLAIN,15));
        type2.setBounds(240,180,200,30);
        add(type2);

        JLabel amt2 = new JLabel("₹"+trxn[1][2]);
        amt2.setFont(new Font("Courier New",Font.PLAIN,15));
        amt2.setBounds(380,180,200,30);
        add(amt2);

        JLabel date3 = new JLabel(trxn[2][0].substring(0,19));
        date3.setFont(new Font("Courier New",Font.PLAIN,15));
        date3.setBounds(20,200,200,30);
        add(date3);

        JLabel type3 = new JLabel(trxn[2][1]);
        type3.setFont(new Font("Courier New",Font.PLAIN,15));
        type3.setBounds(240,200,200,30);
        add(type3);

        JLabel amt3 = new JLabel("₹"+trxn[2][2]);
        amt3.setFont(new Font("Courier New",Font.PLAIN,15));
        amt3.setBounds(380,200,200,30);
        add(amt3);

        JLabel date4 = new JLabel(trxn[3][0].substring(0,19));
        date4.setFont(new Font("Courier New",Font.PLAIN,15));
        date4.setBounds(20,220,200,30);
        add(date4);

        JLabel type4 = new JLabel(trxn[3][1]);
        type4.setFont(new Font("Courier New",Font.PLAIN,15));
        type4.setBounds(240,220,200,30);
        add(type4);

        JLabel amt4 = new JLabel("₹"+trxn[3][2]);
        amt4.setFont(new Font("Courier New",Font.PLAIN,15));
        amt4.setBounds(380,220,200,30);
        add(amt4);

        JLabel date5 = new JLabel(trxn[4][0].substring(0,19));
        date5.setFont(new Font("Courier New",Font.PLAIN,15));
        date5.setBounds(20,240,200,30);
        add(date5);

        JLabel type5 = new JLabel(trxn[4][1]);
        type5.setFont(new Font("Courier New",Font.PLAIN,15));
        type5.setBounds(240,240,200,30);
        add(type5);

        JLabel amt5 = new JLabel("₹"+trxn[4][2]);
        amt5.setFont(new Font("Courier New",Font.PLAIN,15));
        amt5.setBounds(380,240,200,30);
        add(amt5);

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

        JLabel curr = new JLabel("Your current balance is ₹"+sum);
        curr.setFont(new Font("Courier New",Font.BOLD,15));
        curr.setBounds(20,430,600,30);
        add(curr);

        getContentPane().setBackground(Color.white);

        setSize(490,550);
        setVisible(true);
        setLocation(100,10);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
