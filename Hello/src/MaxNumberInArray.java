public class MaxNumberInArray {

	public static void main(String[] args) {

		int arr1[] = new int[]{3,4,6,5};
		int arr2[] = new int[]{9,1,2,5,8,3};
		int dp[][][] = new int[arr1.length][arr2.length][5];
		System.out.println(maxPossibleSum(arr1, arr2, 4, 0, 0,dp));
		
		
		
	}

	public static int maxPossibleSum(int arr1[], int arr2[], int k, int i, int j,int dp[][][]) {

		if (k < 0 || i >= arr1.length || j>= arr2.length)
			return 0;
		
		if(dp[i][j][k] != 0)
			return dp[i][j][k];

		if (arr1[i] > arr2[j]) {
			dp[i][j][k]= Math.max(
					10 * arr1[i] * maxPossibleSum(arr1, arr2, k - 1, i + 1, j,dp),
					maxPossibleSum(arr1, arr2, k, i + 1, j + 1,dp));
		} else {
			dp[i][j][k]= Math.max(
					10 * arr2[j] * maxPossibleSum(arr1, arr2, k - 1, i, j+1,dp),
					maxPossibleSum(arr1, arr2, k, i + 1, j + 1,dp));
		}
		return dp[0][0][k];
	}
}
