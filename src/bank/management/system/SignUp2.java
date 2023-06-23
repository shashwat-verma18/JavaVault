package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class SignUp2 extends JFrame implements ActionListener {


    JComboBox religion, cat, inc, occupation, education;
    JTextField panNo, aadharNo;
    JRadioButton scYes, scNo, eaYes, eaNo;

    String formNo;
    SignUp2(String formNo){

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


        JLabel pDetails = new JLabel("Page 2 : Additional Details");
        pDetails.setFont(new Font("Raleway",Font.BOLD,20));
        pDetails.setBounds(310,51,400,30);
        add(pDetails);

        JLabel rel = new JLabel("Religion : ");
        rel.setFont(new Font("Raleway",Font.PLAIN,20));
        rel.setBounds(100,150,200,30);
        add(rel);

        String varRel[] = {"Hindu","Sikh","Christian","Muslim","Other"};
        religion = new JComboBox(varRel);
        religion.setBounds(350,150,400,30);
        religion.setFont(new Font("Courier New",Font.BOLD,15));
        religion.setBackground(Color.white);
        add(religion);

        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.PLAIN,20));
        category.setBounds(100,200,200,30);
        add(category);

        String varCat[] = {"General","OBC","SC","ST","Other"};
        cat = new JComboBox(varCat);
        cat.setBounds(350,200,400,30);
        cat.setFont(new Font("Courier New",Font.BOLD,15));
        cat.setBackground(Color.white);
        add(cat);

        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.PLAIN,20));
        income.setBounds(100,250,200,30);
        add(income);

        String varInc[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000", "> 10,00,000"};
        inc = new JComboBox(varInc);
        inc.setBounds(350,250,400,30);
        inc.setFont(new Font("Courier New",Font.BOLD,15));
        inc.setBackground(Color.white);
        add(inc);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.PLAIN,20));
        edu.setBounds(100,300,200,30);
        add(edu);


        JLabel edu2 = new JLabel("Qualification : ");
        edu2.setFont(new Font("Raleway",Font.PLAIN,20));
        edu2.setBounds(100,322,200,30);
        add(edu2);

        String varEdu[] = {"Non Graduate","Graduate","Post Graduate","Doctrate","Other"};
        education = new JComboBox(varEdu);
        education.setBounds(350,315,400,30);
        education.setFont(new Font("Courier New",Font.BOLD,15));
        education.setBackground(Color.white);
        add(education);

        JLabel occ = new JLabel("Occupation : ");
        occ.setFont(new Font("Raleway",Font.PLAIN,20));
        occ.setBounds(100,370,200,30);
        add(occ);

        String varOcc[] = {"Salaried","Self Employed","Business","Student","Retired","Other"};
        occupation = new JComboBox(varOcc);
        occupation.setBounds(350,370,400,30);
        occupation.setFont(new Font("Courier New",Font.BOLD,15));
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel pan = new JLabel("PAN Number : ");
        pan.setFont(new Font("Raleway",Font.PLAIN,20));
        pan.setBounds(100,420,200,30);
        add(pan);

        panNo = new JTextField();
        panNo.setBounds(350,420,400,30);
        panNo.setFont(new Font("Courier New",Font.BOLD,15));
        add(panNo);

        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway",Font.PLAIN,20));
        aadhar.setBounds(100,470,200,30);
        add(aadhar);

        aadharNo = new JTextField();
        aadharNo.setBounds(350,470,400,30);
        aadharNo.setFont(new Font("Courier New",Font.BOLD,15));
        add(aadharNo);

        JLabel sCitizen = new JLabel("Senior Citizen : ");
        sCitizen.setFont(new Font("Raleway",Font.PLAIN,20));
        sCitizen.setBounds(100,520,200,30);
        add(sCitizen);

        scYes = new JRadioButton("Yes");
        scYes.setBounds(350,520,150,30);
        scYes.setFont(new Font("Courier New",Font.BOLD,15));
        scYes.setBackground(Color.white);
        add(scYes);

        scNo = new JRadioButton("No");
        scNo.setBounds(500,520,150,30);
        scNo.setFont(new Font("Courier New",Font.BOLD,15));
        scNo.setBackground(Color.white);
        add(scNo);

        ButtonGroup bg = new ButtonGroup();
        bg.add(scYes);
        bg.add(scNo);

        JLabel existAcc = new JLabel("Existing Account : ");
        existAcc.setFont(new Font("Raleway",Font.PLAIN,20));
        existAcc.setBounds(100,570,200,30);
        add(existAcc);

        eaYes = new JRadioButton("Yes");
        eaYes.setBounds(350,570,150,30);
        eaYes.setFont(new Font("Courier New",Font.BOLD,15));
        eaYes.setBackground(Color.white);
        add(eaYes);

        eaNo = new JRadioButton("No");
        eaNo.setBounds(500,570,150,30);
        eaNo.setFont(new Font("Courier New",Font.BOLD,15));
        eaNo.setBackground(Color.white);
        add(eaNo);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(eaYes);
        bg2.add(eaNo);

        JButton next = new JButton("Next");
        next.setBounds(650,650,100,40);
        next.setFont(new Font("Courier New",Font.PLAIN,25));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,770);
        setVisible(true);
        setLocation(350,30);
    }
    public static void main(String[] args) {
        new SignUp2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sReligion = (String)religion.getSelectedItem();
        String sCategory = (String)cat.getSelectedItem();
        String sIncome = (String)inc.getSelectedItem();
        String sEducation = (String)education.getSelectedItem();
        String sOccupation = (String)occupation.getSelectedItem();
        String pan = panNo.getText();
        String aadhar = aadharNo.getText();
        String seniorCitizen = null;
        String existAc = null;
        if(scYes.isSelected())
            seniorCitizen = "Yes";
        else if(scNo.isSelected())
            seniorCitizen = "No";
        if(eaYes.isSelected())
            existAc = "Yes";
        else if(eaNo.isSelected())
            existAc = "No";

        try{
            Conn c = new Conn();
            String query = "update personalDetails set religion = '"+sReligion+"', inc = '"+sIncome+"', cat = '"+sCategory+"', education = '"+sEducation+"', occupation = '"+sOccupation+"', panNo = '"+pan+"', aadharNo = '"+aadhar+"', seniorCitizen = '"+seniorCitizen+"', existingAccount = '"+existAc+"' where formNo = '"+formNo+"'";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUp3(formNo).setVisible(true);

        }catch (Exception e2){
            System.out.println(e2);
        }

    }
}
