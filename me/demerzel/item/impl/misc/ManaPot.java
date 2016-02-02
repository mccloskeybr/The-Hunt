package me.demerzel.item.impl.misc;

import me.demerzel.entity.Entity;
import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.item.Usable;

/**
 * Created by Demerzel on 2/1/16.
 */
public class ManaPot extends Item implements Usable{
    public ManaPot() {
        super(0, 25, 40, "ManaPot", "Restores 25 mana", "You used the Mana Potion!", false, ItemSlot.MISC, ItemType.FIREONCE);
    }


    @Override
    public void use(Entity entity) {
        int healed;

        if(entity.getMaxMana() - entity.getMana() < getMagnitude()){
            healed = entity.getMaxMana() - entity.getMana();
        }else{
            healed = getMagnitude();
        }


        entity.modMana(healed);
        System.out.println("You drank the potion. You gained " + healed + " Mana!");
    }
}
