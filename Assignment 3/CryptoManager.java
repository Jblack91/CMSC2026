/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key)
    {
        if (!isStringInBounds(plainText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < plainText.length(); i++)
        {
            char plainChar = plainText.charAt(i);

            int keyIndex = i % key.length();
            char keyChar = key.charAt(keyIndex);

            int plainPosition = plainChar - LOWER_RANGE;
            int keyPosition = keyChar - LOWER_RANGE;

            int newPosition = plainPosition + keyPosition;
            newPosition = newPosition % RANGE;
            newPosition = newPosition + LOWER_RANGE;

            char encryptedChar = (char) newPosition;

            result = result + encryptedChar;
        }

        return result;
    }
    public static String vigenereDecryption(String encryptedText, String key)
    {
        if (!isStringInBounds(encryptedText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < encryptedText.length(); i++)
        {
            char encryptedChar = encryptedText.charAt(i);

            int keyIndex = i % key.length();
            char keyChar = key.charAt(keyIndex);

            int encryptedPosition = encryptedChar - LOWER_RANGE;
            int keyPosition = keyChar - LOWER_RANGE;

            int newPosition = encryptedPosition - keyPosition;
            newPosition = newPosition + RANGE;
            newPosition = newPosition % RANGE;
            newPosition = newPosition + LOWER_RANGE;

            char plainChar = (char) newPosition;

            result = result + plainChar;
        }

        return result;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key)
    {
        if (!isStringInBounds(plainText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";

        String matrixString = "";

        for (int i = 0; i < key.length(); i++)
        {
            char current = key.charAt(i);

            if (matrixString.indexOf(current) == -1)
                matrixString = matrixString + current;
        }

        for (int i = 0; i < ALPHABET64.length(); i++)
        {
            char current = ALPHABET64.charAt(i);

            if (matrixString.indexOf(current) == -1)
                matrixString = matrixString + current;
        }

        char[][] matrix = new char[8][8];

        int index = 0;

        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                matrix[row][col] = matrixString.charAt(index);
                index++;
            }
        }

        String processed = "";

        for (int i = 0; i < plainText.length(); i++)
        {
            processed = processed + plainText.charAt(i);

            if (i < plainText.length() - 1)
            {
                if (plainText.charAt(i) == plainText.charAt(i + 1))
                {
                    processed = processed + "X";
                }
            }
        }

        if (processed.length() % 2 != 0)
        {
            processed = processed + "X";
        }

        plainText = processed;

        String result = "";

        for (int i = 0; i < plainText.length(); i = i + 2)
        {
            char a = plainText.charAt(i);
            char b = plainText.charAt(i + 1);

            int r1 = 0;
            int c1 = 0;
            int r2 = 0;
            int c2 = 0;

            for (int row = 0; row < 8; row++)
            {
                for (int col = 0; col < 8; col++)
                {
                    if (matrix[row][col] == a)
                    {
                        r1 = row;
                        c1 = col;
                    }

                    if (matrix[row][col] == b)
                    {
                        r2 = row;
                        c2 = col;
                    }
                }
            }

            if (r1 == r2)
            {
                result = result + matrix[r1][(c1 + 1) % 8];
                result = result + matrix[r2][(c2 + 1) % 8];
            }
            else if (c1 == c2)
            {
                result = result + matrix[(r1 + 1) % 8][c1];
                result = result + matrix[(r2 + 1) % 8][c2];
            }
            else
            {
                result = result + matrix[r1][c2];
                result = result + matrix[r2][c1];
            }
        }

        return result;
    }
    public static String playfairDecryption(String encryptedText, String key)
    {
        if (!isStringInBounds(encryptedText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";

        String matrixString = "";

        for (int i = 0; i < key.length(); i++)
        {
            char current = key.charAt(i);

            if (matrixString.indexOf(current) == -1)
                matrixString = matrixString + current;
        }

        for (int i = 0; i < ALPHABET64.length(); i++)
        {
            char current = ALPHABET64.charAt(i);

            if (matrixString.indexOf(current) == -1)
                matrixString = matrixString + current;
        }

        char[][] matrix = new char[8][8];

        int index = 0;

        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                matrix[row][col] = matrixString.charAt(index);
                index++;
            }
        }

        String result = "";

        for (int i = 0; i < encryptedText.length(); i = i + 2)
        {
            char a = encryptedText.charAt(i);
            char b = encryptedText.charAt(i + 1);

            int r1 = 0;
            int c1 = 0;
            int r2 = 0;
            int c2 = 0;

            for (int row = 0; row < 8; row++)
            {
                for (int col = 0; col < 8; col++)
                {
                    if (matrix[row][col] == a)
                    {
                        r1 = row;
                        c1 = col;
                    }

                    if (matrix[row][col] == b)
                    {
                        r2 = row;
                        c2 = col;
                    }
                }
            }

            if (r1 == r2)
            {
                result = result + matrix[r1][(c1 + 7) % 8];
                result = result + matrix[r2][(c2 + 7) % 8];
            }
            else if (c1 == c2)
            {
                result = result + matrix[(r1 + 7) % 8][c1];
                result = result + matrix[(r2 + 7) % 8][c2];
            }
            else
            {
                result = result + matrix[r1][c2];
                result = result + matrix[r2][c1];
            }
        }
        
        String cleaned = "";

        for (int i = 0; i < result.length(); i++)
        {
            if (i > 0 && i < result.length() - 1)
            {
                if (result.charAt(i) == 'X' &&
                    result.charAt(i - 1) == result.charAt(i + 1))
                {
                    continue;
                }
            }

            cleaned = cleaned + result.charAt(i);
        }

        if (cleaned.endsWith("X"))
        {
            cleaned = cleaned.substring(0, cleaned.length() - 1);
        }

        return cleaned;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key)
    {
        if (!isStringInBounds(plainText))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < plainText.length(); i++)
        {
            char current = plainText.charAt(i);

            int position = current - LOWER_RANGE;
            position = position + key;
            position = position % RANGE;
            position = position + LOWER_RANGE;

            char encryptedChar = (char) position;

            result = result + encryptedChar;
        }

        return result;
    }
    public static String caesarDecryption(String encryptedText, int key)
    {
        if (!isStringInBounds(encryptedText))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < encryptedText.length(); i++)
        {
            char current = encryptedText.charAt(i);

            int position = current - LOWER_RANGE;
            position = position - key;
            position = position + RANGE;
            position = position % RANGE;
            position = position + LOWER_RANGE;

            char decryptedChar = (char) position;

            result = result + decryptedChar;
        }

        return result;
    } 

}
