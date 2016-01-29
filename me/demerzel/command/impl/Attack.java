package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.Runnable;
import me.demerzel.util.GameManager;

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

        try{
            int arg = Integer.parseInt(args[1]);
            EntityMob target = player.getLocation().getMob(arg);

            if(target == null){
                System.out.println("Can't find that mob!");
                return false;
            }

            target.modHealth(-1 * player.getAttack());
            if(target.getHealth() <= 0){
                target.onDefeat();
                if(target instanceof Runnable){
                    ((Runnable) target).run();
                }
                player.getLocation().removeMob(target);
            }

            System.out.println();
            gameManager.showEnemies();
        }catch(Exception e){
            System.out.println("Enter a number.");
            return false;
        }

        return false;
    }
}
