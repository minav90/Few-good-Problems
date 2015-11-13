public class PrintCombo {

	static int count = 0;
	public static void main(String[] args) {

		String str = "abcdefgh";
		printAll(str, "", 0);
		//System.out.println(count);

	}

	private static void printAll(String str, String prefix, int k) {

		if (prefix.length() == 4) {
			printSolution(prefix);
			count++;
			return;
		}

		for (int i = k; i < str.length(); i++) {
			printAll(str, prefix + str.charAt(i), k + 1);
			k++;
		}
	}

	private static void printSolution(String prefix) {

		String str = "";
		for(int i=0;i<prefix.length();i++)
		{
			str += "-"+prefix.charAt(i)+" ";
		}
		System.out.println(str.trim());
		
	}
}
