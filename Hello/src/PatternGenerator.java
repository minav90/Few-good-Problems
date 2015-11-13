
public class PatternGenerator {

	public static void main(String[] args) {

		char main[] = new char[] { 'a', 'b', 'c', 'x', 'a', 'b', 'c', 'd', 'a', 'b', 'x', 'a', 'b', 'c', 'd', 'a', 'b',
				'c', 'd', 'a', 'b', 'c', 'y' };
		char str[] = new char[] { 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'y' };
		int pat[] = buildPattern(str);
		int i = 0;
		int j = 0;
		while (i < main.length) {
			if (main[i] == str[j]) {
				i++;
				j++;
			} else {
				while (j > 0) {
					j = pat[j-1];
					if (main[i] == str[j]) {
						i++;
						j++;
						break;
					}
				}
				i = j == 0?i+1:i;
			}

		}
		if(i == main.length && j == str.length)
			System.out.println(true);
		else
			System.out.println(false);

	}

	private static int[] buildPattern(char[] str) {

		int n = str.length;
		int pat[] = new int[n];
		pat[0] = 0;
		int j = 0;
		for (int i = 1; i < str.length; i++) {
			if (str[i] == str[j]) {
				pat[i] = j + 1;
				j++;
			} else {
				while (j > 0) {
					j = pat[j - 1];
					if (str[j] == str[i]) {
						pat[i] = j + 1;
						j++;
						break;
					}
				}
				pat[i] = j == 0 ? 0 : pat[i];
			}
		}

		return pat;

	}

}
