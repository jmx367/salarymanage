package longyongqi;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dbutil.ConnectionUtil;

public class XiuGai extends JDialog{
	
	public int tempnum = 1;
	String code = "";
	String name = "";
	String sex = "";
	String age = "";
	String apartment = "";
	String job = "";
	String jobtime = "";
	String basicsalary = "";
	String extralsalary = "";

	JLabel lab0 = new JLabel("Ա�����:");	//Ա����� ���� �Ա� ���� ���� ְ��  ��ְʱ��  �������� ���  ���¹���
	JLabel lab1 = new JLabel("��      ��:");//����
	JLabel lab2 = new JLabel("��      ��:");//�Ա�
	JLabel lab3 = new JLabel("��      ��:");//����
	JLabel lab4 = new JLabel("��ְʱ��:");//����
	JLabel lab5 = new JLabel("ְ      ��:");//ְ��
	JLabel lab6 = new JLabel("��      ��:");//��ְʱ��
	JLabel lab7 = new JLabel("��������:");//��������
	JLabel lab8 = new JLabel("��      ��:");//���
	JLabel lab9 = new JLabel("���¹���:");//���¹���
	JTextField t0 = new JTextField();
	JTextField t1 = new JTextField();
//	JTextField jcb = new JTextField();
	JComboBox jcb = null;
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	JTextField t8 = new JTextField();
	JTextField t9 = new JTextField();
	
	JButton but1 = new JButton("����");
	JButton but2 = new JButton("ȡ��");
	Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
	public XiuGai() throws ClassNotFoundException, SQLException{
		String tempsex[] ={"��","Ů"}; 
		jcb = new JComboBox(tempsex);
		getendcode();
		this.setLayout(null);
		t0.setBounds(150, 100, 150, 30);	
		t1.setBounds(150, 150, 150, 30);	
		jcb.setBounds(150, 200, 150, 30);	
		t3.setBounds(150, 250, 150, 30);	
		t4.setBounds(150, 300, 150, 30);	
		
		t5.setBounds(420, 100, 150, 30);
		t6.setBounds(420, 150, 150, 30);
		t7.setBounds(420, 200, 150, 30);
		t8.setBounds(420, 250, 150, 30);
		t9.setBounds(420, 300, 150, 30);
		
		lab0.setBounds(60, 100, 90, 30);
		lab1.setBounds(60, 150, 90, 30);
		lab2.setBounds(60, 200, 90, 30);
		lab3.setBounds(60, 250, 90, 30);
		lab4.setBounds(60, 300, 90, 30);
		
		lab5.setBounds(330, 100, 90, 30);
		lab6.setBounds(330, 150, 90, 30);
		lab7.setBounds(330, 200, 90, 30);
		lab8.setBounds(330, 250, 90, 30);
		lab9.setBounds(330, 300, 90, 30);
		but1.setBounds(500, 380, 120, 30);
		but2.setBounds(360, 380, 120, 30);
		
		
		lab0.setFont(new Font("���ķ���",Font.BOLD,18));
		lab1.setFont(new Font("���ķ���",Font.BOLD,18));
		lab2.setFont(new Font("���ķ���",Font.BOLD,18));
		lab3.setFont(new Font("���ķ���",Font.BOLD,18));
		lab4.setFont(new Font("���ķ���",Font.BOLD,18));
		lab5.setFont(new Font("���ķ���",Font.BOLD,18));
		lab6.setFont(new Font("���ķ���",Font.BOLD,18));
		lab7.setFont(new Font("���ķ���",Font.BOLD,18));
		lab8.setFont(new Font("���ķ���",Font.BOLD,18));
		lab9.setFont(new Font("���ķ���",Font.BOLD,18));

		but1.setFont(new Font("����",Font.BOLD,18));
		but2.setFont(new Font("����",Font.BOLD,18));
		
		this.add(lab0);
		this.add(lab1);
		this.add(lab2);
		this.add(lab3);
		this.add(lab4);
		this.add(lab5);
		this.add(lab6);
		this.add(lab7);
		this.add(lab8);
		this.add(lab9);
		
		
		
		
		this.add(t0);
		this.add(jcb);
		this.add(t4);
		this.add(t6);
		this.add(t1);
		this.add(t8);
		this.add(t3);
		this.add(t5);		
		this.add(t7);		
		this.add(t9);
		this.add(but1);
		this.add(but2);
		this.setTitle("�޸�Ա����Ϣ");
		
		 int i = 0;

	     i = Zhujiemian.mpan.table.getSelectedRow();
	     if(i==-1){
	    	 i=0;
	     }else{
	    	 ;
	     }

		 code = Zhujiemian.mpan.tableModel.getValueAt(i, 0).toString();
		 name = Zhujiemian.mpan.tableModel.getValueAt(i, 1).toString();
		 sex = Zhujiemian.mpan.tableModel.getValueAt(i, 2).toString();
		 age = Zhujiemian.mpan.tableModel.getValueAt(i, 3).toString();
		 apartment = Zhujiemian.mpan.tableModel.getValueAt(i, 6).toString();
		 job = Zhujiemian.mpan.tableModel.getValueAt(i, 5).toString();
		 jobtime = Zhujiemian.mpan.tableModel.getValueAt(i, 4).toString();
		 basicsalary = Zhujiemian.mpan.tableModel.getValueAt(i, 7).toString();
		 extralsalary = Zhujiemian.mpan.tableModel.getValueAt(i, 8).toString();
		 
		 System.out.println("0:"+code+"   1:"+name+"   2:"+sex+"   3:"+age+"   4:"+apartment+"   5:"+job+"   6:"+jobtime+"   "
			 		+ "7:"+basicsalary+"   8:"+extralsalary);
		 t0.setText(code);
		 t1.setText(name);
		 jcb.setSelectedItem(sex);
		 t3.setText(age);
		 t4.setText(apartment);
		 t5.setText(job);
		 t6.setText(jobtime);
		 t7.setText(basicsalary);
		 t8.setText(extralsalary);
		 t9.setText(Float.parseFloat(basicsalary)+Float.parseFloat(extralsalary)+"");
		 t9.setEditable(false); 
		 t0.setEditable(false);
		 but2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			Zhujiemian.xg.dispose();		
			}
			
		 });
		 but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					changeinfo();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
			 
		 });
		 t7.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				if(t7.getText().equals("")){
					
				}else{
				t9.setText(Float.parseFloat(t7.getText())+Float.parseFloat(t8.getText())+"");
				}
			}
			public void removeUpdate(DocumentEvent e) {
				if(t7.getText().equals("")){
					
				}else{
				t9.setText(Float.parseFloat(t7.getText())+Float.parseFloat(t8.getText())+"");
				}
			}

			public void changedUpdate(DocumentEvent e) {
				if(t7.getText().equals("")){
					
				}else{
				t9.setText(Float.parseFloat(t7.getText())+Float.parseFloat(t8.getText())+"");
				}
			}
			 
		 });
		 t8.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				if(t8.getText().equals("")){
					
				}else{
				t9.setText(Float.parseFloat(t7.getText())+Float.parseFloat(t8.getText())+"");
				}
			}
			public void removeUpdate(DocumentEvent e) {
				if(t8.getText().equals("")){
					
				}else{
				t9.setText(Float.parseFloat(t7.getText())+Float.parseFloat(t8.getText())+"");
				}
			}

			public void changedUpdate(DocumentEvent e) {
				if(t8.getText().equals("")){
					
				}else{
				t9.setText(Float.parseFloat(t7.getText())+Float.parseFloat(t8.getText())+"");
				}
			}
			 
		 });
		this.setSize(660, 510);//885  715
		this.setLocation(((int) (ds.getWidth())-660)/2, ((int) (ds.getHeight())-510)/2);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void changeinfo() throws ClassNotFoundException, SQLException{//�����Ϣ
		 int i = 0;
		 code = t0.getText();
		 name = t1.getText();
		 sex = jcb.getSelectedItem().toString();
		 age = t3.getText();
		 apartment = t4.getText();
		 job = t5.getText();
		 jobtime = t6.getText();
		 basicsalary = t7.getText();
		 extralsalary = t8.getText();

		Connection conn = ConnectionUtil.getConnection();
	    Statement sta = conn.createStatement();   //ִ��sql��������  row �� column ��
	    String str = "update  EmployerInfo set name = '"+name+"',age= "+age+" ,sex='"+sex+"',"
	    		+ "startjob='"+apartment+"',job='"+job+"',apartment='"+
	    		jobtime+"',basicsalary= "+Float.parseFloat(basicsalary)+" ,extralsalary= "+
	    		Float.parseFloat(extralsalary)+",allsalary="+(Float.parseFloat(basicsalary)+
	    				Float.parseFloat(extralsalary))+" where code="+code+"";
	    JOptionPane.showMessageDialog(null,"Ա����"+name+" ����Ϣ�޸ĳɹ���","ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
	    sta.executeUpdate(str);	 
	    sta.close();
	    conn.close();
	    //Ա����� ���� �Ա� ���� ���� ְ��  ��ְʱ��  �������� ���  ���¹���    
	}
	public int getendcode() throws ClassNotFoundException, SQLException{
		Connection conn = ConnectionUtil.getConnection(); 
	    Statement sta = conn.createStatement();   //ִ��sql��������  row �� column ��
	    String str = "select * from EmployerInfo";
	    ResultSet re = sta.executeQuery(str);   //ִ����Ľ������  ResultSet
	    tempnum=1;
	    while(re.next()){
	    	tempnum++;
	    }	    
	    sta.close();
	    conn.close();
	    t0.setText(String.valueOf(tempnum));
	    return tempnum;
	}
}

