package project;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Pulmonology extends JFrame {

    JLabel l1, l2, l3, l4, l;
    JLabel L1, L2, L3, L4;
    JScrollPane sp;
    JTextArea p = new JTextArea(150, 0);
    Statement stmt;
    Connection conn;
    int h = 0;

    Pulmonology() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "@Hanumaan12@");
        stmt = conn.createStatement();
        l = new JLabel("Doctors in Pulmonology");
        l.setBounds(120, 40, 350, 50);
        l.setFont(l.getFont().deriveFont(25.0f));
        p.add(l);
        String s = "Select * from Doctor where Spec='Pulmonology'";
        try {
            ResultSet r = stmt.executeQuery(s);
            while (r.next()) {
                l1 = new JLabel("Name :");
                l1.setBounds(120, 90 + h, 200, 40);
                l1.setFont(l1.getFont().deriveFont(19.0f));
                p.add(l1);
                l2 = new JLabel("ID :");
                l2.setBounds(120, 130 + h, 200, 40);
                l2.setFont(l2.getFont().deriveFont(19.0f));
                p.add(l2);
                l3 = new JLabel("Experience :");
                l3.setBounds(120, 170 + h, 200, 40);
                l3.setFont(l3.getFont().deriveFont(19.0f));
                p.add(l3);
                l4 = new JLabel("Qualification :");
                l4.setBounds(120, 210 + h, 200, 40);
                l4.setFont(l4.getFont().deriveFont(19.0f));
                p.add(l4);
                L1 = new JLabel("" + r.getString(2));
                L1.setBounds(360, 90 + h, 250, 40);
                L1.setFont(L1.getFont().deriveFont(19.0f));
                p.add(L1);
                L2 = new JLabel("" + r.getString(1));
                L2.setBounds(360, 130 + h, 200, 40);
                L2.setFont(L2.getFont().deriveFont(19.0f));
                p.add(L2);
                L3 = new JLabel("" + r.getString(6));
                L3.setBounds(360, 170 + h, 200, 40);
                L3.setFont(L3.getFont().deriveFont(19.0f));
                p.add(L3);
                L4 = new JLabel("" + r.getString(5));
                L4.setBounds(360, 210 + h, 300, 40);
                L4.setFont(L4.getFont().deriveFont(19.0f));
                p.add(L4);
                h = h + (4 * 40) + 10;
            }
            p.setEditable(false);
            setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
            p.setBackground(Color.PINK);
            setTitle("PULMONOLOGY");
            sp = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            add(sp);
            sp.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
            setSize(2000, 2000);
            setVisible(true);
        } catch (Exception ex) {
            p.setEditable(false);
            setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
            p.setBackground(Color.PINK);
            setTitle("PULMONOLOGY");
            sp = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            add(sp);
            sp.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
            setSize(2000, 2000);
            setVisible(true);
            JOptionPane.showMessageDialog(this, "No Doctors are present currently");
        }

    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        new Pulmonology();
    }
}
