import java.util.ArrayList;
import java.util.List;

public class RotateSearch {
	// DO NOT MODIFY THE LIST
	
	public static void main(String[] args) {
		
		int a [] = new int []{1, 7, 67, 133, 178 };
		List<Integer> res = new ArrayList<Integer>();
		for(int num : a)
		{
			res.add(num);
		}
		System.out.println(search(res, 1));
		
	}
	
	public static int search(final List<Integer> a, int b) {
	    
	    if(a.isEmpty())
	    return 0;
	    
	    
	    return search(a, 0,a.size() - 1, b);
	    
	    
	}
	
	
	public static int search(List<Integer> a,int l,int h,int key)
	{
		if(l > h)
		{
			return -1;
		}
		int mid = (l+h)/2;
		
		if(a.get(mid) == key)
			return mid;
		if(a.get(l) <= a.get(mid))
		{
			if(a.get(l) <= key && key <= a.get(mid))
				return search(a,l,mid-1,key);
			
			return search(a,mid+1,h,key);
		}
		
		if(key >= a.get(mid) && key <= a.get(h))
			return search(a,mid+1,h,key);
		
		return search(a,l,mid-1,key);
	}
	
}
