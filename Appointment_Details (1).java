package project;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Appointment_Details extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JLabel L1,L2,L3,L4;
    JComboBox c;
    String dt,dt1,dt2,dt3,dt4,dt5,dt6,dt7;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate,LL1,LL2,LL3,LL4,LL5,LL6,LL7;
    Statement stmt;
    Connection conn;
    int h;
    JButton b;
    Appointment_Details() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
        stmt=conn.createStatement();
        l1=new JLabel("App.No.");
        l1.setBounds(50,70,100,30);
        add(l1);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        l2=new JLabel("Doctor_ID");
        l2.setBounds(160,70,120,30);
        add(l2);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        l3=new JLabel("Specialization");
        l3.setBounds(290,70,200,30);
        add(l3);
        l3.setFont(l3.getFont().deriveFont(20.0f));
        l4=new JLabel("Date");
        l4.setBounds(500,70,120,30);
        add(l4);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        localDate= LocalDate.now();
        dt=dtf.format(localDate);
        LL1=localDate.plusDays(1);
        dt1=dtf.format(LL1);
        LL2=localDate.plusDays(2);
        dt2=dtf.format(LL2);
        LL3=localDate.plusDays(3);
        dt3=dtf.format(LL3);
        LL4=localDate.plusDays(4);
        dt4=dtf.format(LL4);
        LL5=localDate.plusDays(5);
        dt5=dtf.format(LL5);
        LL6=localDate.plusDays(6);
        dt6=dtf.format(LL6);
        LL7=localDate.plusDays(7);
        dt7=dtf.format(LL7);
        String[] s={"Select Date",""+dt,""+dt1,""+dt2,""+dt3,""+dt4,""+dt5,""+dt6,""+dt7};
        c=new JComboBox(s);
        c.setBounds(650,70,200,30);
        c.setFont(c.getFont().deriveFont(18.0f));
        add(c);
        c.addActionListener(this);
        b=new JButton("OK");
        b.setBounds(900,70,70,30);
        add(b);
        b.addActionListener(this);
        getContentPane().setBackground(Color.PINK);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setTitle("APPOINTMENTS DETAILS");
        setSize(2000,2000);
        setLayout(null);
        setVisible(true);
    }
    Appointment_Details(String n) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
        stmt=conn.createStatement();
        l1=new JLabel("App.No.");
        l1.setBounds(50,70,100,30);
        add(l1);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        l2=new JLabel("Doctor_ID");
        l2.setBounds(160,70,120,30);
        add(l2);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        l3=new JLabel("Specialization");
        l3.setBounds(290,70,200,30);
        add(l3);
        l3.setFont(l3.getFont().deriveFont(20.0f));
        l4=new JLabel("Date");
        l4.setBounds(500,70,120,30);
        add(l4);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        localDate= LocalDate.now();
        dt=dtf.format(localDate);
        LL1=localDate.plusDays(1);
        dt1=dtf.format(LL1);
        LL2=localDate.plusDays(2);
        dt2=dtf.format(LL2);
        LL3=localDate.plusDays(3);
        dt3=dtf.format(LL3);
        LL4=localDate.plusDays(4);
        dt4=dtf.format(LL4);
        LL5=localDate.plusDays(5);
        dt5=dtf.format(LL5);
        LL6=localDate.plusDays(6);
        dt6=dtf.format(LL6);
        LL7=localDate.plusDays(7);
        dt7=dtf.format(LL7);
        String[] s={"Select Date",""+dt,""+dt1,""+dt2,""+dt3,""+dt4,""+dt5,""+dt6,""+dt7};
        c=new JComboBox(s);
        c.setBounds(650,70,200,30);
        c.setFont(c.getFont().deriveFont(18.0f));
        add(c);
        c.addActionListener(this);
        b=new JButton("OK");
        b.setBounds(900,70,70,30);
        add(b);
        b.addActionListener(this);
        try
        {
            String q1="select * from Appointments where Dates='"+n+"'";
            ResultSet r=stmt.executeQuery(q1);
            h=50;
            while(r.next())
            {
                L1=new JLabel(""+r.getString(1));
                L1.setBounds(50,70+h,100,30);
                L1.setFont(L1.getFont().deriveFont(18.0f));
                add(L1);
                L2=new JLabel(""+r.getString(7));
                L2.setBounds(160,70+h,120,30);
                L2.setFont(L2.getFont().deriveFont(18.0f));
                add(L2);
                L3=new JLabel(""+r.getString(6));
                L3.setBounds(290,70+h,200,30);
                L3.setFont(L3.getFont().deriveFont(18.0f));
                add(L3);
                L4=new JLabel(""+r.getString(9));
                L4.setBounds(500,70+h,120,30);
                L4.setFont(L4.getFont().deriveFont(18.0f));
                add(L4);
                h=h+30;
            }
        }
        catch(Exception ex){}
        getContentPane().setBackground(Color.PINK);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setTitle("APPOINTMENTS DETAILS ON "+n);
        setSize(2000,2000);
        setLayout(null);
        setVisible(true);
        }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            if(c.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(this,"Select Date");
            }
            else
            {
                this.dispose();
                try {
                    new Appointment_Details(c.getSelectedItem().toString());
                    } catch (Exception e1){}
            }
        }
        
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        new Appointment_Details();
    }
}
