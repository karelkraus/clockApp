import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class MyFrame extends JFrame {
	
	ImageIcon icon = new ImageIcon("clock.png");
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time; //the current time will be saved in the string
	String day;
	String date;
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("What time is it?");
		this.setLayout(new FlowLayout());
		this.setSize(350,250);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("dd.MMMMM yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Bauhaus 93",Font.PLAIN,55));
		timeLabel.setForeground(Color.red);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Bauhaus 93",Font.PLAIN,45));
		dayLabel.setForeground(Color.darkGray);
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Bauhaus 93",Font.PLAIN,35));
		dateLabel.setForeground(Color.darkGray);
		
		
		this.add(dayLabel);
		this.add(timeLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	
	public void setTime() {
		while(true) { //loop to update the time
		time = timeFormat.format(Calendar.getInstance().getTime()); //to get the current time
		timeLabel.setText(time);
		
		day = dayFormat.format(Calendar.getInstance().getTime()); //to get the day
		dayLabel.setText("Dnes je " + day);
		
		date = dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date);
		
		try {
			Thread.sleep(1000); // each second updated
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
