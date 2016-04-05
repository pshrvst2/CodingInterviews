import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Piyush
 *
 */
public class Rotate2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int[][] mat = new int[3][3];
		int i = 0;
		int j = 1;
		int num = 1;
		
		while(i<=2)
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(j<=3)
			{
				int x = num++;
				list.add(x);
				mat[i][j-1] = x;
				j++;
			}
			a.add(list);
			j=1;
			i++;
		}
		
		//rotate(a);
		
		for(ArrayList<Integer> listA : a)
		{
			for(Integer intA : listA)
			{
				System.out.print(intA);System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println();
		rotate(mat);
		System.out.println();
		rotate2dd(a);

	}
	
public static void rotate(ArrayList<ArrayList<Integer>> a) {
	    
	    //int count = 0;
	    int index = 0;
	    
	    while(index<a.size())
	    {
	        ArrayList<Integer> tempList = new ArrayList<Integer>();
	        for (int i = a.size()-1; i>=0; i--)
	        {
	            ArrayList<Integer> intList = a.get(i);
	            tempList.add(intList.get(index));
	            //count++;
	        }
	        
	        ArrayList<Integer> indexList = a.get(index);
	        int sz = a.size();
	        for(Integer x : tempList)
	        {
	            indexList.add(sz++,x);
	        }
	        index++;
	    }
	    
	    for(ArrayList<Integer> listA : a)
		{
			for(int x = 0; x < a.size(); x++)
				listA.remove(0);
		}
	}

public static void rotate(int[][] matrix) {
	int n = matrix.length;
	for (int i = 0; i < n / 2; i++) 
	{
		for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) 
		{
			int temp = matrix[i][j];
			matrix[i][j] = matrix[n-1-j][i];
			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
			matrix[j][n-1-i] = temp;
		}
	}
	
	for(int i = 0; i < n; i++){
		for(int j =0; j<n; j++){
			System.out.print(matrix[i][j]+" ");
		}
		System.out.println();
	}
}

public static void rotate2dd(ArrayList<ArrayList<Integer>> a)
{
	int n = a.size();
	for(int i = 0; i < n/2; i++)
	{
		for(int j = 0; j < n-1/*Math.ceil(((double)n)/2.)*/; j++)
		{
			int temp = a.get(i).get(j);
			//for the top left
			a.get(i).set(j, a.get(n-1-j).get(i));
			// for left down
			a.get(n-1-j).set(i, a.get(n-1-i).get(n-1-j));
			// for right down
			a.get(n-1-i).set((n-1-j), a.get(j).get(n-1-i));
			// for top right
			a.get(j).set((n-1-i), temp);
		}
	}
	for(ArrayList<Integer> listA : a)
	{
		for(Integer intA : listA)
		{
			System.out.print(intA);System.out.print("  ");
		}
		System.out.println();
	}
}

}
