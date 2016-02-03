package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.*;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.location.Location;
import me.demerzel.location.impl.Battleground;
import me.demerzel.util.BattleManager;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

import java.util.ArrayList;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Battle extends Command {
    public Battle(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        Location location = player.getLocation();
        if(player.getLocation().getMobs().size() > 1){
            if(args.length < 2){
                System.out.println("Which mob to attack?");
                return false;
            }

            if(!Utilities.isInteger(args[1])){
                System.out.println("You need to provide a number!");
                return false;
            }

            EntityMob mob = location.getMob(Integer.parseInt(args[1]));

            if(mob == null){
                System.out.println("Entity not found!");
                return false;
            }

            mob.setType(EntityBehavior.HOSTILE);
            Location battleground = new Battleground();
            player.setLocation(battleground);
            battleground.addMob(mob);
            GameManager.getInstance().getBattleManager().beginBattle(location, mob);
            GameManager.getInstance().showEntities();
            return true;
        }else if(player.getLocation().getMobs().size() > 0){
            EntityMob mob = player.getLocation().getMob(0);
            mob.setType(EntityBehavior.HOSTILE);
            Location battleground = new Battleground();
            player.setLocation(battleground);
            battleground.addMob(mob);
            GameManager.getInstance().getBattleManager().beginBattle(location, mob);
            return true;
        }else {
            System.out.println("There aren't any enemies in the room!");
        }

        return false;
    }
}
