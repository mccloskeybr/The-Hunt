package me.demerzel.location;

import me.demerzel.Window;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EntityMob;
import me.demerzel.item.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


public abstract class Location {
    private String title;
    private String description;
    private HashMap<Integer, String> states;
    private int state;
    private ArrayList<Exit> exits;
    private ArrayList<Item> items;
    private ArrayList<Item> usableItems;
    private ArrayList<EntityMob> mobs;
    private BufferedImage image;

    public Location(BufferedImage image, String title, String description, HashMap<Integer, String> states, int state, ArrayList<Exit> exits, ArrayList<Item> items, ArrayList<Item> usableItems, ArrayList<EntityMob> mobs) {
        this.title = title;
        this.description = description;
        this.states = states;
        this.state = state;
        this.exits = exits;
        this.items = items;
        this.usableItems = usableItems;
        this.mobs = mobs;
        this.image = image;
    }

    public Location(BufferedImage image, String title, String description){
        this(image, title, description, new HashMap<>(), 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public String toString(){
        return this.title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public void addExit(Exit exit){
        this.exits.add(exit);
    }

    public void removeExit(Exit exit){
        if(exits.contains(exit)){
            exits.remove(exit);
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        if(items.contains(item)){
            items.remove(item);
        }
    }

    public ArrayList<Item> getUsableItems() {
        return usableItems;
    }

    public void addUsableItem(Item item){
        usableItems.add(item);
    }

    public void removeUsableItem(Item item){
        if(usableItems.contains(item)){
            usableItems.remove(item);
        }
    }

    public boolean canUse(Item item){
        for(Object o : this.usableItems){
            Item item1 = (Item) o;
            if(item.getName().equalsIgnoreCase(item1.getName())){
                return true;
            }
        }

        return false;
    }

    public HashMap getStates() {
        return states;
    }

    public String getCurrentState(){
        return states.get(this.state);
    }

    public void addState(int state, String description){
        this.states.put(state, description);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ArrayList<EntityMob> getMobs(){
        return mobs;
    }

    public ArrayList<EntityMob> getMobs(EntityBehavior behavior){
        return this.getMobs().stream().filter(mob -> mob.getType() == behavior).collect(Collectors.toCollection(ArrayList::new));
    }

    public EntityMob getMob(int i){
        try{
            return getMobs().get(i);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public void addMob(EntityMob mob){
        mobs.add(mob);
    }

    public void removeMob(EntityMob mob){
        if(mobs.contains(mob)){
            mobs.remove(mob);
        }
    }

    public void render(Graphics g){

        g.drawImage(image, 0, 0, Window.WINDOW_SIZE, Window.WINDOW_SIZE, null);

        for (int i = 0; i < mobs.size(); i++) {
            if (i % 2 == 0)
                mobs.get(i).render(g, Window.WINDOW_SIZE / 2 + 64 * i, 200);
            else
                mobs.get(i).render(g, Window.WINDOW_SIZE / 2 - 64 * i, 200);
        }
    }
}
