package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Admin_Profile extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l;
    JTextField t1,t2,t3,t4,t5;
    JButton b;
    String u;
    Statement stmt;
    Connection conn;
    Admin_Profile() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
        stmt=conn.createStatement();
        String q="select * from Login_Details where status=1";
        ResultSet r=stmt.executeQuery(q);r.next();
        u=r.getString(5);
        l=new JLabel("Profile");
        l.setBounds(950,220,100,50);
        l.setFont(l.getFont().deriveFont(28.0f));
        add(l);
        l1=new JLabel("Name : ");
        l1.setBounds(690,300,200,50);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        add(l1);
        t1=new JTextField(""+r.getString(2));
        t1.setBounds(900,305,400,40);
        t1.setFont(t1.getFont().deriveFont(20.0f));
        add(t1);
        l2=new JLabel("Mobile Number : ");
        l2.setBounds(690,370,200,50);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        add(l2);
        t2=new JTextField(""+r.getString(3));
        t2.setBounds(900,375,400,40);
        t2.setFont(t2.getFont().deriveFont(20.0f));
        add(t2);
        l3=new JLabel("Username : ");
        l3.setBounds(690,440,200,50);
        l3.setFont(l3.getFont().deriveFont(20.0f));
        add(l3);
        t3=new JTextField(""+r.getString(5));
        t3.setBounds(900,445,400,40);
        t3.setFont(t3.getFont().deriveFont(20.0f));
        add(t3);
        l4=new JLabel("Password : ");
        l4.setBounds(690,510,200,50);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        add(l4);
        t4=new JTextField(""+r.getString(6));
        t4.setBounds(900,515,400,40);
        t4.setFont(t4.getFont().deriveFont(20.0f));
        add(t4);
        l5=new JLabel("Confirm Password : ");
        l5.setBounds(690,580,200,50);
        l5.setFont(l5.getFont().deriveFont(20.0f));
        add(l5);
        t5=new JTextField(""+r.getString(6));
        t5.setBounds(900,585,400,40);
        t5.setFont(t5.getFont().deriveFont(20.0f));
        add(t5);
        b=new JButton("Update");
        b.setBounds(900,670,200,40);
        b.setFont(b.getFont().deriveFont(20.0f));
        add(b);
        b.addActionListener(this);
        getContentPane().setBackground(Color.PINK);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setTitle("ADMIN PROFILE");
        setSize(2000,2000);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(t1.getText().compareTo("")!=0&&t2.getText().compareTo("")!=0&&t3.getText().compareTo("")!=0&&t4.getText().compareTo("")!=0&&t5.getText().compareTo("")!=0)
        {
        if(t4.getText().compareTo(t5.getText())==0){
        String q1="update Login_Details set Full_Name='"+t1.getText()+"',Mobile='"+t2.getText()+"',Username='"+t3.getText()+"',Password='"+t4.getText()+"' where Username='"+u+"'";
        try{stmt.executeUpdate(q1);}catch(Exception ex){System.out.println(ex);}
        q1="Update Current_Status set Username='"+t3.getText()+"' where Status=1";
        try{stmt.executeUpdate(q1);}catch(Exception ex){System.out.println(ex);}
        this.dispose();
        JOptionPane.showMessageDialog(this,"Profile Updated Successfully!!");
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Password and Confirm Password should be same !!");
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Empty fields are present !!");
        }
    }
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        new Admin_Profile();
    }
}
