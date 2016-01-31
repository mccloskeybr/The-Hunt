package me.demerzel.util;

import me.demerzel.command.Command;
import me.demerzel.command.CommandManager;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.impl.Fists;
import me.demerzel.location.Location;
import me.demerzel.location.impl.*;
import me.demerzel.location.Exit;

import java.util.ArrayList;

public class GameManager {
    private static GameManager gameManager;

    private CommandManager factory = new CommandManager();
    private EntityPlayer player;

    private GameManager(){

    }

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
        Location store = new Store();

        start.addExit(new Exit(Exit.WEST, ventEntrance, true));
        start.addExit(new Exit(Exit.NORTH, store, true));
        store.addExit(new Exit(Exit.SOUTH, start, true));
        ventEntrance.addExit(new Exit(Exit.WEST, ventWest, true));
        ventEntrance.addExit(new Exit(Exit.EAST, ventEast, true));
        ventEntrance.addExit(new Exit(Exit.OUT, start, true));
        ventEast.addExit(new Exit(Exit.WEST, ventEntrance, true));
        ventWest.addExit(new Exit(Exit.EAST, ventEntrance, true));

        player = new EntityPlayer("Main Character", "Character Bio", start);

        Item fist = new Fists();
        player.addItem(fist);
        player.equip(fist);
    }

    public void showLocation(){
        System.out.println(player.getLocation().getTitle());
        System.out.println(player.getLocation().getDescription() + "\n");
        System.out.println("Possible exits:");

        ArrayList<Exit> exits = player.getLocation().getExits();
        exits.stream().filter(Exit::getActive).forEach(exit -> System.out.println(exit.toString()));

        showEntities();
    }

    public void showEntities(){
        if(player.getLocation().getMobs().size() > 0){
            System.out.println("\nEntities in room:");
            for(EntityMob mob: player.getLocation().getMobs()){
                System.out.println("[" + player.getLocation().getMobs().indexOf(mob) + "] " + mob.getName() + " [HP: " + mob.getHealth() + " | Damage: " + mob.getStrength() + "]");
            }
        }
    }

    public boolean action(){
        String command = Utilities.cmd("");
        String[] args = Utilities.parseInput(command);
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

    public CommandManager getFactory(){
        return factory;
    }
}
