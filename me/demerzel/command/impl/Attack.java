package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.*;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

import java.util.ArrayList;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Attack extends Command {
    public Attack(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        ArrayList<EntityMob> dead = new ArrayList<>();

        if(player.getLocation().getMobs().size() > 1){
            if(player.getEquipped().get(ItemSlot.WEAPON).getType() == ItemType.MULTITARGET){
                for(EntityMob mob : player.getLocation().getMobs()){
                    mob.onAttack(player);
                    if(mob.getHealth() <= 0){
                        mob.onDefeat();
                        if(mob instanceof EventKilled){
                            ((EventKilled) mob).onDeath(player);
                        }
                        dead.add(mob);
                    }else{
                        mob.attack(player);
                    }
                }

                player.getLocation().getMobs().removeAll(dead);
                GameManager.getInstance().showEntities();
                return true;
            }else{
                if(args.length < 2){
                    System.out.println("Which mob to attack?");
                    return false;
                }

                if(!Utilities.isInteger(args[1])){
                    System.out.println("You need to provide a number!");
                    return false;
                }

                EntityMob mob = player.getLocation().getMob(Integer.parseInt(args[1]));

                if(mob == null){
                    System.out.println("Entity not found!");
                    return false;
                }

                mob.onAttack(player);
                if(mob.getHealth() <= 0){
                    mob.onDefeat();
                    if(mob instanceof EventKilled){
                        ((EventKilled) mob).onDeath(player);
                    }
                    player.getLocation().removeMob(mob);
                }else{
                    mob.attack(player);
                }
            }

            GameManager.getInstance().showEntities();
            return true;
        }else if(player.getLocation().getMobs().size() > 0){
            EntityMob mob = player.getLocation().getMob(0);

            mob.onAttack(player);
            if(mob.getHealth() <= 0){
                mob.onDefeat();
                if(mob instanceof EventKilled){
                    ((EventKilled) mob).onDeath(player);
                }
                player.getLocation().removeMob(mob);
            }else{
                mob.attack(player);
            }

            GameManager.getInstance().showEntities();
            return true;
        }else {
            System.out.println("There aren't any enemies in the room!");
        }

        return false;
    }
}
