import java.util.ArrayList;


public class Spiral2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateMatrix(80);

	}
	
public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    
	    int matSize = a*a;
	    int b[][] = new int[a][a];
	    
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    
	    if(a<=0)
	        return list;
	        
	    int stepCount = 0;
	    int i = 0; 
	    int j = 0;
	    int dir = 0;
	    
	    int l=0, r=a, t=0, d=a;
	    
	    while (stepCount < matSize)
	    {
	        switch (dir)
	        {
	        
	        case 0:
	            
	            if(j+1<=r)
	            {
	            	b[i][j] = ++stepCount;
	                j++;
	            }
	            else
	            {
	            	j--;
	            	i++;
	                dir = 1;
	                t++;
	            }
	            break;
	            
	        case 1:
	            
	            if(i+1<=d)
	            {
	            	b[i][j] = ++stepCount;
	            	i++;
	            }
	            else
	            {
	            	i--;
	            	j--;
	                dir = 2;
	                r--;
	            }
	            break;
	   
	        case 2:
	            
	            if(j>=l)
	            {
	            	b[i][j] = ++stepCount;
	                j--;
	            }
	            else
	            {
	            	i--;
	            	j++;
	                dir = 3;
	                d--;
	            }
	            break;
	            
	        case 3:
	            
	            if(i>=t)
	            {
	            	b[i][j] = ++stepCount;
	                i--;
	            }
	            else
	            {
	                dir = 3;
	                l++;
	                i++;
	                j++;
	                dir = 0;
	            }
	            break;
	        }   
	    }
	    
	    for(i=0;i<a;i++)
	    {
	        ArrayList<Integer> list1 = new ArrayList<Integer>();
	        for(j=0;j<a;j++)
	        {
	            System.out.print(b[i][j]);
	            list1.add(b[i][j]);
	        }
	        System.out.println();
	        list.add(list1);
	    }
	    
	    return list;
	}

}
