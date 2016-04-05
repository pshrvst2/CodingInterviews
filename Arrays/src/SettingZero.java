import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class SettingZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int i = 0;
		int j = 1;
		int num = 1;
		
		while(i<=1)
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(j<=2)
			{
				//list.add(num++);
				list.add(0);
				j++;
			}
			a.add(list);
			j=1;
			i++;
		}
		
		setZeroes(a);

	}
	
public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    
	    boolean setZero = false;
	    Set<Integer> rowSet = new HashSet<Integer>();
	    Set<Integer> colSet = new HashSet<Integer>();
	    Integer row = 0;
	    Integer col = 0;
	    
	    for(ArrayList<Integer> list : a)
	    {
	        boolean hasZero = false;
	        for (Integer in : list)
	        {
	            if(in == 0)
	            {
	                colSet.add(col);
	                hasZero = true;
	            }
	            col = col + 1;
	        }
	        
	        if(hasZero)
	            rowSet.add(row);
	        
	        col=0;
	        row++;
	    }
	    
	    row = 0;
	    col = 0;
	    
	    for(ArrayList<Integer> list : a)
	    {
	        boolean allZ = false;
	        if(rowSet.contains(row))
	        {
	            allZ = true;
	        }
	        
	        for (Integer in : list)
	        {
	            if(allZ)
	            {
	            	list.remove(0);
	            	list.add(3);
	            }
	            else if(colSet.contains(col))
	            {
	            	list.set(0,0);
	            	//list.add(0);
	            	// check my solution on interviewbit
	            }
	            col++;
	        }
	        
	        col=0;
	        row++;
	    }
	}

}
