package me.demerzel.entity.impl.shopkeepers;

import me.demerzel.command.impl.Spellbook;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EventInteract;
import me.demerzel.item.Item;
import me.demerzel.item.impl.armor.BodyArmor;
import me.demerzel.item.impl.misc.BookThunderbolt;
import me.demerzel.item.impl.misc.HealthPot;
import me.demerzel.item.impl.misc.ManaPot;
import me.demerzel.item.impl.weapon.BasicBow;
import me.demerzel.item.impl.weapon.Revolver;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

/**
 * Created by Demerzel on 2/2/16.
 */
public class Hobo extends Shopkeeper implements EventInteract {
    public Hobo(String name, Location location) {
        super(name, location, "Hey there sonny! I got a nice surprise for you. Just step right over here...");

        addLoot(new Revolver());
        addLoot(new BodyArmor());
        addLoot(new BasicBow());
        addLoot(new ManaPot());
        addLoot(new ManaPot());
        addLoot(new HealthPot());
        addLoot(new BookThunderbolt());
    }

    @Override
    public void onDefeat(){
        System.out.println("You killed the shopkeeper! Murderer!");
        System.out.println("On the bright side, you found " + getMoneyRewarded() + " coins and " + getExpRewarded() + " EXP. Enjoy the bloodmoney...");
        GameManager.getInstance().getPlayer().modMoney(getMoneyRewarded());
        GameManager.getInstance().getPlayer().modExperience(getExpRewarded());

        try{
            getLocation().setState(2);
        }catch(Exception ignored){

        }
    }
}
