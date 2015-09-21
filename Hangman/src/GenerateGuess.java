import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateGuess {

	public char guessTheWord(HashMap<Integer, ArrayList<String>> tempList, ArrayList<String> found) {

		String words[] = GuessThePhrase.current_state.split("[^\\w_]+");
		int w = 0;
		int result_array[] = new int[256];
		for (String word : words) {
			String temp = word;
			if (!temp.contains("_")) {
				continue;
			}
			ArrayList<String> dicWordList = tempList.get(word.length());
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) != -1) {
					word = word.replace("_", "[A-Z]");
					word += "$";
					word = "^" + word;
					for (int j = 0; j < dicWordList.size(); j++) {
						Pattern p = Pattern.compile(word);
						String dicWord = dicWordList.get(j);
						Matcher m = p.matcher(dicWord);
						if (m.find()) {
							for (int k = 0; k < temp.length(); k++) {
								if (temp.charAt(k) == '_') {
									char foundChar = dicWord.charAt(k);
									result_array[foundChar]++;
								}
							}
						}
					}
				}
				int maxInt = 0;
				int maxValOfChar = 0;
				for (int p = 65; p <= 90; p++) {
					if (result_array[p] >= maxInt && !found.contains((char) p + "")) {
						maxValOfChar = p;
						maxInt = result_array[p];
					}
				}
				found.add(((char) maxValOfChar) + "");
				return (char) maxValOfChar;

			}
		}
		return (char) randInt(65, 90, found);
	}

	public static int randInt(int min, int max, ArrayList<String> found) {

		Random rand = null;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		while (!found.contains(((char) randomNum) + "")) {
			randomNum = rand.nextInt((max - min) + 1) + min;
		}
		found.add((char) randomNum + "");
		return randomNum;
	}

}