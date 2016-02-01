package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.util.GameManager;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Attack extends Command {
    public Attack(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        EntityMob mob = player.getLocation().getMob(0);


        System.out.println("You attacked the " + mob.getName() + "! It took " + player.getAttack() + " damage!");
        mob.onAttack(player);
        GameManager.getInstance().showEntities();
        System.out.println();
        return false;
    }
}
