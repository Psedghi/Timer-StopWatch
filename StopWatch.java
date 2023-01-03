import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//NOTE WANT TO ADD Milliseconds to Timer too!!!
public class StopWatch implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	JButton resetButton = new JButton("Reset");
	JLabel timeLabel = new JLabel();
	
	int elapsedTime = 0; //this is milliseconds
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false; //see if time has started or not
	
	String seconds_String = String.format("%02d", seconds);
	String minutes_String = String.format("%02d", minutes);
	String hours_String = String.format("%02d", hours);
 
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			elapsedTime = (elapsedTime + 1000);
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime /60000) % 60;
			seconds = (elapsedTime/ 1000) % 60;
			
			seconds_String = String.format("%02d", seconds);
			minutes_String = String.format("%02d", minutes);
			hours_String = String.format("%02d", hours);
			timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
		}
	});
	
	StopWatch(){
		//displays text on stopwatch
		timeLabel.setText(hours_String + ":" + minutes_String+ ":" + seconds_String);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		//creates startButton
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		//creates resetButton
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		frame.add(resetButton);
		frame.add(startButton);
		frame.add(timeLabel);
		//creates frame on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);//need to put this at end of constructor
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == startButton) {
			
			if(started == false) {
				started = true;
				startButton.setText("Stop");
				start();
			}else if(started == true) {
				started = false;
				startButton.setText("Start");
				stop();
			}
		}
		if(e.getSource() == resetButton) {
			started = false;
			startButton.setText("Start");
			reset();
		}
	}
	
	public void start() {
		timer.start();
	}
	public void stop() {
		timer.stop();
	}
	public void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		seconds_String = String.format("%02d", seconds);
		minutes_String = String.format("%02d", minutes);
		hours_String = String.format("%02d", hours);
		timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
	}
	
}
