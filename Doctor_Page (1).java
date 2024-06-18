package project;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static project.Add_Admin.stmt;

public class Doctor_Page extends JFrame implements ActionListener {

    JFrame f;
    JComboBox c;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, lb, lb1, a, a1, a2, a3, a4, a5;
    JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, A1, A2, A3, A4, A5;
    JTextField t, t1;
    JButton b, B, b1,b2;
    JScrollPane sp;
    JTextArea p = new JTextArea(150, 0);
    Statement stmt;
    Connection conn;
    String u, w;

    Doctor_Page() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "@Hanumaan12@");
        stmt = conn.createStatement();
        String q = "select Username from Current_Status where Status=1";
        ResultSet r = stmt.executeQuery(q);
        r.next();
        u = r.getString(1);
        String Q = "select * from Doctor where Username='" + r.getString(1) + "'";
        r = stmt.executeQuery(Q);
        r.next();
        l = new JLabel("Profile");
        l.setBounds(150, 30, 200, 50);
        l.setFont(l.getFont().deriveFont(22.0f));
        p.add(l);
        l1 = new JLabel("Name :");
        l1.setBounds(150, 80, 200, 40);
        l1.setFont(l1.getFont().deriveFont(19.0f));
        p.add(l1);
        L1 = new JLabel("" + r.getString(2));
        L1.setBounds(350, 80, 300, 40);
        L1.setFont(L1.getFont().deriveFont(19.0f));
        p.add(L1);
        l2 = new JLabel("ID :");
        l2.setBounds(150, 120, 200, 40);
        l2.setFont(l2.getFont().deriveFont(19.0f));
        p.add(l2);
        L2 = new JLabel("" + r.getString(1));
        L2.setBounds(350, 120, 300, 40);
        L2.setFont(L2.getFont().deriveFont(19.0f));
        p.add(L2);
        l3 = new JLabel("Gender :");
        l3.setBounds(150, 160, 200, 40);
        l3.setFont(l3.getFont().deriveFont(19.0f));
        p.add(l3);
        L3 = new JLabel("" + r.getString(3));
        L3.setBounds(350, 160, 300, 40);
        L3.setFont(L3.getFont().deriveFont(19.0f));
        p.add(L3);
        l4 = new JLabel("Specialization :");
        l4.setBounds(150, 200, 200, 40);
        l4.setFont(l4.getFont().deriveFont(19.0f));
        p.add(l4);
        L4 = new JLabel("" + r.getString(4));
        L4.setBounds(350, 200, 300, 40);
        L4.setFont(L4.getFont().deriveFont(19.0f));
        p.add(L4);
        l5 = new JLabel("Qualification :");
        l5.setBounds(150, 240, 200, 40);
        l5.setFont(l5.getFont().deriveFont(19.0f));
        p.add(l5);
        L5 = new JLabel("" + r.getString(5));
        L5.setBounds(350, 240, 300, 40);
        L5.setFont(L5.getFont().deriveFont(19.0f));
        p.add(L5);
        l6 = new JLabel("Experience :");
        l6.setBounds(150, 280, 200, 40);
        l6.setFont(l6.getFont().deriveFont(19.0f));
        p.add(l6);
        L6 = new JLabel("" + r.getString(6) + " Years");
        L6.setBounds(350, 280, 300, 40);
        L6.setFont(L6.getFont().deriveFont(19.0f));
        p.add(L6);
        l7 = new JLabel("Mobile No :");
        l7.setBounds(150, 320, 200, 40);
        l7.setFont(l7.getFont().deriveFont(19.0f));
        p.add(l7);
        L7 = new JLabel("" + r.getString(11));
        L7.setBounds(350, 320, 300, 40);
        L7.setFont(L7.getFont().deriveFont(19.0f));
        p.add(L7);
        l8 = new JLabel("Username :");
        l8.setBounds(150, 360, 200, 40);
        l8.setFont(l8.getFont().deriveFont(19.0f));
        p.add(l8);
        L8 = new JLabel("" + r.getString(12));
        L8.setBounds(350, 360, 300, 40);
        L8.setFont(L8.getFont().deriveFont(19.0f));
        p.add(L8);
        l9 = new JLabel("Appointments :");
        l9.setBounds(150, 400, 200, 40);
        l9.setFont(l9.getFont().deriveFont(19.0f));
        p.add(l9);
        L9 = new JLabel("" + r.getString(8));
        L9.setBounds(350, 400, 300, 40);
        L9.setFont(L9.getFont().deriveFont(19.0f));
        p.add(L9);
        l10 = new JLabel("Total Treated :");
        l10.setBounds(150, 440, 200, 40);
        l10.setFont(l4.getFont().deriveFont(19.0f));
        p.add(l10);
        L10 = new JLabel("" + r.getString(9));
        L10.setBounds(350, 440, 300, 40);
        L10.setFont(L10.getFont().deriveFont(19.0f));
        p.add(L10);
        l11 = new JLabel("Surgeries :");
        l11.setBounds(150, 480, 200, 40);
        l11.setFont(l11.getFont().deriveFont(19.0f));
        p.add(l11);
        L11 = new JLabel("" + r.getString(10));
        L11.setBounds(350, 480, 300, 40);
        L11.setFont(L11.getFont().deriveFont(19.0f));
        p.add(L11);
        b = new JButton("Update Profile");
        b.setBounds(670, 480, 180, 35);
        p.add(b);
        b.setFont(b.getFont().deriveFont(18.0f));
        b.addActionListener(this);
        B = new JButton("Change Password");
        B.setBounds(870, 480, 210, 35);
        p.add(B);
        B.setFont(B.getFont().deriveFont(18.0f));
        B.addActionListener(this);
        a = new JLabel("Appointments");
        a.setBounds(150, 540, 200, 40);
        a.setFont(a.getFont().deriveFont(22.0f));
        p.add(a);
        a1 = new JLabel("APP No.");
        a1.setBounds(150, 580, 210, 40);
        a1.setFont(a1.getFont().deriveFont(19.0f));
        p.add(a1);
        a2 = new JLabel("Age");
        a2.setBounds(360, 580, 100, 40);
        a2.setFont(a2.getFont().deriveFont(19.0f));
        p.add(a2);
        a3 = new JLabel("Gender");
        a3.setBounds(460, 580, 150, 40);
        a3.setFont(a3.getFont().deriveFont(19.0f));
        p.add(a3);
        a4 = new JLabel("Problem");
        a4.setBounds(610, 580, 310, 40);
        a4.setFont(a4.getFont().deriveFont(19.0f));
        p.add(a4);
        a5 = new JLabel("Date");
        a5.setBounds(920, 580, 200, 40);
        a5.setFont(a1.getFont().deriveFont(19.0f));
        p.add(a5);
        b2=new JButton("Back");
        b2.setBounds(30,30,100,30);
        b2.setFont(b.getFont().deriveFont(16.0f));
        p.add(b2);
        b2.addActionListener(this);
        int h = 40;
        try {
            String q2 = "select DID from Doctor where Username='" + u + "'";
            ResultSet r3 = stmt.executeQuery(q2);
            r3.next();
            w = r3.getString("DID");
            Q = "select * from Appointments where Doctor_ID='" + w + "' && Status='Not treated'";
            ResultSet R = stmt.executeQuery(Q);
            while (R.next()) {
                A1 = new JLabel("" + R.getString(1));
                A1.setBounds(150, 580 + h, 210, 40);
                A1.setFont(A1.getFont().deriveFont(19.0f));
                p.add(A1);
                A2 = new JLabel("" + R.getString(3));
                A2.setBounds(360, 580 + h, 100, 40);
                A2.setFont(A2.getFont().deriveFont(19.0f));
                p.add(A2);
                A3 = new JLabel("" + R.getString(4));
                A3.setBounds(460, 580 + h, 150, 40);
                A3.setFont(A3.getFont().deriveFont(19.0f));
                p.add(A3);
                A4 = new JLabel("" + R.getString(5));
                A4.setBounds(610, 580 + h, 310, 40);
                A4.setFont(A4.getFont().deriveFont(19.0f));
                p.add(A4);
                A5 = new JLabel("" + R.getString(9));
                A5.setBounds(920, 580 + h, 200, 40);
                A5.setFont(A5.getFont().deriveFont(19.0f));
                p.add(A5);
                h = h + 40;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No Appointments" + ex);
        }
        p.setEditable(false);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        p.setBackground(Color.PINK);
        setTitle("DOCTOR'S HOME PAGE");
        sp = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp);
        sp.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        setSize(2000, 2000);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            f = new JFrame();
            String[] s = {"Select", "Name", "Gender", "Qualification", "Experience", "MobileNo", "Username"};
            c = new JComboBox(s);
            c.setBounds(40, 160, 120, 35);
            c.setFont(c.getFont().deriveFont(17.0f));
            f.add(c);
            t = new JTextField();
            t.setBounds(220, 160, 240, 35);
            t.setFont(t.getFont().deriveFont(17.0f));
            f.add(t);
            b1 = new JButton("OK");
            b1.setBounds(200, 240, 70, 30);
            b1.setFont(b1.getFont().deriveFont(17.0f));
            f.add(b1);
            b1.addActionListener(E -> {
                String m = c.getItemAt(c.getSelectedIndex()).toString();
                if (c.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(f, "Please select right field to update");
                } else if (c.getSelectedIndex() == 1) {
                    if (t.getText().compareTo("") != 0) {
                        String q = "update Doctor set Name='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error7");
                        }
                        q = "update Login_Details set Name='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error6");
                        }
                        JOptionPane.showMessageDialog(f, "Successfully updated !!");
                        f.dispose();
                        this.dispose();
                        try {
                            new Doctor_Page();
                        } catch (Exception ex) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Fill all the details");
                    }
                } else if (c.getSelectedIndex() == 2) {
                    if (t.getText().compareTo("M") == 0 || t.getText().compareTo("F") == 0 || t.getText().compareTo("O") == 0) {
                        String q = "update Doctor set Gender='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error7");
                        }
                        q = "update Login_Details set Gender='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error6");
                        }
                        JOptionPane.showMessageDialog(f, "Successfully updated !!");
                        f.dispose();
                        this.dispose();
                        try {
                            new Doctor_Page();
                        } catch (Exception ex) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Please Enter M/F/O");
                    }
                } else if (c.getSelectedIndex() == 5) {
                    if (t.getText().compareTo("") != 0) {
                        System.out.println("" + u + " " + m);
                        String q = "update Doctor set MobileNo='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error7");
                        }
                        q = "update Login_Details set Mobile='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error6");
                        }
                        JOptionPane.showMessageDialog(f, "Successfully updated !!");
                        f.dispose();
                        this.dispose();
                        try {
                            new Doctor_Page();
                        } catch (Exception ex) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Fill all the details");
                    }
                } else if (c.getSelectedIndex() == 6) {
                    if (t.getText().compareTo("") != 0) {
                        String q = "update Doctor set Username='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error5");
                        }
                        q = "update Login_Details set Username='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error4");
                        }
                        q = "update Current_Status set Username='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                            JOptionPane.showMessageDialog(f, "Successfully updated !!");
                            f.dispose();
                            this.dispose();
                            try {
                                new Doctor_Page();
                            } catch (Exception ex) {
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error3");
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Fill all the details");
                    }
                } else if (c.getSelectedIndex() == 3) {
                    if (t.getText().compareTo("") != 0) {
                        String q = "update Doctor set Qual='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                            JOptionPane.showMessageDialog(f, "Successfully updated !!");
                            f.dispose();
                            this.dispose();
                            try {
                                new Doctor_Page();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(f, "Error0");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Fill all the details");
                    }
                } else if (c.getSelectedIndex() == 4) {
                    if (t.getText().compareTo("") != 0) {
                        String q = "update Doctor set Exp='" + t.getText() + "' where Username='" + u + "'";
                        try {
                            stmt.executeUpdate(q);
                            JOptionPane.showMessageDialog(f, "Successfully updated !!");
                            f.dispose();
                            this.dispose();
                            try {
                                new Doctor_Page();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(f, "Error0");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Enter only Number");
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Fill all the details");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please select right field to update");
                }
            });
            f.getContentPane().setBackground(Color.PINK);
            f.setTitle("UPDATE PROFILE");
            f.setBounds(630, 300, 500, 500);
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(500, 500);
        }
        if (e.getSource() == B) {
            f = new JFrame();
            lb = new JLabel("New Password :");
            lb.setBounds(50, 130, 200, 50);
            lb.setFont(lb.getFont().deriveFont(17.0f));
            f.add(lb);
            t = new JTextField();
            t.setBounds(250, 135, 300, 40);
            t.setFont(t.getFont().deriveFont(17.0f));
            f.add(t);
            lb1 = new JLabel("Confirm Password :");
            lb1.setBounds(50, 190, 200, 50);
            lb1.setFont(lb.getFont().deriveFont(17.0f));
            f.add(lb1);
            t1 = new JTextField();
            t1.setBounds(250, 195, 300, 40);
            t1.setFont(t1.getFont().deriveFont(17.0f));
            f.add(t1);
            b1 = new JButton("OK");
            b1.setBounds(245, 270, 70, 30);
            b1.setFont(b1.getFont().deriveFont(17.0f));
            f.add(b1);
            b1.addActionListener(E -> {
                if (t.getText().compareTo("") != 0 && t1.getText().compareTo("") != 0 && t1.getText().compareTo("" + t.getText()) == 0) {
                    String q = "select Username from Login_Details where Status=1";
                    try {
                        ResultSet r2 = stmt.executeQuery(q);
                        try {
                            String q3 = "update Login_Details set Password='" + t1.getText() + "' where Status=1;";
                            stmt.executeUpdate(q3);
                            f.dispose();
                            JOptionPane.showMessageDialog(f, "Successfully updated !!");
                            this.dispose();
                            try {
                                new Doctor_Page();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(f, "Error0");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, "Error1");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(f, "Error11");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please fill all the details properly");
                }
            });
            f.getContentPane().setBackground(Color.PINK);
            f.setTitle("UPDATE PASSWORD");
            f.setBounds(625, 300, 600, 500);
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(600, 500);
        }
        if(e.getSource()==b2)
        {
            try 
            {
                new Doctor_Login();
                this.dispose();
            } 
            catch (Exception ex) {}
        }
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        new Doctor_Page();
    }
}
