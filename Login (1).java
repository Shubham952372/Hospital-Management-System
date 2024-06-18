package project;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JPasswordField p1;
    static JTextField t1;
    JButton b1, b2, b;
    Connection conn;
    Statement stmt;

    Login() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "@Hanumaan12@");
        stmt = conn.createStatement();
        l3 = new JLabel("Patient's Login Form");
        l3.setBounds(840, 230, 300, 100);
        add(l3);
        l3.setFont(l3.getFont().deriveFont(25.0f));
        l1 = new JLabel("Username : ");
        l1.setBounds(785, 330, 150, 50);
        add(l1);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        t1 = new JTextField();
        t1.setBounds(935, 340, 200, 35);
        t1.setFont(t1.getFont().deriveFont(20.0f));
        add(t1);
        l2 = new JLabel("Password : ");
        l2.setBounds(785, 390, 150, 50);
        add(l2);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        p1 = new JPasswordField();
        p1.setBounds(935, 395, 200, 35);
        p1.setFont(p1.getFont().deriveFont(20.0f));
        add(p1);
        b1 = new JButton("Login");
        b1.setBounds(785, 470, 100, 35);
        add(b1);
        b1.addActionListener(this);
        b1.setFont(b1.getFont().deriveFont(17.0f));
        b2 = new JButton("SignUp");
        b2.setBounds(1020, 470, 110, 35);
        add(b2);
        b2.setFont(b2.getFont().deriveFont(17.0f));
        b2.addActionListener(this);
        b = new JButton("Back");
        b.setBounds(30, 30, 100, 30);
        add(b);
        b.setFont(b.getFont().deriveFont(17.0f));
        b.addActionListener(this);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.PINK);
        setSize(2050, 2050);
        setLayout(null);
        setTitle("PATIENT'S LOGIN FORM");
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (t1.getText().compareTo("") != 0 && p1.getText().compareTo("") != 0) {
                try {
                    String p = "select Username,Password,Status from Login_Details where Username='" + t1.getText() + "';";
                    ResultSet r = stmt.executeQuery(p);
                    r.next();
                    if (r.getString(1).compareTo("") != 0) {
                        if (r.getString(2).compareTo("" + p1.getText()) == 0) {
                            if (r.getInt(3) == 0) {
                                String q = "Update Login_Details set Status=1 where Username='" + t1.getText() + "';";
                                stmt.executeUpdate(q);
                                q = "Update Login_Details set Status=0 where Username!='" + t1.getText() + "'";
                                stmt.executeUpdate(q);
                                JOptionPane.showMessageDialog(this, "You are logged in successfully!!");
                                q = "truncate table Current_Status";
                                stmt.execute(q);
                                q = "insert into Current_Status values('" + t1.getText() + "',1);";
                                stmt.executeUpdate(q);
                                this.dispose();
                                new Project();
                            } else {
                                JOptionPane.showMessageDialog(this, "You are already logged in!!");
                                String q = "insert into Current_Status values('" + t1.getText() + "',1);";
                                stmt.executeUpdate(q);
                                this.dispose();
                                new Project();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Password");
                        }
                    }
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(this, "Invalid Username");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all the details");
            }
        } else if (e.getSource() == b2) {
            this.dispose();
            try {
                new Signup();
            } catch (Exception n) {
            }
        } else if (e.getSource() == b) {
            this.dispose();
            try {
                new Project();
            } catch (Exception ex) {
            }
        }
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        new Login();
    }
}
