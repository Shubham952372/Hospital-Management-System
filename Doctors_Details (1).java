package project;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;

public class Doctors_Details extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
    int h = 50;
    JTextArea p = new JTextArea(150, 0);
    JScrollPane s;
    Statement stmt;
    Connection conn;

    Doctors_Details() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "@Hanumaan12@");
        stmt = conn.createStatement();
        l1 = new JLabel("Doctor_ID");
        l1.setBounds(70, 50, 130, 30);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        p.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(200, 50, 250, 30);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        p.add(l2);
        l3 = new JLabel("Specialization");
        l3.setBounds(450, 50, 210, 30);
        l3.setFont(l3.getFont().deriveFont(20.0f));
        p.add(l3);
        l4 = new JLabel("Qualification");
        l4.setBounds(660, 50, 270, 30);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        p.add(l4);
        l5 = new JLabel("Experience");
        l5.setBounds(930, 50, 200, 30);
        l5.setFont(l5.getFont().deriveFont(20.0f));
        p.add(l5);
        l6 = new JLabel("Salary");
        l6.setBounds(1130, 50, 150, 30);
        l6.setFont(l6.getFont().deriveFont(20.0f));
        p.add(l6);
        l7 = new JLabel("Appointments");
        l7.setBounds(1280, 50, 200, 30);
        l7.setFont(l7.getFont().deriveFont(20.0f));
        p.add(l7);
        l8 = new JLabel("Total Treated");
        l8.setBounds(1480, 50, 200, 30);
        l8.setFont(l8.getFont().deriveFont(20.0f));
        p.add(l8);
        l9 = new JLabel("Surgeries");
        l9.setBounds(1680, 50, 100, 30);
        l9.setFont(l9.getFont().deriveFont(20.0f));
        p.add(l9);
        try {
            String q1 = "select * from Doctor";
            ResultSet r = stmt.executeQuery(q1);
            while (r.next()) {
                L1 = new JLabel("" + r.getString(1));
                L1.setBounds(70, 50 + h, 130, 30);
                L1.setFont(L1.getFont().deriveFont(18.0f));
                p.add(L1);
                L2 = new JLabel("" + r.getString(2));
                L2.setBounds(200, 50 + h, 250, 30);
                L2.setFont(L2.getFont().deriveFont(18.0f));
                p.add(L2);
                L3 = new JLabel("" + r.getString(4));
                L3.setBounds(450, 50 + h, 210, 30);
                L3.setFont(L3.getFont().deriveFont(18.0f));
                p.add(L3);
                L4 = new JLabel("" + r.getString(5));
                L4.setBounds(660, 50 + h, 270, 30);
                L4.setFont(L4.getFont().deriveFont(18.0f));
                p.add(L4);
                L5 = new JLabel("" + r.getInt(6) + " Years");
                L5.setBounds(945, 50 + h, 200, 30);
                L5.setFont(L5.getFont().deriveFont(18.0f));
                p.add(L5);
                L6 = new JLabel("" + r.getInt(7));
                L6.setBounds(1130, 50 + h, 150, 30);
                L6.setFont(L6.getFont().deriveFont(18.0f));
                p.add(L6);
                L7 = new JLabel("" + r.getInt(8));
                L7.setBounds(1330, 50 + h, 200, 30);
                L7.setFont(L7.getFont().deriveFont(18.0f));
                p.add(L7);
                L8 = new JLabel("" + r.getInt(9));
                L8.setBounds(1525, 50 + h, 200, 30);
                L8.setFont(L8.getFont().deriveFont(18.0f));
                p.add(L8);
                L9 = new JLabel("" + r.getInt(10));
                L9.setBounds(1720, 50 + h, 100, 30);
                L9.setFont(L9.getFont().deriveFont(18.0f));
                p.add(L9);
                h = h + 30;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No Doctors available");
        }
        p.setEditable(false);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        p.setBackground(Color.PINK);
        setTitle("DOCTORS DETAILS");
        s = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(s);
        s.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        setSize(2000, 2000);
        setVisible(true);
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        new Doctors_Details();
    }
}
