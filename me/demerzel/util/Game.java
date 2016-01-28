package me.demerzel.util;

import me.demerzel.command.Command;
import me.demerzel.command.CommandFactory;
import me.demerzel.item.impl.Helmet;
import me.demerzel.item.impl.Revolver;
import me.demerzel.item.impl.Sledgehammer;
import me.demerzel.location.Location;
import me.demerzel.location.impl.Start;
import me.demerzel.location.impl.VentEast;
import me.demerzel.location.impl.VentEntrance;
import me.demerzel.location.impl.VentWest;
import me.demerzel.location.Exit;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static String command;

    private static int game = 1;
    private static CommandFactory factory = new CommandFactory();
    private static Player player;

    public static void main(String[] args) {
        Location start = new Start();
        Location ventEntrance = new VentEntrance();
        Location ventWest = new VentWest();
        Location ventEast = new VentEast();

        start.addExit(new Exit(Exit.WEST, ventEntrance, true));
        ventEntrance.addExit(new Exit(Exit.WEST, ventWest, true));
        ventEntrance.addExit(new Exit(Exit.EAST, ventEast, true));
        ventEast.addExit(new Exit(Exit.WEST, ventEntrance, true));
        ventWest.addExit(new Exit(Exit.EAST, ventEntrance, true));

        player = new Player("Sergeant Wolf", "A badass sergenat", start);

        start.addItem(new Revolver());
        start.addItem(new Sledgehammer());
        start.addItem(new Helmet());

        start.addUsableItem(new Revolver());

        //Begin game
        System.out.println("Welcome to The Hunt");
        command = cmd("Enter <Start> to begin!");
        if(command.equalsIgnoreCase("start")){
            begin();
        }
    }

    private static String cmd(String output){
        System.out.println(output);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void begin(){
        showLocation();

        while(player.getHealth() > 0){
            action();
        }

        System.out.println("Your player's health has reached zero! Game Over! Retry?");
    }

    public static void showLocation(){
        System.out.println(player.getLocation().getTitle());
        System.out.println(player.getLocation().getDescription() + "\n");
        System.out.println("Possible exits:");

        ArrayList exits = player.getLocation().getExits();
        for(Object o: exits){
            Exit exit = (Exit) o;
            if(exit.getActive()){
                System.out.println(exit.toString());
            }
        }

    }

    private static boolean action(){
        command = cmd("");
        String[] args = command.split("\\s+");
        Command cmd = factory.getCommand(args[0]);
        if(cmd != null){
            cmd.execute(args);
            return true;
        }

        System.out.println("You're spouting jibberish.");
        return true;
    }

    public static Player getPlayer(){
        return player;
    }
}
