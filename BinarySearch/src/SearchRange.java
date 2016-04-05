import java.util.ArrayList;
import java.util.List;


public class SearchRange {

	public static void main(String[] args) {
		
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		searchRange(a,1);

	}
	
	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		    ArrayList<Integer> r = new ArrayList<Integer>();
		    
		    if(a.size()==0)
		        return r;
		    
		    
		    int start = 0;
		    int end = a.size()-1;
		    
		    int mid = (start+end)/2;
		    int index = 0;
		    int startInd = -1;
		    int endInd = -1;
		    boolean found = false;
		    
		    while(start<=end)
		    {
		        if(a.get(mid)==b)
		        {
		            index = mid;
		            found = true;
		            break;
		        }
		        else if(a.get(mid)>b)
		        {
		            end = mid - 1;
		            mid = (start+end)/2;
		        }
		        else
		        {
		            start = mid + 1;
		            mid = (start+end)/2;
		        }
		    }
		    
		    if(!found)
		    {
		        r.add(-1);
		        r.add(-1);
		        return r;
		    }
		    
		    while(a.get(index)==b)
		    {
		        index--;
		        if(index<0)
		    		break;
		    }
		    startInd = ++index;
		    
		    while(a.get(index)==b)
		    {
		        index++;
		        if(index > (a.size()-1))
		        	break;
		        	
		    }
		    endInd = --index;
		    
		    r.add(startInd);
		    r.add(endInd);
		    
		    return r;
		}

}
