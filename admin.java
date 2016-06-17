import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

 public class admin  implements ActionListener
 {
   JFrame f1;
   JButton b1;
   JButton b2;
   JLabel l1,l2,l;
   JPasswordField pw;
   JTextField t1;

   admin()
  {
    f1=new JFrame("Hotel Management System");
    
   ImageIcon i=new ImageIcon("C:\\Users\\Hp\\Desktop\\htm\\a7.jpg");
   l=new JLabel();
   l.setBounds(0,0,700,700);
   l.setIcon(i);
   f1.add(l);

   l1=new JLabel("User Id");
   l.add(l1);
   l1.setBounds(350,340,100,25);

   t1=new JTextField();
   t1.setBounds(450,340,130,25);
   l.add(t1);


   l2=new JLabel("Password");
   l.add(l2);
   l2.setBounds(350,370,100,25);

   pw=new JPasswordField();
   pw.setBounds(450,370,130,25);
   pw.setEchoChar('*');
   l.add(pw);


   b1=new JButton("Log In");
   b1.setBounds(370,420,100,30);
   l.add(b1);
   
   
   b2=new JButton("Exit");
   b2.setBounds(370,460,100,30);  
   l.add(b2);

    f1.setSize(600,550);
    f1.setLocation(500,200); 
    f1.setVisible(true);
  //  f1.setLayout(null);
    f1.setResizable(false);
 
   b1.addActionListener(this);
   b2.addActionListener(this);
 
  }

	

  public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
    {     
      try{

    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
	 Statement stat=con.createStatement();
         ResultSet rs=stat.executeQuery("select * from admin  ");
 	
	  String uid=t1.getText();
	  String pwd=new String(pw.getPassword());

	int ctr=0;
	while(rs.next())
	{
	   String s1=rs.getString("id");
	   String s2=rs.getString("password");

  		if(s1.equals(uid)&&s2.equals(pwd))
		{
	 		  ctr++; 
			  break;
		}
	}

	rs.close();
	if(ctr !=0)
	{
	  login lg=new login();
          f1.setVisible(false);
	}
	else
	{
	  JOptionPane.showMessageDialog(null,"Please check your user id and/or password");
	}
      		 
      	} //try close

	catch(Exception e)
	{
	}


   }  

//FOR EXIT BUTTON

   if(ae.getSource()==b2)
    {
      f1.setVisible(false);  
    }
  }

 
 public static void main(String[] arg)
  {
     admin ad=new admin();
  }

}
 