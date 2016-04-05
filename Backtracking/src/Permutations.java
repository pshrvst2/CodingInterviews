import java.util.ArrayList;


public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		permute(l);

	}
	
public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    
	    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
	    if(a==null || a.size()==0)
	        return retList;
	    
	    permutations(retList, a, new ArrayList<Integer>(), a.size());
	    return retList;
	}
	
	public static void permutations(ArrayList<ArrayList<Integer>> retList, 
	                    ArrayList<Integer> choices, ArrayList<Integer> currList, int maxSize)
    {
        if(currList.size()==maxSize)
        {
            retList.add(new ArrayList<Integer>(currList));
            //return;
        }
        
        for(Integer in : choices)
        {
            currList.add(in);
            ArrayList<Integer> newChoices = new ArrayList<Integer>(choices);
            newChoices.remove(in);
            permutations(retList, newChoices, currList, maxSize);
        }
        if(currList.size()>0)
        	currList.remove(currList.size()-1);
    }

}
