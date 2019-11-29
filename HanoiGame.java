import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HanoiGame extends Canvas {

	public static void main(String args[]) {
				
		JFrame frame = new JFrame("Towers of Hanoi");
        Canvas canvas = new HanoiGame();
        canvas.setSize(800, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.DARK_GRAY);
		
		for(int i = 0; i < 3; i++) {
			
			g.fillRect(50+(i*250), 380, 200, 20); //Bases
			g.fillRect(140+(i*250), 100, 20, 300); //Columns
			
		}
		
		g.setColor(Color.blue);
		//for(int width = 180, x = 60, y = 360; width >= 40; width-=20, x+=10, y-=20) {
			//g.fillRoundRect(x, y, width, 20, 10, 10);
		//}
		
		//for(int i = 1; i < 10; i++) {
			//Ring mofo = new Ring(i, 1, i);
			//mofo.drawRing(g);
		//}
		LinkedList<Ring> columnA = new LinkedList<Ring>();
		LinkedList<Ring> columnB = new LinkedList<Ring>();
		LinkedList<Ring> columnC = new LinkedList<Ring>();
		
		for(int i = 9, j = 0; i > 0; i--, j++) {
			columnA.add(new Ring(i, 1, i));
			//columnA.get(j).drawRing(g);
		}
		
		columnA.getLast().moveRing(columnA, columnB, 2);
		columnB.getLast().drawRing(g);
		
		for(int i = 9, j = 0; i > 0; i--, j++) {
		//	columnA.add(new Ring(i, 1, i));
			columnA.get(j).drawRing(g);
		}
		
	}
}
