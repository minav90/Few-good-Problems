import java.io.IOException;

public class PrettyPrint {

	public static void main(String[] args) throws IOException {

		int num = 4;
		int len = 1 + (num - 1) * 2;
		int arr[][] = new int[len][len];

		int nx[] = { 0, 1, 0, -1 };
		int ny[] = { 1, 0, -1, 0 };
		int x = 0, y = -1;
		int m = arr.length, n = arr[0].length;
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
				arr[x][y] = num;
			}

			i = (i + 1) % 4; // direction
			if(i==0)
				num--;
		}

		for (int p = 0; p < arr.length; p++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[p][j] + " ");
			}
			System.out.println("");
		}

	}

}
