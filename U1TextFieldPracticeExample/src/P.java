import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class P extends JFrame implements ActionListener {
private JPasswordField pfPassword;
private JButton btnOK;
private JLabel lblMessage;
public static void main(String[] args) {
new P();
}
public P() {
// Initialize and set properties of JPasswordField
pfPassword = new JPasswordField(15);
pfPassword.setHorizontalAlignment(JPasswordField.CENTER);
// Initialize and setProperties of JButton
btnOK = new JButton("OK");
btnOK.addActionListener(this);
// Initialize and set properties of JLabel
lblMessage = new JLabel();
lblMessage.setHorizontalAlignment(JLabel.CENTER);
lblMessage.setPreferredSize(new Dimension(150, 30));
// Declare and initialize JPanel
JPanel panel = new JPanel();
panel.add(pfPassword);
panel.add(btnOK);
panel.add(lblMessage);
// Set properties of JFrame
setContentPane(panel);
setSize(200, 125);
setTitle("JPasswordField Example");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
getRootPane().setDefaultButton(btnOK);
setVisible(true);
}
public void actionPerformed(ActionEvent e) {
// Output password in label
lblMessage.setText("PASSWORD: " + pfPassword.getText());
}
}