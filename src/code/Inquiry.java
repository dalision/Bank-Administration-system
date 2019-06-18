package contentcl;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Inquiry extends JFrame implements ActionListener{

	JLabel jlb1, jlb2, jlb3;  
	JTextField jtf1,jtf2,jtf3;   
	JPasswordField jpf; 
	JPanel jp1,jp2,jp3;		
	
	public Inquiry(String countname) throws IOException {

	//界面设计	
		jlb1 = new JLabel("姓名");
		jlb2 = new JLabel("账户号");
		jlb3 = new JLabel("金额");
		
		jtf1 = new JTextField(13);
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		jp3.add(jlb3);
		jp3.add(jtf3);
		

	    this.setTitle("查询");
	    this.setLayout(null);   
	    
	    jp1.setBounds(-10, 40, 300 ,50);   
	    jp2.setBounds(-10, 110, 300 ,50);
	    jp3.setBounds(-10, 180, 300 ,50);
	    

	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3); 
	    
	    this.setSize(300, 300);   
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
	        
	    this.setVisible(true);  
	    this.setResizable(false);	
	    //提取用户数据并加工
	    String []message = new UserMessage().read(countname);
	    
	    message[0] ="*"+message[0].substring(1,message[0].length());//隐去第一位
	
	    message[1] =message[1].substring(0,6)+"*******"+message[1].substring(13,message[1].length());
	    
	    
	    jtf1.setText(message[0]);
	    jtf2.setText(message[1]);
	    jtf3.setText(message[4]);
	    
	    
	    
	    
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
	
		
	}

}
