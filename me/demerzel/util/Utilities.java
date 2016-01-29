package me.demerzel.util;

import java.util.Scanner;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Utilities {
    public static String cmd(String output){
        System.out.println(output);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
