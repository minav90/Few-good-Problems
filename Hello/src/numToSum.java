


public class numToSum {

	public static void main(String[] args) {

			//enumerate(5, "", 5);
			int arr[] = new int[]{2, 4, 1, 3, 8, 4, 6};
	        totalComboToSum(11,arr,"",0);
	}

	private static void totalComboToSum(int num, int[] arr, String str,int pos) {

		if(num == 0)
		{
			System.out.println(str);
		}
		if(num < 0)
			return;
		for(int i=pos;i<arr.length;i++)
		{
			totalComboToSum(num - arr[i], arr, str + arr[i],pos + 1);
		}
	}

	public static void enumerate(int num, String str, int n) {
		if (num == 0) {
			System.out.println(str);
			return;
		}
		if (num < 0)
			return;
		for (int i = 1; i < n; i++) {
			enumerate(num - i, str + i, n);
		}

	}
}
