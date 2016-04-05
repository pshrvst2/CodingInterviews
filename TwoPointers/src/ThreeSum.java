import java.util.ArrayList;
import java.util.Collections;


public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(-6);
		a.add(1);
		a.add(-4);
		a.add(-1);
		a.add(8);
		a.add(-4);
		a.add(9);
		a.add(0);
		a.add(-3);
		a.add(7);
		a.add(-3);
		a.add(2);
		a.add(-4);
		a.add(-2);
		a.add(3);
		a.add(-4);
		a.add(10);
		a.add(0);
		a.add(9);
		a.add(6);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(2);
		
		threeSumClosest(a,-3);

	}
	
public static int threeSumClosest(ArrayList<Integer> a, int b) {
	    
	Collections.sort(a);
    int closestSum = b;
    int bLeft = b;
    int bRight = b;
    int n = a.size();
    int i = 0;
    boolean found = false;
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(b);
    
    for(i = 0; i <= n-3; i++)
    {
        int p = a.get(i);
        int start = i+1;
        int end = n-1;
        while (start < end)
        {
            int q = a.get(start);
            int r = a.get(end);
            int sum = p+q+r;
            if (list.contains(sum))
            {
                found = true;
                closestSum = sum;
                break;
                // output a, b, c;
                // Continue search for all triplet combinations summing to zero.
                // start = start + 1
                // end = end - 1
            }
            else if (sum > b)
            {
                end = end - 1;
            }
            else
            {
                start = start + 1;
            }
        }
        
        if(found)
            break;
            
        if(i==(n-3))
        {
            i = -1;
            list.add(--bLeft);
            list.add(++bRight);
        }
    }
    return closestSum;
	}

}
