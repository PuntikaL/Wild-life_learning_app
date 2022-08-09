package MiniFunctions;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.*;


public class CountDown extends BasketGame{
	CountDown(){
		super.gameTimer.start();
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	        final Runnable runnable = new Runnable() {
	            int countdownStarter = 60;
	            public void run() {
	                countdownStarter--;
	                ticktok--;
	                timeLabel.setText("Time : "+(ticktok+1));
	                if (countdownStarter < 0) {
	                    //System.out.println("Game Over!");
	                    scheduler.shutdown();
	                    gameTimer.stop();
	                    ticktok = 60;
	                    JFrame popUp = new JFrame();
	    				JOptionPane.showMessageDialog(popUp, "Congrats!! Your score is: "+score+". And you got "+correct+" correct answers. Don't forget to take a review!");
	                }
	            }
	        };
	        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
	 }
}
