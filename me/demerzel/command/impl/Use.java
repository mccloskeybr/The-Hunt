package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.Usable;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

public class Use extends Command {
    public Use(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        Location location = player.getLocation();
        for(Item item : player.getInventory()){
            if(item instanceof Usable){
                if(item.getName().equalsIgnoreCase(args[1])){
                    if(location.canUse(item)){
                        System.out.println(item.getUseText());
                        ((Usable) item).use();
                        location.removeUsableItem(item);
                        if(!item.isPermanent()){
                            player.removeItem(item);
                        }
                        return true;
                    }else{
                        System.out.println("You can't use that here.");
                        return true;
                    }
                }
            }else{
                System.out.println("No matter how hard you try to use it, it just refuses to be used. Shame on you.");
                return true;
            }
        }

        System.out.println("You don't have that item.");
        return false;
    }
}
