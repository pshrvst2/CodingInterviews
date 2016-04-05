import java.util.ArrayList;
import java.util.Collections;


public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		subsets(l);

	}
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) 
	{
	    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
	    if(a==null || a.size()==0)
	        return retList;
	    subSetGen(retList, new ArrayList<Integer>(), a);
	    return retList;
	}
	
	public static void subSetGen(ArrayList<ArrayList<Integer>> retList, 
	            ArrayList<Integer> currList, ArrayList<Integer> choices)
	{
	    //Collections.sort(currList);
	    //if(!retList.contains(currList))
	    retList.add(new ArrayList<Integer>(currList));
	    int i = 0;
	    for(Integer in : choices)
	    {
	    	
	        //if(!currList.contains(in))
	        currList.add(in);
	        ArrayList<Integer> newChoices = new ArrayList<Integer>(choices);
	        int j = 0;
	        while(j<i)
	        	newChoices.remove(j++);
	        subSetGen(retList, /*new ArrayList<Integer>(*/currList/*)*/, newChoices);
	        currList.remove(currList.size()-1);
	        //choices.remove(in);
	        i++;
	    }
	}

}
