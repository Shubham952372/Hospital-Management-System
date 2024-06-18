package project;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Patient_Details extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
    JButton b;
    int h = 50;
    JTextArea p = new JTextArea(100, 0);
    JScrollPane s;
    Statement stmt;
    Connection conn;

    Patient_Details() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "@Hanumaan12@");
        stmt = conn.createStatement();
        l1 = new JLabel("App.No.");
        l1.setBounds(100, 50, 80, 30);
        l1.setFont(l1.getFont().deriveFont(20.0f));
        p.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(200, 50, 220, 30);
        l2.setFont(l2.getFont().deriveFont(20.0f));
        p.add(l2);
        l3 = new JLabel("Gender");
        l3.setBounds(420, 50, 150, 30);
        l3.setFont(l3.getFont().deriveFont(20.0f));
        p.add(l3);
        l9 = new JLabel("Age");
        l9.setBounds(570, 50, 100, 30);
        l9.setFont(l9.getFont().deriveFont(20.0f));
        p.add(l9);
        l4 = new JLabel("Mobile No.");
        l4.setBounds(690, 50, 100, 30);
        l4.setFont(l4.getFont().deriveFont(20.0f));
        p.add(l4);
        l5 = new JLabel("Specialization");
        l5.setBounds(890, 50, 220, 30);
        l5.setFont(l5.getFont().deriveFont(20.0f));
        p.add(l5);
        l6 = new JLabel("Doctor_ID");
        l6.setBounds(1110, 50, 200, 30);
        l6.setFont(l6.getFont().deriveFont(20.0f));
        p.add(l6);
        l7 = new JLabel("Date");
        l7.setBounds(1310, 50, 200, 30);
        l7.setFont(l7.getFont().deriveFont(20.0f));
        p.add(l7);
        l8 = new JLabel("Status");
        l8.setBounds(1510, 50, 180, 30);
        l8.setFont(l8.getFont().deriveFont(20.0f));
        p.add(l8);
        b = new JButton("Update Status");
        b.setBounds(1690, 50, 180, 30);
        p.add(b);
        b.setFont(b.getFont().deriveFont(20.0f));
        b.addActionListener(this);
        try {
            String q1 = "select * from Appointments";
            ResultSet r = stmt.executeQuery(q1);
            while (r.next()) {
                L1 = new JLabel("" + r.getString(1));
                L1.setBounds(110, 50 + h, 80, 30);
                L1.setFont(L1.getFont().deriveFont(18.0f));
                p.add(L1);
                L2 = new JLabel("" + r.getString(2));
                L2.setBounds(200, 50 + h, 220, 30);
                L2.setFont(L2.getFont().deriveFont(18.0f));
                p.add(L2);
                L3 = new JLabel("" + r.getString(4));
                L3.setBounds(440, 50 + h, 150, 30);
                L3.setFont(L3.getFont().deriveFont(18.0f));
                p.add(L3);
                L9 = new JLabel("" + r.getInt(3));
                L9.setBounds(570, 50 + h, 100, 30);
                L9.setFont(L9.getFont().deriveFont(20.0f));
                p.add(L9);
                L4 = new JLabel("" + r.getString(8));
                L4.setBounds(690, 50 + h, 100, 30);
                L4.setFont(L4.getFont().deriveFont(18.0f));
                p.add(L4);
                L5 = new JLabel("" + r.getString(6));
                L5.setBounds(890, 50 + h, 220, 30);
                L5.setFont(L5.getFont().deriveFont(18.0f));
                p.add(L5);
                L6 = new JLabel("" + r.getString(7));
                L6.setBounds(1110, 50 + h, 200, 30);
                L6.setFont(L6.getFont().deriveFont(18.0f));
                p.add(L6);
                L7 = new JLabel("" + r.getString(9));
                L7.setBounds(1310, 50 + h, 200, 30);
                L7.setFont(L7.getFont().deriveFont(18.0f));
                p.add(L7);
                L8 = new JLabel("" + r.getString(10));
                L8.setBounds(1510, 50 + h, 300, 30);
                L8.setFont(L8.getFont().deriveFont(18.0f));
                p.add(L8);
                h = h + 30;
            }
        } catch (Exception ex) {
            b.setEnabled(false);
        }
        p.setEditable(false);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        p.setBackground(Color.PINK);
        setTitle("PATIENTS DETAILS");
        s = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(s);
        s.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        setSize(2000, 2000);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            JFrame f = new JFrame();
            JLabel n1 = new JLabel("App.No.     : ");
            n1.setBounds(80, 90, 150, 50);
            n1.setFont(n1.getFont().deriveFont(18.0f));
            f.add(n1);
            JTextField t1 = new JTextField();
            t1.setBounds(230, 95, 200, 40);
            t1.setFont(t1.getFont().deriveFont(18.0f));
            f.add(t1);
            JLabel n2 = new JLabel("Status        : ");
            n2.setBounds(80, 160, 150, 50);
            n2.setFont(n2.getFont().deriveFont(18.0f));
            f.add(n2);
            JRadioButton r1, r2, r3;
            r1 = new JRadioButton("  Not treated");
            r2 = new JRadioButton("  Medicine");
            r3 = new JRadioButton("  Surgery");
            r1.setFont(r1.getFont().deriveFont(18.0f));
            r2.setFont(r2.getFont().deriveFont(18.0f));
            r3.setFont(r3.getFont().deriveFont(18.0f));
            r1.setBounds(230, 160, 150, 50);
            r2.setBounds(230, 210, 150, 50);
            r3.setBounds(230, 260, 150, 50);
            f.add(r1);
            f.add(r2);
            f.add(r3);
            ButtonGroup bg = new ButtonGroup();
            bg.add(r1);
            bg.add(r2);
            bg.add(r3);
            JButton b = new JButton("OK");
            b.setBounds(190, 330, 100, 40);
            b.setFont(b.getFont().deriveFont(18.0f));
            f.add(b);
            b.addActionListener(E -> {
                String st = new String();
                try {
                    if (r1.isSelected() || r2.isSelected() || r3.isSelected()) {
                        int K = 0, K1 = 0,K2=0;
                        String com = "";
                        String g = "select status from Appointments where AppNo='" + t1.getText() + "'";
                        try {
                            ResultSet RS = stmt.executeQuery(g);
                            RS.next();
                            com = RS.getString(1);
                        } catch (Exception ex) {
                        }

                        g = "select Treated from Doctor where DID='" + L6.getText() + "'";
                        try {
                            ResultSet RS2 = stmt.executeQuery(g);
                            RS2.next();
                            K = RS2.getInt(1);
                        } catch (Exception ex) {
                        }

                        g = "select Surgeries from Doctor where DID='" + L6.getText() + "'";
                        try {
                            ResultSet RS1 = stmt.executeQuery(g);
                            RS1.next();
                            K1 = RS1.getInt(1);
                        } catch (Exception ex) {
                        }
                        g = "select App from Doctor where DID='" + L6.getText() + "'";
                        try {
                            ResultSet RS1 = stmt.executeQuery(g);
                            RS1.next();
                            K2 = RS1.getInt(1);
                        } catch (Exception ex) {
                        }

                        if (r1.isSelected()) {
                            st = "Not treated";
                            if (com.compareTo("Medicine") == 0) {
                                g = "Update Doctor set Treated=" + (K - 1) + " where DID='" + L6.getText() + "'";
                                try {
                                    stmt.executeUpdate(g);
                                } catch (Exception ex4) {}
                                
                            } else if (com.compareTo("Surgery") == 0) {
                                g = "Update Doctor set Treated=" + (K - 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                                g = "Update Doctor set Surgeries=" + (K1 - 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                            }
                        } else if (r2.isSelected()) {
                            st = "Medicine";
                            if (com.compareTo("Not treated") == 0) {
                                g = "Update Doctor set Treated=" + (K + 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                                g = "Update Doctor set App=" + (K2 - 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                            } else if (com.compareTo("Surgery") == 0) {
                                g = "Update Doctor set Surgeries=" + (K1 - 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                            }
                        } else {
                            st = "Surgery";
                            if (com.compareTo("Not treated") == 0) {
                                g = "Update Doctor set Treated=" + (K + 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                                g = "Update Doctor set Surgeries=" + (K1 + 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                                g = "Update Doctor set App=" + (K2 - 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                            } else if (com.compareTo("Medicine") == 0) {
                                g = "Update Doctor set Surgeries=" + (K1 + 1) + " where DID='" + L6.getText() + "'";
                                stmt.executeUpdate(g);
                            }
                        }
                        String c = "Update Appointments set Status='" + st + "' where AppNo='" + t1.getText() + "'";
                        int v = stmt.executeUpdate(c);
                        if (v == 0) {
                            JOptionPane.showMessageDialog(f, "Enter correct AppNo !!");
                        } else {
                            f.dispose();
                            this.dispose();
                            new Patient_Details();
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Select one!!");
                    }
                } catch (Exception ex) {
                }
            });
            f.setBounds(700, 300, 300, 300);
            f.setTitle("Update Status");
            f.setLayout(null);
            f.setVisible(true);
            f.setSize(500, 500);
        }
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        new Patient_Details();
    }
}
