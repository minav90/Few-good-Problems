import java.util.ArrayList;
import java.util.List;


public class MergeRange {

	public static void main(String[] args) {
		
		Range ranges[] =new Range[4];
		Range range1 = new Range(1, 5);
		Range range2 = new Range(7, 8);
		Range range3 = new Range(9, 13);
		Range range4 = new Range(17, 22);
		ranges[0] = range1;
		ranges[1] = range2;
		ranges[2] = range3;
		ranges[3] = range4;
		
		Range newRange = new Range(4, 10);
		List<Range> mergeRange = mergeRange(ranges,newRange);
		for(Range range : mergeRange)
		{
			System.out.println(range.begin + " "+ range.end);
		}
		
		
	}
	
	private static List<Range> mergeRange(Range[] ranges, Range newRange) {

		List<Range> res = new ArrayList<Range>();
		int s = newRange.begin;
		int e = newRange.end;
				
        for(Range range : ranges)
        {
        	if(range.begin > e || range.end < s)
        	{
        		res.add(range);
        	}
        	else
        	{
        		s = Math.min(s, range.begin);
        		e = Math.max(e, range.end);
        	}
        }
		res.add(new Range(s, e));
		return res;
	}

	static class Range
	{
		int begin;
		int end;
		public Range(int begin,int end)
		{
		     this.begin = begin;
		     this.end =end;
		}
	}
	
}
