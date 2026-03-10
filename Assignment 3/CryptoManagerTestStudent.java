import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBoundsTrue()
    {
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
    }

    @Test
    public void testIsStringInBoundsFalse()
    {
        assertFalse(CryptoManager.isStringInBounds("hello")); // lowercase should fail
    }

    @Test
    public void testCaesarEncryptionDecryption()
    {
        String text = "SECURE";
        int key = 5;

        String encrypted = CryptoManager.caesarEncryption(text, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }

    @Test
    public void testVigenereEncryptionDecryption()
    {
        String text = "CYBER DATA";
        String key = "CODE";

        String encrypted = CryptoManager.vigenereEncryption(text, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }

    @Test
    public void testPlayfairEncryptionDecryption()
    {
        String text = "COMPUTER";
        String key = "SECURITY";

        String encrypted = CryptoManager.playfairEncryption(text, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }

    @Test
    public void testPlayfairOddLength()
    {
        String text = "DOG";
        String key = "KEY";

        String encrypted = CryptoManager.playfairEncryption(text, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }
}