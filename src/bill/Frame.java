package bill;

import javax.swing.JFrame;

public class Frame {
	
	Details details=new Details();
	
	Frame(){
	
	JFrame frame=new JFrame();
	frame.setSize(1366, 768);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setTitle("Electricity Bill");
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
	frame.add(details.mPanel);
	
	
	
	}
	
	

}
