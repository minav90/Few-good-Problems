
public class TextJustification {

	public static void main(String[] args) {
		
		String words[]= new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		int matrix[][] = new int[words.length][words.length];
		int spacing = 16;
		matrix = generateSpaceMatrix(spacing,words);
		int cost[] = new int[words.length];
		int index[] = new int[words.length];
		
		calculateCost(cost,index,matrix,spacing);
		
		buildPattern(index,words);
		
	}
	
	private static void buildPattern(int[] index, String[] words) {

		int i = 0;
		while(i < index.length)
		{
			int j = i;
			while(j < index[i])
			{
				System.out.print(words[j]+" ");
				j++;
			}
			System.out.println("");
			i = index[i];
		}
	}

	private static void calculateCost(int[] cost, int[] index, int[][] matrix,
			int spacing) {

		for(int i = cost.length - 1 ;i>=0;i--)
		{
			int j = cost.length - 1;
			if(spacing > Math.sqrt(matrix[i][j]))
			{
				cost[i] = matrix[i][j];
				index[i] = j+1;
			}
			else
			{
				int min = Integer.MAX_VALUE;
				for(int k=j;k>i;k--)
				{
					if(Math.sqrt(matrix[i][k-1]) > spacing)
						continue;
					if(matrix[i][k-1] + cost[k] < min)
					{
						min = matrix[i][k-1] + cost[k];
						index[i] = k;
					}
				}
				cost[i] = min;
			}
		}
		
	}

	public static int[][] generateSpaceMatrix(int spacing,String[] words)
	{
		int matrix[][] = new int[words.length][words.length];
		int n = matrix.length;
		for(int i=0;i<n;i++)
		{
			int temp = spacing - words[i].length();
			matrix[i][i] = temp * temp;
		}
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int temp = (int) (Math.sqrt(matrix[i][j-1]) - 1 - words[j].length());
				matrix[i][j] = (int) (temp >= 0 ? temp*temp : Integer.MAX_VALUE);
			}
		}
		
		return matrix;
		
	}
}
