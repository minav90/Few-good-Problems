import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permute {
	
	public static void main(String[] args) {
		
		int num[] = new int[]{1,2,1};
		ArrayList<ArrayList<Integer>> res = permute(num);
		
		for(ArrayList<Integer> arr : res)
		{
			System.out.println(arr);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> permute(int num[])
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		
		for(int i=0;i<num.length;i++)
		{
			Set<ArrayList<Integer>> current = new HashSet<ArrayList<Integer>>();
			
			for(ArrayList<Integer> l : result)
			{
				for(int j=0;j<l.size() + 1;j++)
				{
					l.add(j,num[i]);
					
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
					
					
					l.remove(j);
				}
			}
			
			result = new ArrayList<ArrayList<Integer>>(current);
			
		}
		
		
		return result;
	}
	
	
	

}
