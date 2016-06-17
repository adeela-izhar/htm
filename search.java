import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


  public class search implements ActionListener,ItemListener
  {

   JFrame f9;
   JButton b1;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
   JComboBox cb;

   String fname="",lname="",name="";
  
   search()
   {
    f9=new JFrame("Customer details");
    f9.setSize(800,700);
    f9.setLocation(400,100); 
    f9.setLayout(null);
    f9.setResizable(false); 

   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f9.add(l);

  
   l1=new JLabel("Father's name");
   l.add(l1);
   l1.setBounds(250,30,100,30);

   cb=new JComboBox();
   cb.setBounds(400,30,150,25); 
   l.add(cb);

  
   l2=new JLabel("Mobile No.");
   l.add(l2);
   l2.setBounds(250,80,100,30);

   t2=new JTextField();
   t2.setBounds(400,80,150,30);
   l.add(t2);


   l3=new JLabel("Address");
   l.add(l3);
   l3.setBounds(250,130,100,30);

   t3=new JTextField();
   t3.setBounds(400,130,150,30);
   l.add(t3);


   l4=new JLabel("City");
   l.add(l4);
   l4.setBounds(250,180,100,30);

   t4=new JTextField();
   t4.setBounds(400,180,150,30);
   l.add(t4);


   l5=new JLabel("State/Country");
   l.add(l5);
   l5.setBounds(250,230,100,30);

   t5=new JTextField();
   t5.setBounds(400,230,150,30);
   l.add(t5);


   l6=new JLabel("Arrival Date");
   l.add(l6);
   l6.setBounds(250,280,100,30);

   t6=new JTextField();
   t6.setBounds(400,280,150,30);
   l.add(t6);


   l12=new JLabel("Arrival time");
   l.add(l12);
   l12.setBounds(250,330,100,30);
   
   t12=new JTextField();
   l.add(t12);
   t12.setBounds(400,330,150,30);


   l7=new JLabel("Departure date");
   l.add(l7);
   l7.setBounds(250,380,130,30);

   t7=new JTextField();
   t7.setBounds(400,380,150,30);
   l.add(t7);


   l8=new JLabel("Id no.");
   l.add(l8);
   l8.setBounds(250,430,100,30);
 
   t8=new JTextField();
   t8.setBounds(400,430,150,30);
   l.add(t8);


   l9=new JLabel("Room no.");
   l.add(l9);
   l9.setBounds(250,480,120,30);

   t9=new JTextField();
   t9.setBounds(400,480,150,30);
   l.add(t9);


   l10=new JLabel("No. of persons alongwith");
   l.add(l10);
   l10.setBounds(250,530,100,30);

   t10=new JTextField();
   t10.setBounds(400,530,150,30);
   l.add(t10);

   b1=new JButton("Back");
   b1.setBounds(380,600,100,30);
   l.add(b1);
   
   
   b1.addActionListener(this);
   
   cb.addItemListener(this);

   try
     {
    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 Statement stat=con.createStatement();
         ResultSet rs=stat.executeQuery("select * from customer");
	 

	while(rs.next())
	{
	  fname=rs.getString("firstname");
	  lname=rs.getString("lasttname");
	  name=fname+" "+lname;
	  cb.addItem(name);	
	}

	rs.close();  
    		 
      	} //try close

	catch(Exception e)
	{
	}

   f9.setVisible(true);


   }// constructor ends


	String cbitem="",arrdate="";
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

		ResultSet rt=stat.executeQuery("select  * from customer where firstname like '"+cbitem+"%'");
		while(rt.next())
		{
		
		 arrdate=rt.getString("arrdate");
		

		}
		
		
		t3.setText(arrdate);
		
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
        f9.setVisible(false);  
	login l=new login();
    }
   }



  public static void main(String[] arg)
 {
	new search();

}
}