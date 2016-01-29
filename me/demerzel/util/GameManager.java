package me.demerzel.util;

import me.demerzel.command.Command;
import me.demerzel.command.Commands;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.impl.*;
import me.demerzel.location.Location;
import me.demerzel.location.impl.Start;
import me.demerzel.location.impl.VentEast;
import me.demerzel.location.impl.VentEntrance;
import me.demerzel.location.impl.VentWest;
import me.demerzel.location.Exit;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private static GameManager gameManager;
    private static String command;

    private static Commands factory = new Commands();
    private static EntityPlayer player;

    public static GameManager getInstance(){
        if(gameManager != null){
            return gameManager;
        }

        gameManager = new GameManager();
        return gameManager;
    }

    public void begin(){
        showLocation();

        while(player.getHealth() > 0){
            action();
        }

        System.out.println("Your player's health has reached zero! Game Over! Retry?");
    }

    public void setup(){
        Location start = new Start();
        Location ventEntrance = new VentEntrance();
        Location ventWest = new VentWest();
        Location ventEast = new VentEast();

        start.addExit(new Exit(Exit.WEST, ventEntrance, true));
        ventEntrance.addExit(new Exit(Exit.WEST, ventWest, true));
        ventEntrance.addExit(new Exit(Exit.EAST, ventEast, true));
        ventEntrance.addExit(new Exit(Exit.SOUTH, start, true));
        ventEast.addExit(new Exit(Exit.WEST, ventEntrance, true));
        ventWest.addExit(new Exit(Exit.EAST, ventEntrance, true));

        player = new EntityPlayer("Sergeant Wolf", "A badass sergenat", start);

        start.addItem(new Revolver());
        start.addItem(new Sledgehammer());
        start.addItem(new Helmet());

        start.addUsableItem(new Revolver());
    }

    public void showLocation(){
        System.out.println(player.getLocation().getTitle());
        System.out.println(player.getLocation().getDescription() + "\n");
        System.out.println("Possible exits:");

        ArrayList<Exit> exits = player.getLocation().getExits();
        exits.stream().filter(Exit::getActive).forEach(exit -> System.out.println(exit.toString()));

        showEnemies();

    }

    public void showEnemies(){
        if(player.getLocation().getMobs().size() > 0){
            System.out.println("\nEnemies in room:");
            for(EntityMob mob: player.getLocation().getMobs()){
                System.out.println("[" + mob.getUid() + "] " + mob.getName() + " [HP: " + mob.getHealth() + " | Damage: " + mob.getStrength() + "]");
            }
        }
    }

    public boolean action(){
        command = Utilities.cmd("");
        String[] args = command.split("\\s+");
        Command cmd = factory.getCommand(args[0]);
        if(cmd != null){
            cmd.execute(args, player);
            return true;
        }

        System.out.println("You're spouting jibberish.");
        return true;
    }

    public EntityPlayer getPlayer(){
        return player;
    }
}
