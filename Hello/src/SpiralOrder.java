import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public static void main(String[] args) {

		int matrix[][] = { { 1, 2, 3 ,4}, { 5, 6,7,8 }, { 9,10,11,12 },{13,14,15,16} };
		print(spiralOrder(matrix));
		
	}

	private static void print(List<Integer> spiralOrder) {
		for(int i : spiralOrder)
		{
			System.out.print(i+" ");
		}
		
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0)
			return res;
		int nx[] = { 0, 1, 0, -1 };
		int ny[] = { 1, 0, -1, 0 };
		int x = 0, y = -1;
		int m = matrix.length, n = matrix[0].length;
		int i = 0;

		while (m > 0 && n > 0) {
			int k;
			if (i % 2 == 0) {
				k = n;
				m--;
			} else {
				k = m;
				n--;
			}

			while (k-- > 0) {
				x += nx[i];
				y += ny[i];
				res.add(matrix[x][y]);
			}

			i = (i + 1) % 4; // direction
		}
		return res;
	}
}