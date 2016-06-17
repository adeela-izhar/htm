import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class bill implements ActionListener,ItemListener

{
   JFrame f8;
   JButton b1,b2;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
   JComboBox cb;
  
   bill()
   {
    f8=new JFrame("Bill Statement");
    f8.setSize(800,700);
    f8.setLocation(400,100); 
    f8.setLayout(null);
    f8.setResizable(false); 

   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f8.add(l);

  
   l1=new JLabel("Room no.");
   l.add(l1);
   l1.setBounds(250,30,100,30);

   cb=new JComboBox();
   cb.setBounds(400,30,150,25); 
   l.add(cb);

  
   l2=new JLabel("Guest Name");
   l.add(l2);
   l2.setBounds(250,80,100,30);

   t2=new JTextField();
   t2.setBounds(400,80,150,30);
   l.add(t2);


   l3=new JLabel("Check-in Date");
   l.add(l3);
   l3.setBounds(250,130,100,30);

   t3=new JTextField();
   t3.setBounds(400,130,150,30);
   l.add(t3);


   l4=new JLabel("Check-out Date");
   l.add(l4);
   l4.setBounds(250,180,100,30);

   t4=new JTextField();
   t4.setBounds(400,180,150,30);
   l.add(t4);


   l5=new JLabel("Room Rent");
   l.add(l5);
   l5.setBounds(250,230,100,30);

   t5=new JTextField();
   t5.setBounds(400,230,150,30);
   l.add(t5);


   l6=new JLabel("Food Charges");
   l.add(l6);
   l6.setBounds(250,280,100,30);

   t6=new JTextField();
   t6.setBounds(400,280,150,30);
   l.add(t6);


   l12=new JLabel("Taxi charges");
   l.add(l12);
   l12.setBounds(250,330,100,30);
   
   t12=new JTextField();
   l.add(t12);
   t12.setBounds(400,330,150,30);


   l7=new JLabel("Other charges (if any)");
   l.add(l7);
   l7.setBounds(250,380,130,30);

   t7=new JTextField();
   t7.setBounds(400,380,150,30);
   l.add(t7);


   l8=new JLabel("Subtotal");
   l.add(l8);
   l8.setBounds(250,430,100,30);
 
   t8=new JTextField();
   t8.setBounds(400,430,150,30);
   l.add(t8);


   l9=new JLabel("Service Tax(14.0%)");
   l.add(l9);
   l9.setBounds(250,480,120,30);

   t9=new JTextField();
   t9.setBounds(400,480,150,30);
   l.add(t9);


   l10=new JLabel("Total");
   l.add(l10);
   l10.setBounds(250,530,100,30);

   t10=new JTextField();
   t10.setBounds(400,530,150,30);
   l.add(t10);

   b1=new JButton("Get total");
   b1.setBounds(280,600,100,30);
   l.add(b1);
   
   
   b2=new JButton("Back");
   b2.setBounds(430,600,100,30);  
   l.add(b2);

   b1.addActionListener(this);
   b2.addActionListener(this);
   cb.addItemListener(this);

  try
	{
    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 Statement stat=con.createStatement();
         ResultSet rs=stat.executeQuery("select roomno from room where roomstate='locked'");
	  String rno="";

	while(rs.next())
	{
	  rno=rs.getString("roomno");
	  cb.addItem(rno);	
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
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 	Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 	Statement stat=con.createStatement();

		 String guestname="";
		 String fname="",lname="",arrdate="";
		 String food="",taxi="";

		ResultSet rt=stat.executeQuery("select  * from customer where roomno='"+cbitem+"'");
		while(rt.next())
		{
		 fname=rt.getString("firstname");
		 lname=rt.getString("lastname");
		 arrdate=rt.getString("arrdate");
		 food=rt.getString("foodcharges");
		 taxi=rt.getString("taxicharges");

		}
		
		guestname=fname+" "+lname;
		t2.setText(guestname);
		t3.setText(arrdate);
		t6.setText(food);
		t12.setText(taxi);
		rt.close();

              }
		catch(Exception e)
		{
		  
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

		 String food="",taxi="";

		ResultSet rt=stat.executeQuery("select  * from customer where roomno='"+cbitem+"'");
		while(rt.next())
		{
		 food=rt.getString("foodcharges");
		 taxi=rt.getString("taxicharges");

		}
		
		t6.setText(food);
		t12.setText(taxi);
		rt.close();


	String roomrent="4000";

	Double subtotal,total,servicetax;
	Double fd=Double.parseDouble(food);
	Double txi=Double.parseDouble(taxi);
	Double rr=Double.parseDouble(roomrent);
	Double others=Double.parseDouble(t7.getText());

	subtotal=rr+fd+txi+others;
	t8.setText(subtotal.toString());

	Double f=0.14;
	servicetax=f*subtotal;
	t9.setText(servicetax.toString());

	total=subtotal+servicetax;
	t10.setText(total.toString());

              }
		catch(Exception e)
		{
		  
		}

 	


    } // if button1

  
  //FOR EXIT BUTTON

   if(ae.getSource()==b2)
    {
        f8 .setVisible(false);  
	login l=new login();
    }
   }


public static void main(String[] arg)
{
  new bill();
}
}