package bill;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Details implements ActionListener {
	
	JPanel mPanel=new JPanel();
	JPanel tPanel=new JPanel();
	JPanel bPanel=new JPanel();
	JPanel lPanel=new JPanel();
	JPanel rPanel=new JPanel();
	JPanel cPanel=new JPanel();
	JPanel fPanel=new JPanel();

	JPanel billPanel=new JPanel();
	
	JLabel cid;
	JLabel phno;
	JLabel units;
	JLabel date;
	JLabel datea;
	JLabel bill=new JLabel();
	JLabel heading =new JLabel();
	
	JLabel trueUnits=new JLabel();
	
	
	Font font;
	
	JTextField cidf;
	JTextField phnof;
	JTextField unitsf;
	JTextField datef;
	

	JButton genBill;
	JButton makePay=new JButton();
	JButton clear=new JButton();

	

	String Fulldate;
	String Delimiter;
	String []day;
	int iday;
	
	
	
	Details(){
		
		
		mPanel.setSize(1366, 768);
		mPanel.setBackground(Color.black);
		mPanel.setLayout(new BorderLayout());
		
		tPanel.setBackground(new Color(255,88,0));
		tPanel.setPreferredSize(new Dimension(100,160));
		tPanel.setLayout(null);
		
		heading.setText("Electricity Bill");		
		font = new Font("Sanserif", Font.PLAIN, 90);
		heading.setFont(font);
		heading.setForeground(Color.WHITE);
		heading.setBounds(30, 10, 2000, 130);
		
		tPanel.add(heading);
		mPanel.add(tPanel,BorderLayout.NORTH);
		
		Panel panel=new Panel();
		
		


		bPanel.setBackground(new Color(51,88,255));
		bPanel.setPreferredSize(new Dimension(100,170));
		bPanel.setLayout(null);
		
		makePay.setText("Make Payment");
		makePay.setBounds(490, 30, 120, 40);
		makePay.setBackground(Color.white);
		makePay.setForeground(Color.black);
		makePay.addActionListener(this);
		makePay.setVisible(false);
		bPanel.add(makePay);
		
		clear.setText("Clear");
		clear.setBounds(630, 30, 120, 40);
		clear.setBackground(Color.white);
		clear.setForeground(Color.black);
		clear.addActionListener(this);
		clear.setVisible(false);
		bPanel.add(clear);
		
		
		mPanel.add(bPanel,BorderLayout.SOUTH);
		
		lPanel.setBackground(new Color(51,88,255));
		lPanel.setPreferredSize(new Dimension(95,100));
		mPanel.add(lPanel,BorderLayout.WEST);
		
		rPanel.setBackground(new Color(51,88,255));
		rPanel.setPreferredSize(new Dimension(100,100));
		mPanel.add(rPanel,BorderLayout.EAST);
		
		
		cPanel.setBackground(Color.WHITE);
		cPanel.setPreferredSize(new Dimension(100,100));
		cPanel.setLayout(new BorderLayout());
		cPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//--SUBSTART--
		fPanel.setPreferredSize(new Dimension(700,50));
		fPanel.setBackground(new Color(244,244,244));
		fPanel.setLayout(null); 
		cPanel.add(fPanel,BorderLayout.CENTER);
		
		genBill=new JButton("Generate Bill");
		
		genBill.setBounds(460, 210, 120, 40);
		genBill.setBackground(new Color(64, 219, 183));
		genBill.setForeground(Color.black);
		genBill.addActionListener(this);
		fPanel.add(genBill);
		
		cid=new JLabel("Customer id: ");
		cid.setBounds(20, 50, 100, 50);
		fPanel.add(cid);
		
		cidf=new JTextField();
		cidf.setBounds(110, 60, 210, 30);
		fPanel.add(cidf);
		
		
		phno=new JLabel("Phone Number: ");
		phno.setBounds(600, 50, 100, 50);
		fPanel.add(phno);
		
		phnof=new JTextField();
		phnof.setBounds(710, 60, 210, 30);
		fPanel.add(phnof);
		
		
		units=new JLabel("Units: ");
		units.setBounds(60, 150, 100, 50);
		fPanel.add(units);
		
		unitsf=new JTextField();
		unitsf.setBounds(110, 162, 210, 30);
		fPanel.add(unitsf);
		
		
		date=new JLabel("Current date: ");
		date.setBounds(615, 150, 100, 50);
		fPanel.add(date);
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		Fulldate=dtf.format(now);
		date=new JLabel(Fulldate);
		date.setBounds(706, 160, 210, 30);
		fPanel.add(date);
		
		Delimiter="/";
		
		day=Fulldate.split(Delimiter);
//		System.out.println(day[0]);
		
		iday=Integer.parseInt(day[0]);
		
//		System.out.println(iday);
		
		
		
//		datef=new JTextField();
//		datef.setBounds(710, 162, 210, 30);
//		fPanel.add(datef);

		billPanel.setPreferredSize(new Dimension(700,130));
		billPanel.setBackground(new Color(238,238,238));
		billPanel.setLayout(null);
		cPanel.add(billPanel,BorderLayout.SOUTH);
		
		billPanel.add(panel);
//		panel.setBounds(95, 0, 960, 2);
		panel.setBounds(0, 0, 1160, 2);

		
		bill.setText("Your Bill: ");		
		font = new Font("Sanserif", Font.BOLD, 90);
		bill.setFont(font);
		bill.setForeground(Color.black);
		bill.setBounds(50, 10, 600, 100);
//		bill.setVisible(false);
		
		
		
		billPanel.add(trueUnits);
		billPanel.add(bill);
	
		//--SUBEND--
		
		
		mPanel.add(cPanel,BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==genBill) {
			
			
			
			
			if(cidf.getText().isBlank()==true||phnof.getText().isBlank()==true||unitsf.getText().isBlank()==true) {
				
				JOptionPane.showMessageDialog(null, "Please fill up all the fields", "No Bill Generated", JOptionPane.WARNING_MESSAGE);

				
			}
		
			else {
				
				double units_value;
				
				double fetchunits=Double.parseDouble(unitsf.getText());
				
			
				if(iday>10) {
					
					units_value=(fetchunits*9.5);
					double actual_units_value=units_value+(units_value*0.02);
					
					String units_value_2=String.valueOf(actual_units_value);
					
	
					
					trueUnits.setText("\u20B9"+units_value_2+"/-");
					font = new Font("Sanserif", Font.BOLD, 90);
					trueUnits.setFont(font);
					trueUnits.setForeground(Color.black);
					trueUnits.setBounds(500, 10, 600, 100);
					
	
				}
				
				else {
					
					units_value=fetchunits*9.5;
					
					String units_value_1=String.valueOf(units_value);
					
					
					trueUnits.setText("\u20B9"+units_value_1+"/-");
					font = new Font("Sanserif", Font.BOLD, 90);
					trueUnits.setFont(font);
					trueUnits.setForeground(Color.black);
					trueUnits.setBounds(500, 10, 600, 100);
					
					
				}
			
			
			
//				bill.setVisible(true);
				makePay.setVisible(true);
				cidf.setEditable(false);
				phnof.setEditable(false);
				unitsf.setEditable(false);
				
				clear.setVisible(true);
				
			
			}
			
			
			
			
			
		}
		
		if(e.getSource()==makePay) {
			
			if(cidf.getText().isBlank()==true||phnof.getText().isBlank()==true||unitsf.getText().isBlank()==true) {
				
				JOptionPane.showMessageDialog(null, "Please fill up all the fields", "Payment status: Payment not processed.", JOptionPane.WARNING_MESSAGE);

				
			}
			else {
				JOptionPane.showMessageDialog(null, "Customer ID: "+cidf.getText()+"\n"+"Phone Number: "+phnof.getText(), "Payment status: Paid", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
		}
		
		if(e.getSource()==clear) {
			
			
			cidf.setText("");
			phnof.setText("");
			unitsf.setText("");
			trueUnits.setText("");
			
			cidf.setEditable(true);
			phnof.setEditable(true);
			unitsf.setEditable(true);
			clear.setVisible(false);
			makePay.setVisible(false);
			
			
		}
		
		
	}
	
}
