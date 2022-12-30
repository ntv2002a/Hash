
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trung
 */
public class Inputter {

    static Scanner sc = new Scanner(System.in);

    public static String InputString(String mess, String regex) {
        String input;
        do {
            System.out.print(mess);
            sc = new Scanner(System.in);
            input = sc.nextLine();
            // Check empty
            if (input.isEmpty()) {
                System.err.println("Input can not be blank. Please try again!");
            } else {
                //Check regex empty    
                if (regex.isEmpty()) {
                    return input;
                } else {
                    //Check input matches regex if regex isn't empty        
                    if (input.matches(regex)) {
                        return input;
                    }
                    System.err.println("Invalid input. Please try again!");
                }
            }
        } while (true);
    }

    public static int InputInt(String mess) {
        sc = new Scanner(System.in);
        int n;
        String input;
        do {
            System.out.print(mess);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input can not be blank. Please try again!");
            } else {
                try {
                    n = Integer.parseInt(input);
                    return n;
                } catch (Exception e) {
                    System.err.println("Invalid input. Please try again!");
                }
            }
        } while (true);
    }
}
