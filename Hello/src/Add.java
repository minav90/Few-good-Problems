import java.util.ArrayList;
import java.util.List;

public class Add {
	
    public static void main(String[] args) {
		
    	String num = "105";
    	int target = 5;
    	List<String> res = new ArrayList<String>();
        System.out.println(count(num,target,res,""));
        System.out.println(res);
	}
    
    public static int count(String num,int target,List<String> res,String curr)
    {
        if(num.length() == 1)
        {
            if(Integer.parseInt(num) == target)
            {
                res.add(curr+num.charAt(0));
                return 1;
            }
            else
            return 0;
        }
        
        int numericValue = Character.getNumericValue(num.charAt(0));
		return count(num.substring(1),target - numericValue,res,curr + num.charAt(0)+"+") + count(num.substring(1),numericValue-target,res,curr + num.charAt(0)+"-") + count(num.substring(1),target/numericValue,res,curr + num.charAt(0)+"*"); 
    }
}