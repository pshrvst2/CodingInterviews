import java.util.ArrayList;
import java.util.Collections;


public class StainPrint {
	
	public static void main(String[] args)
	{
		StairCase(3);
		
	}
	
	
static void StairCase(int n) {
        
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        
        for(int i = 0; i < n; i++)
        {
            int len = 0;
            ArrayList<String> sl = new ArrayList<String>();
            while(i-len>0)
            {
                sl.add(" ");
                len++; 
            }
            while(n>len)
            {
                sl.add("#");
                len++;
            }
            list.add(sl);  
        }
        
        Collections.reverse(list);
        
        for(ArrayList<String> arList : list)
        {
            for(String temp : arList)
                System.out.print(temp);
            
            System.out.println();
            
        }


    }

}
