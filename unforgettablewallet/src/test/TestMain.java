package test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import unforgettablewallet.hash.Base58;
import unforgettablewallet.hash.Hash;
import unforgettablewallet.utils.FakeWordsGeneratorUtil;

public class TestMain {

	private static String hashInput = "Yi Deng jiu Shi yi nian duo.  san bai liu shi wu ge ri zi bu hao guo";
	
	public static void main(String[] args) throws Exception {
		
//		case1();
//		testFakeWordGenerator();
		testPadRealKeyWithFakeKeys();
		testPadRealKeyWithFakeKeys();
		testPadRealKeyWithFakeKeys();
		
	}
	
	private static void testPadRealKeyWithFakeKeys() throws Exception {
		String [] base58CheckKeys = {"3mDLLijh8xZZDNFzaRJPb9i3Nf4KqiWYS7ko2kKB1EhQFNtMVb",
									"3mDLLijh8xZZDNFzaRJPb9i3Nf4KqiWYS7ko2kKB1EhQFNtMVa",
									"3mDLLijh8xZZDNFzaRJPb9i3Nf4KqiWYS7ko2kKB1EhQFNtMVc",
									"3mDLLijh8xZZDNFzaRJPb9i3Nf4KqiWYS7ko2kKB1EhQFNtMVd",
									"3mDLLijh8xZZDNFzaRJPb9i3Nf4KqiWYS7ko2kKB1EhQFNtMVe",
									"3mDLLijh8xZZDNFzaRJPb9i3Nf4KqiWYS7ko2kKB1EhQFNtMVf"
		};
		
		for (String base58CheckKey : base58CheckKeys) {
			Set<String> wordList = new HashSet<>();
			FakeWordsGeneratorUtil.populateFakeWords(10, wordList);
			
			Set<byte[]> wordListHashed = new Hash().hash(wordList);
			Set<String> wordListDoubleHashed = new HashSet<>();
			// double hash
			for (byte[] hashedWord : wordListHashed) {
				wordListDoubleHashed.add(Arrays.toString(hashedWord));
			}
			wordListHashed = new Hash().hash(wordListDoubleHashed);
	
			List<String> wordListEncoded = new ArrayList<String>();
			
			for (byte[] hashedWord : wordListHashed) {
				wordListEncoded.add("3" + Base58.encodeChecked(1, hashedWord).substring(1));
			}
			
			System.out.println(wordListEncoded.toString());
			
			double randomNum = Math.random()*10+1;
			int insertIndex = (int)randomNum;
			System.out.println(insertIndex);
			wordListEncoded.add(insertIndex, base58CheckKey);
			
			System.out.println(wordListEncoded.toString().replaceAll(",\\s", "").replaceAll("\\[", "").replaceAll("\\]", ""));
		}
	}
	
	private static void testFakeWordGenerator() throws Exception {
		System.out.println(new Date());
		for (int i = 0; i < 1000000; ++i) {
			Set<String> wordList = new HashSet<>();
			
			FakeWordsGeneratorUtil.MINIMUM_NUMBER_OF_CHARS = 3;
			
			FakeWordsGeneratorUtil.populateFakeWords(6, wordList);
//			System.out.println(wordList);
			
			for (String word : wordList) {
				if (word.length() < FakeWordsGeneratorUtil.MINIMUM_NUMBER_OF_CHARS) {
					System.out.println("found word that less than " + FakeWordsGeneratorUtil.MINIMUM_NUMBER_OF_CHARS);
				}
			}
		}
		System.out.println(new Date());
	}
	
	private static void case1() throws NoSuchAlgorithmException {
		String unforgettableClue = "Tian Mi Mi.";
		
		print(new Hash().hash(initializeHashInput()));
		
		Set<String> realHashInput = new HashSet<String>();
		realHashInput.add(hashInput);
		
		Set<byte[]> realHashOutput = new Hash().hash(realHashInput);
		
		exists(realHashOutput, new Hash().hash(initializeHashInput()));
		

		Set<String> doubleHashedInput = new HashSet<String>();
		doubleHashedInput.add(Arrays.toString(realHashOutput.iterator().next()));
		System.out.println(Arrays.toString(new Hash().hash(doubleHashedInput).iterator().next()));
		
		System.out.println("Your clue is: " + unforgettableClue);
		realHashInput = new HashSet<String>();
		realHashInput.add(new Scanner(System.in).nextLine());
		doubleHashedInput = new HashSet<String>();
		doubleHashedInput.add(Arrays.toString(realHashOutput.iterator().next()));
		System.out.println(Arrays.toString(new Hash().hash(doubleHashedInput).iterator().next()));
		
		System.out.println(Base58.encodeChecked(1, new Hash().hash(doubleHashedInput).iterator().next()));
	}
	
	private static void exists(final Set<byte[]> realHashSet, final Set<byte[]> generatedHashSet) {
		byte[] realHash = realHashSet.iterator().next();
		
		System.out.println("real hash: " + Arrays.toString(realHash));
		for (byte[] otherHash : generatedHashSet) {
			System.out.println(realHash.equals(otherHash));
			if (Arrays.equals(realHash, otherHash)) {
				System.out.println(Arrays.toString(realHash) + ":found");
			}
		}
	}
	
	private static void print(Set<byte[]> hashSet) {
		if (hashSet != null) {
			for (byte[] hash : hashSet) {
				System.out.println(Arrays.toString(hash) + ":" + hash.length);
			}
		}
	}
	
	private static Set<String> initializeHashInput() {
		
		String userFakeHashInput1 = "this is my fake input to generate a hash 1";
		String userFakeHashInput2 = "this is my fake input to generate a hash 2";
		String userFakeHashInput3 = "this is my fake input to generate a hash 3";
		String userFakeHashInput4 = "this is my fake input to generate a hash 4";
		String userFakeHashInput5 = "this is my fake input to generate a hash 5";
		String userFakeHashInput6 = "this is my fake input to generate a hash 6";
		String userFakeHashInput7 = "this is my fake input to generate a hash 7";
		String userFakeHashInput8 = "this is my fake input to generate a hash 8";
		String userFakeHashInput9 = "this is my fake input to generate a hash 9";
		String userFakeHashInput10 = "this is my fake input to generate a hash 10";
		
		Set<String> retInputs = new HashSet<String>();
		retInputs.add(userFakeHashInput10);
		retInputs.add(userFakeHashInput9);
		retInputs.add(userFakeHashInput8);
		retInputs.add(userFakeHashInput7);
		retInputs.add(userFakeHashInput6);
		retInputs.add(hashInput);
		retInputs.add(userFakeHashInput5);
		retInputs.add(userFakeHashInput4);
		retInputs.add(userFakeHashInput3);
		retInputs.add(userFakeHashInput2);
		retInputs.add(userFakeHashInput1);
		
		return retInputs;
	}

}
