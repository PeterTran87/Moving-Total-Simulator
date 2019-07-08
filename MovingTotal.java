import java.util.ArrayList;

public class MovingTotal {
    private ArrayList<Integer> movingTotal = new ArrayList<Integer>();
    private boolean initialised = false;
    private int last;
    private int secondLast;
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
    	if (list.length == 1) {
    		int total = list[0] + last + secondLast;
			movingTotal.add(total);
			last = secondLast;
			secondLast = list[0];
		} else {
			if (!initialised) {
				for (int i = 0; i < list.length - 2; i++) {
					last = list[i+2];
					secondLast = list[i+1];
					int total = list[i] + last + secondLast;
					movingTotal.add(total);
				}
				initialised = true;
			} else {
				for (int number: list) {
					int total = number + last + secondLast;
					last = secondLast;
					secondLast = number;
					movingTotal.add(total);
				}
			}
		}
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        if (movingTotal.contains(total)) return true;
        else return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });
        movingTotal.append(new int[] { 4, 10, 4, 13, 5, 6, 7, 8, 9, 10 });
        
        int i = 0;
        while (i < 50) {
        	if (movingTotal.contains(i)) System.out.println("Contains " + i + ".");
        	i++;
        }
    }
}