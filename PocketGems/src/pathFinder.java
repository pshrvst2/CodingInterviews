import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class pathFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lines = new String[6];
		lines[0] = "5";
		lines[1] = "A C";
		lines[2] = "A : B D";
		lines[3] = "B : C D";
		lines[4] = "D : C";
		lines[5] = "C : D";
		//lines[1] = "";
		
		pathFin(lines);

	}
	
	public static String[] pathFin(String[] lines)
	{
		if(lines.length == 0 || lines==null)
			return null;
		
		char source = lines[1].substring(0,1).charAt(0);
		char destination = lines[1].substring(2,3).charAt(0);
		
		HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
		
		for(int i = 2; i< lines.length; i++)
		{
			String temp[] = lines[i].split(":");
			char key = temp[0].charAt(0);
			if(key==destination)
				continue;
			
			ArrayList<Character> value = new ArrayList<Character>();
			
			String temp2[] = temp[1].split("\\s");
			for(String string1 : temp2)
			{
				if(!string1.isEmpty())
					value.add(string1.charAt(0));
			}
			
			map.put(key, value);
		}
		
		List<Character> list = new ArrayList<>();
		list.add(source);
		List<String>  retList = new ArrayList<String>();
		
		find(list, map, destination, retList);
		
		int index = 0;
		String[] str = new String[retList.size()];
		
		if(!retList.isEmpty())
		{
			for(String l : retList)
			{
				
				str[index++] = l;
				System.out.println(l);
			}
		}
		
		return str;
		
	}
	
	public static void find(List<Character> list, HashMap<Character, ArrayList<Character>> map, char dest, List<String>  retList) 
	{
		if(list.isEmpty())
			return;
		
		int size = list.size();
		char currentLetter = list.get(size-1);
		
		if(currentLetter==dest)
		{
			StringBuffer s = new StringBuffer();
			for(char c : list)
				s.append(c);
			retList.add(s.toString());
			list.remove(list.size()-1);
			return;
		}
		for(char connectedNode : map.get(currentLetter))
		{
			if(!list.contains(connectedNode))
			{
				list.add(connectedNode);
				find(list, map, dest, retList);
			}		
		}
		list.remove(list.size()-1);
	   
	}

}
