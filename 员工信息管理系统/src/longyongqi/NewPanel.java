package longyongqi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

public class NewPanel extends JPanel{
	
	private Image image = null;
	private boolean isMoued;
	private Point pre_point;
	private Point end_point;
	
	public NewPanel(Image image){
		this.image = image;
		
		this.setSize(1085, 58);
		this.setBackground(Color.GREEN);
		
	}
	//固定背景图片，允许这儿JPanel可以在图片上添加其他组件
	protected void  paintComponent(Graphics g){		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(),this);

	}
	
}
