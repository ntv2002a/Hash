import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trung
 */
public class HashSHA256 {

    public static String HashString() throws NoSuchAlgorithmException {
        String res = null;
        String Hash = Inputter.InputString("Input String need to Hash with SHA-256: ", "");
        String salt;
        byte[] bsalt = null;
        int c;
        // Choose whether to use "salt" or not
        do {
            c = Inputter.InputInt("Would you like to use salt? 2: Random Salt | 1: Yes | 0: No\nChoice: ");
            switch (c) {
                case 2:
                    bsalt = getRandomSalt();
                    break;
                case 1:
                    salt = Inputter.InputString("Input Salt: ", "");
                    bsalt = salt.getBytes();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Your should choose 2, 1 or 0. Please choose again!");
            }
            if (c == 1 || c == 0 || c == 2) {
                break;
            }
        } while (true);

        try {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            if (bsalt != null) {
                md.update(bsalt);
            }

            // digest() method called
            // to calculate message digest of an input
            byte[] bytes = md.digest(Hash.getBytes());

            // convert bytes array of message digest to string
            res = toHexString(bytes);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return res;
    }

    public static byte[] getRandomSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
