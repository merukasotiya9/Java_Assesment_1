package com.Assesment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Jdbc implements ActionListener
{
	JFrame frame;
	JLabel l1,l2,l3,l4,l5 ,msg;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	
	public Jdbc()
	{
		frame=new JFrame("My Swing Example");
		frame.setLayout(new GridLayout(8 ,2));
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1=new JLabel("ID");
		l2=new JLabel("FIRST NAME");
		l3=new JLabel("LAST NAME");
		l4=new JLabel("EMAIL");
		l5=new JLabel("MOBILE");
		msg=new JLabel(" ");
		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		t4=new JTextField(15);
		t5=new JTextField(15);
		

		b1=new JButton("INSERT");
		b1.addActionListener(this);
		b2=new JButton("SEARCH");
		b2.addActionListener(this);
		b3=new JButton("UPDATE");
		b3.addActionListener(this);
		b4=new JButton("DELETE");
		b4.addActionListener(this);


		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l3);
		frame.add(t3);
		frame.add(l4);
		frame.add(t4);
		frame.add(l5);
		frame.add(t5);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(msg);
	
	}

	@Override
	public void actionPerformed(ActionEvent z) 
	{
		if(z.getSource()==b1)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root",""
						);
				System.out.println("Connection Established...");
				
				Statement st=cn.createStatement();
				
				int x=st.executeUpdate("Insert Into Student Values ('"+Integer.parseInt(t1.getText())+"','"+t2.getText()+"','"+t3.getText()+"','"
				+t4.getText()+"','"+t5.getText()+"')");
				if(x>0)
				{
					msg.setText("Record is Succesfully Inserted..");
				}
				else
				{
					msg.setText("Record is not Succesfully Inserted..");
				}
				cn.close();
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t4.setText(" ");
				t5.setText(" ");

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(z.getSource()==b2)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root",""
						);
				System.out.println("Connection Established...");
				
				Statement st=cn.createStatement();
				
				ResultSet rs=st.executeQuery("select * from student");

				while(rs.next())
				{
					System.out.println("ID IS :- "+rs.getString(1));
					System.out.println("FIRST NAME IS :- "+rs.getString(2));
					System.out.println("LAST NAME IS :- "+rs.getString(3));
					System.out.println("EMAIL IS :- "+rs.getString(4));
					System.out.println("MOBILE IS :- "+rs.getString(5));
				}
				
				cn.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
			
		else if(z.getSource()==b3)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root",""
						);
				System.out.println("Connection Established...");
				
				Statement st=cn.createStatement();
				
				int x = st.executeUpdate("Update Student set FIRST_NAME ='"+t2.getText()+"',LAST_NAME='"+t3.getText()+"',EMAIL='"+t4.getText()+"',MOBILE='"+t5.getText()+"' Where id='"+Integer.parseInt(t1.getText())+"'");

				if(x>0)
				{
					msg.setText("Record is Succesfully Updated..");
				}
				else
				{
					msg.setText("Record is not Succesfully Updated..");
				}
				cn.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(z.getSource()==b4)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
				
				System.out.println("Connection Established...");
				
				Statement st=cn.createStatement();
				
				int x = st.executeUpdate("Delete from Student Where id ="+Integer.parseInt(t1.getText()));

				if(x>0)
				{
					msg.setText("Record is Succesfully Deleted..");
				}
				else
				{
					msg.setText("Record is not Succesfully Deleted..");
				}
				cn.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
public class Assesment_Excersize 
{
	public static void main(String[] args) 
	{
		new Jdbc();
	}
}
