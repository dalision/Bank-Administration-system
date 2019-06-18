package contentcl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
本类实现 对取钱操作的实现， 主要思路 实现对用户金额的修改
 但在输入金额是 要判断 金额的大小 是否能够取出  且不能出现负数
 * 

 *
 */
public class DrawMoney extends JFrame implements ActionListener{
	String countname;
	JButton jb1, jb2, jb3;  //��ť
	JLabel jlb1, jlb2, jlb3; //��ǩ
	JTextArea jta1,jta2;
	
	public DrawMoney(String countname) {
		this.countname = countname;
		
		// TODO Auto-generated constructor stub
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		jlb1 = new JLabel("请输入取出金额：");  
		
	
		 jta1 = new JTextArea();
		 jta2 = new JTextArea();
		
		

        this.setTitle("取钱");
        this.setLayout(null);
        this.setSize(300, 300); 
        
  
        jlb1.setBounds(5, 20, 200, 20);
        jta1.setBounds(20, 50, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15));
        
     
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);
        
       
        jta2.setBounds(20, 160, 300, 50);
        jta2.setFont(new   java.awt.Font("Dialog",   1,   15));
        
        //添加
       this.add(jlb1);
       this.add(jta1);
       this.add(jb1);
       this.add(jb2);
       this.add(jta2);
       //屏幕布局 
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       this.setVisible(true);  
       this.setResizable(false);	
		
	}
	

		private void clear() 
		{
			
			jta1.setText("");   
	        jta2.setText("");  
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand()=="确定")
		{
			
			try {
				drawmoney();  
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand()=="重置")
		{
			clear();
		}
		
	}

	private void drawmoney() throws IOException {
		
		if (jta1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		else if(new Check().checkmoney(jta1.getText()))
		{
			String nowmoney = new UserMessage().updatemoney(countname,-Integer.parseInt(jta1.getText()));
			if (!nowmoney.equals("负数"))
			{
				jta2.setText("您的余额为:\n "+nowmoney);
			    jta1.setText("");
			}
			else 
			{JOptionPane.showMessageDialog(null, "余额不足请重新输入:","消息提示",JOptionPane.WARNING_MESSAGE);
			clear();
				
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "取钱金额不合法!","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	

}
