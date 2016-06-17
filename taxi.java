import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.*;

 public class taxi implements ActionListener,ItemListener
 {
   JFrame f7;
   JButton b1,b2;
   JLabel l1,l2,l3,l4,l5,l6,l,l7;
   JTextField t1,t2,t3,t4,t5,t7;
   JComboBox cb;
  
   taxi()
   {
    f7=new JFrame("Taxi Booking");
    f7.setSize(800,700);
    f7.setLocation(400,100); 
    f7.setLayout(null);
   
   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f7.add(l);



   l6=new JLabel("Room No.");
   l.add(l6);
   l6.setBounds(200,100,100,40);

   cb=new JComboBox();
   cb.setBounds(350,100,150,40); 
   l.add(cb);

   l5=new JLabel("Name");
   l.add(l5);
   l5.setBounds(200,170,100,40);

   t5=new JTextField();
   t5.setBounds(350,170,150,40);
   l.add(t5);

  
   l1=new JLabel("From");
   l.add(l1);
   l1.setBounds(200,240,100,40);

   t1=new JTextField();
   t1.setBounds(350,240,150,40);
   l.add(t1);

   l2=new JLabel("To");
   l.add(l2);
   l2.setBounds(200,310,100,40);

   t2=new JTextField();
   t2.setBounds(350,310,150,40);
   l.add(t2);

   
   l3=new JLabel("Date");
   l.add(l3);
   l3.setBounds(200,380,100,40);

   t3=new JTextField();
   t3.setBounds(350,380,150,40);
   l.add(t3);


   l4=new JLabel("Time");
   l.add(l4);
   l4.setBounds(200,450,100,40);

   t4=new JTextField();
   t4.setBounds(350,450,150,40);
   l.add(t4);

   l7=new JLabel("Fare");
   l.add(l7);
   l7.setBounds(200,520,100,40);

   t7=new JTextField();
   t7.setBounds(350,520,150,40);
   l.add(t7);

   b1=new JButton("Book");
   b1.setBounds(240,590,100,30);
   l.add(b1);

   b2=new JButton("Back");
   b2.setBounds(440,590,100,30);
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
	

     f7.setVisible(true);
     f7.setResizable(false);

     }  // constructor ends


	String cbitem="";

	public void itemStateChanged(ItemEvent ie)
	{
	      try
	      {
		cbitem=(String)ie.getItem();
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 	Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 	Statement stat=con.createStatement();

		 String first="";
		 String last="";
		 String name="";
		 
		ResultSet rt=stat.executeQuery("select firstname,lastname from customer where roomno='"+cbitem+"'");
		while(rt.next())
		{
		first=rt.getString("firstname");
		last=rt.getString("lastname");
		}

		name=first+" "+last;
		t5.setText(name);

	      	rt.close();
              }
 	catch(Exception e){}


 try
         {		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 	Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 	Statement stat=con.createStatement();
 
		ResultSet rp=stat.executeQuery("select taxicharges from customer where roomno='"+cbitem+"'");
		Double taxi;
		while(rp.next())
		{
		  taxi=Double.parseDouble(rp.getString("taxicharges"));
		}
 		Double fare=Double.parseDouble(t7.getText());
		stat.executeUpdate("update customer set taxicharges=(taxi+fare) where roomno='"+cbitem+"'");
	rp.close();
	 }
 		catch(Exception e)
		{
		 
		}


   }  // itemStateChanged() ends



  public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
    {    
 	try
	{

	  JOptionPane.showMessageDialog(null,"Taxi booked");
		
	 }//try close

	catch(Exception e)
	{
	}

    } // if button1

  
  //FOR EXIT BUTTON

   if(ae.getSource()==b2)
    {
        f7.setVisible(false);  
	login l=new login();
    }

 }//actionPerformed close 

   public static void main(String[] arg)
    {
	new taxi();
     }
 
 }