public class WhereIsGuard {
	
	static int moveX[] = {0,-1,0,1};
	static int moveY[] = {1,0,-1,0};

	public static void main(String[] args) {

		char matrix[][] = new char[][] { { '.', '#', '.', 'G', '.' },
				{ '.', '.', '#', '.', '.' }, { 'G', '.', '.', '.', '.' },
				{ '.', '.', '#', '.', '.' } };

		char res[][] = whereIsG(matrix);
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				System.out.print(res[i][j]+" ");
			}
			System.out.println("");
		}

	}

	private static char[][] whereIsG(char[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
			
				if(matrix[i][j] == 'G')
				{
					markNeighBours(matrix,i,j,0);
				}
				
			}
		}
		return matrix;
	}

	private static void markNeighBours(char[][] matrix, int i, int j, int k) {

		for(int m=0;m<moveX.length;m++)
		{
             int nextX = i + moveX[m];
             int nextY = j + moveY[m];
             
             if(isSafe(matrix,nextX,nextY,k+1))
             {
            	 matrix[nextX][nextY] = (char) (k + 1 + 48);
            	 markNeighBours(matrix, nextX, nextY, k+1);
             }
		}
	}

	private static boolean isSafe(char[][] matrix, int nextX, int nextY, int k) {

		if(nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length)
			return false;
		if(matrix[nextX][nextY] == 'G' || matrix[nextX][nextY] == '#')
			return false;
		if(matrix[nextX][nextY] != '.' && (int)matrix[nextX][nextY] - 48 <= k)
			return false;
		
		return true;
	}

	
}
