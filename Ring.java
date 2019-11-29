import java.awt.*;
import java.util.*;

public class Ring {

	int size, column, stack;
	int x, y, width;
	Color color;
	
	public Ring (int sizeInput, int columnInput, int stackInput) {
		
		size = sizeInput; // 1<=Size<=9
		width = (size+1)*20; //40<=Width<=180, with a Base w/ a Width of 200
		
		column = columnInput; //Which Column the Ring's on; 1 (far left) to 3 (far right)
		stack = stackInput; //The Ring's position (bottom to top) in the Stack
		
		color = new Color(size*18, size*18, size*28); //Pseudo-random Color for each Size
		
	}
	
	public void drawRing(Graphics g) {
		
		g.setColor(this.color);
		
		x = 140 + 250*(column-1) - 10*size; //Center of Base + Offset Base - Width Offset (to Center)   
		y = 380 - 20*(stack); //I'm... a modular Tower of Hanoi is /not/ the focus of this exercise. This is a driver, for heck's sake.
		
		g.fillRoundRect(x, y, width, 20, 10, 10);
		
	}
	
	public void moveRing(LinkedList<Ring> oldColumn, LinkedList<Ring> newColumn, int columnIndex) {
		newColumn.add(this);
		stack = newColumn.indexOf(this)+1;
		column = columnIndex;
		
		oldColumn.removeLast(); //'First' is the top ring
		
		for(int i = 0; i < oldColumn.size(); i++) {
			oldColumn.get(i).setStack(i+1); //Move the rest of the rings down
										  //Because, y'know, Gravity.
		}
	}
	
	public void setStack(int newStack) {
		stack = newStack; //Yes, we could incorporate this in the 'moveRing' section
		//however, implementing it would mean overhauling the already-finicky positioning code. 
		//We're leaving it in and leaving it up to the handler to take care of reassigning the stack
		// order.
	}
	
}
