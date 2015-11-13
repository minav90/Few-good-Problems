import java.util.Stack;

public class LongestParanthesisSubString {
	
	public static void main(String[] args) {

		String str = "()(())))))";
		System.out.println(longestSubString(str));
	}

	private static int longestSubString(String str) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int res = 0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(')
				stack.push(i);
			
			else
			{
				stack.pop();
				
				if(!stack.isEmpty())
					res = Math.max(res,i - stack.peek());
				
				else
					stack.push(i);
					
			}
		}
		
		return res;
	}
}
