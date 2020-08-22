import javax.swing.*;

import java.util.*;

import java.io.*;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;

class Book
{
JFrame f;
Choice c1,c2;
TextField t1,t2,t3,t4,t5;
Label l1,l2,l3,l4,l5,l6,l7,l8;
Panel p1,p2,p3,p4;
JButton b1,b2,b3;
JCheckBox cb;
Book()
{
try
{
f=new JFrame("book");
f.setLayout(null);
f.setVisible(true);
f.setSize(1500,1000);
f.setLocationRelativeTo(null);

f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e1)
{
f.dispose();
}
});

p1=new Panel();
p2=new Panel();
p3=new Panel();
p4=new Panel();

f.add(p1);
f.add(p2);
f.add(p3);
f.add(p4);

p1.setBounds(0,0,1500,100);
p2.setBounds(0,100,500,800);
p3.setBounds(500,100,1000,800);
p4.setBounds(0,900,1500,100);

p1.setLayout(null);
p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
p3.setLayout(null);
p4.setLayout(null);

c1=new Choice();
c2=new Choice();
c1.setBounds(200,380,700,70);
c2.setBounds(200,720,700,50);

c1.add("Science fiction");
c1.add("java");
c1.add("c++");
c1.add("ADA");
c1.add("Self Help");

c2.add("A1");
c2.add("A2");
c2.add("A3");
c2.add("A4");
c2.add("A5");
c2.add("B1");
c2.add("B2");
c2.add("B3");
c2.add("B4");
c2.add("B5");
c2.add("C1");
c2.add("C2");
c2.add("C3");
c2.add("C4");
c2.add("C5");

l1=new Label("  BOOK NAME");
l2=new Label("  AUTHOR ");
l3=new Label("  PUBLISHER");
l4=new Label("  CATEGORY");
l5=new Label("  BOOK ID");
l6=new Label("  PRICE(Rs.)");
l7=new Label("  SHELF No.");
l8=new Label("BOOK INFORMATION");

l1.setFont(new Font("sherif",1,40));
l2.setFont(new Font("sherif",1,40));
l3.setFont(new Font("sherif",1,40));
l4.setFont(new Font("sherif",1,40));
l5.setFont(new Font("sherif",1,40));
l6.setFont(new Font("sherif",1,40));
l7.setFont(new Font("sherif",1,40));
l8.setFont(new Font("sherif",1,80));

l8.setBounds(300,0,1000,100);

p2.add(l1);
p2.add(l2);
p2.add(l3);
p2.add(l4);
p2.add(l5);
p2.add(l6);
p2.add(l7);
p1.add(l8);

t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();

t1.setBounds(200,20,700,70);
t2.setBounds(200,130,700,70);
t3.setBounds(200,240,700,70);
t4.setBounds(200,460,700,70);
t5.setBounds(200,590,700,70);

t1.setFont(new Font("sherif",1,40));
t2.setFont(new Font("sherif",1,40));
t3.setFont(new Font("sherif",1,40));
t4.setFont(new Font("sherif",1,40));
t5.setFont(new Font("sherif",1,40));

p3.add(t1);
p3.add(t2);
p3.add(t3);
p3.add(c1);
p3.add(t4);
p3.add(t5);
p3.add(c2);

b1=new JButton("Save");
b2=new JButton("Back");
b3=new JButton("Exit");
b1.setEnabled(false);

b1.setBounds(1050,10,100,40);
b2.setBounds(1200,10,100,40);
b3.setBounds(1350,10,100,40);

b1.setFont(new Font("sherif",1,20));
b2.setFont(new Font("sherif",1,20));
b3.setFont(new Font("sherif",1,20));

cb=new JCheckBox("All entries are correct");
cb.setBounds(300,10,150,30);
cb.addItemListener(new ItemListener()
{
public void itemStateChanged(ItemEvent e1)
{
if(cb.isSelected())
{
b1.setEnabled(true);
}
else
{
b1.setEnabled(false);
}
}
});

p4.add(cb);
p4.add(b1);
p4.add(b2);
p4.add(b3);

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hera","root","abhishek");
String s="insert into kok(bname,author,pub,cat,bid,price,sno) values(?,?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(s);
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,t3.getText());
ps.setString(4,c1.getSelectedItem());
ps.setString(5,t4.getText());
ps.setFloat(6,Float.parseFloat(t5.getText()));
ps.setString(7,c2.getSelectedItem());
ps.executeUpdate();
con.close();
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
cb.setSelected(false);
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

}
});

b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
Member k=new Member();
f.dispose();
}
});

b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
f.dispose();
}
});

}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
public static void main(String ar[])
{
Book b=new Book();
}
}