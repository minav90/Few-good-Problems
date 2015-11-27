
public class CountSubStringPalindrome {

	public static void main(String[] args) {
		
		System.out.println(countPalin("abcbabbab".toCharArray()));
		
	}
	
	public static int countPalin(char []str)
	{
		int len = str.length;
		int count = 0;
		
		int i,j,k;
		for(i=0;i<len;i++)
		{
		        k = i-1;
			    j = i + 1;
			    while(k >=0 && j<len && str[k] == str[j])
			    {
			    	++count;
			    	k--;
			    	j++;
			    }
			    
			    k = i;
			    j = i + 1;
			    while(k >=0 && j<len && str[k] == str[j])
			    {
			    	++count;
			    	k--;
			    	j++;
			    }
		}
		return count;
		
	}
}
