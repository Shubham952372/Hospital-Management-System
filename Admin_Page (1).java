package project;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static project.Add_Doctor.stmt;
public class Admin_Page extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l,l1,l2,L;
    JTextField T;
    JButton b,b1,b2,b3,b4,b5,b6,b7,B1,B2;
    Connection conn;
    static Statement stmt;
    Admin_Page() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
        stmt=conn.createStatement();
        l1=new JLabel("MIRACLE MULTI - SPECIALITY HOSPITAL");
	l1.setBounds(625,20,1200,30);
	add(l1);
        l1.setFont(l1.getFont().deriveFont(40.0f));
        l=new JLabel("Tenali Road, Beside VignanUniversity, Vadlamudi, Guntur.");
        l.setBounds(740,80,550,30);
	add(l);
        l.setFont(l.getFont().deriveFont(18.0f));
        l2=new JLabel("OPTIONS");
        l2.setBounds(925,200,200,40);
	add(l2);
        l2.setFont(l2.getFont().deriveFont(25.0f));
        b1=new JButton("ADD ADMIN");
        b1.setBounds(885,280,200,40);
        add(b1);
        b1.addActionListener(this);
        b1.setFont(b1.getFont().deriveFont(18.0f));
        b6=new JButton("REMOVE ADMIN");
        b6.setBounds(885,380,200,40);
        add(b6);
        b6.addActionListener(this);
        b6.setFont(b6.getFont().deriveFont(18.0f));
        b5=new JButton("ADD DOCTOR");
        b5.setBounds(885,480,200,40);
        add(b5);
        b5.addActionListener(this);
        b5.setFont(b5.getFont().deriveFont(18.0f));
        b7=new JButton("REMOVE DOCTOR");
        b7.setBounds(885,580,200,40);
        add(b7);
        b7.addActionListener(this);
        b7.setFont(b7.getFont().deriveFont(18.0f));
        b2=new JButton("DOCTORS DETAILS");
        b2.setBounds(860,680,250,40);
        add(b2);
        b2.addActionListener(this);
        b2.setFont(b2.getFont().deriveFont(18.0f));
        b3=new JButton("PATIENT DETAILS");
        b3.setBounds(860,780,250,40);
        add(b3);
        b3.addActionListener(this);
        b3.setFont(b3.getFont().deriveFont(18.0f));
        b4=new JButton("APPOINTMENTS DETAILS");
        b4.setBounds(835,880,300,40);
        add(b4);
        b4.addActionListener(this);
        b4.setFont(b4.getFont().deriveFont(18.0f));
        b=new JButton("Back");
        b.setBounds(30,30,100,30);
        b.setFont(b.getFont().deriveFont(16.0f));
        add(b);
        b.addActionListener(this);
        B2=new JButton("Edit Profile");
        B2.setBounds(1680,30,200,35);
        B2.setFont(B2.getFont().deriveFont(16.0f));
        add(B2);
        B2.addActionListener(this);
        getContentPane().setBackground(Color.PINK);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setTitle("ADMIN HOME PAGE");
        setSize(2000,2000);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent E)
    {
        if(E.getSource()==b)
        {
            try 
            {
                new Project();
                this.dispose();
            } 
            catch (Exception ex) {}
        }
        else if(E.getSource()==b1)
        {
            try 
            {
                new Add_Admin();
            }
            catch(Exception ex) {}
        }
        else if(E.getSource()==b2)
        {
            try 
            {
                new Doctors_Details();
            }
            catch(Exception ex) {}
        }
        else if(E.getSource()==b3)
        {
            try 
            {
                new Patient_Details();
            }
            catch(Exception ex) {}
        }
        else if(E.getSource()==b4)
        {
            try 
            {
                new Appointment_Details();
            }
            catch(Exception ex) {}
        }
        else if(E.getSource()==b5)
        {
            try 
            {
                new Add_Doctor();
            }
            catch(Exception ex) {}
        }
        else if(E.getSource()==b7)
        {
            f=new JFrame();
            L=new JLabel("Doctor_ID : ");
            L.setBounds(50,50,150,50);
            f.add(L);
            L.setFont(L.getFont().deriveFont(18.0f));
            T=new JTextField();
            T.setBounds(200,55,200,40);
            f.add(T);
            T.setFont(T.getFont().deriveFont(18.0f));
            B1=new JButton("OK");
            B1.setBounds(170,155,80,40);
            f.add(B1);
            B1.setFont(B1.getFont().deriveFont(18.0f));
            B1.addActionListener(E2->{
            try
            {
                if(T.getText().compareTo("")!=0)
                {
                    String Q="Select Username from Doctor where DID='"+T.getText()+"'";
                    ResultSet rs1=stmt.executeQuery(Q);rs1.next();
                    String P=rs1.getString(1);
                    Q="Delete from Doctor where DID='"+T.getText()+"'";
                    stmt.executeUpdate(Q);
                    Q="Delete from Login_Details where Username='"+P+"'";
                    stmt.executeUpdate(Q);
                    JOptionPane.showMessageDialog(f,"Successfully Removed !!");
                    f.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(f,"Please enter the Doctor_ID");
                }
            }
            catch(Exception E1)
            {
                JOptionPane.showMessageDialog(f,"Please enter the Doctor_ID correctly");
            }});
            f.setTitle("Remove Doctor");
            f.setBounds(750,400,450,300);
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(450,300);
        }
        else if(E.getSource()==b6)
        {
            f=new JFrame();
            L=new JLabel("Username : ");
            L.setBounds(50,50,150,50);
            f.add(L);
            L.setFont(L.getFont().deriveFont(18.0f));
            T=new JTextField();
            T.setBounds(200,55,200,40);
            f.add(T);
            T.setFont(T.getFont().deriveFont(18.0f));
            B1=new JButton("OK");
            B1.setBounds(170,155,80,40);
            f.add(B1);
            B1.setFont(B1.getFont().deriveFont(18.0f));
            B1.addActionListener(E2->{
            try
            {
                if(T.getText().compareTo("")!=0)
                {
                    int t=0;
                    String Q="Delete from Login_Details where Username='"+T.getText()+"'";
                    t=stmt.executeUpdate(Q);
                    if(t!=0){JOptionPane.showMessageDialog(f,"Successfully Removed !!");
                    f.dispose();}
                    else{JOptionPane.showMessageDialog(f,"Please enter the Username correctly");}
                }
                else
                {
                    JOptionPane.showMessageDialog(f,"Please enter the Username");
                }
            }
            catch(Exception E1)
            {
                JOptionPane.showMessageDialog(f,"Please enter the Username correctly");
            }});
            f.setTitle("Remove Admin");
            f.setBounds(750,400,450,300);
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(450,300);
        }
        else if(E.getSource()==B2)
        {
            try{new Admin_Profile();}catch(Exception ex){}
        }
    }
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        new Admin_Page();
    }
}
