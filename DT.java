import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

class DT
{
JFrame f;
TextArea ta;
JButton t1,t2;
Label l1,l2;
int mc;
String mn,mi,mk,mv,mb,da,db,dc,dd,de,df,dg;
DT()
{
try
{
f=new JFrame("MD");
f.setSize(1500,1000);
f.setVisible(true);
f.setLocationRelativeTo(null);
f.setLayout(null);

l1=new Label("Member detail");
l1.setBounds(30, 30, 250, 40);
l1.setFont(new Font("sherif",1,35));

t1=new JButton("CLICK");
t1.setBounds(360, 30, 230, 40);
t1.setFont(new Font("sherif",1,35));

l2=new Label("Book detail");
l2.setBounds(860, 30, 250, 40);
l2.setFont(new Font("sherif",1,35));

t2=new JButton("CLICK");
t2.setBounds(1110, 30, 230, 40);
t2.setFont(new Font("sherif",1,35));

ta=new TextArea();
ta.setBounds(0, 100, 1500, 900);
ta.setFont(new Font("sherif",1,20));

f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(ta);

t1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
try
{
ta.setText("");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hera","root","abhishek");
String s="select * from mok";
PreparedStatement pt = con.prepareStatement(s);
ResultSet rs=pt.executeQuery();
while(rs.next())
{
mn=rs.getString(1);
mi=rs.getString(2);
mk=rs.getString(3);
mv=rs.getString(4);
mc=rs.getInt(5);
mb=rs.getString(6);
ta.append(mn+"    "+mi+"    "+mk+"    "+mv+"    "+mc+"    "+mb+"    "+"\n"+"\n");
}
con.close();
rs.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

}
});

t2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1)
{
try
{
ta.setText("");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hera","root","abhishek");
String s="select * from kok";
PreparedStatement pt = con.prepareStatement(s);
ResultSet rs=pt.executeQuery();
while(rs.next())
{
da=rs.getString(1);
db=rs.getString(2);
dc=rs.getString(3);
dd=rs.getString(4);
de=rs.getString(5);
df=rs.getString(6);
dg=rs.getString(7);
ta.append(da+"    "+db+"    "+dc+"    "+dd+"    "+de+"    "+df+"    "+dg+"\n"+"\n");
}
con.close();
rs.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

}
});

f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e2)
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
DT v=new DT();
}
}