package me.demerzel.util;

import me.demerzel.command.Command;
import me.demerzel.command.CommandManager;
import me.demerzel.command.impl.*;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EventKilled;
import me.demerzel.location.Location;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Demerzel on 1/31/16.
 */
public class BattleManager {
    private boolean myTurn;
    private EntityPlayer player;
    private EntityMob enemy;
    private CommandManager manager;
    private ArrayList<Class<? extends Command>> allowedCommands;

    public BattleManager(Location old, EntityMob enemy){
        this.enemy = enemy;
        this.player = GameManager.getInstance().getPlayer();
        manager = GameManager.getInstance().getFactory();
        allowedCommands = new ArrayList<>();

        allowedCommands.add(Cast.class);
        allowedCommands.add(Crap.class);
        allowedCommands.add(Examine.class);
        allowedCommands.add(Equip.class);
        allowedCommands.add(Inventory.class);
        allowedCommands.add(Spellbook.class);
        allowedCommands.add(Use.class);
        allowedCommands.add(Wallet.class);
        allowedCommands.add(Attack.class);

        myTurn = enemy.getSpeed() <= player.getSpeed();

        System.out.println("============================");
        System.out.println("        BEGIN BATTLE!       ");
        System.out.println("============================");
        GameManager.getInstance().showEntities();

        while(!isEnded()){
            nextTurn();
        }

        if(enemy.getHealth() <= 0){
            System.out.println("============================");
            System.out.println("          YOU WIN!          ");
            System.out.println("============================");
            enemy.onDefeat();
            if(enemy instanceof EventKilled){
                ((EventKilled) enemy).onDeath(player);
            }
            player.getLocation().removeMob(enemy);
            player.setLocation(old);
            old.removeMob(enemy);
        }else{
            System.out.println("============================");
            System.out.println("         YOU LOSE!          ");
            System.out.println("============================");
        }


    }

    private void nextTurn(){
        if(myTurn){
            String command = Utilities.cmd("");
            String[] args = Utilities.parseInput(command);
            Command cmd = manager.getCommand(args[0]);
            if(cmd != null){
                if(isAllowed(command)){
                    cmd.execute(args, player);
                    myTurn = false;
                }else{
                    System.out.println("You can't use that command in battle!");
                }
            }else{
                System.out.println("You're spouting gibberish.");
            }
        }else{
            enemy.attack(player);
            myTurn = true;
        }
    }

    private boolean isEnded(){
        return player.getHealth() <= 0 || enemy.getHealth() <= 0;
    }

    private boolean isAllowed(String cmd){
        for(Class<? extends Command> command : allowedCommands){
            if(manager.getAliases(command).contains(Utilities.parseInput(cmd)[0])){
                return true;
            }
        }

        return false;
    }


}
