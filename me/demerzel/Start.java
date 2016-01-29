package me.demerzel;

import me.demerzel.command.Command;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

import java.util.Scanner;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Start {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        System.out.println("Welcome to The Hunt");
        String command = Utilities.cmd("Enter <Start> to begin!");
        if (command.equalsIgnoreCase("start")) {
            gameManager.setup();
            gameManager.begin();
        }
    }
}
