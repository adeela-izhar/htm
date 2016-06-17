import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

 public class login implements ActionListener
 {
   JFrame f2;
   JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
   JLabel l;

   login()
  {
    f2=new JFrame("Hotel Management System");
    f2.setSize(800,700);
    f2.setLocation(400,100); 
    f2.setVisible(true);
    f2.setLayout(null);
    f2.setResizable(false); 

   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f2.add(l);

   b1=new JButton("Reservation");
   b1.setBounds(200,220,150,30);
   l.add(b1);

   b2=new JButton("Menu");
   b2.setBounds(200,270,150,30);  
   l.add(b2);
   
   b3=new JButton("Taxi booking");
   b3.setBounds(200,320,150,30);
   l.add(b3);

   b4=new JButton("Search Customer");
   b4.setBounds(200,370,150,30);
   l.add(b4);

   b5=new JButton("Room details");
   b5.setBounds(450,220,150,30);
   l.add(b5);

   b6=new JButton("Order");
   b6.setBounds(450,270,150,30);
   l.add(b6);

   b7=new JButton("Bill");
   b7.setBounds(450,320,150,30);
   l.add(b7);

   b8=new JButton("Accomodation Details");
   b8.setBounds(450,370,150,30);
   l.add(b8);

   b9=new JButton("Edit Menu");
   b9.setBounds(200,420,150,30);
   l.add(b9);

   b10=new JButton("Log Out");
   b10.setBounds(450,420,150,30);
   l.add(b10);   

 
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
   b6.addActionListener(this);
   b7.addActionListener(this);
   b8.addActionListener(this);
   b9.addActionListener(this);
   b10.addActionListener(this); 
 }

  public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
    {
	f2.setVisible(false);
  	 new reserve();
     }

   if(ae.getSource()==b2)
    {
      f2.setVisible(false);  
	new menu();
    }
   
   if(ae.getSource()==b3)
    {
      f2.setVisible(false);  
	 new taxi();
	
    }

   if(ae.getSource()==b4)
    {
      f2.setVisible(false);  
//	new search();
    }

   if(ae.getSource()==b5)
    {
      f2.setVisible(false);  
	new room();
     
    }

   if(ae.getSource()==b6)
    {
      f2.setVisible(false); 
//	new order(); 
    }

   if(ae.getSource()==b7)
    {
      f2.setVisible(false);  
	new bill();
    }

   if(ae.getSource()==b8)
    {
      f2.setVisible(false); 
//	new details(); 
    }

   if(ae.getSource()==b9)
    {
      f2.setVisible(false); 
	new editmenu(); 
    }

   if(ae.getSource()==b10)
    {
      f2.setVisible(false); 
	new admin(); 
    }

  }

 
 public static void main(String[] arg)
  {
    
  }

}
 