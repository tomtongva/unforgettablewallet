package unforgettablewallet.initializers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalProperties {

	private final static Logger logger = LoggerFactory.getLogger(GlobalProperties.class.getName());
	
	public static final String MAIN_HASH_ALGORITHM = getProperty(Thread.currentThread().getContextClassLoader()
																	.getResource("").getPath() + "hash.properties",
																 GlobalEnums.mainHashAlgorithm.name());
	public static final String FAKE_ALPHABET = getProperty(Thread.currentThread().getContextClassLoader()
																.getResource("").getPath() + "alphabet.properties",
															GlobalEnums.fakeAlphabet.name());
	public static final String FAKE_ALPHABET_SEPARATOR = getProperty(Thread.currentThread().getContextClassLoader()
																		.getResource("").getPath() + "alphabet.properties",
																	 GlobalEnums.fakeAlphabetSeparator.name());
	
	
	private GlobalProperties() {}
	
	private static final String getProperty(final String fullPathToPropertyFile, final String propertyToGet) {
		String value = null;
		
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream(fullPathToPropertyFile));
			} catch (IOException e) {
				logger.debug(e.getMessage());
			}
			
			value = properties.getProperty(propertyToGet);
	
		
		return value;
	}
}
