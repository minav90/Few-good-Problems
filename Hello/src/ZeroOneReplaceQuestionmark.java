
public class ZeroOneReplaceQuestionmark {

	public static void main(String[] args) {
		
		String str = "01?0?";
		print(str,"",str.length() - 1);
		
	}

	private static void print(String str, String prefix, int pos) {

		if(pos < 0)
		{
			System.out.println(prefix);
			return;
		}
		
		if(str.charAt(pos) == '?')
		{
			print(str, "0"+prefix, pos-1);
			print(str, "1"+prefix, pos-1);
		}
		else
		{
			print(str, str.charAt(pos)+prefix, pos-1);
		}
		
	}
	
}

