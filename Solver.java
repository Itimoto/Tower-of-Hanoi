import java.util.Scanner;
import java.util.*;
import java.awt.*;

public class Solver {

	public Solver () {
		
	}
	
	public static void moveStack (int n, int position, int swap, int target, LinkedList<Ring>[] allColumns) {
		
		Scanner stepper = new Scanner(System.in);
		
		if(n == 1) {
			allColumns[position].getLast().moveRing(allColumns, position, target);
			stepper.nextLine();
		} else {
			moveStack(n-1, position, target, swap, allColumns);
			allColumns[position].getLast().moveRing(allColumns, position, target); //NOTE: this n-1 refers to the array listing referencing the CURRENT Ring, not the one above it
			stepper.nextLine();
			moveStack(n-1, swap, position, target, allColumns);
		}
		System.out.println("out of "+n);
	}
	
}
