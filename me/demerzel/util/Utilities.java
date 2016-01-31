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

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
