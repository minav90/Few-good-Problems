public class PowerSet {

	public static void main(String[] args) {

		printPowerSet("abc", 3);

	}

	public static void printPowerSet(String str, int size) {
		int counter = (int) Math.pow(2, 3);

		for (int i = 0; i < counter; i++) {
			for (int j = 0; j < size; j++) {
				if (((i) & (1 << j)) != 0) {
                        System.out.print(str.charAt(j));
				}
			}
			System.out.println("");
		}

	}

}
