package me.demerzel.entity.impl.shopkeepers;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EventInteract;
import me.demerzel.item.Item;
import me.demerzel.item.impl.armor.BodyArmor;
import me.demerzel.item.impl.misc.HealthPot;
import me.demerzel.item.impl.misc.ManaPot;
import me.demerzel.item.impl.weapon.BasicBow;
import me.demerzel.item.impl.weapon.Revolver;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

/**
 * Created by Demerzel on 1/29/16.
 */
public abstract class Shopkeeper extends EntityMob implements EventInteract {
    private String interact;

    public Shopkeeper(String name, Location location, String interact) {
        super(name, "A man born to sell goods. When you buy his stuff, you give him purpose in life.", 5, 0, 1, location, 100000, 2000, 1, "The Shopkeeper punches you in the nose!", EntityBehavior.NEUTRAL);
        this.interact = interact;
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

    @Override
    public void interact() {
        if(getType() == EntityBehavior.NEUTRAL){
            say(interact, false);
            say("What would you like to buy?", false);
            System.out.println("=========== Shop ============");
            for (Item item : getLoot()){
                System.out.println("> " + item.getName() + " [" + item.getPrice() + "] | " + item.getDescription());
            }
            System.out.println("=============================");
        }else{
            say("Screw you!", false);
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
                        say("Thanks for the purchase!", false);
                        interact();
                        return true;
                    }

                    say("You don't have enough money!", false);
                    return true;
                }
            }

            say("I don't have that item in stock...", false);
            return false;
        }else{
            say("Get out of my shop!", false);
            return false;
        }
    }

    public String getInteract() {
        return interact;
    }

    public void setInteract(String interact) {
        this.interact = interact;
    }
}
