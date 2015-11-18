public class RegularExpression {

	public static void main(String[] args) {

		String source = "aa";
		String pattern = "aaa*b*";
		System.out.println(isMatching(source, pattern, source.length() - 1, pattern.length() - 1));

	}

	public static boolean isMatching(String s, String p, int sInd, int pInd) {
		if (s == "*")
			return true;
		if (sInd < 0 && pInd < 0)
			return true;
		else if (sInd < 0) {
			while (pInd >= 0) {
				if (p.charAt(pInd) == '*')
					pInd -= 2;
				else
					return false;
			}
			return true;
		} else {
			if (pInd < 0)
				return false;
		}

		if (p.charAt(pInd) == s.charAt(sInd)) {
			return isMatching(s, p, --sInd, --pInd);
		} else if (p.charAt(pInd) == '*') {
			if (p.charAt(pInd - 1) == s.charAt(sInd)) {
				if (pInd > 1 && p.charAt(pInd - 1) == p.charAt(pInd - 2)) {
					p = p.substring(0, pInd - 1) + "*";
					pInd--;
				}
				return isMatching(s, p, --sInd, pInd);
			}
			else
			{
				pInd -= 2;
				return isMatching(s, p, sInd, pInd);
			}
		}
		else
			return false;

	}
}
