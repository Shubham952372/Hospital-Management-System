package project;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.Login.t1;
public class Project extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l,L,LL1,LL2,LL3,a,a1,a2;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b,B,m;
        Connection conn;
        static Statement stmt;
	Project() throws SQLException, ClassNotFoundException
	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
            stmt=conn.createStatement();
            Icon icon=new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\Project\\image1.png");
            L=new JLabel();
            L.setIcon(icon);
            L.setBounds(350,367,1100,630);
            add(L);
            Icon icon1=new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\Project\\i1.png");
            LL1=new JLabel();
            LL1.setIcon(icon1);
            LL1.setBounds(1490,374,400,180);
            add(LL1);
            Icon icon2=new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\Project\\i2.png");
            LL2=new JLabel();
            LL2.setIcon(icon2);
            LL2.setBounds(1490,575,400,180);
            add(LL2);
            Icon icon3=new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\Project\\i3.png");
            LL3=new JLabel();
            LL3.setIcon(icon3);
            LL3.setBounds(1490,780,400,200);
            add(LL3);
            Icon icon4=new ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\Project\\i4.png");
            a=new JLabel();
            a.setIcon(icon4);
            a.setBounds(390,38,100,100);
            add(a);
            a1=new JLabel("Contact Us   :   9985431260");
            a1.setBounds(1510,210,300,40);
            add(a1);
            a1.setFont(a1.getFont().deriveFont(20.0f));
            a2=new JLabel("Email            :   teammiracle@gmail.com");
            a2.setBounds(1510,260,400,40);
            add(a2);
            a2.setFont(a2.getFont().deriveFont(20.0f));
                l1=new JLabel("WELCOME TO MIRACLE MULTI - SPECIALITY HOSPITAL");
		l1.setBounds(500,70,1200,30);
		add(l1);
                l1.setFont(l1.getFont().deriveFont(40.0f));
                l=new JLabel("Tenali Road, Beside VignanUniversity, Vadlamudi, Guntur.");
                l.setBounds(750,140,550,30);
		add(l);
                l.setFont(l.getFont().deriveFont(18.0f));
                B=new JButton("Close");
                B.setBounds(1790,40,100,40);
                add(B);
                B.setFont(B.getFont().deriveFont(19.0f));
                B.addActionListener(this);
                m=new JButton("Appointment");
                m.setBounds(1700,120,160,40);
                m.setFont(m.getFont().deriveFont(19.0f));
                add(m);
                m.addActionListener(this);
		l2=new JLabel("Contents");
		l2.setBounds(30,40,170,50);
		add(l2);
                l2.setFont(l2.getFont().deriveFont(28.0f));
		l3=new JLabel("Logins");
		l3.setBounds(30,100,170,48);
		add(l3);
                l3.setFont(l3.getFont().deriveFont(23.0f));
		b1=new JButton("Patient");
		b1.setBounds(30,153,120,48);
		add(b1);
                b1.addActionListener(this);
                b1.setFont(b1.getFont().deriveFont(19.0f));
		b2=new JButton("Doctor");
		b2.setBounds(30,206,120,48);
		add(b2);
                b2.addActionListener(this);
                b2.setFont(b2.getFont().deriveFont(19.0f));
		b3=new JButton("Admin");
		b3.setBounds(30,259,120,48);
		add(b3);
                b3.addActionListener(this);
                b3.setFont(b3.getFont().deriveFont(19.0f));
		l4=new JLabel("Specialities");
		l4.setBounds(30,312,220,50);
		add(l4);
                l4.setFont(l4.getFont().deriveFont(23.0f));
		b15=new JButton("General Medicine");
		b15.setBounds(30,367,300,48);
		add(b15);
                b15.addActionListener(this);
                b15.setFont(b15.getFont().deriveFont(19.0f));
                b4=new JButton("Opthamology");
		b4.setBounds(30,420,300,48);
		add(b4);
                b4.addActionListener(this);
                b4.setFont(b4.getFont().deriveFont(19.0f));
		b5=new JButton("Pediatrics");
		b5.setBounds(30,473,300,48);
		add(b5);
                b5.addActionListener(this);
                b5.setFont(b5.getFont().deriveFont(19.0f));
		b6=new JButton("Gynaecology");
		b6.setBounds(30,526,300,48);
		add(b6);
                b6.addActionListener(this);
                b6.setFont(b6.getFont().deriveFont(19.0f));
		b7=new JButton("Orthopedics");
		b7.setBounds(30,579,300,48);
		add(b7);
                b7.addActionListener(this);
                b7.setFont(b7.getFont().deriveFont(19.0f));
		b8=new JButton("Cardiology");
		b8.setBounds(30,632,300,48);
		add(b8);
                b8.addActionListener(this);
                b8.setFont(b8.getFont().deriveFont(19.0f));
		b9=new JButton("Dentistry");
		b9.setBounds(30,685,300,48);
		add(b9);
                b9.addActionListener(this);
                b9.setFont(b9.getFont().deriveFont(19.0f));
		b10=new JButton("ENT");
		b10.setBounds(30,738,300,48);
		add(b10);
                b10.addActionListener(this);
                b10.setFont(b10.getFont().deriveFont(19.0f));
		b11=new JButton("Pulmonology");
		b11.setBounds(30,791,300,48);
		add(b11);
                b11.addActionListener(this);
                b11.setFont(b11.getFont().deriveFont(19.0f));
		b12=new JButton("Neurology");
		b12.setBounds(30,844,300,48);
		add(b12);
                b12.addActionListener(this);
                b12.setFont(b12.getFont().deriveFont(19.0f));
		b13=new JButton("Psychiatrics");
		b13.setBounds(30,897,300,48);
		add(b13);
                b13.addActionListener(this);
                b13.setFont(b13.getFont().deriveFont(19.0f));
                b14=new JButton("Dermatology");
		b14.setBounds(30,950,300,48);
		add(b14);
                b14.addActionListener(this);
                b14.setFont(b14.getFont().deriveFont(19.0f));
                b=new JButton("Logout");
                b.setBounds(1680,40,100,40);
                add(b);
                b.addActionListener(this);
                b.setFont(b.getFont().deriveFont(19.0f));
                getContentPane().setBackground(Color.PINK);
                setTitle("MIRACLE MULTI-SPECIALIT HOSPITAL");
                setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setSize(5000,5000);
		setLayout(null);
		setVisible(true);
	}
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                try
                {
                    new Login();
                    this.dispose();
                }
                catch(Exception E)
                {}
            }
            else if(e.getSource()==b2)
            {
                try
                {
                    new Doctor_Login();
                    this.dispose();
                }
                catch(Exception E)
                {}
            }
            else if(e.getSource()==b3)
            {
                try
                {
                    new Admin_Login();
                    this.dispose();
                }
                catch(Exception E)
                {}
            }
            else if(e.getSource()==B)
            {
                java.lang.System.exit(0);
            }
            else if(e.getSource()==b)
            {
                int s;
                String q1="select * from Current_Status";
                String q2="Select count(*) from Login_Details where status=1";
            try{
                    ResultSet R1=stmt.executeQuery(q2);
                    R1.next();
                    ResultSet R=stmt.executeQuery(q1);
                    R.next();
                    s=R.getInt("Status");
                    if(s==1)
                    {
                        try 
                        {
                        String q="Update Current_Status set Status=0";
                        stmt.executeUpdate(q);
                        String q3="Update Login_Details set Status=0";
                        stmt.executeUpdate(q3);
                        JOptionPane.showMessageDialog(this,"You are successfully logged out!");
                        } 
                        catch(SQLException ex){JOptionPane.showMessageDialog(this,"Error");}
                    }
                    else if(s==0)
                    {
                        JOptionPane.showMessageDialog(this,"You are not logged in!");
                    }
                }
                catch(Exception ex){JOptionPane.showMessageDialog(this,"You are not logged in!");}
            }
            else if(e.getSource()==m)
            {
                String q2="select Designation from Login_Details where Status=1";
                try
                {
                    String s;
                    ResultSet r1=stmt.executeQuery(q2);
                    r1.next();
                    s=r1.getString(1);
                    if(s.compareTo("Patient")!=0)
                        JOptionPane.showMessageDialog(this,"Please Login as Patient to Book your Appointment!!");
                    else
                        new Appointment();
                }
                catch(Exception e1){JOptionPane.showMessageDialog(this,"Please Login to Book your Appointment!!");}
            }
            else if(e.getSource()==b4)
            {
                try{new Opthamology();}catch(Exception ex4){}
            }
            else if(e.getSource()==b5)
            {
                try{new Pediatrics();}catch(Exception ex4){}
            }
            else if(e.getSource()==b6)
            {
                try{new Gynaecology();}catch(Exception ex4){}
            }
            else if(e.getSource()==b7)
            {
                try{new Orthopedics();}catch(Exception ex4){}
            }
            else if(e.getSource()==b8)
            {
                try{new Cardiology();}catch(Exception ex4){}
            }
            else if(e.getSource()==b9)
            {
                try{new Dental();}catch(Exception ex4){}
            }
            else if(e.getSource()==b10)
            {
                try{new ENT();}catch(Exception ex4){}
            }
            else if(e.getSource()==b11)
            {
                try{new Pulmonology();}catch(Exception ex4){}
            }
            else if(e.getSource()==b12)
            {
                try{new Neurology();}catch(Exception ex4){}
            }
            else if(e.getSource()==b13)
            {
                try{new Psychiatrics();}catch(Exception ex4){}
            }
            else if(e.getSource()==b14)
            {
                try{new Dermatology();}catch(Exception ex4){}
            }
            else if(e.getSource()==b15)
            {
                try{new General_Medicine();}catch(Exception ex4){}
            }
        }
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
            new Project();
	}
}
