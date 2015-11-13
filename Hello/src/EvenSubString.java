
public class EvenSubString {

	public static void main(String[] args) {
		
	String res = "125485482687";
	System.out.println(countEvenSubMaxStr(res));
		
		
	}

	private static int countEvenSubMaxStr(String res) {
          
		int n = res.length();
		int table[][] = new int[n][n];
		
		int max = 0;
		for(int i = n-1;i >= 0;i--)
		{
			for(int j= i;j < n;j++)
			{
				if((j-i+1)%2 != 0 || i==j)
				{
					table[i][j] = 0;
				}
				else
				{
					int diff = Integer.parseInt(res.charAt(j)+"")-Integer.parseInt(res.charAt(i)+"");
				    if(i+1 < n && j-1 >=0)
				    {
				    	if(diff + table[i+1][j-1] == 0 && max < j-i+1)
				    	{
				    		max=j-i+1;
				    	}
				    	table[i][j] = table[i+1][j-1];
				    }
				    table[i][j] += diff;
				}
			}
		}
		
		return max;
	}
	
	
	
	
	
}
