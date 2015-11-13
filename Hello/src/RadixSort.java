
public class RadixSort {

	public static void main(String[] args) {
	
		int[] arr = new int[]{124,147,135,182,167,157,173,152,164,138};
		
		 sort(arr);
		
		
	}

	private static void sort(int[] arr) {

		int max = arr[0];
		for(int i = 1;i < arr.length;i++)
		{
			max = Math.max(max, arr[i]);
		}
		
		int exp = 1;
		int R = 10;
		
		int aux[] = new int[arr.length];
		
		while(max/exp > 0)
		{
			int[] count = new int[R];
			
			for(int i = 0;i<arr.length;i++)
			{
				count[(arr[i] / exp )%10]++;
			}
			
			for(int i = 1;i<arr.length;i++)
			{
				count[i] += count[i-1];
			}
			
			for(int i = arr.length - 1;i >= 0;i--)
			{
				aux[--count[(arr[i]/exp )%10]] = arr[i];
			}
			
			 for (int i = 0; i < arr.length; i++) {
		            arr[i] = aux[i];
		        }
			 
			 exp *= 10;
			
			
		}
		
		 for (int i = 1; i < arr.length; i++) {
		       System.out.print(arr[i] + " " );
		    }
		
		
		
		
	}
	
	
	
}
