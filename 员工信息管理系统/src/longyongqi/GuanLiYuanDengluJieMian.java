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
	public static JFrame lgframe = new JFrame("����Ա��¼");
	public static NewPanel lgpan2 = new NewPanel(new ImageIcon("tu"+File.separator+"2.jpg").getImage());
	
	public static JLabel lglab2 = new JLabel("��������");
	public static JLabel lglab3 = new JLabel("����Ա��");
	public static JLabel lglab4 = new JLabel("��  �룺");
	public static JLabel lglab5 = new JLabel();//����ԱͼƬ
	public static Font lgfnt1 = new Font("����",Font.BOLD,20);
	public static Font lgfnt2 = new Font("����",Font.BOLD,22);
	public static Font lgfnt3 = new Font("����",Font.ITALIC,18);
	public static JTextField lgjtf = new JTextField("");//�û��˺�
	public static JPasswordField lgjpwf = new JPasswordField("");//�û�����
	public static JButton lgbut1 = new JButton("��¼");
	public static JLabel lab = new JLabel();
		
	public static boolean flag = false;
	public   GuanLiYuanDengluJieMian(){
		//���������Ĳ��ַ�ʽ
		lgframe.setLayout(null);
		lgpan2.setLayout(null);
		
		//������ؿؼ��Ĵ�С
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		lgpan2.setBounds(0, 0, 540, 230);
		
		lglab2.setBounds(410, 115, 100, 40);
		lglab3.setBounds(98, 75, 90, 40);
		lglab4.setBounds(98, 115, 90, 40);
		lglab5.setBounds(440, 10, 74, 74);
		lgjtf.setBounds(180, 75, 200, 40);
		lgjpwf.setBounds(180, 115, 200, 40);
		lgbut1.setBounds(200, 170, 150, 40);//540-150=390
		
		
		lglab5.setIcon(new ImageIcon("tu"+File.separator+"����Աͼ��.png"));
		//���ÿؼ��İ�������ɫ���ڵ��������
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
//		lab.setIcon(new ImageIcon("Picture"+File.separator+"ͼƬ1.jpg"));
		

		//���ؼ���ӽ���Ӧ����
		lgframe.add(lgpan2);
		lgpan2.add(lglab2);
		lgpan2.add(lglab3);
		lgpan2.add(lglab4);
		lgpan2.add(lglab5);
		lgpan2.add(lgjtf);
		lgpan2.add(lgjpwf);
		lgpan2.add(lgbut1);
		
		
		//�¼���Ӧ������

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
	
		lgbut1.addActionListener(new ActionListener() {//�û������½��ť��ϵͳ�����û���֤		
			public void actionPerformed(ActionEvent e) {
				try {
					if(lgjtf.getText().equals("")||lgjtf.getText().equals("���������Ա�˺�")){
						JOptionPane.showMessageDialog(null,"���������Ա�˺ţ�","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE); 	
					}else if((!lgjtf.getText().equals(""))&&(!lgjtf.getText().equals("���������Ա�˺�"))&&(String.valueOf(lgjpwf.getPassword()).equals(""))){
						JOptionPane.showMessageDialog(null,"���������Ա���룡","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE); 
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
		
		lgjtf.getDocument().addDocumentListener(new DocumentListener() {  //JTextField�¼������봦��
			
			public void removeUpdate(DocumentEvent e) {	
			}
			
			public void insertUpdate(DocumentEvent e) {
			lgjtf.setFont(lgfnt2);	
			}
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		lgjtf.addFocusListener(new FocusListener() {//�����¼�
			
			public void focusLost(FocusEvent e) {
				if(lgjtf.getText().equals("")||lgjtf.getText().equals("���������Ա�˺�")){
					lgjtf.setText("���������Ա�˺�");
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
			if(lgjtf.getText().equals("")||lgjtf.getText().equals("���������Ա�˺�")){
				lgjtf.setText("");
			}else{
			    ;
			}				
			}
		});
		lgjpwf.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			public void keyPressed(KeyEvent e) {
		     if(e.getKeyCode()==10){//*********************************************************
					try {
						if(lgjtf.getText().equals("")||lgjtf.getText().equals("���������Ա�˺�")){
							JOptionPane.showMessageDialog(null,"���������Ա�˺ţ�","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
						}else if((!lgjtf.getText().equals(""))&&(!lgjtf.getText().equals("���������Ա�˺�"))&&(String.valueOf(lgjpwf.getPassword()).equals(""))){
							JOptionPane.showMessageDialog(null,"���������룡","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
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
	public static void LinkToDb() throws ClassNotFoundException, SQLException{//�������ݿ⣬�����û���֤��
		int tempflag=0; 
		int tempflag1=0; 
		String userpassword=null;
		
		Connection conn = ConnectionUtil.getConnection();	
	    Statement sta = conn.createStatement();   //ִ��sql��������
 
		String str = "select * from admininfo where name='"+lgjtf.getText()+"'";
		ResultSet re = sta.executeQuery(str);   //ִ����Ľ������  ResultSet
		while(re.next()){	
		tempflag=1;
		}
		if(tempflag==1){//�û����ڣ��Դ��û�����½ϵͳ������ϵͳ������
			String str1 = "select * from admininfo where name='"+lgjtf.getText()+"'"+"and password='"+String.valueOf(lgjpwf.getPassword())+"'";
			ResultSet re1 = sta.executeQuery(str1);   //ִ����Ľ������  ResultSet
			while(re1.next()){
				tempflag1=1;	
				
			}
			if(tempflag1==1){//*******************************************************************��֤�ɹ�������������	
				lgframe.dispose();
				Zhujiemian.jtp.add("���ʹ���",Zhujiemian.pan3);
				Zhujiemian.jtp.setSelectedComponent(Zhujiemian.pan3);
				Zhujiemian.mpan.showinfo("");

			}else{//��֤ʧ�ܣ���ʾ�û��������
				JOptionPane.showMessageDialog(null,"�������","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);

			}
		}else{//�û������ڣ������Ի��򣬸�����ʾ��Ϣ��
			JOptionPane.showMessageDialog(null,"�û������ڣ�","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
	}
	}

