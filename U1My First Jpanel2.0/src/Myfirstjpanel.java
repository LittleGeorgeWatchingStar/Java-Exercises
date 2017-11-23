import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Myfirstjpanel extends JFrame{

	public static void main(String[] args) {
		new Myfirstjpanel();
	}
		// constructor
		public Myfirstjpanel() {
			
			//create a JPanel object
			JPanel panel = new JPanel();
			
			//create a JLabel object
			JLabel label = new JLabel();
			label.setBounds(40,70,300,45);
			label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			label.setText("I LOVE U, Teacher~");
			
			
			label.setOpaque(true);
			label.setBackground(Color.red);
			label.setForeground(Color.WHITE);
			Dimension d = new Dimension(200,20);
			label.setPreferredSize(d);
			label.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			
			//add label to panel
			panel.setLayout(null);
			panel.add(label);
			
			//set the properties of the frame
			setContentPane(panel);
			setSize(400,200);
			setTitle("My First JPanel");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			//background property
			getContentPane().setBackground(Color.BLUE);
			
		}

	}


