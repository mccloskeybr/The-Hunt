package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.ItemType;
import me.demerzel.item.Usable;

import java.util.ArrayList;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Use extends Command{
    public Use(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        ArrayList<Item> used = new ArrayList<>();
        for(Item item : player.getInventory()){
            if(item.getName().equalsIgnoreCase(args[1])){
                if(item.getType() != ItemType.FIREONCE){
                    System.out.println("You can't use that item!");
                    return false;
                }

                ((Usable) item).use(player);

                if(!item.isPermanent()){
                    used.add(item);
                }

                break;
            }
        }

        player.getInventory().removeAll(used);
        return true;
    }
}
