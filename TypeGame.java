package MiniFunctions;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class TypeGame extends JPanel implements ActionListener{
	private JLabel headText = new JLabel("Who Am I?");
	protected JLabel hint = new JLabel();
	JTextField answer = new JTextField("");
	String keyWord;
	
	public TypeGame(int num, ImageIcon me){
		JLabel myPic = new JLabel(me);
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("Let's Guess");
		gameFrame.setSize(400,400);
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		gameFrame.add(this);
		
		this.setLayout(new GridLayout(4,1));
		headText.setFont(new Font("Verdana", Font.PLAIN, 25));
		this.add(headText);
		
		this.add(myPic);
		if(num == 0) {
			hint.setText("9 Letters(+space)");
			keyWord = "red panda";
		}
		else if(num == 1) {
			hint.setText("9 Letters(+space)");
			keyWord = "sea otter";
		}
		else if(num == 2) {
			hint.setText("6 Letters");
			keyWord = "rabbit";
		}
		else if(num == 3) {
			hint.setText("8 letters");
			keyWord = "kangaroo";
		}
		else if(num == 4) {
			hint.setText("5 letters");
			keyWord = "horse";
		}
		else if(num == 5) {
			hint.setText("4 letters");
			keyWord = "wolf";
		}
		else if(num == 6) {
			hint.setText("9 letters");
			keyWord = "chickadee";
		}
		else if(num == 7) {
			hint.setText("6 letters");
			keyWord = "beaver";
		}
		else if(num == 8) {
			hint.setText("7 letters");
			keyWord = "unicorn";
		}
		
		this.add(hint);
		this.add(answer); //gui
		
		answer.addActionListener(this); //register
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==answer) {
			String ans = (answer.getText()).toLowerCase();
			ans = ans.toLowerCase();
			if(ans.equals(keyWord)) {
				JFrame popUp = new JFrame();
				JOptionPane.showMessageDialog(popUp,"Good Job, "+ans+" is correct!");
			}
			else { 
				JFrame popUp = new JFrame();
				JOptionPane.showMessageDialog(popUp, ans+" is incorrect. Don't give up, though!");
			}
		}
	}
}
