package me.demerzel.item;

/**
 * Created by yeagerja on 1/27/16.
 */
public enum ItemSlot {
    HEAD("Head"), CHEST("Chest"), PANTS("Pants"), BOOTS("Boots"), WEAPON("Weapon"), BACKUP("Backup"), DEFAULT("Defaut");

    private final String name;
    ItemSlot(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
