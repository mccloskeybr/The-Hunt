package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.Attackable;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EventKilled;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.util.GameManager;

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
        GameManager gameManager = GameManager.getInstance();

        if(player.getLocation().getMobs().size() > 0){
            if(player.getEquipped().get(ItemSlot.WEAPON) == null ||
                    player.getEquipped().get(ItemSlot.WEAPON).getType() == ItemType.SINGLETARGET){
                try{
                    int arg = Integer.parseInt(args[1]);
                    EntityMob target = player.getLocation().getMob(arg);

                    if(target == null){
                        System.out.println("Can't find that mob!");
                        return false;
                    }

                    target.modHealth(- player.getAttack());
                    if(target.getHealth() <= 0){
                        target.onDefeat();
                        if(target instanceof EventKilled){
                            ((EventKilled) target).run();
                        }
                        player.getLocation().removeMob(target);
                    }else{
                        if(target instanceof Attackable){
                            ((Attackable) target).attack(player);
                        }
                    }

                    System.out.println();
                    gameManager.showEnemies();
                }catch(Exception e){
                    System.out.println("Enter a number.");
                    return false;
                }
            }else if(player.getEquipped().get(ItemSlot.WEAPON).getType() == ItemType.MULTITARGET){
                ArrayList<EntityMob> toRemove = new ArrayList<>();

                for(EntityMob mob : player.getLocation().getMobs()){
                    mob.modHealth(- player.getAttack());

                    if(mob.getHealth() <= 0){
                        mob.onDefeat();
                        if(mob instanceof EventKilled){
                            ((EventKilled) mob).run();
                        }
                        toRemove.add(mob);
                    }else{
                        if(mob instanceof Attackable){
                            ((Attackable) mob).attack(player);
                        }
                    }
                }

                player.getLocation().getMobs().removeAll(toRemove);
                System.out.println();
                gameManager.showEnemies();
            }
        }else{
            System.out.println("There aren't any enemies to attack, dude.");
        }

        return false;
    }
}
