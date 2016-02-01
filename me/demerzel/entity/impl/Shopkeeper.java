package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EventInteract;
import me.demerzel.item.Item;
import me.demerzel.item.impl.*;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Shopkeeper extends EntityMob implements EventInteract {

    public Shopkeeper(Location location) {
        super("The Shopkeeper", "A man born to sell goods. When you buy his stuff, you give him purpose in life.", 5, 0, 1, location, 100000, 2000, 1, "The Shopkeeper punches you in the nose!", EntityBehavior.NEUTRAL);
        addLoot(new Revolver());
        addLoot(new BodyArmor());
        addLoot(new BasicBow());

    }

    @Override
    public void onDefeat(){
        System.out.println("You killed the shopkeeper! Murderer!");
        System.out.println("On the bright side, you found " + getMoneyRewarded() + " coins and " + getExpRewarded() + " EXP. Enjoy the bloodmoney...");
        GameManager.getInstance().getPlayer().modMoney(getMoneyRewarded());
        GameManager.getInstance().getPlayer().modExperience(getExpRewarded());
    }

    @Override
    public void interact() {
        if(getType() == EntityBehavior.NEUTRAL){
            say("Hello! Welcome to Generic Shop!");
            say("What would you like to buy?");
            for (Item item : getLoot()){
                System.out.println("> " + item.getName() + " [" + item.getPrice() + "] | " + item.getDescription());
            }
        }else{
            say("Screw you!");
            System.out.println();
        }
    }

    public boolean buy(EntityPlayer player, String item){
        if(getType() != EntityBehavior.HOSTILE){
            for(Item i : getLoot()){
                if(item.equalsIgnoreCase(i.getName())){
                    if(player.getMoney() >= i.getPrice()){
                        player.addItem(i);
                        player.modMoney(-i.getPrice());
                        removeLoot(i);
                        say("Thanks for the purchase!");
                        interact();
                        return true;
                    }

                    say("You don't have enough money!");
                    return true;
                }
            }

            say("I don't have that item in stock...");
            return false;
        }else{
            say("Get out of my shop!");
            return false;
        }
    }
}
