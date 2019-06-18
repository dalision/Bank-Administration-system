package contentcl;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * 
 * @author contentcl
 * Menu��һ�� �˵��࣬Ҳ����Ϊ�ײ��һ����
 * �ṩ�������ܵİ�ť
 * 
 * ����δʹ�ò��֣� ����ʹ������̶��˸�����ǩ�Ͱ�ť��λ��
 *
 */

public class Menu extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jb5,jb6,jb7, jb8; 
	JLabel jlb1, jlb2, jlb3;  
	public Menu() 
	{
		
		jb5 = new JButton("登录");
		jb6 = new JButton("开户");
		jb7 = new JButton("退卡");
		jb8 = new JButton("挂失");
		
		
		jlb1 = new JLabel("银行管理系统");
		jlb1.setFont(new   java.awt.Font("Dialog",   1,   23)); 
		jlb2 = new JLabel("欢迎您");
		jlb2.setFont(new   java.awt.Font("Dialog",   1,   20));
		jlb3 = new JLabel("请您选择服务");
		jlb3.setFont(new   java.awt.Font("Dialog",   1,   22));
		
		
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		jb8.addActionListener(this);
		
		this.setTitle("银行管理管理系统"); 
		this.setSize(450, 500); 		
		this.setLocation(400, 200);		
		this.setLayout(null);			
		
		

		jb8.setBounds(0,350,90,60);
		jb5.setBounds(0,250,90,60);
		jb6.setBounds( 354,250,90,60);
		jb7.setBounds(354,350,90,60);
		
	
		jlb1.setBounds(150,120,150,50);
		jlb2.setBounds(190,160,150,50);
		jlb3.setBounds(150,250,150,50);
		

		this.add(jb5);
		this.add(jb6);
		this.add(jb7);
		this.add(jb8);
		this.add(jlb1);
		this.add(jlb2);
		this.add(jlb3);
		
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
	    this.setVisible(true); 
	    this.setResizable(false);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		 if (e.getActionCommand()=="登录")
		{
			new Login(e.getActionCommand());
			dispose();
		}
		else if (e.getActionCommand()=="开户")
		{
			new Register(); 
		}
		else if (e.getActionCommand()=="挂失")
		{
			new ReportLose();  
		}
		else if (e.getActionCommand()=="退卡")
		{
			System.exit(0);
		}
		
		
	}

}
