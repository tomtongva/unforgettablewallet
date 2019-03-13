package unforgettablewallet.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import unforgettablewallet.initializers.GlobalProperties;

public class Hash {

	public Set<byte[]> hash(final Set<String> hashInputs) throws NoSuchAlgorithmException {
		Set<byte[]> retHashes = null;
		
		if (hashInputs != null) {
			retHashes = new HashSet<byte[]>();
			
			MessageDigest digest = MessageDigest.getInstance(GlobalProperties.MAIN_HASH_ALGORITHM);
			byte[] hash = null;
			for (String input : hashInputs) {
				hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
				retHashes.add(hash);
			}
		}
		
		return retHashes;
	}
}
