import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {

		System.out.println(permutations("abcde").size());
		//List<String> res = new ArrayList<String>();
		//perm("abcde","",res);
		//System.out.println(res.size());
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
		return permutations;
	}

	private static String insertCharAt(String s, char c, int i) {
		return new StringBuilder(s).insert(i, c).toString();
	}

}
