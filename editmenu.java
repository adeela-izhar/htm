import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


  public class editmenu implements ActionListener
  {


   JFrame f10;
   JButton b1,b2,b3,b4;   
   JLabel l;
   
   editmenu()
  {
    f10=new JFrame("Edit menu");
    
   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f10.add(l);

   b1=new JButton("Add item");
   b1.setBounds(320,200,100,30);
   l.add(b1);
   
   
   b2=new JButton("Update item");
   b2.setBounds(320,300,100,30);  
   l.add(b2);

   b3=new JButton("Delete item");
   b3.setBounds(320,400,100,30);  
   l.add(b3);

   b4=new JButton("Back");
   b4.setBounds(320,500,100,30);  
   l.add(b4);

    f10.setSize(800,700);
    f10.setLocation(400,100); 
    f10.setVisible(true);
  //  f10.setLayout(null);
    f10.setResizable(false);
 
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);

  } //constructor ends

	

  public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
    {     
      
	  new additem();
          f10.setVisible(false);
	}


    if(ae.getSource()==b2)
    {
	new updateitem();
      f10.setVisible(false);  
    }


    if(ae.getSource()==b3)
    {
	new deleteitem();
      f10.setVisible(false);  
    }

   if(ae.getSource()==b4)	//back button
    {
      f10.setVisible(false);  
	new login();
    }
  }
   public static void main(String[] arg)
   {
    }
}