import java.awt.event.*;

import javax.swing.*;

public class First extends JFrame implements ActionListener,WindowListener{
	
	private JButton btnClick, btnExit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new First();
    
	}
	
	

    //constructor
	public First() {
		
		//create a button
	    btnClick = new JButton("Click Me");
		btnClick.setToolTipText("This is a Button");
		btnClick.setBounds(100,15,100,40);
		btnClick.setMnemonic(KeyEvent.VK_C);//shortcut key
		btnClick.addActionListener(new ButtonListener());
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(100,70,100,40);
		btnExit.setMnemonic(KeyEvent.VK_D);
		btnExit.addActionListener(new ButtonListener());
		
		
		//create a content panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(btnClick);
		panel.add(btnExit);
		
		
		//set the properties of the frame
		setContentPane(panel);
		setSize(300,160);
		setTitle("My First Buttom");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setVisible(true);	
	}
	
	public void windowClosing(WindowEvent e){
		int option = JOptionPane.showConfirmDialog(null, "Exit",
				"Exit", JOptionPane.YES_NO_CANCEL_OPTION);
		if (option == JOptionPane.YES_OPTION)
			System.exit(0);
		else if (option == JOptionPane.NO_OPTION)
			System.out.println("NO");
		else if (option == JOptionPane.CANCEL_OPTION)
			System.out.println("CANCEL_OPTION");
	}
	public void windowActiviated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowOpen(WindowEvent e){}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnClick){
				JOptionPane.showMessageDialog(null, "It works", "JButton", JOptionPane.INFORMATION_MESSAGE);
			}
				else if (e.getSource() == btnExit) {
					JOptionPane.showMessageDialog(null, "It also works", "JButton", JOptionPane.INFORMATION_MESSAGE);
				}
			}
	}
	
	/*
	private class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e){
			btnExit.doClick();
		
		}
	}
	*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
