import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class room implements ActionListener
{
  JFrame f4;
  JButton b; 
  
  room()
  {
    f4=new JFrame("Rooms Details");
    //f4.setLayout(null);
    b=new JButton("Back");
    b.setBounds(350,500,100,30);
    f4.add(b);
  
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
   Statement stat=con.createStatement();
   ResultSet rs=stat.executeQuery("select * from room ");
   int ctr=0;

   while(rs.next())
   {
     ctr++;
   }

  rs.close();

   String data[][]=new String[ctr][4];

	int i=0;
 
   ResultSet rs1=stat.executeQuery("select * from room");
   while(rs1.next())
	{
 		data[i][0]=rs1.getString("roomno");
		data[i][1]=rs1.getString("class");
 		data[i][2]=rs1.getString("price");
 		data[i][3]=rs1.getString("roomstate");

	    i++;
	}
	
 rs1.close();


  String column[]={"Roomno","Type","Price","State"};
  
 JTable jt=new JTable(data,column);
  jt.setBounds(40,40,200,300);
  
 JScrollPane sp=new JScrollPane(jt);		//container for JTable
  
  f4.add(sp);

 }catch(Exception e)
{
}
   
   b.addActionListener(this);

   f4.setLocation(400,100);
   f4.setSize(800,700);
   f4.setVisible(true);
   f4.setResizable(false);

 } //constructor ends




  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b)
     {
	f4.setVisible(false);
	new login();
      }
   }
  public static void main(String[] arg)
  {
	// new room();
   }
}