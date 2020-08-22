import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Member
{
JFrame f;
Panel p1,p2,p3,p4;
Label l1,l2,l3,l4,l5,l6,l7;
TextField t1,t2,t3,t4,t5,t6;
JButton b,b1,b2;
JCheckBox c;
Member()
{
try
{
f=new JFrame("Member Detail");
f.setLayout(null);
f.setVisible(true);
f.setSize(1500,1000);
f.setLocationRelativeTo(null);

p4=new Panel();
p4.setBounds(0,0,15000,100);

p1=new Panel();
p1.setBounds(0,100,750,800);

p2=new Panel();
p2.setBounds(750,100,750,800);

p3=new Panel();
p3.setBounds(0,900,1500,100);

p4.setLayout(null);
p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
p2.setLayout(null);
p3.setLayout(null);

f.add(p4);
f.add(p1);
f.add(p2);
f.add(p3);

l7=new Label("MEMBER DETAIL");
l7.setBounds(400,0,800,100);
l1=new Label("  MEMBER NAME");
l2=new Label("  MEMBER ID");
l3=new Label("  COLLEGE NAME");
l4=new Label("  CHECK IN DATE");
l5=new Label("  PHONE No.");
l6=new Label("  EMAIL ID");

l7.setFont(new Font("sherif",1,80));
l1.setFont(new Font("sherif",1,40));
l2.setFont(new Font("sherif",1,40));
l3.setFont(new Font("sherif",1,40));
l4.setFont(new Font("sherif",1,40));
l5.setFont(new Font("sherif",1,40));
l6.setFont(new Font("sherif",1,40));

t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();

t1.setBounds(0,20,700,80);
t2.setBounds(0,150,700,80);
t3.setBounds(0,280,700,80);
t4.setBounds(0,410,700,80);
t5.setBounds(0,540,700,80);
t6.setBounds(0,670,700,80);

t1.setFont(new Font("sherif",1,40));
t2.setFont(new Font("sherif",1,40));
t3.setFont(new Font("sherif",1,40));
t4.setFont(new Font("sherif",1,40));
t5.setFont(new Font("sherif",1,40));
t6.setFont(new Font("sherif",1,40));

b=new JButton("Next");
b.setEnabled(false);
b1=new JButton("Exit");
b.setBounds(1350,10,100,40);
b1.setBounds(1200,10,100,40);
b.setFont(new Font("sherif",1,20));
b1.setFont(new Font("sherif",1,20));
b2=new JButton("show details");
b2.setBounds(200,10,200,40);
b2.setFont(new Font("sherif",1,20));
c=new JCheckBox("All the entries are correct");
c.setBounds(700,0,200,40);
c.addItemListener(new ItemListener()
{
public void itemStateChanged(ItemEvent e1)
{
if(c.isSelected())
{
b.setEnabled(true);
}
else
{
b.setEnabled(false);
}
}
});

p4.add(l7);

p1.add(l1);
p1.add(l2);
p1.add(l3);
p1.add(l4);
p1.add(l5);
p1.add(l6);

p2.add(t1);
p2.add(t2);
p2.add(t3);
p2.add(t4);
p2.add(t5);
p2.add(t6);

p3.add(c);
p3.add(b);
p3.add(b1);
p3.add(b2);

b.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hera","root","abhishek");
String s="insert into mok(mname,mid,cname,chin,ph,email) values(?,?,?,?,?,?)";
PreparedStatement st = con.prepareStatement(s);
st.setString(1,t1.getText());
st.setString(2,t2.getText());
st.setString(3,t3.getText());
st.setString(4,t4.getText());
st.setInt(5,Integer.parseInt(t5.getText()));
st.setString(6,t6.getText());
st.executeUpdate();
con.close();
Book d=new Book();
f.dispose();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
});

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
f.dispose();
}
});

b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
DT q=new DT();
}
});

f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e1)
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
Member k=new Member();
}
}