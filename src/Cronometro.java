import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cronometro implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("começar");
	JButton resetButton = new JButton("Resetar");
	JLabel timeLabel = new JLabel();
	int elapsedTime =0;
	int seconds =0;
	int minutes =0;
	int hours =0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime=elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			
		}
		
	});
	
	Cronometro(){
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Arial", Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(50,220,150,50);
		startButton.setFont(new Font("Arial", Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200,220,150,50);
		resetButton.setFont(new Font("Arial", Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,520);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			if(started==false) {
				started=true;
				startButton.setText("Parar");
				start();
			}
			else {
				started=false;
				startButton.setText("começar");
				stop();
			}
		}
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("Começar");
			reset();
		}
		
	}
	
	void start() {
		timer.start();
		
	}
	void stop() {
		timer.stop();
	}
	void reset() {
		timer.stop();
		elapsedTime=0;
		seconds =0;
		minutes =0;
		hours =0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}


}


