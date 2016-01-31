package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EventInteract;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Interact extends Command {
    public Interact(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        if(player.getLocation().getMobs().size() > 1){
            try{
                EntityMob target = player.getLocation().getMob(Integer.parseInt(args[1]));
                if(target instanceof EventInteract){
                    ((EventInteract) target).interact();
                    return true;
                }else{
                    System.out.println("Can't interact with that entity...");
                    return true;
                }
            }catch (Exception e){
                System.out.println("Enter a number!");
                return true;
            }
        }else if(player.getLocation().getMobs().size() > 0){
            EntityMob target = player.getLocation().getMobs().get(0);
            if(target instanceof EventInteract){
                ((EventInteract) target).interact();
                return true;
            }
        }

        System.out.println("There isn't anyone in the room you can interact with...");
        return false;
    }
}
