
public class RomanInteger {

	public static void main(String[] args) {
		
		System.out.println(romanToInteger("XLXIV"));
		System.out.println(integerToRoman(24));
		
	}
	
	public enum Type{
	    M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
	    private final int value;
	    Type(int value) {
	        this.value = value;
	    }
	};

	private static StringBuilder integerToRoman(int i) {

		StringBuilder st = new StringBuilder();
		for(Type t:Type.values())
		{
			if(i >= t.value)
			{
				st.append(t.name());
				i -= t.value;
			}
		}
		return st;
	}

	public static int romanTable(char c){
	    int num = 0;
	    switch(c){
	        case 'I':
	            num = 1;
	            break;
	        case 'V':
	            num = 5;
	            break;
	         case 'X':
	            num = 10;
	            break;
	         case 'L':
	             num = 50;
	             break;
	         case 'C':
	             num = 100;
	             break;
	         case 'D':
	             num = 500;
	             break;
	         case 'M':
	             num = 1000;
	             break;
	         default:
	             num = 0;
	             break;
	    }
	    return num;
	}
	
	private static int romanToInteger(String s) {

		if(s == null)
			return 0;
		
		int pre = 0;
        int len = s.length();
		int sum = 0;
		
		for(int i=len-1;i>=0;i--)
		{
			int curr = romanTable(s.charAt(i));
			if(i == len-1) {
				sum = sum + curr;
			}
			else
			{
				if(pre > curr)
					sum = sum - curr;
				else
					sum = sum + curr;
			}
			pre =  curr;
		}
		
		return sum;
	}
	
}
