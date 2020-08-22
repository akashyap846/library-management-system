import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Log 
{
JFrame f,f1;
JButton b;
TextField t1,t2,ta;
Label l1,l2;
Log()
{
f=new JFrame("login");
b=new JButton("login");
l1=new Label("user ID");
l1.setFont(new Font("Serif", Font.BOLD, 25));
l2=new Label("password");
l2.setFont(new Font("Serif", Font.BOLD, 25));
t1=new TextField();
t1.setFont(new Font("Serif", Font.BOLD, 25));
t2=new TextField();
t2.setFont(new Font("Serif", Font.BOLD, 25));
l1.setBounds(50,50,200,40);
l2.setBounds(50,100,200,40);
t1.setBounds(250,50,250,40);
t2.setBounds(250,100,250,40);
b.setBounds(300,150,70,50);
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(b);
t2.setEchoChar('*');
try
{
b.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
String s1="demo";
String s2="12345678";
String user = t1.getText();
String pass = t2.getText();
if(user.equals(s1) && pass.equals(s2))
{
Member m=new Member();
f.dispose();
}
else
{
ImageIcon i=new ImageIcon("oops.jpg");
JOptionPane.showMessageDialog(null,"incorrect password","try again",JOptionPane.INFORMATION_MESSAGE,i);
t1.setText("");
t2.setText("");
}
}
});
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
f.dispose();
}
});
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
f.setLayout(null);
f.setVisible(true);
f.setSize(700,300);
f.setLocationRelativeTo(null);
}
public static void main(String ar[])
{
Log a=new Log();
}
}