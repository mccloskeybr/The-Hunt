package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EntityType;
import me.demerzel.entity.EventKilled;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Dragon extends EntityMob implements EventKilled{
    public Dragon(Location location) {
        super("The Dragon", "The Final Boss", 300, 500, 7, location, 1000, 4000, 30, "The Dragon breathes fire at you! You offer him a breath mint, but he declines.", EntityType.HOSTILE);
    }

    @Override
    public void onDeath(EntityPlayer player) {
        try{
            System.out.println();
            Thread.sleep(2000);
            say("Did... I lose?");
            Thread.sleep(2000);
            say("It wasn't even a close fight. You were much too powerful.");
            Thread.sleep(2000);
            say("I was completely out of your league. But what will you do now?");
            Thread.sleep(2000);
            say("Now that you are without a worthy match, when will the boredom set in as it did for me all those years ago?");
            Thread.sleep(2000);
            say("Well, don't worry about that now. You are the victor! You have beaten the game.");
            Thread.sleep(2000);
            say("Go celebrate with your friends. Take a load off. Congratulations, and thank you.");
            Thread.sleep(3000);
            System.out.println("===========================");
            System.out.println("         THE HUNT          ");
            System.out.println("===========================");
            System.out.println();
            Thread.sleep(1000);
            System.out.println("         CREDITS:          ");
            Thread.sleep(1000);
            System.out.println(" Main Developer | Demerzel ");
            Thread.sleep(1000);
            System.out.println("    Code Assist | Micro    ");
            Thread.sleep(1000);
            System.out.println("    Code Assist | Space    ");
            Thread.sleep(1000);
            System.out.println("      Storyline | Sean Hackett");
            Thread.sleep(1000);
            System.out.println("      Storyline | Justin Gleason");
            System.out.println();
            Thread.sleep(1000);
            System.out.println("===========================");
            System.out.println("    THANKS FOR PLAYING!    ");
            System.out.println("===========================");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
