package edu.unm.studentweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dhino_000 on 1/15/14.
 */
public class UsingExceptions {
    public static void main(String[] args) {
        File file = new File("C:\\ILikeBeer.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Oh Oh");
        } finally {
            System.out.println("Cleanup Aisle 3");
        }

        System.out.println("Onward!");

        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Good going math genius");
        }

        System.out.println("Even more onward!");
    }
}
