import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
 
class MyCompany extends JFrame implements ActionListener
{
    JLabel lblCompany,lblUser_Type,lblUser,lblPass;
    JComboBox CmbUser_Type;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin,btnCancel;
    String arr[]={"Admin","Manager","Employee"};
 
    public MyCompany()
    {
        super("Meeting Manager");
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
 
        this.setSize(730, 570);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        lblCompany=new JLabel("Meeting Manager");
        lblCompany.setFont(new Font("Times New Roman",Font.BOLD,30));
        lblCompany.setForeground(Color.black);
        lblUser_Type=new JLabel("UserType");
        lblUser=new JLabel("Username");
        lblPass=new JLabel("Password");
        txtUser=new JTextField();
        txtPass=new JPasswordField();
        CmbUser_Type=new JComboBox(arr);
        btnLogin=new JButton("Login");
        btnCancel=new JButton("Cancel");
 
        lblCompany.setBounds(240,100,2000,30);
        lblUser_Type.setBounds(240, 160, 140, 25);
        CmbUser_Type.setBounds(340,160,130,25);
        lblUser.setBounds(240,200,140,25);
        txtUser.setBounds(340,200,130,25);
        lblPass.setBounds(240,240,140,25);
        txtPass.setBounds(340,240,140,25);
        btnLogin.setBounds(240,280,100,30);
        btnCancel.setBounds(340,280,100,30);
 
        this.add(btnCancel);
        this.add(btnLogin);
        this.add(CmbUser_Type);
        this.add(lblCompany);
        this.add(lblPass);
        this.add(lblUser);
        this.add(txtUser);
        this.add(lblUser_Type);
        this.add(txtPass);
 
        btnCancel.addActionListener(this);
        btnLogin.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
  
}
 
public class LoginGUI {
 
    public static void main(String[] args)
    {
        MyCompany ob=new MyCompany();
        ob.setVisible(true);
    }
}