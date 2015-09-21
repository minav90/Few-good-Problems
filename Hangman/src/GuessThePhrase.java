import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class GuessThePhrase {

	static String current_status;
	static String current_state;
	static int remaining_guesses;
	static String token;
	static ArrayList<String> words;

	public static void main(String[] args) throws JSONException {

		try {

			HttpURLConnection conn = getIntialConnection();

			initializeAttr(conn);

			readDictionary();

			/**
			 * This map contains keys all words in the state and values are its
			 * corresponding dictionary words of same length
			 */
			HashMap<Integer, ArrayList<String>> wordList = createMapofDictionaryWords();

			boolean flag = checkIfWordsGuessed(wordList);
			if (flag) {
				System.out.println("YOU WIN");
			} else {
				System.out.println("YOU LOSE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean checkIfWordsGuessed(HashMap<Integer, ArrayList<String>> wordList) throws JSONException {
		ArrayList<String> guessedList = new ArrayList<String>();
		boolean flag = false;
		while (!current_status.equals("DEAD") || remaining_guesses != 0) {
			if (current_status.equals("FREE")) {
				flag = true;
				break;
			}
			makeAGuess(wordList, guessedList);
		}
		return flag;
	}

	private static HashMap<Integer, ArrayList<String>> createMapofDictionaryWords() {
		HashMap<Integer, ArrayList<String>> wordList = new HashMap<Integer, ArrayList<String>>();
		String st[] = current_state.split("[^\\w_]+");
		for (int k = 0; k < st.length; k++) {
			int number_of_words = st[k].length();
			Iterator<String> it = words.iterator();
			ArrayList<String> words = new ArrayList<String>();
			while (it.hasNext()) {
				String tempWord = it.next();
				if (tempWord.length() == number_of_words)
					words.add(tempWord);
			}
			wordList.put(number_of_words, words);
		}
		return wordList;
	}

	private static void readDictionary() throws FileNotFoundException {
		ReadDictionary read = new ReadDictionary();
		words = read.getDictionary();
	}

	private static void makeAGuess(HashMap<Integer, ArrayList<String>> tempList, ArrayList<String> found)
			throws JSONException {
		try {

			GenerateGuess generateGuess = new GenerateGuess();
			char guess = generateGuess.guessTheWord(tempList, found);
			System.out.println("Guess= " + guess);

			HttpURLConnection conn = retrieveConnectionToGuess(guess + "");

			initializeAttr(conn);

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static HttpURLConnection retrieveConnectionToGuess(String guess)
			throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(
				"http://gallows.hulu.com/play?code=minavpatel90@gmail.com&token=" + token + "&guess=" + guess);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		return conn;
	}

	private static void initializeAttr(HttpURLConnection conn) throws IOException, JSONException {

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = br.readLine();
		JSONObject json = new JSONObject(output);
		System.out.println(output);
		current_status = json.getString("status");
		current_state = json.getString("state");
		token = json.getString("token");
		remaining_guesses = json.getInt("remaining_guesses");
	}

	private static HttpURLConnection getIntialConnection()
			throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://gallows.hulu.com/play?code=minavpatel90@gmail.com");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		return conn;
	}

}
