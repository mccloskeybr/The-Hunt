package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.Interactable;
import me.demerzel.item.Item;
import me.demerzel.item.impl.Helmet;
import me.demerzel.item.impl.Revolver;
import me.demerzel.item.impl.Sledgehammer;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Shopkeeper extends EntityMob implements Interactable{
    private boolean isAttacked;

    public Shopkeeper(Location location) {
        super("The Shopkeeper", "A man born to sell goods. When you buy his stuff, you give him purpose in life.", 5, 0, 1, location, 100000, 2000, 1, "The Shopkeeper punches you in the nose!");

        addLoot(new Revolver());
        addLoot(new Sledgehammer());
        addLoot(new Helmet());
    }

    @Override
    public void onDefeat(){
        System.out.println("You killed the shopkeeper! Murderer!");
        System.out.println("On the bright side, you found " + getMoneyRewarded() + " coins. Enjoy the bloodmoney...");
        GameManager.getInstance().getPlayer().modMoney(getMoneyRewarded());
        GameManager.getInstance().getPlayer().modExperience(getExpRewarded());
    }

    @Override
    public void interact() {
        if(!isAttacked()){
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

    public boolean isAttacked() {
        return isAttacked;
    }

    public void setAttacked(boolean attacked) {
        isAttacked = attacked;
    }
}
