package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Add_Doctor extends JFrame implements ActionListener,MouseListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JPasswordField p8;
    JRadioButton r1,r2,r3;
    JButton b1,b;
    JComboBox c;
    Connection conn;
    static Statement stmt;
    Add_Doctor() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
        stmt=conn.createStatement();
        l=new JLabel("Doctor Details");
        l.setBounds(830,50,250,40);
        l.setFont(l.getFont().deriveFont(30.0f));
        add(l);
        l1=new JLabel("Full Name :");
        l1.setBounds(630,150,200,30);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        add(l1);
        t1=new JTextField();
        t1.setBounds(830,150,400,40);
        t1.setFont(t1.getFont().deriveFont(20.0f));
        add(t1);
        l2=new JLabel("Mobile No. :");
        l2.setBounds(630,220,200,30);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        add(l2);
        t2=new JTextField();
        t2.setBounds(830,220,400,40);
        t2.setFont(t2.getFont().deriveFont(20.0f));
        add(t2);
        l6=new JLabel("Gender :");
        l6.setBounds(630,300,200,30);
        l6.setFont(l6.getFont().deriveFont(20.0f));
        add(l6);
        r1=new JRadioButton("Male");
        r1.setBounds(830,290,150,50);
        r1.setFont(r1.getFont().deriveFont(20.0f));
        r1.setBackground(Color.PINK);
        r2=new JRadioButton("Female");
        r2.setBounds(980,290,150,50);
        r2.setFont(r2.getFont().deriveFont(20.0f));
        r2.setBackground(Color.PINK);
        r3=new JRadioButton("Other");
        r3.setBounds(1130,290,100,50);
        r3.setFont(r3.getFont().deriveFont(20.0f));
        r3.setBackground(Color.PINK);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        add(r1);
        add(r2);
        add(r3);
        l3=new JLabel("Qualification :");
        l3.setBounds(630,370,200,30);
        l3.setFont(l2.getFont().deriveFont(20.0f));
        add(l3);
        t3=new JTextField();
        t3.setBounds(830,360,400,40);
        t3.setFont(t3.getFont().deriveFont(20.0f));
        add(t3);
        l4=new JLabel("Specialization :");
        l4.setBounds(630,440,200,30);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        add(l4);
        String[] s={"                  __Select__","General Medicine","Pediatrics","Gynaecology","Orthopedics","Cardiology","Dental","ENT","Pulmonology","Neurology","Psychiatrics","Dermatology"};
        c=new JComboBox(s);
        c.setBounds(830,440,350,40);
        c.setFont(c.getFont().deriveFont(20.0f));
        add(c);
        l5=new JLabel("Experience :");
        l5.setBounds(630,510,300,30);
        l5.setFont(l5.getFont().deriveFont(20.0f));
        add(l5);
        t5=new JTextField("Enter number only");
        t5.setBounds(830,510,400,40);
        t5.setFont(t5.getFont().deriveFont(20.0f));
        add(t5);
        t5.setEnabled(false);
        t5.addMouseListener(this);
        l9=new JLabel("Treated :");
        l9.setBounds(630,580,300,30);
        l9.setFont(l9.getFont().deriveFont(20.0f));
        add(l9);
        t8=new JTextField();
        t8.setBounds(830,580,400,40);
        t8.setFont(t8.getFont().deriveFont(20.0f));
        add(t8);
        l10=new JLabel("Surgeries :");
        l10.setBounds(630,650,300,30);
        l10.setFont(l10.getFont().deriveFont(20.0f));
        add(l10);
        t9=new JTextField();
        t9.setBounds(830,650,400,40);
        t9.setFont(t9.getFont().deriveFont(20.0f));
        add(t9);
        l6=new JLabel("Salary :");
        l6.setBounds(630,720,300,30);
        l6.setFont(l6.getFont().deriveFont(20.0f));
        add(l6);
        t6=new JTextField();
        t6.setBounds(830,720,400,40);
        t6.setFont(t6.getFont().deriveFont(20.0f));
        add(t6);
        l7=new JLabel("Username :");
        l7.setBounds(630,790,300,30);
        l7.setFont(l7.getFont().deriveFont(20.0f));
        add(l7);
        t7=new JTextField();
        t7.setBounds(830,790,400,40);
        t7.setFont(t7.getFont().deriveFont(20.0f));
        add(t7);
        l8=new JLabel("Password :");
        l8.setBounds(630,860,300,30);
        l8.setFont(l8.getFont().deriveFont(20.0f));
        add(l8);
        p8=new JPasswordField();
        p8.setBounds(830,860,400,40);
        p8.setFont(p8.getFont().deriveFont(20.0f));
        add(p8);
        b1=new JButton("Submit");
        b1.setBounds(870,940,100,45);
        b1.setFont(b1.getFont().deriveFont(20.0f));
        add(b1);
        b1.addActionListener(this);
        getContentPane().setBackground(Color.PINK);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setSize(5000,5000);
        setLayout(null);
        setVisible(true);
        setTitle("New Doctor");
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public void mousePressed(MouseEvent m){}
    public void mouseClicked(MouseEvent m)
    {
        if(m.getSource()==t5)
        {
            t5.setEnabled(true);
            if(t5.getText().compareTo("Enter number only")==0)
            {
                t5.setText("");
            }
        }
    }
    public void mouseReleased(MouseEvent m){}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try
            {
                String q1="create table if not exists Login_Details(Designation varchar(20),Full_Name varchar(30) not null,Mobile varchar(11) not null,Gender char not null,Username varchar(20) primary key,Password varchar(20) not null,Status int)";
                stmt.execute(q1);
                q1="create table if not exists Doctor(DID varchar(10) primary key,Name varchar(30),Gender char(2),Spec varchar(30),Qual varchar(30),Exp int,Salary int,App int,Treated int,Surgeries int,MobileNo varchar(20),Username varchar(20),foreign key(Username) references Login_Details(Username))";
                stmt.execute(q1);
                q1="Select count(*) from Doctor";
                ResultSet rs1=stmt.executeQuery(q1);rs1.next();
                String m;int v=rs1.getInt(1)+1;
                while(true)
                {
                    if(v<10)
                    {
                        m="MHD0"+v+"";
                    }   
                    else
                    {
                        m="MHD"+v+"";
                    }
                    String f="select count(*) from Doctor where DID='"+m+"'";
                    ResultSet rs2=stmt.executeQuery(f);
                    rs2.next();
                    if(rs2.getInt(1)==0)
                    {
                        break;
                    }
                    else{v++;}
                }
                int k;
                k=c.getSelectedIndex();
                String p;
                p=c.getItemAt(k).toString();
                if(t1.getText().compareTo("")!=0 && t2.getText().compareTo("")!=0 && t3.getText().compareTo("")!=0 && t5.getText().compareTo("")!=0 && t6.getText().compareTo("")!=0 && t7.getText().compareTo("")!=0 && p8.getText().compareTo("")!=0 && t8.getText().compareTo("")!=0 && t9.getText().compareTo("")!=0 && k!=0)
                {
                    if(r1.isSelected() || r2.isSelected() || r3.isSelected())
                    {
                    try
                    {
                        String q2;
                        if(r1.isSelected())
                        {
                            try{q2="insert into Login_Details values('Doctor','"+t1.getText()+"','"+t2.getText()+"','M','"+t7.getText()+"','"+p8.getText()+"',0)";
                            stmt.executeUpdate(q2);
                            q2="insert into Doctor values('"+m+"','"+t1.getText()+"','M','"+p+"','"+t3.getText()+"','"+t5.getText()+"','"+t6.getText()+"',0,'"+t8.getText()+"','"+t9.getText()+"','"+t2.getText()+"','"+t7.getText()+"')";
                            stmt.executeUpdate(q2);}catch(Exception ex){JOptionPane.showMessageDialog(this,"Invalid Username");}
                        }
                        else if(r2.isSelected())
                        {
                            try{q2="insert into Login_Details values('Doctor','"+t1.getText()+"','"+t2.getText()+"','F','"+t7.getText()+"','"+p8.getText()+"',0)";
                            stmt.executeUpdate(q2);
                            q2="insert into Doctor values('"+m+"','"+t1.getText()+"','F','"+p+"','"+t3.getText()+"','"+t5.getText()+"','"+t6.getText()+"',0,0,0,'"+t2.getText()+"','"+t7.getText()+"')";
                            stmt.executeUpdate(q2);}catch(Exception ex){JOptionPane.showMessageDialog(this,"Invalid Username");}
                        }
                        else if(r3.isSelected())
                        {
                            try{q2="insert into Login_Details values('Doctor','"+t1.getText()+"','"+t2.getText()+"','O','"+t7.getText()+"','"+p8.getText()+"',0)";
                            stmt.executeUpdate(q2);
                            q2="insert into Doctor values('"+m+"','"+t1.getText()+"','O','"+p+"','"+t3.getText()+"','"+t5.getText()+"','"+t6.getText()+"',0,0,0,'"+t2.getText()+"','"+t7.getText()+"')";
                            stmt.executeUpdate(q2);}catch(Exception ex){JOptionPane.showMessageDialog(this,"Invalid Username");}
                        }
                        JOptionPane.showMessageDialog(this,"New Doctor is added successfully ! Your ID is : "+m);
                        this.dispose();
                    }
                    catch(Exception p1)
                    {
                        JOptionPane.showMessageDialog(this,"Invalid Data given for Experience or Salary");
                    }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Please fill all the details");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Please fill all the details");
                }   
            }
            catch(Exception P)
            {
                JOptionPane.showMessageDialog(this,""+P);
            }
        }
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException
    {
        new Add_Doctor();
    }
}
