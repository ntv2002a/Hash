
import java.security.NoSuchAlgorithmException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trung
 */
public class main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String hashRes = HashSHA256.HashString();
        System.out.println("Hashed string using SHA-256: " + hashRes);
    }
}
