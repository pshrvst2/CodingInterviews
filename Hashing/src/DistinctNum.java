import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class DistinctNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(1);
		num.add(3);
		num.add(4);
		num.add(3);
		
		ArrayList<Integer> x = dNums(num, 3);

	}
	
public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        
        Integer index = -1;
        ArrayList<Integer> retList = new ArrayList<Integer>();
        //HashMap<Integer, Set<Integer>> disMap = new HashMap<Integer, Set<Integer>>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int i = 0;
        int j = 0;
        //Set<Integer> set = new HashSet<Integer>();
        while(i < A.size())
        {
            if(j%B==0)
            {
                //set = new HashSet<Integer>();
            	
                index++;
                
                if(j>0)
                	i=i-B+1;
            }                      
            
            String a = map.get(index);
        	if(a==null)
        		a = "";
        	a = a + A.get(i).toString() +",";
        	map.put(index,a);
            
            i++;
            j++;
        }
        
        for(Map.Entry<Integer, String> entry : map.entrySet())
        {
        	String temp[] = entry.getValue().split(",");
        	HashSet<String> hs = new HashSet<String>();
        	for(String x : temp)
        	{
        		hs.add(x);
        	}
            retList.add(hs.size());
        }
        
        return retList;
        
    }



/*
 * vector<int> Solution::dNums(vector<int> &A, int B) {
    assert(B<=A.size());
    int n=A.size();
    vector<int> ret;
    unordered_map <int, int> m;
    for(int i=0; i<n; i++){
        //increase key
        m[A[i]]++;
        if(i-B+1>=0){

            //decrease key
            ret.push_back(m.size());
            m[A[i-B+1]]--;

            //remove if count becomes 0
            if(m[A[i-B+1]]==0)m.erase(A[i-B+1]);
        }
    }
    return ret;
}
 * 
 */

}
