package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.impl.Shopkeeper;
import me.demerzel.item.Item;
import me.demerzel.location.Location;
import me.demerzel.location.impl.Store;
import me.demerzel.util.GameManager;

import java.util.ArrayList;

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

        Location location = player.getLocation();
        if(location instanceof Store){
            for(EntityMob mob : location.getMobs()){
                if(mob instanceof Shopkeeper){
                    for(Item item : mob.getLoot()){
                        if(args[1].equalsIgnoreCase(item.getName())){
                            if(player.getMoney() >= item.getPrice()){
                                player.addItem(item);
                                player.modMoney(-item.getPrice());
                                mob.removeLoot(item);
                                System.out.println("You bought the " + item.getName());
                                ((Shopkeeper) mob).interact();
                                return true;
                            }

                            System.out.println("You don't have enough money!");
                            return true;
                        }
                    }

                    System.out.println("Can't find that item...");
                    return true;
                }
            }


        }else{
            System.out.println("You can't buy anything here!");
        }

        return false;
    }
}
