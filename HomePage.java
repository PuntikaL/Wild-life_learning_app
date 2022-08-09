import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

import MiniFunctions.BasketGame;
import MiniFunctions.TypeGame;

public class HomePage extends JPanel implements ActionListener{
	private JButton[] buttons = new JButton[9];
	private JLabel heading = new JLabel("Wild Life"); 
	JLabel[] blanks = new JLabel[9];
	JPanel picPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel functionPanel = new JPanel();
	public ImageIcon[] images = new ImageIcon[9];
	
	
	JButton gameButton = new JButton("Let's Play!");
	JButton quizButton = new JButton("Let's Quiz!");
	
	public HomePage(){
		JFrame hpFrame = new JFrame("My Home Page");
		hpFrame.setSize(570, 750);
		hpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hpFrame.setLocationRelativeTo(null);
		
		heading.setFont(new Font("Verdana", Font.PLAIN, 35));
		topPanel.setLayout(new GridLayout(3,3));
		topPanel.add(heading);
		for(int i=0;i<9;i++) {
			if(i==4) {
				topPanel.add(heading);
			}
			else if (i == 2 || i == 8) {
				blanks[i] = new JLabel("");
				topPanel.add(blanks[i]);
			}
			else {
				blanks[i] = new JLabel("\t");
				topPanel.add(blanks[i]);
			}
		}
		
		gameButton.setPreferredSize(new Dimension(100,50));
		functionPanel.setLayout(new GridLayout(2,1));
		functionPanel.add(gameButton);
		functionPanel.add(quizButton);
		picPanel.setLayout(new GridLayout(3,3));
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(picPanel, BorderLayout.CENTER);
		this.add(functionPanel, BorderLayout.SOUTH);
		
		images[0] = new ImageIcon("Wild Animals/ThisRedPanda.jpg");
		images[1] = new ImageIcon("Wild Animals/ThisSeaOtter.png");
		images[2] = new ImageIcon("Wild Animals/ThisRabbits.jpg");
		images[3] = new ImageIcon("Wild Animals/ThisKangaroo.jpg");
		images[4] = new ImageIcon("Wild Animals/ThisHansomeHorse.jpg");
		images[5] = new ImageIcon("Wild Animals/ThisLoneWolf.jpg");
		images[6] = new ImageIcon("Wild Animals/ThisChickadeeBird.jpg");
		images[7] = new ImageIcon("Wild Animals/ThisBeaver.jpg");
		images[8] = new ImageIcon("Wild Animals/CuteUnicorn.jpg");
		
		//if there're any mistake with work directory, please use the comment code below to load image(it will take some more time to compile)
//		try {
//			images[0] = new ImageIcon(new URL("https://i.ibb.co/SmFCSZm/This-Red-Panda.jpg"));
//			images[1] = new ImageIcon(new URL("https://i.ibb.co/jWvNx3G/This-Sea-Otter.png"));
//			images[2] = new ImageIcon(new URL("https://i.ibb.co/wyQ4Kmm/This-Rabbits.jpg"));
//			images[3] = new ImageIcon(new URL("https://i.ibb.co/Gxbb4VF/This-Kangaroo.jpg"));
//			images[4] = new ImageIcon(new URL("https://i.ibb.co/2cy3HYd/This-Hansome-Horse.jpg"));
//			images[5] = new ImageIcon(new URL("https://i.ibb.co/hRGMsMX/This-Lone-Wolf.jpg"));
//			images[6] = new ImageIcon(new URL("https://i.ibb.co/YfLYMtP/This-Chickadee-Bird.jpg"));
//			images[7] = new ImageIcon(new URL("https://i.ibb.co/rc0N0hk/This-Beaver.jpg"));
//			images[8] = new ImageIcon(new URL("https://i.ibb.co/zZyVxMS/Cute-Unicorn.jpg"));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		
		for(int i = 0; i< 9 ;i++) {
			buttons[i] = new JButton(images[i]);
			buttons[i].addActionListener(this);
			picPanel.add(buttons[i]);
			//System.out.println("Button"+(i+1)+"is created");
		}
		
		gameButton.addActionListener(this);
		quizButton.addActionListener(this);
		
		hpFrame.add(this);
		hpFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttons[0]) {
			InfoPanel redPanda = new InfoPanel(0, images[0]);
		}
		if(e.getSource()==buttons[1]) {
			InfoPanel SeaOtter = new InfoPanel(1, images[1]);
		}
		if(e.getSource()==buttons[2]) {
			InfoPanel Rabbit = new InfoPanel(2, images[2]);
		}
		if(e.getSource()==buttons[3]) {
			InfoPanel Kangaroo = new InfoPanel(3, images[3]);
		}
		if(e.getSource()==buttons[4]) {
			InfoPanel Horse = new InfoPanel(4, images[4]);
		}
		if(e.getSource()==buttons[5]) {
			InfoPanel Wolf = new InfoPanel(5, images[5]);
		}
		if(e.getSource()==buttons[6]) {
			InfoPanel Chickadee = new InfoPanel(6, images[6]);
		}
		if(e.getSource()==buttons[7]) {
			InfoPanel Beaver = new InfoPanel(7, images[7]);
		}
		if(e.getSource()==buttons[8]) {
			InfoPanel Unicorn = new InfoPanel(8, images[8]);
		}
		if(e.getSource()==gameButton) {
			int temp = new Random().nextInt(8);
			TypeGame whoAmI = new TypeGame(temp, images[temp]);
		}
		if(e.getSource()==quizButton) {
			BasketGame popquiz = new BasketGame();
		}
	}
}
