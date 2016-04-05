import java.util.ArrayList;


public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);a.add(0);a.add(0);/*a.add(0);a.add(0);*/
		a.add(1);a.add(1);/*a.add(1);a.add(1);*/
		a.add(2);a.add(2);/*a.add(2);*/a.add(3);
		
		//removeDuplicates(a);
		//removeDuplicates_prob2(a);
		//removeDuplicates_prob2_2(a);
		removeDuplicates_prob2(a);

	}
	
	public static int removeDuplicates2(ArrayList<Integer> a) {
	    
	    int prev =0;
	    int curr = 0;
	    int len = a.size();
	    int size = a.size();
	    
	    if(a.size()==0)
	        return 0;
	    ArrayList<Integer> index = new ArrayList<Integer>();
	    
	    int i =0;
	    int del = 0;
	    while(size>0)
	    {
	        curr = a.get(i-del);
	        
	        if(i>0 && prev==curr)
	        {
	            --len;
	            index.add(i-del);
	            a.remove(a.get(i-del));
	            del++;
	        }
	        
	        prev = curr;
	        i++;
	        --size;
	    }
	    
	    /*for(Integer x : index)
	    {
	        //a.add(0);
	        a.remove(x);
	    }*/
	   /* int t = a.size();
	    
	    for(int j = t-1; j>=len ; j--)
	    {
	        a.remove(j);
	    }*/
	    
	    return len;
	}
	
	public static int removeDuplicates(ArrayList<Integer> A) {
	    int index = 1;
	    int n = A.size();
	    
	    if (A == null || A.size() == 0)
	        return 0;
	    
	    for (int i = 1; i < n; i++) {
	        
	        if (A.get(i).intValue() != A.get(i - 1).intValue()) {
	            int temp = A.get(index);
	            A.set(index, A.get(i));
	            index++;
	        }
	    }
	    
	    return index;
	    
	}
	
public static int removeDuplicates_prob2(ArrayList<Integer> a) {
	int index = 1;
    int count = 1;
    int n = a.size();
    
    for (int i = 1; i < n; i++) 
    {
    	int curr = a.get(i).intValue();
    	int prev = a.get(i-1).intValue();
        
    	if (curr == prev && count < 2) 
        {
            a.set(index, a.get(i));
            count++;
            index++;
        } 
    	else if (curr != prev) 
    	{
            a.set(index, curr);
            count = 1;
            index++;
        }
    }
    
    
    return index;
	}

public static int removeDuplicates_prob2_2(ArrayList<Integer> a) {
    
    int prev1 =0;
    int prev2 =0;
    int curr = 0;
    int len = a.size();
    int size = a.size();
    
    if(a.size()==0)
        return 0;
    ArrayList<Integer> index = new ArrayList<Integer>();
    
    int i =0;
    int del = 0;
    while(size>0)
    {
        curr = a.get(i-del);
        
        if(i>1 && prev1==curr && prev2==curr)
        {
            --len;
            index.add(i-del);
            a.remove(a.get(i-del));
            del++;
        }
        prev2 = prev1;
        prev1 = curr;
        i++;
        --size;
    }

    return len;
}

}
