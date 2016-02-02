package me.demerzel.util;

import me.demerzel.command.Command;
import me.demerzel.command.CommandManager;
import me.demerzel.command.impl.*;
import me.demerzel.entity.*;
import me.demerzel.location.Location;
import me.demerzel.spell.LingerEffect;
import me.demerzel.spell.Spell;
import me.demerzel.spell.SpellTarget;

import java.lang.reflect.Array;
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
    private ArrayList<Spell> lingeringSpells;

    public BattleManager(){
        allowedCommands = new ArrayList<>();
        lingeringSpells = new ArrayList<>();

        allowedCommands.add(Cast.class);
        allowedCommands.add(Crap.class);
        allowedCommands.add(Examine.class);
        allowedCommands.add(Equip.class);
        allowedCommands.add(Inventory.class);
        allowedCommands.add(Spellbook.class);
        allowedCommands.add(Use.class);
        allowedCommands.add(Wallet.class);
        allowedCommands.add(Attack.class);
        allowedCommands.add(Cheat.class);
    }

    public void beginBattle(Location old, EntityMob enemy){
        this.enemy = enemy;
        this.player = GameManager.getInstance().getPlayer();
        manager = GameManager.getInstance().getFactory();
        myTurn = enemy.getSpeed() <= player.getSpeed();

        System.out.println("============================");
        System.out.println("        BEGIN BATTLE!       ");
        System.out.println("============================");
        GameManager.getInstance().showEntities();

        if(enemy instanceof EventBattle){
            ((EventBattle) enemy).onBattle();
        }

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

        lingeringSpells.clear();
    }

    public void addLingerEffect(Spell spell){
        lingeringSpells.add(spell);
    }

    private void nextTurn(){
        if(myTurn){
            String command = Utilities.cmd("");
            String[] args = Utilities.parseInput(command);

            if(args.length < 1){
                return;
            }

            Command cmd = manager.getCommand(args[0]);
            if(cmd != null){
                if(isAllowed(command)){
                    cmd.execute(args, player);
                    if(cmd.getClass().equals(Attack.class) || cmd.getClass().equals(Cast.class) || cmd.getClass().equals(Use.class)){
                        myTurn = false;
                    }
                }else{
                    System.out.println("You can't use that command in battle!");
                }
            }else{
                System.out.println("You're spouting gibberish.");
            }
        }else{
            enemy.attack(player);
            for(Spell spell : lingeringSpells){
                if(spell.getTarget() == SpellTarget.SELF){
                    ((LingerEffect) spell).fire(player);
                }else{
                    ((LingerEffect) spell).fire(enemy);
                }
            }
            myTurn = true;
            System.out.println("Your Move!");
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
