package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.impl.shopkeepers.Shopkeeper;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Buy extends Command {
    public Buy(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        if(args.length < 2){
            System.out.println("Buy what?");
            return false;
        }

        for(EntityMob mob : player.getLocation().getMobs()){
            if(mob instanceof Shopkeeper){
                ((Shopkeeper) mob).buy(player, args[1]);
                return true;
            }
        }

        System.out.println("There aren't any shopkeepers here!");
        return false;
    }
}
