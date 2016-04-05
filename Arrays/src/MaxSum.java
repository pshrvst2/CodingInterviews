import java.util.ArrayList;
import java.util.List;


public class MaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		//{-2,1,-3,4,-1,2,1,-5,4}
		list.add(-2);
		list.add(1);
		list.add(-3);
		list.add(4);
		list.add(-1);
		list.add(2);
		list.add(1);
		list.add(-5);
		list.add(4);
		
		System.out.println(maxSubArray(list));

	}

public static int maxSubArray(final List<Integer> a) {
	    
	    if(a.size()==0 || a==null)
	        return 0;
	    
	    int currSum = a.get(0);
	    int maxSum = a.get(0);
	    
	    for(int i = 1; i < a.size(); i++)
	    {
	    	int curr = a.get(i);
	        currSum = Math.max(currSum+curr, curr);
	        maxSum = Math.max(currSum, maxSum);
	    }
	    
	    return maxSum;
	}
}
