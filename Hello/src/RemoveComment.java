
public class RemoveComment {
	public static void main(String[] args) {
		
		String str = "hii!!! this is my world /* this is my world */ cool then enjoy";
		String val = removeComment(str.toCharArray());
		System.out.println(str);
		System.out.println(val);
	}

	private static String removeComment(char[] charArray) {

		boolean startcomment = false;
		boolean endcomment = false;
		String finalString = "";
		for(int i=0;i<charArray.length;i++)
		{
			if(charArray[i] == '/')
			{
				if(charArray[i+1] == '*')
				{
					startcomment = true;
				}
			}
			if(charArray[i] == '*')
			{
				if(charArray[i+1] == '/')
				{
					endcomment = true;
					i = i+1;
					continue;
				}
			}
			if(!startcomment || endcomment)
			{
				finalString += charArray[i];
			}
		}
		
		return finalString;
	}

}
