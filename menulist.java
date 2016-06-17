import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class menulist implements ActionListener
{
  JFrame f6;
  JButton b; 
  JLabel l;
  menulist(String food)
 {
  f6=new JFrame("Menu Details");
   
   b=new JButton("Back");
   b.setBounds(350,500,100,30);
   f6.add(b);
 try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("jdbc:odbc:a","sa","niit");
  Statement stat=con.createStatement();
  ResultSet rs=stat.executeQuery("select * from menu where category='"+food+"'");
  int ctr=0;

  while(rs.next())
  {
    ctr++;
 }

 rs.close();

 String data[][]=new String[ctr][4];

	int i=0;

 ResultSet rs1=stat.executeQuery("select * from menu where category='"+food+"'");
 while(rs1.next())
	{
 		data[i][0]=rs1.getString("fooditem");
		data[i][1]=rs1.getString("qty");
		data[i][2]=rs1.getString("price");
		data[i][3]=rs1.getString("veg_nonveg");
		i++;
	}
	
 rs1.close();


  String column[]={"Food item","Quantity","Price","Veg. / Non-veg."};
  
  JTable jt=new JTable(data,column);
  jt.setBounds(40,40,200,300);
  
  JScrollPane sp=new JScrollPane(jt);		//container for JTable
  
  f6.add(sp);

 }catch(Exception e)
{
}
   
   b.addActionListener(this);

   f6.setLocation(400,100);
   f6.setSize(800,700);
   f6.setVisible(true);
   f6.setLayout(null);
  // f6.setResizable(false);

} //constructor ends




  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b)
     {
	f6.setVisible(false);
	new menu();
      }
   }
  public static void main(String[] arg)
  {
     
   }
}