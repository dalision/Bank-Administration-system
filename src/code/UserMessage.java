package contentcl;
import java.io.*;  

public class UserMessage
{

	public void write(String[] message)throws IOException
	{
		File file=new File("Message.txt");
		String messagesum="";
		for (int i=0; i<5; i++) //格式化
			messagesum+=message[i]+"~";
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true); //文件输入对象
        StringBuffer sb=new StringBuffer();      //向文字流添加信息
        sb.append(messagesum+"\n");				
         out.write(sb.toString().getBytes("gb2312"));        
        out.close();			
	}

	//返回文件当中用户信息（文件已经存在）
	public String[] read(String countname) throws IOException
	{
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        
        String []message = new String[5];     //读取用户信息
        while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();           
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	if (message[2].equals(countname))  //判断用户信息
        	{
        		return message;
        	}
            temp=br.readLine();
        }
        return null;
	}
	 
	/*改变用户的存款金额
	 * 
	 */
	public String updatemoney(String countname,int wangsave) throws IOException
	{
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException(); 
      
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer(); 
        StringBuffer sb1=new StringBuffer();
        
        String moneystring="";
        
        temp=br.readLine();
        String []message = new String[5]; //֤
        while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();          
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)     
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	
        	if (message[2].equals(countname))   
        	{
        		String newmessage="";
        		int moneyint;
        		moneyint=Integer.parseInt(message[4])+wangsave;  //改变存款金额
        							
        		
        		if (moneyint<0)
        		{
        			return "负数";
        		}
        		moneystring  = String.valueOf(moneyint);	
        		for (int i=0; i<4; i++)				
        			newmessage += message[i]+"~";
        		newmessage += moneystring+"~";
        		sb1.append(newmessage+"\n");
        	}
        	else
        	{
        		sb1.append(temp+"\n");
        	}
        	temp=br.readLine();
        }
        /*
         * 说明：
         * 本来的想法是在原文件对象中覆盖内容，但是发现覆盖后文本为空， 无法解决
         * 但重新创建文件对象，则可以完成操作
         */
        File file1=new File("Message.txt");  
        if(!file1.exists())
           file1.createNewFile();
        FileOutputStream out=new FileOutputStream(file1,false); 
        out.write(sb1.toString().getBytes("gb2312"));
        out.close();
        
		return moneystring;
	}
	
	
      //用来更新密码
	public String updatepwd(String countname,String pwd) throws IOException
	{
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException(); 
        //���ļ�  
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        //д�ļ�
        //FileOutputStream out=new FileOutputStream(file,false);        
        StringBuffer sb1=new StringBuffer();
        
        String moneystring="";
        
        temp=br.readLine();
        String []message = new String[5];   //  ֤
        while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();           
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)      
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	
        	if (message[2].equals(countname))   
        	{
        		//�޸�����
        		for (int i=0; i<3; i++)
        			sb1.append(message[i]+"~");
        		sb1.append(pwd+"~");
        		sb1.append(message[4]+"~\n");
        	}
        	else
        	{
        		sb1.append(temp+"\n");
        	}
        	temp=br.readLine();
        }
        
        File file1=new File("Message.txt");
        if(!file1.exists())
           file1.createNewFile();
        FileOutputStream out=new FileOutputStream(file1,false);
        out.write(sb1.toString().getBytes("gb2312"));
        out.close();
        
		return moneystring;
	}
	
	
	
	

}
