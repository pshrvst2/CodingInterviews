import java.util.HashMap;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"2 3","3 7","4 1"};
		System.out.println(countX(arr));

	}

	public static int countX(String[] arr)
	{
		int rowMax = 0;
		int colMax = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			String s = arr[i];
			String[] coord = s.split(" ");
			rowMax = Math.max(Integer.valueOf(coord[0]), rowMax);
			colMax = Math.max(Integer.valueOf(coord[1]), colMax);
		}
		
		int[][] matrix = new int[rowMax][colMax];
		for(int i = 0; i < rowMax; i++)
			for(int j = 0; j < colMax; j++)
				matrix[i][j] = 0;
		
		int maxNbr = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++)
		{
			String s = arr[i];
			String[] coord = s.split(" ");
			int a = Integer.valueOf(coord[0]);
			int b = Integer.valueOf(coord[1]);
			incMatrix(matrix, a, b, rowMax, colMax);
		}
				
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// find the max and its count
		for(int i = 0; i < rowMax; i++)
		{	
			for(int j = 0; j < colMax; j++)
			{
				maxNbr = Math.max(matrix[i][j], maxNbr);
				if(map.containsKey(matrix[i][j]))
				{
					int v = map.get(matrix[i][j]);
					v++;
					map.put(matrix[i][j], v);
				}
				else
				{
					map.put(matrix[i][j], 1);
				}
			}
		}
		
		return map.get(maxNbr);
	}
	
	public static void incMatrix(int[][] matrix, int a, int b, int rows, int cols)
	{
		System.out.println(a);
		System.out.println(b);
		for(int i = 0; i < a; i++)
			for(int j = 0; j < b; j++)
				matrix[i][j]++;
		
		display(matrix, rows, cols);
	}

	private static void display(int[][] matrix, int rowMax, int colMax) {
		
		for(int i = 0; i < rowMax; i++)
		{
			for(int j = 0; j < colMax; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
