package test;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import unforgettablewallet.hash.Base58;
import unforgettablewallet.hash.Hash;
import unforgettablewallet.utils.FakeWordsGeneratorUtil;

public class TestMain {

	private static String hashInput = "Yi Deng jiu Shi yi nian duo.  san bai liu shi wu ge ri zi bu hao guo";
	
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 1000; ++i) {
			List<String> wordList = new CopyOnWriteArrayList<>();
			
			FakeWordsGeneratorUtil.populateFakeWords(6, wordList);
			System.out.println(wordList);
		}
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
