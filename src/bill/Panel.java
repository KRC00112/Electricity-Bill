package bill;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	Panel(){
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(10000,1));

	}
	
	
	public void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		
		Graphics2D g2D=(Graphics2D) g;

		g2D.setStroke(new BasicStroke(5));
		g2D.drawLine(0, 0, 5000000, 0);
		

		
		
		
		
		
	}
	
	
	
	

}
