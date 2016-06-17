import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class menu implements ActionListener,ItemListener
{
  JFrame f5;
  JButton b,b1; 
  JComboBox cb;
  JLabel l;
  menu()
 {
   f5=new JFrame("Menu");
   f5.setLocation(400,100);
   f5.setSize(800,700);
   f5.setLayout(null);

  ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f5.add(l);
   
   b=new JButton("Back");
   b.setBounds(340,400,100,30);
   l.add(b);

   b1=new JButton("Go");
   b1.setBounds(340,330,100,30);
   l.add(b1);

   String cat[]={"","Breakfast","Beverages","Lunch","Snacks","Dinner","Dessert"};
   cb=new JComboBox(cat);
   cb.setBounds(340,250,100,25);
   l.add(cb);

   b.addActionListener(this);
   b1.addActionListener(this);
   cb.addItemListener(this);

   f5.setVisible(true);
   f5.setResizable(false);
  
 
 }//constructor ends

   String food="";

  public void itemStateChanged(ItemEvent ie)
  {
  food=(String)ie.getItem();
  }



  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b)
     {
	f5.setVisible(false);
	new login();
      }

    if(ae.getSource()==b1)
     {
	f5.setVisible(false);
	new menulist(food);
     }

   }

  public static void main(String[] arg)
   {
    
   }
}