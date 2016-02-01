package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EventKilled;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.spell.Spell;
import me.demerzel.spell.SpellManager;
import me.demerzel.spell.SpellTarget;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

import java.util.ArrayList;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Cast extends Command {
    public Cast(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        SpellManager spellManager = new SpellManager();
        ArrayList<EntityMob> dead = new ArrayList<>();

        if(args.length < 2){
            System.out.println("Usage: cast <spell> <target>");
            return false;
        }

        Spell spell = spellManager.getSpell(args[1]);

        if(spell == null){
            System.out.println("Spell not found...");
            return false;
        }

        if(!player.hasSpell(spell)){
            System.out.println("You don't have that spell!");
            return false;
        }

        if(player.getMana() < spell.getCost()){
            System.out.println("You need more mana to cast that!");
            return false;
        }

        if(spell.getTarget() != SpellTarget.SELF){
            if(player.getLocation().getMobs().size() > 1){
                if(spell.getTarget() == SpellTarget.MULTITARGET){
                    for(EntityMob mob : player.getLocation().getMobs()){
                        spell.onCast(mob);
                        mob.setType(EntityBehavior.HOSTILE);
                        if(mob.getHealth() <= 0){
                            mob.onDefeat();
                            if(mob instanceof EventKilled){
                                ((EventKilled) mob).onDeath(player);
                            }
                            dead.add(mob);
                        }else{
                            mob.attack(player);
                        }
                    }

                    player.getLocation().getMobs().removeAll(dead);
                    GameManager.getInstance().showEntities();
                }else{
                    if(args.length < 3){
                        System.out.println("Which mob to attack?");
                        return false;
                    }

                    if(!Utilities.isInteger(args[2])){
                        System.out.println("You need to provide a number!");
                        return false;
                    }

                    EntityMob mob = player.getLocation().getMob(Integer.parseInt(args[2]));

                    if(mob == null){
                        System.out.println("Entity not found!");
                        return false;
                    }

                    spell.onCast(mob);
                    mob.setType(EntityBehavior.HOSTILE);
                    if(mob.getHealth() <= 0){
                        mob.onDefeat();
                        if(mob instanceof EventKilled){
                            ((EventKilled) mob).onDeath(player);
                        }
                        player.getLocation().removeMob(mob);
                    }else{
                        mob.attack(player);
                    }
                }

                GameManager.getInstance().showEntities();
            }else if(player.getLocation().getMobs().size() > 0){
                EntityMob mob = player.getLocation().getMob(0);

                spell.onCast(mob);
                mob.setType(EntityBehavior.HOSTILE);
                if(mob.getHealth() <= 0){
                    mob.onDefeat();
                    if(mob instanceof EventKilled){
                        ((EventKilled) mob).onDeath(player);
                    }
                    player.getLocation().removeMob(mob);
                }else{
                    mob.attack(player);
                }

                GameManager.getInstance().showEntities();
            }else {
                System.out.println("There aren't any enemies in the room!");
                return false;
            }
        }else{
            spell.onCast(player);
        }

        player.modMana(-spell.getCost());
        return true;
    }
}
