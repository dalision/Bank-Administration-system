package contentcl;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Modify extends JFrame implements ActionListener{
	JButton jb1, jb2, jb3;  
	JPanel jp1,jp2,jp3, jp4;		
	JPasswordField jtf1,jtf2;   
	JLabel jlb1, jlb2, jlb3; 
	
	String name = "123";   
	String pwd = "123"; 
	String countname;
	
	public Modify(String countname) {
		this.countname = countname;
		// TODO Auto-generated constructor stub
		/*
		 * GUI设计
		 */
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();  
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("新密码"); 
		jlb2 = new JLabel("重置密码");
		
		jtf1 = new JPasswordField(10);	
		jtf2 = new JPasswordField(10);
		
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        
       
        this.setTitle("改密");
        this.setLayout(new GridLayout(3,1));  //利用网格布局
        this.setSize(300, 200);   
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        
        this.setVisible(true);  
        this.setResizable(false);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="确定")
		{
			
			try {
				modify();  
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}
		else if (e.getActionCommand()=="重置")
		{
			clear();}
		
	}

	private void modify() throws IOException {
		// TODO Auto-generated method stub
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty())  //�ж���Ϣ�Ƿ�Ϊ��
		{
			JOptionPane.showMessageDialog(null, "信息未填写完成！","消息提示",JOptionPane.WARNING_MESSAGE);
		}
		else if (jtf1.getText().equals(jtf2.getText()))
		{
			new UserMessage().updatepwd(countname, jtf1.getText());   //����UserMessage��updatepwd������������
			JOptionPane.showMessageDialog(null,  "修改成功！","消息提示",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null,  "2次密码不一致，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
			clear();
		}
		
	}

	private void clear() 
	{
		// TODO Auto-generated method stub
		jtf1.setText("");   
        jtf2.setText("");  
	}
	

}
