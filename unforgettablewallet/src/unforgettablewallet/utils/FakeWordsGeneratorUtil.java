package unforgettablewallet.utils;

import java.util.List;
import java.util.Set;

import unforgettablewallet.initializers.GlobalProperties;

public class FakeWordsGeneratorUtil {

	public static int MINIMUM_NUMBER_OF_CHARS = 4;
	
	private FakeWordsGeneratorUtil() {}
	
	private static String fakeAlphabet[] = GlobalProperties.FAKE_ALPHABET.split(GlobalProperties.FAKE_ALPHABET_SEPARATOR);
	
	public static void populateFakeWords(final int numberOfWordsToGet, Set<String> wordList) throws Exception {
		if (wordList == null) throw new Exception("word list cannot be null");
		
		for (int round = 0; round < numberOfWordsToGet; ++round) {
			double random = Math.random()*10+MINIMUM_NUMBER_OF_CHARS;
			int lengthOfWord = (int)random;
			
			String word = "";
			for (int pickFromFakeAlphabetCur = 0; pickFromFakeAlphabetCur < lengthOfWord; ++pickFromFakeAlphabetCur) {
				int fakeAlphabetIndex = (int) (Math.random()*fakeAlphabet.length+1);
				word += fakeAlphabet[fakeAlphabetIndex-1];
			}
			
			
			if (wordList.contains(word)) {
				round--;
			}
			
			wordList.add(word);
		}
	}
}
