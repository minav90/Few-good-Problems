import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

	public static void main(String[] args) {

		int nums[] = new int[] { 1, 2, 2,2 };
		ArrayList<Integer> temp = subsetsWithDup(nums);

			for (Integer n : temp) {
				System.out.println(n);
			}
		}

	

	public static ArrayList<Integer> subsetsWithDup(int[] nums) {

		// iterate over the nums and print all possible combo

		ArrayList<Integer> res = compute(nums);

		// add empty


		return res;
	}

	public static ArrayList<Integer> compute(int[] nums) {
		String str = intArrayToString(nums);
		ArrayList<Integer> temp = null;

		temp = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j >= i; j--) {
				if (i != j) {
					int a = Integer.parseInt(str.substring(i, j+1));
					if(!temp.contains(a))
					temp.add(a);
				} else {
					int b = Integer.parseInt(str.charAt(i) + "");
					if(!temp.contains(b))
					temp.add(b);
				}
			}
		}
		return temp;
	}

	private static String intArrayToString(int[] array) {
		String strRet = "";
		for (int i : array) {
			strRet += Integer.toString(i);
		}
		return strRet.trim();
	}

}