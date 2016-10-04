import java.util.ArrayList;
import java.util.List;



public class MaxGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Testing
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(3);
		newList.add(5);
		newList.add(4);
		newList.add(2);
		System.out.println(maximumGap(newList));
		

	}
	
public static int maximumGap(final List<Integer> a) {
	     if(a==null || a.size()==0)
	        return -1;
	    
	    int[] leftMin = new int[a.size()];
	    int[] rightMax = new int[a.size()];
	    leftMin[0] = a.get(0);
	    rightMax[a.size()-1] = a.get(a.size()-1);
	    
	    for(int i = 1; i < a.size(); i++)
	    {
	        if(leftMin[i-1] < a.get(i))
	            leftMin[i] = leftMin[i-1];
	        else
	            leftMin[i] = a.get(i);
	    }
	    
	    for(int i = a.size()-2; i >=0; i--)
	    {
	        if(rightMax[i+1] > a.get(i))
	            rightMax[i] = rightMax[i+1];
	        else
	            rightMax[i] = a.get(i);
	    }
	    
	    int i =0; int j =0;
	    int maxGap = 0;
	    while(i<a.size() && j<a.size())
	    {
	        if(leftMin[i] < rightMax[j])
	        {
	            if(maxGap <= (j-i))
	                maxGap = j-i;
	                
	            j++;
	        }
	        else
	        {
	            i++;
	            
	        }
	    }
	    
	    return maxGap;
	}

}
