package longyongqi;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dbutil.ConnectionUtil;

public class GongZiGuanLi extends JPanel{
		
	String str[] = {"",""};
	public int infoflag = 0;
	public JTable table = null ;
	public DefaultTableModel tableModel ;	// TableModel
	public String[] titles = {"员工编号","姓名","性别","年龄","部门","职务","入职时间","基本工资","提成","总工资"} ;
	
	String code = ""; 
	String name = ""; 
	String apartment = ""; 
	String job = ""; 
	
	String info = "";
	public GongZiGuanLi(){
		
		this.setLayout(new GridLayout(1,1,0,0));//设置面板的布局方式
		tableModel = new DefaultTableModel(null,this.titles) ;
		tableModel.setRowCount(22);//设置表格的默认行数为22行
		table = new JTable(this.tableModel){
			public boolean isCellEditable(int row,int column){
				return false;
			}
		};
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//设置JTable内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setFont(new Font("楷体",Font.PLAIN,19));//设置JTable标题大小及背景色
		table.setDefaultRenderer(Object.class, tcr);
		table.setFont(new Font("宋体",Font.PLAIN,17));
		table.setRowHeight(25);//设置表格的高度
		table.setAlignmentX(CENTER_ALIGNMENT);
		JScrollPane scr = new JScrollPane(this.table);
		this.add(scr);
		table.setRowSelectionInterval(0, 0);
	}
	

	public void showinfo(String info) throws ClassNotFoundException, SQLException{
		this.info = info;
		Connection conn = ConnectionUtil.getConnection(); 
		int r = 0;
	    Statement sta = conn.createStatement();   //执行sql语句的容器  row 行 column 列
	    
	    str[1] = "select * from employerinfo where code='"+info+"'or name='"+info+"'or apartment = '"+info+"'or job ='"+info+"'";
	    str[0] = "select * from employerinfo ";
	     
	    ResultSet re = sta.executeQuery(str[infoflag]);   //执行完的结果赋给  ResultSet
	    tableModel.setRowCount(0);
	    tableModel.setRowCount(22);
	    while(re.next()){
	    	if(r<22){
		    	table.setValueAt(re.getString("code"), r, 0);
		    	table.setValueAt(re.getString("name"), r, 1);
		    	table.setValueAt(re.getString("sex"), r, 2);
		    	table.setValueAt(re.getString("age"), r, 3);
		    	table.setValueAt(re.getString("apartment"), r, 4);
		    	table.setValueAt(re.getString("job"), r, 5);
		    	table.setValueAt(re.getString("startjob"), r, 6);
		    	table.setValueAt(re.getString("basicsalary"), r, 7);
		    	table.setValueAt(re.getString("extralsalary"), r, 8);	    	
		    	table.setValueAt(re.getString("allsalary"), r, 9);	    	
		    	r++;

	    	}else{
		    	Object userinfo[] = {re.getString("code"),re.getString("name"),re.getString("sex"),
		    			re.getString("age"),re.getString("apartment"),re.getString("job"
		    			+ ""),re.getString("startjob"),re.getString("basicsalary"),re.getString("extralsalary"),
		    			re.getString("allsalary")};
		    	this.tableModel.addRow(userinfo);
	    	}
	    }
	    sta.close();
	    conn.close();
	}
}
