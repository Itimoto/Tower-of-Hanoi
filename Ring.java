import java.awt.*;
import java.util.*;
import java.util.Random;

public class Ring {

	int size, column, stack;
	static int maxSize = 0;
	int x, y, width;
	Color color;
	Graphics g;
	
	Random rnGesus = new Random();
	
	public Ring (int sizeInput, int columnInput, int stackInput, Graphics passedGraphics) {
		
		size = sizeInput; // 1<=Size<=9
		if(size > maxSize) {
			maxSize = size; //For modular rings
		}
		width = (size+1)*20; //40<=Width<=180, with a Base w/ a Width of 200
		
		column = columnInput; //Which Column the Ring's on; 1 (far left) to 3 (far right)
		stack = stackInput; //The Ring's position (bottom to top) in the Stack
		
		//color = new Color(size*(5+rnGesus.nextInt(18)), size*(20+rnGesus.nextInt(8)), size*(20+rnGesus.nextInt(8))); //Pseudo-random Color for each Size
		color = new Color(size*18, size*18, size*28); //A pretty purple within the range of 1<=Size<=9
		//color = new Color(rnGesus.nextInt(255), rnGesus.nextInt(255), rnGesus.nextInt(255));
		
		g = passedGraphics; //to simplify later instances
		
	}
	
	public void drawRing() {
		
		g.setColor(this.color);
		
		x = 140 + 250*(column) - 10*size; //Center of Base + Offset Base - Width Offset (to Center)   
		y = 380 + (20*(stack-1)-(maxSize*20)); //This is now modular
		
		g.fillRoundRect(x, y, width, 20, 10, 10);
		
	}
	
	public void eraseRing() {
		g.setColor(new Color(240, 240, 240));
		g.fillRect(x, y, width, 20);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(140+250*(column), 380+(20*stack-200), 20, 20);
		
	}
	
	
	public void moveRing(LinkedList<Ring>[] columnArray, int start, int end) {
		this.eraseRing();
		columnArray[end].add(columnArray[start].getLast());
		stack = maxSize-columnArray[end].indexOf(this);
		column = end;
		
		columnArray[start].removeLast(); //'First' is the top ring
		
		for(int i = 0; i < columnArray[start].size(); i++) {
			columnArray[start].get(i).eraseRing();
			columnArray[start].get(i).setStack(maxSize-i); //Move the rest of the rings down
										  //Because, y'know, Gravity.
			columnArray[start].get(i).drawRing();
		}
		
		this.drawRing();
	}
	
	public void setStack(int newStack) {
		stack = newStack; //Yes, we could incorporate this in the 'moveRing' section
		//however, implementing it would mean overhauling the already-finicky positioning code. 
		//We're leaving it in and leaving it up to the handler to take care of reassigning the stack
		// order.
		//From Future-Past Me: I figured it out nevermind
	}
	public void setColumn(int newColumn) {
		column = newColumn;
	}
	
}
