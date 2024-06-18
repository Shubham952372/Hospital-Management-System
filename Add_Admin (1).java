package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Add_Admin extends JFrame implements ActionListener,KeyListener,MouseListener
{
    JLabel l1,l2,l3,l4,l5,l6,l,L2;
    JTextField t1,t2,t3,t4;
    JPasswordField p1,p2;
    JRadioButton r1,r2,r3;
    JButton b1,b;
    Connection conn;
    static Statement stmt;
    Add_Admin() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
        stmt=conn.createStatement();
        l=new JLabel("Admin Details");
        l.setBounds(830,130,250,40);
        l.setFont(l.getFont().deriveFont(30.0f));
        add(l);
        l1=new JLabel("Full Name :");
        l1.setBounds(630,230,200,30);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        add(l1);
        t1=new JTextField();
        t1.setBounds(830,230,400,40);
        t1.setFont(t1.getFont().deriveFont(20.0f));
        add(t1);
        t1.addMouseListener(this);
        l2=new JLabel("Mobile No. :");
        l2.setBounds(630,300,200,30);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        add(l2);
        t2=new JTextField();
        t2.setBounds(830,300,400,40);
        t2.setFont(t2.getFont().deriveFont(20.0f));
        add(t2);
        t2.addMouseListener(this);
        l6=new JLabel("Gender :");
        l6.setBounds(630,380,200,30);
        l6.setFont(l6.getFont().deriveFont(20.0f));
        add(l6);
        r1=new JRadioButton("Male");
        r1.setBounds(830,370,150,50);
        r1.setFont(r1.getFont().deriveFont(20.0f));
        r1.setBackground(Color.PINK);
        r2=new JRadioButton("Female");
        r2.setBounds(980,370,150,50);
        r2.setFont(r2.getFont().deriveFont(20.0f));
        r2.setBackground(Color.PINK);
        r3=new JRadioButton("Other");
        r3.setBounds(1130,370,100,50);
        r3.setFont(r3.getFont().deriveFont(20.0f));
        r3.setBackground(Color.PINK);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        add(r1);
        add(r2);
        add(r3);
        l3=new JLabel("Username :");
        l3.setBounds(630,450,200,30);
        l3.setFont(l2.getFont().deriveFont(20.0f));
        add(l3);
        t3=new JTextField();
        t3.setBounds(830,440,400,40);
        t3.setFont(t3.getFont().deriveFont(20.0f));
        add(t3);
        t3.addMouseListener(this);
        l4=new JLabel("Set Password :");
        l4.setBounds(630,520,200,30);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        add(l4);
        p1=new JPasswordField();
        p1.setBounds(830,520,400,40);
        p1.setFont(p1.getFont().deriveFont(20.0f));
        add(p1);
        p1.addKeyListener(this);
        p1.addMouseListener(this);
        l5=new JLabel("Confirm Password :");
        l5.setBounds(630,590,300,30);
        l5.setFont(l5.getFont().deriveFont(20.0f));
        add(l5);
        p2=new JPasswordField();
        p2.setBounds(830,590,400,40);
        p2.setFont(p2.getFont().deriveFont(20.0f));
        add(p2);
        p2.addKeyListener(this);
        p2.addMouseListener(this);
        L2=new JLabel("");
        L2.setBounds(1250,595,200,30);
        L2.setFont(L2.getFont().deriveFont(15.0f));
        add(L2);
        b1=new JButton("Submit");
        b1.setBounds(870,660,100,45);
        b1.setFont(b1.getFont().deriveFont(20.0f));
        add(b1);
        b1.addActionListener(this);
        b1.setEnabled(false);
        getContentPane().setBackground(Color.PINK);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setSize(5000,5000);
        setLayout(null);
        setVisible(true);
        setTitle("New Admin");
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public void mousePressed(MouseEvent m){}
    public void mouseClicked(MouseEvent m)
    {
        if((m.getSource()!=p2&&m.getSource()!=p1)||(p2.getText()==null&&p1.getText()==null))
        {
            L2.setText(" ");
        }
    }
    public void mouseReleased(MouseEvent m){}
    public void keyTyped(KeyEvent k)
    {
        if(p1.getText().compareTo(p2.getText())==0)
        {
            L2.setText("Valid");
            L2.setForeground(Color.green);
            b1.setEnabled(true);
        }
        else
        {
            L2.setText("Invalid");
            L2.setForeground(Color.red);
            b1.setEnabled(false);
        }
    }
    public void keyPressed(KeyEvent k){}
    public void keyReleased(KeyEvent k)
    {
        if(p1.getText().compareTo(p2.getText())==0)
        {
            L2.setText("Valid");
            L2.setForeground(Color.green);
            b1.setEnabled(true);
        }
        else
        {
            L2.setText("Invalid");
            L2.setForeground(Color.red);
            b1.setEnabled(false);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try
            {
                String q1="create table if not exists Login_Details(Designation varchar(20),Full_Name varchar(30) not null,Mobile varchar(11) not null,Gender char not null,Username varchar(20) primary key,Password varchar(20) not null,Status int)";
                stmt.execute(q1);
                if(t1.getText().compareTo("")!=0 && t2.getText().compareTo("")!=0 && t3.getText().compareTo("")!=0 && p1.getText().compareTo("")!=0 && p2.getText().compareTo("")!=0 && t1.getText().compareTo("")!=0)
                {
                    if(r1.isSelected() || r2.isSelected() || r3.isSelected())
                    {
                    try
                    {
                        if(r1.isSelected())
                        {
                            String q2="insert into Login_Details values('Admin','"+t1.getText()+"','"+t2.getText()+"','M','"+t3.getText()+"','"+p1.getText()+"',0)";
                            stmt.executeUpdate(q2);
                        }
                        else if(r2.isSelected())
                        {
                            String q2="insert into Login_Details values('Admin','"+t1.getText()+"','"+t2.getText()+"','F','"+t3.getText()+"','"+p1.getText()+"',0)";
                            stmt.executeUpdate(q2);
                        }
                        else if(r3.isSelected())
                        {
                            String q2="insert into Login_Details values('Admin','"+t1.getText()+"','"+t2.getText()+"','O','"+t3.getText()+"','"+p1.getText()+"',0)";
                            stmt.executeUpdate(q2);
                        }
                        JOptionPane.showMessageDialog(this,"New Admin is added successfully !");
                        this.dispose();
                    }
                    catch(Exception p)
                    {
                        JOptionPane.showMessageDialog(this,"Invalid Username");   
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
            catch(SQLException P)
            {
                //
            }
        }
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException
    {
        new Add_Admin();
    }
}