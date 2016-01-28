package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.util.Game;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Attack extends Command {
    public Attack(String[] aliases, String description) {
        super(aliases, description);
    }

    @Override
    public boolean execute(String[] args) {
        try{
            int arg = Integer.parseInt(args[1]);
            EntityPlayer player = Game.getPlayer();
            EntityMob target = player.getLocation().getMob(arg);

            if(target == null){
                System.out.println("Can't find that mob!");
                return false;
            }

            target.modHealth(-1 * player.getAttack());
            if(target.getHealth() <= 0){
                target.onDefeat();
                Game.getPlayer().getLocation().removeMob(target);
            }

            System.out.println();
            Game.showEnemies();
        }catch(Exception e){
            System.out.println("Enter a number.");
            return false;
        }

        return false;
    }
}
