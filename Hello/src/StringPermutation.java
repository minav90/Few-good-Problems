import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {

	static int count;
	public static void main(String[] args) {

		//System.out.println(permutations("abcde").size());
		//List<String> res = new ArrayList<String>();
		//perm("abcde","",res);
		//System.out.println(res.size());
		
		newPerm("abcde".toCharArray(),0);
		System.out.println(count);
	}

	public static void perm(String str, String prefix,List<String> res)
	{
		int n = str.length();
        if(n == 0)
        {
        	res.add(prefix);
        }
		for(int i=0;i<n;i++)
		{
			perm(str.substring(0, i) + str.substring(i+1, n),prefix+str.charAt(i),res);
		}
	}
	
	public static void newPerm(char arr[], int pos)
	{
         if(pos == arr.length)
         {
        	 System.out.println(arr);
        	 count++;
        	 return; 
         }
         Set<Character> set = new HashSet<Character>();
         for(int i=pos;i<arr.length;++i)
         {
        	 if(set.contains(arr[i]))
        	 {
        		 continue;
        	 }
        	 swap(arr,i,pos);
        	 newPerm(arr, pos+1);
        	 swap(arr, i, pos);
        	 set.add(arr[i]);
        	 
         }
         
		
		
	}
	
	private static void swap(char[] arr, int i, int pos) {

		char temp = arr[i];
		arr[i] = arr[pos];
		arr[pos] = temp;
		
	}

	private static List<String> permutations(String s) {
		List<String> permutations = new ArrayList<String>();
		if (s == null) {
			return null;
		} else if (s.length() == 0) {
			permutations.add("");
			return permutations;
		}

		List<String> remainder = permutations(s.substring(1));
		for (String permutation : remainder) {
			for (int i = 0; i <= permutation.length(); ++i) {
				permutations.add(insertCharAt(permutation, s.charAt(0), i));
			}
		}
		System.out.println(permutations);
		return permutations;
	}

	private static String insertCharAt(String s, char c, int i) {
		return new StringBuilder(s).insert(i, c).toString();
	}

}
