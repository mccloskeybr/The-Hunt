package me.demerzel.item.impl.misc;

import me.demerzel.entity.Entity;
import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.item.Usable;

/**
 * Created by Demerzel on 1/31/16.
 */
public class HealthPot extends Item implements Usable {
    public HealthPot() {
        super(0, 20, 20, "Potion", "Heals 20 HP", "You used the Health Potion!", false, ItemSlot.MISC, ItemType.FIREONCE);
    }

    @Override
    public void use(Entity entity) {
        int healed;

        if(entity.getMaxHealth() - entity.getHealth() < getMagnitude()){
            healed = entity.getMaxHealth() - entity.getHealth();
        }else{
            healed = getMagnitude();
        }

        entity.modHealth(healed);
        System.out.println("You drank the potion. You gained " + healed + " HP!");
    }
}
