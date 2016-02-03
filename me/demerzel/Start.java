package me.demerzel;

import me.demerzel.command.Command;
import me.demerzel.item.impl.armor.BodyArmor;
import me.demerzel.item.impl.weapon.BasicBow;
import me.demerzel.item.impl.weapon.Revolver;
import me.demerzel.spell.impl.Fireball;
import me.demerzel.spell.impl.Heal;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

import javax.rmi.CORBA.Util;
import java.util.Scanner;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Start {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        gameManager.setup();

        String name = Utilities.cmd("Who are you?");
        String desc = Utilities.cmd("Tell me about yourself?");
        String stat1 = Utilities.cmd("What do you value more? The Spirit or the Body?");

        switch(stat1){
            case "spirit":
            case "the spirit":
                gameManager.getPlayer().modMaxMana(10);
                gameManager.getPlayer().modMaxHealth(-10);
                System.out.println("So you value the Spirit more?");
                break;
            case "body":
            case "the body":
                gameManager.getPlayer().modMaxHealth(15);
                gameManager.getPlayer().modMaxMana(-20);
                System.out.println("So you value the Body more?");
                break;
            case "both":
                gameManager.getPlayer().modMaxMana(5);
                gameManager.getPlayer().modMaxHealth(10);
                System.out.println("Ah, a balance. Very wise.");
                break;
            default:
                System.out.println("You value neither? Very well...");
        }

        String stat2 = Utilities.cmd("What is more useful? Magic or Physical Weapons?");

        switch(stat2){
            case "magic":
                gameManager.getPlayer().addSpell(new Fireball());
                gameManager.getPlayer().addSpell(new Heal());
                System.out.println("Ah, a very useful art indeed.");
                break;
            case "weapons":
            case "physical weapons":
            case "physical":
                gameManager.getPlayer().addItem(new BasicBow());
                gameManager.getPlayer().addItem(new BodyArmor());
                System.out.println("You prefer something more concrete? Understandable.");
                break;
            default:
                System.out.println("You prefer neither? Interesting.");
        }

        System.out.println("When you're ready to start, hit <Enter>");
        Utilities.cmd("");

        System.out.println();
        System.out.println("===============================");
        System.out.println("      Welcome to The Hunt!     ");
        System.out.println("===============================");
        System.out.println();


        gameManager.getPlayer().setName(name);
        gameManager.getPlayer().setBio(desc);
        gameManager.getPlayer().heal();

        gameManager.begin();
    }
}
