package project;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Appointment extends JFrame implements MouseListener,ActionListener,ItemListener 
{
        String dt1,dt2,dt3,dt4,dt5,dt6,dt7;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate,LL1,LL2,LL3,LL4,LL5,LL6,LL7;
	JFrame f;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,t5,l8;
	JTextField t1,t2,t3,t6,t7;
	JButton b1,b,B;
	JRadioButton r1,r2,r3;
	JComboBox c;
	JCheckBox c1;
        Connection conn;
        static Statement stmt;
        int r=1;
        int h=0,v=0;
	Appointment() throws SQLException, ClassNotFoundException,UnsupportedOperationException,ClassCastException
	{
                localDate= LocalDate.now();
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
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","@Hanumaan12@");
                stmt=conn.createStatement();
                try
                {
                    String R="Select count(*) from Appointments";
                    ResultSet k=stmt.executeQuery(R);
                    k.next();
                    r=k.getInt(1)+1;
                }
                catch(Exception e){}
                l8=new JLabel("Appointment Form");
		l8.setBounds(845,110,400,50);
		add(l8);
                l8.setFont(l8.getFont().deriveFont(29.0f));
		l1=new JLabel("Patient Name : ");
		l1.setBounds(650,200,200,50);
		add(l1);
                l1.setFont(l1.getFont().deriveFont(19.0f));
		t1=new JTextField();
		t1.setBounds(860,210,400,35);
		add(t1);
                t1.setFont(t1.getFont().deriveFont(19.0f));
		l2=new JLabel("Age : ");
		l2.setBounds(650,260,200,50);
		add(l2);
                l2.setFont(l2.getFont().deriveFont(19.0f));
		t2=new JTextField();
		t2.setBounds(860,270,400,35);
		add(t2);
                t2.setFont(t2.getFont().deriveFont(19.0f));
		l=new JLabel("Gender : ");
		l.setBounds(650,320,200,50);
		add(l);
                l.setFont(l.getFont().deriveFont(19.0f));
		r1=new JRadioButton("Male");
		r1.setBounds(860,320,150,50);
                r1.setFont(r1.getFont().deriveFont(19.0f));
		r2=new JRadioButton("Female");
		r2.setBounds(1010,320,150,50);
                r2.setFont(r2.getFont().deriveFont(19.0f));
		r3=new JRadioButton("Others");
		r3.setBounds(1160,320,100,50);
                r3.setFont(r3.getFont().deriveFont(19.0f));
                r1.setBackground(Color.PINK);
                r2.setBackground(Color.PINK);
                r3.setBackground(Color.PINK);
		ButtonGroup B=new ButtonGroup();
		B.add(r1);
		B.add(r2);
		B.add(r3);
		add(r1);
		add(r2);
		add(r3);
		l3=new JLabel("Problem : ");
		l3.setBounds(650,380,200,50);
		add(l3);
                l3.setFont(l3.getFont().deriveFont(19.0f));
		t3=new JTextField();
		t3.setBounds(860,390,400,35);
		add(t3);
                t3.setFont(t3.getFont().deriveFont(19.0f));
		l4=new JLabel("Specialization : ");
		l4.setBounds(650,440,200,50);
		add(l4);
                l4.setFont(l4.getFont().deriveFont(19.0f));
		String[] s={"                  __Select__","General Medicine","Pediatrics","Gynaecology","Orthopedics","Cardiology","Dentistry","ENT","Pulmonology","Neurology","Psychiatrics","Dermatology","Opthamology"};
		c=new JComboBox(s);
		c.setBounds(860,450,350,35);
		add(c);
                c.addActionListener(this);
                c.setFont(c.getFont().deriveFont(19.0f));
		l5=new JLabel("Doctor ID : ");
		l5.setBounds(650,500,200,50);
		add(l5);
                l5.setFont(l5.getFont().deriveFont(19.0f));
		t5=new JLabel();
		t5.setBounds(860,510,400,35);
		add(t5);
                t5.setFont(t5.getFont().deriveFont(19.0f));
		t5.addMouseListener(this);
		l6=new JLabel("MobileNumber : ");
		l6.setBounds(650,560,200,50);
		add(l6);
                l6.setFont(l6.getFont().deriveFont(19.0f));
		t6=new JTextField();
		t6.setBounds(860,570,400,35);
		add(t6);
                t6.setFont(t6.getFont().deriveFont(19.0f));
		l7=new JLabel("Date : ");
		l7.setBounds(650,620,200,50);
		add(l7);
                l7.setFont(l7.getFont().deriveFont(19.0f));
		t7=new JTextField("YYYY/MM/DD");
		t7.setBounds(860,630,400,35);
		add(t7);
                t7.setEnabled(false);
                t7.addMouseListener(this);
                t7.setFont(t7.getFont().deriveFont(19.0f));
		b1=new JButton("Submit");
		b1.setBounds(900,750,100,35);
		add(b1);
                b1.addActionListener(this);
                b1.setFont(b1.getFont().deriveFont(19.0f));
		b1.setEnabled(false);
		c1=new JCheckBox(" I accept all Terms and Conditions of the Hospital");
		c1.setBounds(770,680,600,50);
		add(c1);
                c1.setBackground(Color.PINK);
                c1.setFont(c1.getFont().deriveFont(17.0f));
		c1.addItemListener(this);
                b=new JButton("Back");
                b.setBounds(30,30,100,30);
                add(b);
                b.addActionListener(this);
                getContentPane().setBackground(Color.PINK);
                setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
                setTitle("Appointment");
		setSize(5000,5000);
		setLayout(null);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent a)
	{
		if(c1.isSelected())
		b1.setEnabled(true);
		else
		b1.setEnabled(false);
	}
	public void mouseClicked(MouseEvent e)
        {
        if(e.getSource()==t7)
        {
            t7.setEnabled(true);
            if(t7.getText().compareTo("YYYY/MM/DD")==0)
            {
                t7.setText("");
            }
        }
        }
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void actionPerformed(ActionEvent e)
	{
            if(e.getSource()==c)
            {
                f=new JFrame();
                f.setBounds(700,300,1000,1000);
		int p;
                B=new JButton("OK");
		p=c.getSelectedIndex();
                if(p==0)
                {
                    t5.setText("");
                }
                if(p==1)
		{
                        h=0;
                        v=0;
                        
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='General Medicine'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("General Medicine");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==2)
		{
                        h=0;
                        v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Pediatrics'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Pediatrics");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==3)
		{
                        h=0;
                      v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Gynaecology'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Gynaecology");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==4)
		{
                        h=0;
                       v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Orthopedics'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Orthopedics");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==5)
		{
                        h=0;
                        v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Cardiology'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Cardiology");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==6)
		{
                        h=0;v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Dentistry'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Dentistry");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==7)
		{
                        h=0;v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='ENT'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,350,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("ENT");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==8)
		{
                        h=0;v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Pulmonology'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Pulmonology");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==9)
		{
                        h=0;v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Neurology'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Neurology");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==10)
		{   
                        h=0;v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Psychiatrics'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Psychiatrics");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==11)
		{
                        h=0;v=0;
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Dermatology'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,350,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Dermatology");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
                if(p==12)
		{
                        h=0;
                        v=0;
                        
                        JRadioButton[] R=new JRadioButton[100];
                        try
                        {
                            String x="select Name,DID from Doctor where Spec='Opthamology'";
                            ResultSet x1,x2;
                            x1=stmt.executeQuery(x);
                            ButtonGroup bg=new ButtonGroup();
                            while(x1.next())
                            {
                                R[v]=new JRadioButton(""+x1.getString(1)+" - "+x1.getString(2));
                                R[v].setFont(R[v].getFont().deriveFont(17.0f));
                                R[v].setBounds(60,50+h,300,40);
                                f.add(R[v]);
                                bg.add(R[v]);
                                v++;
                                h=h+60;
                            }
                            B.setBounds(60,50+h,70,35);
                            B.setFont(B.getFont().deriveFont(17.0f));
                            f.add(B);
                            h=h+120;
                            x2=stmt.executeQuery(x);
                            B.addActionListener(E->{
                            int i,j=0;
                            for(i=0;i<v;i++)
                            {
                                try{x2.next();}catch(Exception ex){}
                                if(R[i].isSelected())
                                {
                                    j=1;
                                    break;
                                }
                            }
                            if(j==1)
                            {
                                try{t5.setText(""+x2.getString(2));}catch(Exception ex){}
                                f.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"Select One");
                            }
                            });
                        }catch(Exception e3){}
                        f.setTitle("Opthamology");
			f.setSize(500,40+h);
			f.setLayout(null);
			f.setVisible(true);
		}
            }
            else if(e.getSource()==b)
            {
                this.dispose();
                try
                {
                    new Project();
                }
                catch(Exception ex){}
            }
            else if(e.getSource()==b1)
            {
            try
            {
                String q1="create table if not exists Appointments(AppNo varchar(5) primary key,Patient_Name varchar(30),Age varchar(11),Gender char(2),Problem varchar(20),Specialization varchar(20),Doctor_ID varchar(20),foreign key(Doctor_ID) references Doctor(DID),Mobile_No varchar(11),Dates date,Status varchar(20) default 'Not treated')";
                stmt.execute(q1);
                if(t1.getText().compareTo("")!=0 && t2.getText().compareTo("")!=0 && t3.getText().compareTo("")!=0 && t5.getText().compareTo("")!=0 && t6.getText().compareTo("")!=0 && t7.getText().compareTo("")!=0)
                {
                    if(r1.isSelected() || r2.isSelected() || r3.isSelected())
                    {
                        if(t7.getText().compareTo(""+dt1)==0 || t7.getText().compareTo(""+dt2)==0 || t7.getText().compareTo(""+dt3)==0 || t7.getText().compareTo(""+dt4)==0 || t7.getText().compareTo(""+dt5)==0 || t7.getText().compareTo(""+dt6)==0 || t7.getText().compareTo(""+dt7)==0)
                        {
                        try
                        {
                            if(r1.isSelected())
                            {
                                String q2="insert into Appointments values('MH"+r+"','"+t1.getText()+"','"+t2.getText()+"','M','"+t3.getText()+"','"+c.getSelectedItem()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','Not treated')";
                                stmt.executeUpdate(q2);
                                String q="select App from Doctor where DID='"+t5.getText()+"';";
                                ResultSet rs=stmt.executeQuery(q);
                                rs.next();
                                q2="update Doctor set App="+(rs.getInt(1)+1)+" where DID='"+t5.getText()+"';";
                                stmt.executeUpdate(q2);
                            }
                            else if(r2.isSelected())
                            {
                                String q2="insert into Appointments values('MH"+r+"','"+t1.getText()+"','"+t2.getText()+"','F','"+t3.getText()+"','"+c.getSelectedItem()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','Not treated')";
                                stmt.executeUpdate(q2);
                                String q="select App from Doctor where DID='"+t5.getText()+"';";
                                ResultSet rs=stmt.executeQuery(q);
                                rs.next();
                                q2="update Doctor set App="+(rs.getInt(1)+1)+" where DID='"+t5.getText()+"';";
                                stmt.executeUpdate(q2);
                            }
                            else if(r3.isSelected())
                            {
                                String q2="insert into Appointments values('MH"+r+"','"+t1.getText()+"','"+t2.getText()+"','O','"+t3.getText()+"','"+c.getSelectedItem()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','Not treated')";
                                stmt.executeUpdate(q2);
                                String q="select App from Doctor where DID='"+t5.getText()+"';";
                                ResultSet rs=stmt.executeQuery(q);
                                rs.next();
                                q2="update Doctor set App="+(rs.getInt(1)+1)+" where DID='"+t5.getText()+"';";
                                stmt.executeUpdate(q2);
                            }
                            JOptionPane.showMessageDialog(this,"Appointment Successful! Your App.No. is : MH"+r);
                            this.dispose();
                            new Project();
                        }
                        catch(Exception p)
                        {
                            JOptionPane.showMessageDialog(this,"Please enter the date properly !!"+p);   
                        }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"Appointments can be booked only from "+dt1+" to "+dt7+" !!!"); 
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Please fill all the details1");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Please fill all the details");
                }
            }
            catch(Exception ex){JOptionPane.showMessageDialog(this,""+ex);}  
            }
        }
	public static void main(String args[]) throws SQLException, ClassNotFoundException, UnsupportedOperationException
	{
		new Appointment();
	}
}