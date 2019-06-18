package contentcl;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu2 extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jb1, jb2, jb3,jb4,jb5,jb8, jb6,jb7;
	JLabel jlb1, jlb2, jlb3;
	private String turn;  
	public Menu2(String countname) 
	{
		this.turn=countname; 
		jb1 = new JButton("查询");
        jb2 = new JButton("存款");
        jb3 = new JButton("取款");
        jb4 = new JButton("转账");
        jb5 = new JButton("改密");
        jb6 = new JButton("退卡");
        jb7 = new JButton("返回主菜单");
		
		
		jlb1 = new JLabel("银行管理系统");
		jlb1.setFont(new   java.awt.Font("Dialog",   1,   23)); 
		jlb2 = new JLabel("欢迎您");
		jlb2.setFont(new   java.awt.Font("Dialog",   1,   20));
		jlb3 = new JLabel("请您选择服务");
		jlb3.setFont(new   java.awt.Font("Dialog",   1,   22));
		
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);

		
		this.setTitle("银行管理管理系统"); 
		this.setSize(450, 500); 		
		this.setLocation(400, 200);		
		this.setLayout(null);			
		
		

		 jb1.setBounds( 0,50,90,60);   
	     jb2.setBounds( 0,150,90,60);
	     jb3.setBounds( 0,250,90,60);
	     jb4.setBounds( 354,50,90,60);
	     jb5.setBounds( 354,150,90,60);
	     jb6.setBounds( 354,250,90,60);
	     jb7.setBounds(150,400,150,60);


		
	
		jlb1.setBounds(150,120,150,50);
		jlb2.setBounds(190,160,150,50);
		jlb3.setBounds(150,250,150,50);
		

		this.add(jb5);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb6);
		this.add(jb7);
		this.add(jlb1);
		this.add(jlb2);
		this.add(jlb3);
		
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
	    this.setVisible(true); 
	    this.setResizable(false);	
	}

	//任务接受
	public void actionPerformed(ActionEvent a ) {
		// TODO Auto-generated method stub
		if (a.getActionCommand()=="查询")
		{
			 
			try {
				 new Inquiry(this.turn);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
		}
		else if (a.getActionCommand()=="存款")
		{
			new SaveMoney(this.turn);
           
		}
		else if (a.getActionCommand()=="取款")
		{
			new DrawMoney(this.turn);
           
		}
		else if (a.getActionCommand()=="改密")
		{
			 new Modify(this.turn);
          
		}
		else if (a.getActionCommand()=="转账")
		{
			 new Transfer(this.turn);
             
		}
		else if (a.getActionCommand()=="退卡")
		{
			System.exit(0);
		}
		else if (a.getActionCommand()=="返回主菜单")
		{
			new Menu();
			dispose();
		}
	}
}
