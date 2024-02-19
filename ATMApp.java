import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
public class ATMApp { 
private JFrame frame; 
private JLabel balanceLabel; 
private double accountBalance; 
public ATMApp() 
{ 
accountBalance = 1000.0; 
// Initial account balance 
frame = new JFrame("ATM Simulator"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.setSize(400, 300); 
frame.setLayout(new BorderLayout()); 
balanceLabel = new JLabel("Account Balance: $" + accountBalance); 
frame.add(balanceLabel, BorderLayout.NORTH); 
JPanel buttonPanel = new JPanel(new GridLayout(3, 1)); 
JButton checkBalanceButton = new JButton("Check Balance"); 
JButton depositButton = new JButton("Deposit"); 
JButton withdrawButton = new JButton("Withdraw"); 
checkBalanceButton.addActionListener(new ButtonClickListener()); 
depositButton.addActionListener(new ButtonClickListener());
withdrawButton.addActionListener(new ButtonClickListener()); 
buttonPanel.add(checkBalanceButton); 
buttonPanel.add(depositButton); 
buttonPanel.add(withdrawButton); 
frame.add(buttonPanel, BorderLayout.CENTER); 
frame.setVisible(true); 
}
private class ButtonClickListener implements ActionListener 
{ 
public void actionPerformed(ActionEvent e) 
{ 
String buttonText = e.getActionCommand(); 
switch (buttonText) 
{ 
case "Check Balance": 
JOptionPane.showMessageDialog(frame, "Account Balance: $" + accountBalance); 
break; 
case "Deposit": 
String depositAmountString = JOptionPane.showInputDialog(frame, "Enter deposit amount:"); 
try 
{ 
double depositAmount = Double.parseDouble(depositAmountString); 
if (depositAmount > 0) 
{ 
accountBalance += depositAmount; 
updateBalanceLabel(); 
} 
else 
{ 
JOptionPane.showMessageDialog(frame, "Invalid deposit amount. Please enter a positive value.");
} 
} 
catch (NumberFormatException ex) 
{ 
JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numerical value.");
} 
break; 
case "Withdraw": 
String withdrawAmountString = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:"); 
try 
{ 
double withdrawAmount = Double.parseDouble(withdrawAmountString); 
if (withdrawAmount > 0 && withdrawAmount <= accountBalance) 
{ 
accountBalance -= withdrawAmount; 
updateBalanceLabel(); 
} 
else if (withdrawAmount <= 0) 
{ 
JOptionPane.showMessageDialog(frame, "Invalid withdrawal amount. Please enter a positive value."); 
} 
else 
{ 
JOptionPane.showMessageDialog(frame, "Insufficient funds."); 
} 
} 
catch (NumberFormatException ex) 
{ 
JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numerical value."); 
} 
break; 
} 
} 
} 
private void updateBalanceLabel() 
{ 
balanceLabel.setText("Account Balance: $" + accountBalance); 
} 
public static void main(String[] args) 
{ 
SwingUtilities.invokeLater(ATMApp::new); 
} 
}