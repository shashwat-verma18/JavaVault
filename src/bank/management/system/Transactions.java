package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, cash_withdrawal, fast_cash, mini_statement, pin_change, balance_enquiry, exit;
    String cardNo;
    Transactions(String cardNo){
        this.cardNo = cardNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setForeground(Color.white);
        text.setFont(new Font("Courier New",Font.BOLD,20));
        text.setBounds(200,205,700,35);
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(175,339,160,30);
        deposit.setFont(new Font("Courier New",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);

        cash_withdrawal = new JButton("CASH WITHDRAWAL");
        cash_withdrawal.setBounds(392,339,180,30);
        cash_withdrawal.setFont(new Font("Courier New",Font.BOLD,15));
        cash_withdrawal.addActionListener(this);
        image.add(cash_withdrawal);

        fast_cash = new JButton("FAST CASH");
        fast_cash.setBounds(175,377,160,30);
        fast_cash.setFont(new Font("Courier New",Font.BOLD,15));
        fast_cash.addActionListener(this);
        image.add(fast_cash);

        mini_statement = new JButton("MINI STATEMENT");
        mini_statement.setBounds(392,377,180,30);
        mini_statement.setFont(new Font("Courier New",Font.BOLD,15));
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        pin_change = new JButton("PIN CHANGE");
        pin_change.setBounds(175,415,160,30);
        pin_change.setFont(new Font("Courier New",Font.BOLD,15));
        pin_change.addActionListener(this);
        image.add(pin_change);

        balance_enquiry = new JButton("BALANCE ENQUIRY");
        balance_enquiry.setBounds(392,415,180,30);
        balance_enquiry.setFont(new Font("Courier New",Font.BOLD,15));
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);

        exit = new JButton("EXIT");
        exit.setBounds(392,453,180,30);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        exit.addActionListener(this);
        image.add(exit);


        setSize(1000,800);
        setLocation(250,20);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(cardNo).setVisible(true);
        }
        else if(e.getSource() == cash_withdrawal){
            setVisible(false);
            new CashWithdrawal(cardNo).setVisible(true);
        }
        else if(e.getSource() == fast_cash){
            setVisible(false);
            new FastCash(cardNo).setVisible(true);
        }
        else if(e.getSource() == mini_statement){
//            setVisible(false);
//            new MiniStatement(cardNo).setVisible(true);
        }
        else if(e.getSource() == pin_change){
            setVisible(false);
            new PINChange(cardNo).setVisible(true);
        }
        else if(e.getSource() == balance_enquiry){
            setVisible(false);
            new BalanceEnquiry(cardNo).setVisible(true);
        }
        else if(e.getSource() == exit)
            System.exit(0);
    }
}
