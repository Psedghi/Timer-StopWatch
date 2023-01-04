import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
public class ClockTime extends JFrame{
	
	//Calendar calendar;
	SimpleDateFormat date;
	SimpleDateFormat dayFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	String day;
	String time;

	//Constructor
	ClockTime(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock");
		this.setLayout(new FlowLayout());
		this.setSize(350,200);
		this.setResizable(false);
		
		date = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE, d MMMMM");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Ventrua", Font.PLAIN, 50));
		timeLabel.setForeground(Color.black);
		timeLabel.setBackground(Color.gray);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		dayLabel.setBackground(Color.gray);
		dayLabel.setOpaque(true);
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.setVisible(true);
		
		setTime();
	}
	public void setTime() {
		while(true) {
			time = date.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
