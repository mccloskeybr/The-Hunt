package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;
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

    private BufferedImage image;

    public EntityMob(BufferedImage image, String name, String bio, int maxHealth, int maxMana, int speed, Location location, int expRewarded, int moneyRewarded, int strength, String attackText, EntityBehavior type) {
        super(name, bio, maxHealth, maxMana, speed, location, type);
        this.loot = new ArrayList<>();
        this.expRewarded = expRewarded;
        this.moneyRewarded = moneyRewarded;
        this.strength = strength;
        this.attackText = attackText;
        this.image = image;
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
        int damage = Math.min(getHealth(), player.getAttack());

        if(damage < 0){
            damage = 0;
        }
        modHealth(-damage);
    }

    public void onDefeat() {
        double d = Math.random();
        this.getLoot().stream().filter(item -> d >= 0.5).forEach(item -> {
            GameManager.getInstance().getPlayer().addItem(item);
            System.out.println("Looted " + item.getName() + " from " + getName());
        });

        System.out.println("Gained " + getExpRewarded() + " EXP!");
        System.out.println("Found " + getMoneyRewarded() + " coins!");
        GameManager.getInstance().getPlayer().modExperience(getExpRewarded());
        GameManager.getInstance().getPlayer().modMoney(getMoneyRewarded());
        System.out.println();
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(image, x, y, null);
    }
}
