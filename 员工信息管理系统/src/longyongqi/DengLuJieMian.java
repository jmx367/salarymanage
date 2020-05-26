package longyongqi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dbutil.ConnectionUtil;

public class DengLuJieMian {
	public static JFrame lgframe = new JFrame("用户登录");
	public static NewPanel lgpan1 = new NewPanel(new ImageIcon("tu"+File.separator+"1.jpg").getImage());
	public static NewPanel lgpan2 = new NewPanel(new ImageIcon("tu"+File.separator+"2.jpg").getImage());
	
	public static JLabel lglab2 = new JLabel("重置密码");
	public static JLabel lglab3 = new JLabel("用户名：");
	public static JLabel lglab4 = new JLabel("密  码：");
	public static Font lgfnt1 = new Font("宋体",Font.BOLD,20);
	public static Font lgfnt2 = new Font("宋体",Font.BOLD,22);
	public static Font lgfnt3 = new Font("宋体",Font.ITALIC,18);
	public static JTextField lgjtf = new JTextField("");//用户账号
	public static JPasswordField lgjpwf = new JPasswordField("");//用户密码
	public static JButton lgbut1 = new JButton("登录");
	public static JLabel lab = new JLabel();
	public static JTextField jtf = new JTextField("---------------------季旻霞--------------------" );

		

	public   DengLuJieMian(){
		//设置容器的布局方式
		lgframe.setLayout(null);
		lgpan1.setLayout(new GridLayout(1,1,0,0));
		lgpan2.setLayout(null);
		lgpan1.setLayout(new FlowLayout());
		
		//设置相关控件的大小
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		lgpan1.setBounds(0, 0, 540, 230);
		lgpan2.setBounds(0, 230, 540, 185);
		
		lglab2.setBounds(410, 55, 100, 40);
		lglab3.setBounds(98, 15, 90, 40);
		lglab4.setBounds(98, 55, 90, 40);
		
		lgjtf.setBounds(200, 15, 200, 40);
		lgjpwf.setBounds(200, 55, 200, 40);
		jtf.setBounds(195, 120, 150, 40);
		
		lgbut1.setBounds(195, 120, 150, 40);//540-150=390
		
		//设置控件的包括背景色在内的相关属性
		lgpan1.setBackground(Color.orange);
		lgpan2.setBackground(Color.green);
		lglab2.setFont(lgfnt1);
		lglab3.setFont(lgfnt1);
		lglab4.setFont(lgfnt1);
		jtf.setFont(lgfnt1);
		lglab2.setForeground(Color.black);
		lglab3.setForeground(Color.black);
		lglab4.setForeground(Color.black);
		lgjtf.setFont(lgfnt3);//
		lgjpwf.setFont(lgfnt2);
		lgbut1.setFont(lgfnt2);
		lgjpwf.setEchoChar('*');
//		lab.setIcon(new ImageIcon("Picture"+File.separator+"图片1.jpg"));
		

		//将控件添加进相应容器
		lgframe.add(lgpan1);
		lgframe.add(lgpan2);
		lgpan1.add(lab);
		lgpan2.add(lglab2);
		lgpan2.add(lglab3);
		lgpan2.add(lglab4);
		lgpan2.add(lgjtf);
		lgpan2.add(lgjpwf);
		lgpan2.add(lgbut1);
		lgpan1.add(jtf);
		
		//事件响应及处理

		lglab2.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
			
			}
			public void mousePressed(MouseEvent e) {
			lglab2.setForeground(Color.black);			
			}
			public void mouseReleased(MouseEvent e) {
			lglab2.setForeground(Color.gray);	
			}
			public void mouseEntered(MouseEvent e) {
			lglab2.setForeground(Color.gray);
			}
			public void mouseExited(MouseEvent e) {
			lglab2.setForeground(Color.black);
			}		
		});
	
		lgbut1.addActionListener(new ActionListener() {//用户点击登陆按钮后系统进行用户验证		
			public void actionPerformed(ActionEvent e) {
				try {
					if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入用户账号")){
						JOptionPane.showMessageDialog(null,"请输入用户账号！","系统提示",JOptionPane.WARNING_MESSAGE); 	
					}else if((!lgjtf.getText().equals(""))&&(!lgjtf.getText().equals("请输入用户账号"))&&(String.valueOf(lgjpwf.getPassword()).equals(""))){
						JOptionPane.showMessageDialog(null,"请输入用户密码！","系统提示",JOptionPane.WARNING_MESSAGE); 
					}else  {
					LinkToDb();

					}
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		lgjtf.getDocument().addDocumentListener(new DocumentListener() {  //JTextField事件监听与处理
			
			public void removeUpdate(DocumentEvent e) {	
			}
			
			public void insertUpdate(DocumentEvent e) {
			lgjtf.setFont(lgfnt2);	
			}
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		lgjtf.addFocusListener(new FocusListener() {//焦点事件
			
			public void focusLost(FocusEvent e) {
				if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入用户账号")){
					lgjtf.setText("请输入用户账号");
					lgjtf.setFont(lgfnt3);
				}else{
				    ;
				}
			}
			public void focusGained(FocusEvent e) {
				
			}
		});
		lgjtf.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
	
			}
			public void mousePressed(MouseEvent e) {

			}
			
			public void mouseExited(MouseEvent e) {
				
			}
			
			public void mouseEntered(MouseEvent e) {	
			}
			public void mouseClicked(MouseEvent e) {
			if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入用户账号")){
				lgjtf.setText("");
			}else{
			    ;
			}				
			}
		});
		lgjpwf.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}

			public void keyPressed(KeyEvent e) {
		     if(e.getKeyCode()==10){//*********************************************************
					try {
						if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入用户账号")){
							JOptionPane.showMessageDialog(null,"请输入用户账号！","系统提示",JOptionPane.WARNING_MESSAGE);
						}else if((!lgjtf.getText().equals(""))&&(!lgjtf.getText().equals("请输入用户账号"))&&(String.valueOf(lgjpwf.getPassword()).equals(""))){
							JOptionPane.showMessageDialog(null,"请输入密码！","系统提示",JOptionPane.WARNING_MESSAGE);
						}else  {
						LinkToDb();

						}
						
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		     }
			}

			public void keyReleased(KeyEvent e) {
		
			}	
		});
		lgjpwf.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
			lgjpwf.setText("");
				
			}

			public void mousePressed(MouseEvent e) {	
			}

			public void mouseReleased(MouseEvent e) {
		
			}

			public void mouseEntered(MouseEvent e) {
		
			}
			public void mouseExited(MouseEvent e) {	
			}
			
		});
		
		
		lgframe.setSize(545, 450);
		lgframe.setLocation((int) ((ds.getWidth()-545)/2), (int) ((ds.getHeight()-450)/2));
		lgframe.setResizable(false);
		lgframe.setDefaultCloseOperation(lgframe.DISPOSE_ON_CLOSE);
		lgframe.setVisible(true);		
		
	}
	public static void LinkToDb() throws ClassNotFoundException, SQLException{//连接数据库，进行用户验证。
		int tempflag=0; 
		int tempflag1=0; 
		String userpassword=null;
		
		Connection conn = ConnectionUtil.getConnection();	
	    Statement sta = conn.createStatement();   //执行sql语句的容器
 
		String str = "select * from userinfo where name='"+lgjtf.getText()+"'";
		ResultSet re = sta.executeQuery(str);   //执行完的结果赋给  ResultSet
		while(re.next()){	
		tempflag=1;
		}
		if(tempflag==1){//用户存在，以此用户名登陆系统，弹出系统主界面
			String str1 = "select * from userinfo where name='"+lgjtf.getText()+"'"+"and password='"+String.valueOf(lgjpwf.getPassword())+"'";
			ResultSet re1 = sta.executeQuery(str1);   //执行完的结果赋给  ResultSet
			while(re1.next()){
				tempflag1=1;	

			}
			if(tempflag1==1){//验证成功，弹出主界面	
				lgframe.dispose();
				new Zhujiemian();

			}else{//验证失败，提示用户密码错误。
				JOptionPane.showMessageDialog(null,"密码错误！","系统提示",JOptionPane.WARNING_MESSAGE);

			}
		}else{//用户不存在，弹出对话框，给出提示信息。
			JOptionPane.showMessageDialog(null,"用户不存在！","系统提示",JOptionPane.WARNING_MESSAGE);
		}
	}
	}
