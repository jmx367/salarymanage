package µÇÂ¼;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import longyongqi.GuanLiYuanDengluJieMian;
import longyongqi.DengLuJieMian;
import longyongqi.Tianjia;
import longyongqi.Zhujiemian;

public class DengLu {
public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	DengLuJieMian dljm = new DengLuJieMian();
}
}
