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
		
		LinkedList<Ring>[] allColumns = new LinkedList[3];
		for(int i = 0; i < 3; i++) { //initialize elements of the array before manipulating them
			allColumns[i] = new LinkedList<Ring>();
		}
		
		for(int size = 9, stackIndex = 1; size > 0; size--, stackIndex++) {
			allColumns[0].add(new Ring(size, 0, size, g));
			allColumns[0].get(stackIndex-1).drawRing();
		}
		
		Solver.moveStack(9, 0, 1, 2, allColumns);
		
		
		//allColumns[0].getLast().moveRing(allColumns, 0, 1);
		//allColumns[1].getLast().drawRing();
		
		//for(int i = 9, j = 0; i > 0; i--, j++) {
			//allColumns[0].get(j).drawRing();
		//}
		
	}	
}
