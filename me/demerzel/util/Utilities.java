package me.demerzel.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import me.demerzel.command.Command;
import org.jetbrains.annotations.Contract;
import java.util.*;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Utilities {
    public static String cmd(String output){
        System.out.println(output);
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase();
    }

    public static String[] parseInput(String input){
        input += " ";
        HashMap<String, Command> commands = GameManager.getInstance().getFactory().getCommandHashMap();
        ArrayList<String> parsedArray = new ArrayList<>();
        for(String key : commands.keySet()){
            if(input.startsWith(key)){
                parsedArray.add(key);
                input = input.substring(key.length() + 1);
                break;
            }
        }

        Collections.addAll(parsedArray, input.split("\\s+"));

        return parsedArray.toArray(new String[parsedArray.size()]);
    }

    @Contract("null -> false")
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
