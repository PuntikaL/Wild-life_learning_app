package MiniFunctions;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BasketGame extends JPanel implements ActionListener, KeyListener, MouseListener{
	//It might be hard trying to play this game cause the pictures is a little bit small. so I suggest 
	//memorizing the picture in animalIcon first. Sorry for inconvenient. Good Luck!
	
	Timer gameTimer = new Timer(50, this);
	boolean play = false;
	private String[] funFact = new String[9];
	private Image[] vectorImg = new Image[9]; 
	int which = new Random().nextInt(9);
	int choice = new Random().nextInt(9);
	int sizeImg = 0;
	int change = new Random().nextInt(3);
	static int correct = 0;
	//private Image bgImg;
	
	JPanel lowPanel = new JPanel();
	JLabel rule  = new JLabel("<html>you will control your pink basket with key A and D. collect yellow ball to gain score but "
			+ "avoid the blue objects. Please keep in mind that the more animal pictures, suit the question on the right lower coner, you get, "
			+ "the more score you earn</html>");
	JLabel scoreLabel = new JLabel();
	JPanel detail = new JPanel();
	JLabel howToStart = new JLabel("Click in the frame to Start");
	JLabel question = new JLabel();
	
	int heightBasket = 60;
	int widthBasket = 50;
	int xBasket = 200;
	int yBasket = 320;
	
	int radius = 7;
	int rectWidth = 15;
	
	int xRect = new Random().nextInt(700-30);
	int yRect = 0 ;
	int xBall = new Random().nextInt(690);
	int yBall = 0;
	int xImg = new Random().nextInt(700-30);
	int yImg = 10;
	int xBall2 = new Random().nextInt(690);
	int yBall2 = 0;
	
	static int speed1 = new Random().nextInt(10)+5;
	static int speed2 = new Random().nextInt(10)+5;
	static int speed3 = new Random().nextInt(10)+5;
	static int speed4 = new Random().nextInt(10)+5;
	
	static int score = 0;
	static double temp = 60; //implicit casting
	static int ticktok = (int)temp; //explicit casting
	JLabel timeLabel = new JLabel("Time : "+ticktok);
	
	public BasketGame(){
		funFact[0] = "<html>Which animal: stand up when being provoked or threatened!</html>";
		funFact[1] = "<html>Which animal: sleep on their backs!</html>";
		funFact[2] = "<html>Which animal: that their teeth never stop growing!</html>";
		funFact[3] = "<html>Which animal: can't walk backwards!</html>";
		funFact[4] = "<html>Which animal: have a nearly 360 degree field of vision!</html>";
		funFact[5] = "<html>Which animal: that their kids are born deaf and blind with bright blue eyes!</html>";
		funFact[6] = "<html>Which animal: weigh less than one-half of an ounce!<html>";
		funFact[7] = "<html>Which animal: slap their tails on the water to indicate danger!</html>";
		funFact[8] = "<html>Which animal: are afraid of Labradors!</html>";
		
		vectorImg[0] = new ImageIcon("animalIcon/red-panda.png").getImage();
		vectorImg[1] = new ImageIcon("animalIcon/sea-otter.png").getImage();
		vectorImg[2] = new ImageIcon("animalIcon/rabbit.png").getImage();
		vectorImg[3] = new ImageIcon("animalIcon/kangaroo.png").getImage();
		vectorImg[4] = new ImageIcon("animalIcon/horse.png").getImage();
		vectorImg[5] = new ImageIcon("animalIcon/wolf.png").getImage();
		vectorImg[6] = new ImageIcon("animalIcon/chickadee.png").getImage();
		vectorImg[7] = new ImageIcon("animalIcon/beaver.png").getImage();
		vectorImg[8] = new ImageIcon("animalIcon/unicorn.png").getImage();
		//bgImg = new ImageIcon("animalIcon/forrest2.png").getImage();
		
		question.setText(funFact[which]);
		
		rule.setForeground(Color.GRAY);
		question.setForeground(Color.RED);
		scoreLabel.setText("Score: "+score);
		lowPanel.setLayout(new GridLayout(2,1));
		detail.setLayout(new GridLayout(1,4));
		detail.add(timeLabel);
		detail.add(scoreLabel);
		detail.add(howToStart);
		detail.add(question);
		lowPanel.add(detail);
		lowPanel.add(rule);
		this.setLayout(new BorderLayout());
		this.add(lowPanel, BorderLayout.SOUTH);
		JFrame fieldFrame = new JFrame();
		fieldFrame.setTitle("Fun Fact!!");
		fieldFrame.setSize(700,470);
		fieldFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fieldFrame.setLocationRelativeTo(null);
		fieldFrame.add(this);
		fieldFrame.setVisible(true);
		fieldFrame.addKeyListener(this);
		fieldFrame.addMouseListener(this);
	}

	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.setColor(new Color(120, 161, 132));
		setBackground(new Color(120, 161, 132));
		//g.drawImage(bgImg, 0, 0, null);
		g.setColor(Color.BLUE);
		g.fillRect(xRect,yRect,rectWidth,rectWidth);
		g.setColor(Color.YELLOW);
		g.fillOval(xBall, yBall, 2*radius, 2*radius);
		g.fillOval(xBall2, yBall2, 2*radius, 2*radius);
		g.setColor(Color.PINK);
		g.fillRect(xBasket,yBasket, heightBasket, widthBasket);
		g.drawImage(vectorImg[choice], xImg, yImg, this);
	}
	//Methods
	
	boolean collect(int x,int y) {
		if(y+sizeImg >=315 && x+sizeImg>=xBasket && x<=xBasket+widthBasket) {
			return true;
		}else return false;
	}
	
	
	//Events
	@Override
	public void actionPerformed(ActionEvent e) {
		if(yImg>=0 && yImg<=340) {
			yImg = yImg+speed3;
			if(collect(xImg,yImg)) {
				if(which==choice) {
					score = (int)(score+Math.pow(2, correct)); //explicit casting+math function
					correct = correct+1;
					which = new Random().nextInt(9);
					question.setText(funFact[which]);
				}
				else if(which!=choice){
					score = score-5;
				}
				change = new Random().nextInt(3);
				if(change==0) choice = which;
				else choice = new Random().nextInt(9);
				yImg = 0;
				xImg = new Random().nextInt(670);
				speed3 = new Random().nextInt(10)+5;
				scoreLabel.setText("Score: "+score);
				repaint();
			}
		}
		if(yImg>340) {
			change = new Random().nextInt(3);
			if(change==0) choice = which;
			else choice = new Random().nextInt(9);
			yImg = 0;
			xImg = new Random().nextInt(670);
			speed3 = new Random().nextInt(10)+5;
			repaint();
		}
		
		if(yBall>=0 && yBall <=345) {
			yBall = yBall+speed1;
			if(yBall+radius >= 340 && xBall+radius>=xBasket && xBall+radius<= xBasket+widthBasket) {
				score = score+1;
				yBall = 0;
				xBall = new Random().nextInt(670);
				speed1 = new Random().nextInt(10)+5;
				scoreLabel.setText("Score: "+score);
				repaint();
			}
			
		}
		
		if(yBall+radius >= 345){
			yBall = 0;
			xBall = new Random().nextInt(670);
			speed1 = new Random().nextInt(10)+5;
		}
		
		if(yBall2>=0 && yBall2 <=345) {
			yBall2 = yBall2+speed4;
			if(yBall2+radius >= 340 && xBall2+radius>=xBasket && xBall2+radius<= xBasket+widthBasket) {
				score = score+1;
				yBall2 = 0;
				xBall2 = new Random().nextInt(670);
				speed4 = new Random().nextInt(10)+5;
				scoreLabel.setText("Score: "+score);
				repaint();
			}
			
		}
		if(yBall2+radius >= 345){
			yBall2 = 0;
			xBall2 = new Random().nextInt(670);
			speed4 = new Random().nextInt(10)+5;
		}
		
		if(yRect>=0 && yRect<=345) {
			yRect = yRect+speed2;
			if(yRect+rectWidth >= 340 && xRect+rectWidth>=xBasket && xRect<= xBasket+widthBasket) {
				score = score-2;
				yRect = 0;
				xRect = new Random().nextInt(700-30);
				speed2 = new Random().nextInt(10)+5;
				scoreLabel.setText("Score: "+score);
				repaint();
			}
		}
		if(yRect+rectWidth >= 345){
			yRect = 0;
			xRect = new Random().nextInt(700-30);
			speed2 = new Random().nextInt(10)+5;
		}
	
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == 'A'||e.getKeyChar()== 'a') {
				if(xBasket>= 5 && xBasket <= 620){
					xBasket = xBasket-15; 
				}
				if(xBasket<=0) {
					xBasket = 10;
				}
			}
			else if(e.getKeyChar() == 'D'||e.getKeyChar()== 'd') {
				if(xBasket>= 5 && xBasket <= 620){
					xBasket = xBasket+15; 
				}
				if(xBasket>=625) {
					xBasket = 620;
				}
			}
			repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		play = true;
		CountDown start = new CountDown();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
