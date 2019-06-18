package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Register extends JFrame implements ActionListener{
	
	JButton jb1, jb2;  
	JLabel jlb1, jlb2, jlb3,jlb4,jlb5, jlb6;  
	JTextField jtf1,jtf2,jtf3,jtf4, jtf5;  
	JPasswordField jpf; 
	JPanel jp1,jp2,jp3, jp4,jp5,jp6,jp7;		
	
	public Register() {
		
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		jlb1 = new JLabel("        姓名");
		jlb2 = new JLabel("身份证号");
		jlb3 = new JLabel("        账号");
		jlb4 = new JLabel("        密码");
		jlb6 = new JLabel("注册信息");
		jlb5 = new JLabel("开户金额");
		
		jlb6.setFont(new   java.awt.Font("Dialog",   1,   20));  
	
		jtf1 = new JTextField(13);
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		jtf4 = new JTextField(13);
		jtf5 = new JTextField(13);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jlb3);
		jp3.add(jtf3);
		
		jp4.add(jlb4);
		jp4.add(jtf4);
		
		jp5.add(jlb5);
		jp5.add(jtf5);
		
		jp6.add(jb1);
		jp6.add(jb2);
		
		jp7.add(jlb6);
		
		this.add(jp7);  
		
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3); 
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        
        
        this.setTitle("注册信息");
        this.setLayout(new GridLayout(7, 1));
        this.setSize(350, 350);   
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        
        this.setVisible(true); 
        this.setResizable(false);
		
	}
	
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand()=="确定")
		{
			try {
				register();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand()=="重置")
		{
			clear();
		}
		
	}
	
	public void register() throws IOException
	{
		
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty()||
				jtf3.getText().isEmpty()||jtf4.getText().isEmpty()||jtf5.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "信息不完整，请补全！","提示",JOptionPane.WARNING_MESSAGE);
		}
		
		else if (jtf2.getText().length()!=18)
		{
			JOptionPane.showMessageDialog(null, "身份证号不合法，请重新输入！","提示",JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!new Check().checkmoney(jtf5.getText()))
		{  
			JOptionPane.showMessageDialog(null, "存入金额不合法!","提示",JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!new Check().checkname(jtf1.getText()))
		{
			JOptionPane.showMessageDialog(null, "姓名不合法！","提示",JOptionPane.WARNING_MESSAGE);
		}
		
		else if (new Check().checkcountname(jtf3.getText())||new Check().checkcountname(jtf4.getText()))
		{
			JOptionPane.showMessageDialog(null, "用户名或密码存在中文，不合法!","提示",JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!jtf1.getText().isEmpty()&&!jtf2.getText().isEmpty()&&
				!jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty()&&!jtf5.getText().isEmpty())
		{
			
			String []message = new String[5]; 
			message[0] = jtf1.getText();  
			message[1] = jtf2.getText();
			message[2] = jtf3.getText();
			message[3] = jtf4.getText();
			message[4] = jtf5.getText();
			if (!new Check().check2(message[2]))   
			{
				new UserMessage().write(message);  
				JOptionPane.showMessageDialog(null,"注册成功！","消息",JOptionPane.WARNING_MESSAGE);
				dispose();  
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"账号已存在，请重新输入！","消息",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	
	private void clear() {
		
		jtf1.setText("");   
	    jtf2.setText("");
	    jtf3.setText("");  
	    jtf4.setText("");  
	    jtf5.setText("");  
			
	}
	

}
