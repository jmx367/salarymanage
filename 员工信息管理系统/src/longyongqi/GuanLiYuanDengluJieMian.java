package longyongqi;

import java.awt.Color;
import java.awt.Dimension;
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

public class GuanLiYuanDengluJieMian {
	public static JFrame lgframe = new JFrame("管理员登录");
	public static NewPanel lgpan2 = new NewPanel(new ImageIcon("tu"+File.separator+"2.jpg").getImage());
	
	public static JLabel lglab2 = new JLabel("重置密码");
	public static JLabel lglab3 = new JLabel("管理员：");
	public static JLabel lglab4 = new JLabel("密  码：");
	public static JLabel lglab5 = new JLabel();//管理员图片
	public static Font lgfnt1 = new Font("宋体",Font.BOLD,20);
	public static Font lgfnt2 = new Font("宋体",Font.BOLD,22);
	public static Font lgfnt3 = new Font("宋体",Font.ITALIC,18);
	public static JTextField lgjtf = new JTextField("");//用户账号
	public static JPasswordField lgjpwf = new JPasswordField("");//用户密码
	public static JButton lgbut1 = new JButton("登录");
	public static JLabel lab = new JLabel();
		
	public static boolean flag = false;
	public   GuanLiYuanDengluJieMian(){
		//设置容器的布局方式
		lgframe.setLayout(null);
		lgpan2.setLayout(null);
		
		//设置相关控件的大小
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		lgpan2.setBounds(0, 0, 540, 230);
		
		lglab2.setBounds(410, 115, 100, 40);
		lglab3.setBounds(98, 75, 90, 40);
		lglab4.setBounds(98, 115, 90, 40);
		lglab5.setBounds(440, 10, 74, 74);
		lgjtf.setBounds(180, 75, 200, 40);
		lgjpwf.setBounds(180, 115, 200, 40);
		lgbut1.setBounds(200, 170, 150, 40);//540-150=390
		
		
		lglab5.setIcon(new ImageIcon("tu"+File.separator+"管理员图标.png"));
		//设置控件的包括背景色在内的相关属性
		lgpan2.setBackground(Color.green);
		lglab2.setFont(lgfnt1);
		lglab3.setFont(lgfnt1);
		lglab4.setFont(lgfnt1);
		lglab2.setForeground(Color.black);
		lglab3.setForeground(Color.black);
		lglab4.setForeground(Color.black);
		lgjtf.setFont(lgfnt3);//
		lgjpwf.setFont(lgfnt2);
		lgbut1.setFont(lgfnt2);
		lgjpwf.setEchoChar('*');
//		lab.setIcon(new ImageIcon("Picture"+File.separator+"图片1.jpg"));
		

		//将控件添加进相应容器
		lgframe.add(lgpan2);
		lgpan2.add(lglab2);
		lgpan2.add(lglab3);
		lgpan2.add(lglab4);
		lgpan2.add(lglab5);
		lgpan2.add(lgjtf);
		lgpan2.add(lgjpwf);
		lgpan2.add(lgbut1);
		
		
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
					if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入管理员账号")){
						JOptionPane.showMessageDialog(null,"请输入管理员账号！","系统提示",JOptionPane.WARNING_MESSAGE); 	
					}else if((!lgjtf.getText().equals(""))&&(!lgjtf.getText().equals("请输入管理员账号"))&&(String.valueOf(lgjpwf.getPassword()).equals(""))){
						JOptionPane.showMessageDialog(null,"请输入管理员密码！","系统提示",JOptionPane.WARNING_MESSAGE); 
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
				if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入管理员账号")){
					lgjtf.setText("请输入管理员账号");
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
			if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入管理员账号")){
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
						if(lgjtf.getText().equals("")||lgjtf.getText().equals("请输入管理员账号")){
							JOptionPane.showMessageDialog(null,"请输入管理员账号！","系统提示",JOptionPane.WARNING_MESSAGE);
						}else if((!lgjtf.getText().equals(""))&&(!lgjtf.getText().equals("请输入管理员账号"))&&(String.valueOf(lgjpwf.getPassword()).equals(""))){
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
		
		
		lgframe.setSize(545, 260);
		lgframe.setLocation((int) ((ds.getWidth()-545)/2), (int) ((ds.getHeight()-260)/2));
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
 
		String str = "select * from admininfo where name='"+lgjtf.getText()+"'";
		ResultSet re = sta.executeQuery(str);   //执行完的结果赋给  ResultSet
		while(re.next()){	
		tempflag=1;
		}
		if(tempflag==1){//用户存在，以此用户名登陆系统，弹出系统主界面
			String str1 = "select * from admininfo where name='"+lgjtf.getText()+"'"+"and password='"+String.valueOf(lgjpwf.getPassword())+"'";
			ResultSet re1 = sta.executeQuery(str1);   //执行完的结果赋给  ResultSet
			while(re1.next()){
				tempflag1=1;	
				
			}
			if(tempflag1==1){//*******************************************************************验证成功，弹出主界面	
				lgframe.dispose();
				Zhujiemian.jtp.add("工资管理",Zhujiemian.pan3);
				Zhujiemian.jtp.setSelectedComponent(Zhujiemian.pan3);
				Zhujiemian.mpan.showinfo("");

			}else{//验证失败，提示用户密码错误。
				JOptionPane.showMessageDialog(null,"密码错误！","系统提示",JOptionPane.WARNING_MESSAGE);

			}
		}else{//用户不存在，弹出对话框，给出提示信息。
			JOptionPane.showMessageDialog(null,"用户不存在！","系统提示",JOptionPane.WARNING_MESSAGE);
		}
	}
	}

