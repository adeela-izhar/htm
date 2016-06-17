import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.*;

 class reserve  implements ActionListener,KeyListener,ItemListener
 {
   JFrame f3;
   JButton b1,b2;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,tt;
   JComboBox cb;
  
  reserve()
  {
    f3=new JFrame("Reservation");
    f3.setSize(800,700);
    f3.setLocation(400,100); 
    f3.setLayout(null);
    f3.setResizable(false); 

   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\b3.jpg");
   l=new JLabel();
   l.setBounds(0,0,800,700);
   l.setIcon(i);
   f3.add(l);

  
   l1=new JLabel("First Name");
   l.add(l1);
   l1.setBounds(100,100,100,30);

   t1=new JTextField();
   t1.setBounds(200,100,150,30);
   l.add(t1);

  
   l2=new JLabel("Last Name");
   l.add(l2);
   l2.setBounds(450,100,100,30);

   t2=new JTextField();
   t2.setBounds(550,100,150,30);
   l.add(t2);


   l3=new JLabel("Father's Name");
   l.add(l3);
   l3.setBounds(100,160,100,30);

   t3=new JTextField();
   t3.setBounds(200,160,150,30);
   l.add(t3);


   l4=new JLabel("Mobile no.");
   l.add(l4);
   l4.setBounds(450,160,100,30);

   t4=new JTextField();
   t4.setBounds(550,160,150,30);
   l.add(t4);


   l5=new JLabel("Address");
   l.add(l5);
   l5.setBounds(100,220,100,30);

   t5=new JTextField();
   t5.setBounds(200,220,150,30);
   l.add(t5);


   l6=new JLabel("City");
   l.add(l6);
   l6.setBounds(450,220,100,30);

   t6=new JTextField();
   t6.setBounds(550,220,150,30);
   l.add(t6);


   l12=new JLabel("State/Country");
   l.add(l12);
   l12.setBounds(100,280,100,30);
   
   t12=new JTextField();
   l.add(t12);
   t12.setBounds(200,280,150,30);


   l7=new JLabel("No. of persons");
   l.add(l7);
   l7.setBounds(450,280,100,30);

   t7=new JTextField();
   t7.setBounds(550,280,150,30);
   l.add(t7);


   l8=new JLabel("Date of arrival");
   l.add(l8);
   l8.setBounds(100,340,100,30);
 
   t8=new JTextField();
   t8.setBounds(200,340,150,30);
   l.add(t8);


   l9=new JLabel("Time of arrival");
   l.add(l9);
   l9.setBounds(450,340,100,30);

   t9=new JTextField();
   t9.setBounds(550,340,150,30);
   l.add(t9);


   l10=new JLabel("No.of days");
   l.add(l10);
   l10.setBounds(100,400,100,30);

   t10=new JTextField();
   t10.setBounds(200,400,150,30);
   l.add(t10);


   l11=new JLabel("Id no.");
   l.add(l11);
   l11.setBounds(450,400,100,30);

   t11=new JTextField();
   t11.setBounds(550,400,150,30);
   l.add(t11);

   
   b1=new JButton("Reserve");
   b1.setBounds(350,500,100,30);
   l.add(b1);
   
   
   b2=new JButton("Back");
   b2.setBounds(350,550,100,30);  
   l.add(b2);

   cb=new JComboBox();
   cb.setBounds(280,30,100,25); 
   l.add(cb);
 
    tt=new JTextField();
    l.add(tt);
    tt.setBounds(430,30,100,25);

    f3.setVisible(true);


   b1.addActionListener(this);
   b2.addActionListener(this);
   cb.addItemListener(this);
   t4.addKeyListener(this);
   t7.addKeyListener(this);
   t10.addKeyListener(this);
 
  try
	{
    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 Statement stat=con.createStatement();
         ResultSet rs=stat.executeQuery("select roomno from room where roomstate='unlocked'");
	  
	  String rno="";
          cb.addItem(rno);

	while(rs.next())
	{
	  rno=rs.getString("roomno");
	  cb.addItem(rno);	
	}

	rs.close();  
    		 
      	} //try close

	catch(Exception e)
	{System.out.println(e);
	}
	


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

		 String rtype="";
		ResultSet rt=stat.executeQuery("select class from room where roomno='"+cbitem+"'");
		while(rt.next())
		{
		rtype=rt.getString("class");
		}
		tt.setText(rtype);
		rt.close();
              }
		catch(Exception e)
		{
		  System.out.println(e);
		}
	}	


  	public void keyReleased(KeyEvent EVT)
	{
	}

	public void keyTyped(KeyEvent EVT)
	{
	}


	public void keyPressed(KeyEvent EVT)
	{

  	   if((EVT.getSource()==t4)||(EVT.getSource()==t10)||(EVT.getSource()==t7))
   	    {
		JTextField t=(JTextField)EVT.getSource();
 		String value=t.getText();
 		if((EVT.getKeyChar()>='0')&&(EVT.getKeyChar()<='9'))
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
        String fname=t1.getText();
	String lname=t2.getText();
	String father=t3.getText();
	String mob=t4.getText();
	String address=t5.getText();
	String city=t6.getText();
	String state=t7.getText();
	String date=t8.getText();
	String time=t9.getText();
	String persons=t10.getText();
	String idno=t11.getText();System.out.println(idno);
	int num=Integer.parseInt(persons);
	int rn=Integer.parseInt(cbitem);
	
 	try
	{
		System.out.println("in try 2");

    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 Statement stat=con.createStatement();

	System.out.println("stat");

         stat.executeUpdate("insert into customer (firstname,lastname,fathersname,mobileno,addrss,city,state,arrdate,arrtime,persons,id_no,roomno) values('"+fname+"','"+lname+"','"+father+"','"+mob+"','"+address+"','"+city+"','"+state+"','"+date+"','"+time+"','"+num+"','"+idno+"','"+rn+"')");

	System.out.println("details entered");

        stat.executeUpdate("update room set roomstate='locked' where roomno='"+rn+"'");
	
	System.out.println("updated");

	  JOptionPane.showMessageDialog(null,"Room reserved");
		System.out.println("msg reserved");
	 }//try close

	catch(Exception e)
	{
	    System.out.println(e);
	}

    } // if button1

  
  //FOR EXIT BUTTON

   if(ae.getSource()==b2)	
    {
        f3.setVisible(false);  
	login l=new login();
    }

 }//actionPerformed close 


 public static void main(String[] arg)
  {
   new reserve();
  }

}
 