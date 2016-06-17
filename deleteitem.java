import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class deleteitem implements ActionListener,ItemListener

{
   JFrame f8;
   JButton b1,b2;
   JLabel l1,l2,l;
   JComboBox cb1,cb2;
  String cbitem="";

  deleteitem()
   {
    f8=new JFrame("DeleteFood Item");
    f8.setSize(800,700);
    f8.setLocation(400,100); 
    f8.setLayout(null);
    f8.setResizable(false); 

   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f8.add(l);

  
   l1=new JLabel("Category");
   l.add(l1);
   l1.setBounds(250,220,100,30);

   cb1=new JComboBox();
   cb1.setBounds(400,220,150,25); 
   l.add(cb1);

  
   l2=new JLabel("Food Item");
   l.add(l2);
   l2.setBounds(250,280,100,30);

   cb2=new JComboBox();
   cb2.setBounds(400,280,150,25); 
   l.add(cb2);

   
   b1=new JButton("Delete item");
   b1.setBounds(280,500,100,30);
   l.add(b1);
   
   
   b2=new JButton("Back");
   b2.setBounds(430,500,100,30);  
   l.add(b2);

   b1.addActionListener(this);
   b2.addActionListener(this);
   cb1.addItemListener(this);
   cb2.addItemListener(this);
   cb1.addItem("");	
  try
	{
    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 Statement stat=con.createStatement();
         ResultSet rs=stat.executeQuery("select distinct category from menu");
	  String cat="";

	while(rs.next())
	{
	  cat=rs.getString("category");
	  cb1.addItem(cat);	
	}

	rs.close();  
 		 
      	} //try close

	catch(Exception e)
	{
	}

   f8.setVisible(true);


   }// constructor ends


	String food="";
	public void itemStateChanged(ItemEvent ie)
	{	
	  if(ie.getSource()==cb1)
	   {	
		cbitem=(String)ie.getItem();	
	    	 try
	      {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
		 Statement stat=con.createStatement();
	     
		ResultSet rt=stat.executeQuery("select fooditem from menu where category='"+cbitem+"'");
		while(rt.next())
		{
		  food=rt.getString("fooditem");
		  cb2.addItem(food);
		}
		  rt.close();
              }
		catch(Exception e)
		{
		  System.out.println(e);
		}

	   }

	if(ie.getSource()==cb2)
	{
		food=(String)ie.getItem();
	}

	}	//itemlistener ends






  public void actionPerformed(ActionEvent ae)
  {

    if(ae.getSource()==b1)
    {   

	try
	{
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
		 Statement stat=con.createStatement();
	        
		 stat.executeUpdate("Delete menu where fooditem='"+food+"'");
		
		 JOptionPane.showMessageDialog(null,"Item deleted");
          }
	catch(Exception e)
	{
	  System.out.println(e);	  
	}

    } // if button1

  
  //FOR back BUTTON

   if(ae.getSource()==b2)
    {
        f8 .setVisible(false);  
	new editmenu();
    }
   }


  public static void main(String[] arg)
   {
   }
  }