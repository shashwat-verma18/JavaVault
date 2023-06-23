package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Random;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUp1 extends JFrame implements ActionListener{

    long ran;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pinCodeTextField, stateTextField;
    JButton next;
    JRadioButton male, female, single, married, other;
    JDateChooser date;

    SignUp1(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);


        try{
            while(true){
                Random r = new Random();
                ran = Math.abs((r.nextLong()%9000L)+1000L);

                Conn c = new Conn();
                String q = "select * from signup where formNo = '"+ran+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next())
                    continue;
                else
                    break;
            }

        }catch (Exception ex){
            System.out.println(ex);
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        JLabel label = new JLabel(i1);
        label.setBounds(115,0,150,120);
        add(label);

        JLabel formNo = new JLabel("Application Form No : "+ran);
        formNo.setForeground(Color.decode("#000080"));
        formNo.setFont(new Font("Courier New",Font.BOLD,28));
        formNo.setBounds(275,20,600,50);
        add(formNo);


        JLabel pDetails = new JLabel("Page 1 : Personal Details");
        pDetails.setFont(new Font("Raleway",Font.BOLD,20));
        pDetails.setBounds(345,70,400,30);
        add(pDetails);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        name.setBounds(100,150,200,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(350,150,380,30);
        nameTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.PLAIN,20));
        fname.setBounds(100,200,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(350,200,380,30);
        fnameTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.PLAIN,20));
        dob.setBounds(100,250,200,30);
        add(dob);

        date = new JDateChooser();
        date.setBounds(350,250,380,30);
        date.setFont(new Font("Courier New",Font.BOLD,15));
        add(date);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.PLAIN,20));
        gender.setBounds(100,300,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350,300,150,30);
        male.setFont(new Font("Courier New",Font.BOLD,15));
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(500,300,150,30);
        female.setFont(new Font("Courier New",Font.BOLD,15));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway",Font.PLAIN,20));
        email.setBounds(100,350,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(350,350,380,30);
        emailTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(emailTextField);

        JLabel mstatus = new JLabel("Marital Status : ");
        mstatus.setFont(new Font("Raleway",Font.PLAIN,20));
        mstatus.setBounds(100,400,200,30);
        add(mstatus);

        single = new JRadioButton("Single");
        single.setBounds(350,400,150,30);
        single.setFont(new Font("Courier New",Font.BOLD,15));
        single.setBackground(Color.white);
        add(single);

        married = new JRadioButton("Married");
        married.setBounds(500,400,150,30);
        married.setFont(new Font("Courier New",Font.BOLD,15));
        married.setBackground(Color.white);
        add(married);

        other = new JRadioButton("Other");
        other.setBounds(650,400,150,30);
        other.setFont(new Font("Courier New",Font.BOLD,15));
        other.setBackground(Color.white);
        add(other);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(single);
        bg2.add(married);
        bg2.add(other);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.PLAIN,20));
        address.setBounds(100,450,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(350,450,380,30);
        addressTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(addressTextField);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.PLAIN,20));
        city.setBounds(100,500,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(350,500,380,30);
        cityTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(cityTextField);

        JLabel pinCode = new JLabel("Pin Code : ");
        pinCode.setFont(new Font("Raleway",Font.PLAIN,20));
        pinCode.setBounds(100,550,200,30);
        add(pinCode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setBounds(350,550,380,30);
        pinCodeTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(pinCodeTextField);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.PLAIN,20));
        state.setBounds(100,600,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(350,600,380,30);
        stateTextField.setFont(new Font("Courier New",Font.BOLD,15));
        add(stateTextField);

        next = new JButton("Next");
        next.setBounds(630,680,100,40);
        next.setFont(new Font("Courier New",Font.PLAIN,25));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setVisible(true);
        setLocation(350,30);
    }


    public static void main(String[] args) {
        new SignUp1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = ""+ran;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
            gender = "Male";
        else if(female.isSelected())
            gender = "Female";
        String email = emailTextField.getText();
        String maritalStatus = null;
        if(single.isSelected())
            maritalStatus = "Single";
        else if(married.isSelected())
            maritalStatus = "Married";
        else if(other.isSelected())
            maritalStatus = "Other";
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pinCode = pinCodeTextField.getText();
        String state = stateTextField.getText();

        try{
            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Name is Required");
            else{
                Conn c = new Conn();
                String query = "insert into personalDetails values('"+formNo+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+pinCode+"', '"+state+"', null, null, null, null, null, null, null, null, null, null, null)";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUp2(formNo).setVisible(true);


            }
        }catch (Exception e2){
            System.out.println(e2);
        }
    }
}
