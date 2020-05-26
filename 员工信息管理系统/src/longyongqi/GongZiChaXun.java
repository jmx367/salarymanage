package longyongqi;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dbutil.ConnectionUtil;

public class GongZiChaXun extends JPanel{
		
		int numj = 0;
		int code = 1;
		float basicsalary = 0.0f;
		float extralsalary = 0.0f;
		float allsalary = 0.0f;
		
		String tempinfo = "";//����һ����ʱ���������洢�û��ĵĲ�ѯ��ʽ

		public JTable table = null ;
		public DefaultTableModel tableModel ;	// TableModel
		public String[] titles = {"Ա�����","����","ְ��","��������","���","�ܹ���"} ;
		
		
		
	public GongZiChaXun(){
		
		this.setLayout(new GridLayout(1,1,0,0));//�������Ĳ��ַ�ʽ
		tableModel = new DefaultTableModel(null,this.titles) ;
		tableModel.setRowCount(22);//���ñ���Ĭ������Ϊ22��
		table = new JTable(this.tableModel){
			public boolean isCellEditable(int row,int column){
				return false;
			}
		};
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//����JTable���ݾ���
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setFont(new Font("����",Font.PLAIN,19));//����JTable�����С������ɫ
		table.setDefaultRenderer(Object.class, tcr);
		table.setFont(new Font("����",Font.PLAIN,17));
		table.setRowHeight(25);//���ñ��ĸ߶�
		table.setAlignmentX(CENTER_ALIGNMENT);
		JScrollPane scr = new JScrollPane(this.table);
		this.add(scr);		
	}
	public void findinfo(String info,int index) throws SQLException, ClassNotFoundException{
		String tempinfo = info;
		int tempcode = 0;
		boolean flag = true;
		try{
			tempcode = Integer.parseInt(tempinfo);
		}catch(NumberFormatException e){
			flag = false;
		}
		Connection conn = ConnectionUtil.getConnection(); 
		int r = 0;
	    Statement sta = conn.createStatement();   //ִ��sql��������  row �� column ��
	    String str = "";
	    System.out.println("��ѯ��־��" + flag);
	    String orderStr = " order by ";
	    switch(index) {
	    case 0:
	    	orderStr = orderStr + "code";
	    	break;
	    case 1:
	    	orderStr = orderStr + "code desc";
	    	break;
	    case 2:
	    	orderStr = orderStr + "basicsalary";
	    	break;
	    case 3:
	    	orderStr = orderStr + "basicsalary desc";
	    	break;
	    case 4:
	    	orderStr = orderStr + "extralsalary";
	    	break;
	    case 5:
	    	orderStr = orderStr + "extralsalary desc";
	    	break;	    
	    }
	    
	    if(flag){
	    	str = "select * from EmployerInfo where code like '%"+tempcode+"" + "%'" + orderStr;
	    }else{
	    	str = "select * from EmployerInfo where job like '%"+tempinfo +"%'" + orderStr;
	    }
	    ResultSet re = sta.executeQuery(str);   //ִ����Ľ������  ResultSet
	    tableModel.setRowCount(0);
	    tableModel.setRowCount(22);
	    while(re.next()){
	    	if(r<22){
		    	table.setValueAt(re.getString("code"), r, 0);
		    	table.setValueAt(re.getString("apartment"), r, 1);
		    	table.setValueAt(re.getString("job"), r, 2);
		    	table.setValueAt(re.getString("basicsalary"), r, 3);
		    	table.setValueAt(re.getString("extralsalary"), r, 4);
		    	table.setValueAt(re.getString("allsalary"), r, 5);
		    	r++;
	    	}else{
		    	Object userinfo[] = {re.getString("code"),re.getString("apartment"),re.getString("job"
		    			+ ""),re.getString("basicsalary"),re.getString("extralsalary"),
		    			re.getString("allsalary")};
		    	this.tableModel.addRow(userinfo);
	    	}
	    }
	    sta.close();
	    conn.close();
	    
	    
	}
	public void setinfo(String info,int num) throws ClassNotFoundException, SQLException{		
		numj = num;
		String info1 = "";
		if(numj==0||numj==2||numj==4||numj==6){//���������򷵻ص�λ������������ʽΪ����������ascΪ����descΪ����
			info1 = "asc";
		}else{
			info1 = "desc";
		}
		tempinfo = info;//��ȡ���û���Ŀ������ʽ
		Connection conn = ConnectionUtil.getConnection();
		int r = 0;
	    Statement sta = conn.createStatement();   //ִ��sql��������  row �� column ��
	    String str = "select * from EmployerInfo order by '"+tempinfo+"' "+info1+"";
	    ResultSet re = sta.executeQuery(str);   //ִ����Ľ������  ResultSet

	    while(re.next()){
	    	if(r<22){
		    	table.setValueAt(re.getString("code"), r, 0);
		    	table.setValueAt(re.getString("apartment"), r, 1);
		    	table.setValueAt(re.getString("job"), r, 2);
		    	table.setValueAt(re.getString("basicsalary"), r, 3);
		    	table.setValueAt(re.getString("extralsalary"), r, 4);
		    	table.setValueAt(re.getString("allsalary"), r, 5);
		    	r++;
	    	}else{
		    	Object userinfo[] = {re.getString("code"),re.getString("apartment"),re.getString("job"
		    			+ ""),re.getString("basicsalary"),re.getString("extralsalary"),
		    			re.getString("allsalary")};
		    	this.tableModel.addRow(userinfo);
	    	}
	    }
	    sta.close();
	    conn.close();
	}
}
