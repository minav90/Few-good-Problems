public class ValidString {

	public static void main(String[] args) {

		int N = 4;
		recur(N-1,0,"","ABC",0);
	}

	public static void recur(int N, int k, String str, String orig, int pos) {
		if (k == 0)
			System.out.println(str);
		if (pos > N || k < 0)
			return;
		for (int i = 0; i < orig.length(); i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (orig.charAt(i) > str.charAt(j))
					count++;
			}
			recur(N,k-count,str+orig.charAt(i),orig,pos + 1);
		}
	}
}
