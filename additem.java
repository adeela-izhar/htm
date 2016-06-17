import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class additem implements ActionListener,ItemListener,KeyListener

{
   JFrame f8;
   JButton b1,b2;
   JLabel l1,l2,l3,l4,l5,l;
   JTextField t1,t2,t3,t4,t5;
   JComboBox cb;
  
  additem()
   {
    f8=new JFrame("Add Food Item");
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

   cb=new JComboBox();
   cb.setBounds(400,120,150,25); 
   l.add(cb);

  
   l2=new JLabel("Food Item");
   l.add(l2);
   l2.setBounds(250,180,100,30);

   t2=new JTextField();
   t2.setBounds(400,180,150,30);
   l.add(t2);


   l3=new JLabel("Quantity");
   l.add(l3);
   l3.setBounds(250,240,100,30);

   t3=new JTextField();
   t3.setBounds(400,240,150,30);
   l.add(t3);


   l4=new JLabel("Price");
   l.add(l4);
   l4.setBounds(250,320,100,30);

   t4=new JTextField();
   t4.setBounds(400,320,150,30);
   l.add(t4);


   l5=new JLabel("Veg. / Non-veg.");
   l.add(l5);
   l5.setBounds(250,380,100,30);

   t5=new JTextField();
   t5.setBounds(400,380,150,30);
   l.add(t5);


   
   b1=new JButton("Add item");
   b1.setBounds(280,500,100,30);
   l.add(b1);
   
   
   b2=new JButton("Back");
   b2.setBounds(430,500,100,30);  
   l.add(b2);

   b1.addActionListener(this);
   b2.addActionListener(this);
   cb.addItemListener(this);
   t4.addKeyListener(this);


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
	  cb.addItem(cat);	
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
	      try
	      {
		cbitem=(String)ie.getItem();
              }
		catch(Exception e)
		{
		  System.out.println(e);

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

  	   if((EVT.getSource()==t4))
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
		 
		 String food=t2.getText();
		 String qty=t3.getText();
		 Float price=Float.parseFloat(t4.getText());
		 String veg=t5.getText();

		stat.executeUpdate("insert into menu values('"+food+"','"+cbitem+"','"+qty+"','"+price+"','"+veg+"')");
		      		 
  		JOptionPane.showMessageDialog(null,"Item added");
		

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