import java.util.ArrayList;


public class IncrementNumberByOne {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(9);
		arr.add(9);
		arr.add(9);
		increment(arr);
		
		
		
	}

	private static void increment(ArrayList<Integer> arr) {

		int carry = 1;
		for(int i = arr.size() - 1;i>=0 && carry != 0;i--)
		{
			carry = carry + arr.get(i);
			arr.set(i, carry%10);
			carry = carry / 10;
		}
		if(carry > 0)
		{
			arr.add(0,carry);
		}
		System.out.println(arr);
		
		
		
		
		
		
		
	}
	
}
