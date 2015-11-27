public class AlternateMaxSum {

	public static void main(String[] args) {

		int arr[] =  {1, 2,3,4};
		//System.out.println(maxAltSum(arr));
		printSubSet("",arr,0,2);
	}

	private static void printSubSet(String str, int[] arr, int pos, int k) {

		if(str.length() == k)
		{
			System.out.println(str);
			return;
		}
		for(int i=pos;i<arr.length;i++)
		{
			printSubSet(str+arr[i], arr, ++pos, k);
		}
		
	}

	public static int maxAltSum(int arr[]) {
		int res[] = new int[arr.length];
		res[0] = arr[0];
		res[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			res[i] = Math.max(res[i-1], res[i-2] + arr[i]);
		}
		return res[arr.length - 1];

	}

}
