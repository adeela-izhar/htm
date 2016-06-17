import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class updateitem implements ActionListener,ItemListener,KeyListener

{
   JFrame f8;
   JButton b1,b2;
   JLabel l1,l2,l3,l4,l5,l;
   JTextField t1,t2,t3,t4,t5;
   JComboBox cb1,cb2;
   String food="";

  updateitem()
   {
    f8=new JFrame("Update Food Item");
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
   l1.setBounds(250,120,100,30);

   cb1=new JComboBox();
   cb1.setBounds(400,120,150,25); 
   l.add(cb1);
   cb1.addItem("");
  
   l2=new JLabel("Food Item");
   l.add(l2);
   l2.setBounds(250,180,100,30);


   cb2=new JComboBox();
   cb2.setBounds(400,180,150,25); 
   l.add(cb2);
   

   l3=new JLabel("Quantity");
   l.add(l3);
   l3.setBounds(250,240,100,30);

   t3=new JTextField();
   t3.setBounds(400,240,150,30);
   l.add(t3);


   l4=new JLabel("Old Price");
   l.add(l4);
   l4.setBounds(250,320,100,30);

   t4=new JTextField();
   t4.setBounds(400,320,150,30);
   l.add(t4);


   l5=new JLabel("New Price");
   l.add(l5);
   l5.setBounds(250,380,100,30);

   t5=new JTextField();
   t5.setBounds(400,380,150,30);
   l.add(t5);


   
   b1=new JButton("Update item");
   b1.setBounds(270,500,110,30);
   l.add(b1);
   
   
   b2=new JButton("Back");
   b2.setBounds(430,500,100,30);  
   l.add(b2);

   b1.addActionListener(this);
   b2.addActionListener(this);
   cb1.addItemListener(this);
   cb2.addItemListener(this);
   t5.addKeyListener(this);

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


	String cbitem="";
	public void itemStateChanged(ItemEvent ie)
	{
  	  if(ie.getSource()==cb1)
	    {
	      try
	      {
		cbitem=(String)ie.getItem();
 
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
		try
		{
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
		 Statement stat=con.createStatement();
	     
		ResultSet rt=stat.executeQuery("select qty,price from menu where fooditem='"+food+"'");
		 while(rt.next())
		   {
	 		t3.setText(rt.getString("qty"));
			t4.setText(rt.getString("price"));
	           }
		}
		catch(Exception e)
		{
		  System.out.println(e);
		}

	}

	}	//itemlistener ends


	public void keyReleased(KeyEvent EVT)
	{
	}

	public void keyTyped(KeyEvent EVT)
	{
	}


	public void keyPressed(KeyEvent EVT)
	{

  	   if((EVT.getSource()==t5))
   	    {
		JTextField t=(JTextField)EVT.getSource();
 		String value=t.getText();
 		if((EVT.getKeyChar()>='0')&&(EVT.getKeyChar()<='9')||(EVT.getKeyChar()=='.'))
  		{
	  	  t.setEditable(true); 
		}
   	  	 else
  	   	{
	           t.setEditable(false);
       	           String s=t.getText();
		   JOptionPane.showMessageDialog(null,"Only number allowed");
		   t.setEditable(true);
		   t.setText(s);
   	        }
	  
	    }
       }
	



  public void actionPerformed(ActionEvent ae)
  {

    if(ae.getSource()==b1)
    {   

	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 	Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 	Statement stat=con.createStatement();
		 
		 Float price=Float.parseFloat(t5.getText());

		stat.executeUpdate("update menu set price='"+price+"' where fooditem='"+food+"'");		      		 
  		JOptionPane.showMessageDialog(null,"Item updated");
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