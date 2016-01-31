package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

import java.util.ArrayList;

/**
 * Created by Demerzel on 1/28/16.
 */
public abstract class EntityMob extends Entity {
    private int expRewarded;
    private int moneyRewarded;
    private int strength;
    private String attackText;
    private ArrayList<Item> loot;

    public EntityMob(String name, String bio, int health, int mana, int speed, Location location, int expRewarded, int moneyRewarded, int strength, String attackText, EntityType type) {
        super(name, bio, health, mana, speed, location, type);
        this.loot = new ArrayList<>();
        this.expRewarded = expRewarded;
        this.moneyRewarded = moneyRewarded;
        this.strength = strength;
        this.attackText = attackText;
    }

    public int getExpRewarded() {
        return expRewarded;
    }

    public void setExpRewarded(int expRewarded) {
        this.expRewarded = expRewarded;
    }

    public int getMoneyRewarded() {
        return moneyRewarded;
    }

    public void setMoneyRewarded(int moneyRewarded) {
        this.moneyRewarded = moneyRewarded;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getAttackText() {
        return attackText;
    }

    public void setAttackText(String attackText) {
        this.attackText = attackText;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void addLoot(Item item){
        loot.add(item);
    }

    public void removeLoot(Item item){
        if(loot.contains(item)){
            loot.remove(item);
        }
    }

    public void attack(EntityPlayer player){
        System.out.println(getAttackText());
        double d = Math.random();
        if(d >= 0.1){
            int damage = Math.min(player.getHealth(), getStrength() - player.getArmor());

            if(damage < 0){
                damage = 0;
            }

            player.modHealth(-damage);
            System.out.println("You took " + damage + " damage! Remaining HP: [" + player.getHealth() + "]");
        }else{
            System.out.println("But he misses. What a jerk!");
        }
    }

    public void onAttack(EntityPlayer player){
        modHealth(-player.getAttack());
    }

    public void onDefeat() {
        System.out.println("You have defeated the " + getName());

        for(Item item:this.getLoot()){
            GameManager.getInstance().getPlayer().addItem(item);
            System.out.println("Looted " + item.getName() + " from " + getName());
        }

        System.out.println("Gained " + getExpRewarded() + " EXP!");
        System.out.println("Found " + getMoneyRewarded() + " coins!");
        GameManager.getInstance().getPlayer().modExperience(getExpRewarded());
        GameManager.getInstance().getPlayer().modMoney(getMoneyRewarded());
        System.out.println();
    }
}
