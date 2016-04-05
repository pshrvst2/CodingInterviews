import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LongestSequenceZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> x = new ArrayList<Integer>();
		//x.add(1);x.add(2);x.add(-2);x.add(4);x.add(-4);x.add(-4);
		//x.add(1);x.add(2);x.add(-3);x.add(3);
		// -19, 8, 2, -8, 19, 5, -2, -23 
		//x.add(0);x.add(-19);x.add(8);x.add(2);x.add(-8);x.add(19);x.add(5);x.add(2);x.add(-23);
		x.add(0);x.add(-10);x.add(0);
		lszero(x);

	}
	
public static ArrayList<Integer> lszero(ArrayList<Integer> a) 
{
        
        ArrayList<Integer> retList = new ArrayList<Integer>();
        
        if(a==null || a.size()==0)
            return retList;
        
        int i;
		int k = i = 0;
        HashMap<Integer, ArrayList<Integer>> lenMap = new HashMap<Integer, ArrayList<Integer>>();
        int maxLen = 0;
        boolean newSeq = true;
        ArrayList<Integer> seqList;
        int sum = 0;
        while(k<a.size())
        {
            i = k+1;
            seqList = new ArrayList<Integer>();
            seqList.add(a.get(k));
            sum = a.get(k);
            if(sum==0)
            {
            	if(!lenMap.containsKey(1))
                {
            		ArrayList<Integer> l = new ArrayList<>();
            		l.add(sum);
            		lenMap.put(1, l);
            		maxLen = 1;
                }
            }
            newSeq = true;
            while(i<a.size())
            {
                if(newSeq && !(i==k+1))
                {
                    seqList = new ArrayList<Integer>();
                    newSeq = false;
                }
            
                int num = a.get(i);
                seqList.add(num);
                sum = sum + num;
                if(sum==0)
                {
                    int size = seqList.size();
                    if(!lenMap.containsKey(size))
                    {
                    	ArrayList<Integer> nl = new ArrayList<Integer>();
                    	for(Integer in : seqList)
                    	{
                    		nl.add(in);
                    	}
                        lenMap.put(size, nl);
                    }
                    newSeq = false;
                    if(size>maxLen)
                        maxLen = size;
                }
                else
                {
                	newSeq = false;
                }
                i++;
            }
            k++;
        }
        
        if(lenMap.size()==0)
        {
        	return new ArrayList<Integer>();
        }
        
        return lenMap.get(maxLen);
    }

}
