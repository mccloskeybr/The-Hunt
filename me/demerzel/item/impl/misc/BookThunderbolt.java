package me.demerzel.item.impl.misc;

import me.demerzel.entity.Entity;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.item.Usable;
import me.demerzel.spell.impl.Thunderbolt;

/**
 * Created by Demerzel on 2/1/16.
 */
public class BookThunderbolt extends Item implements Usable {
    public BookThunderbolt() {
        super(0, 0, 200, "Spellbook:Thunderbolt", "Teaches the user the Thunderbolt spell", "Ancient knowledge is now yours! You now know Thunderbolt!", false, ItemSlot.MISC, ItemType.FIREONCE);
    }

    @Override
    public void use(Entity entity) {
        entity.addSpell(new Thunderbolt());
        System.out.println(getUseText());
    }
}
