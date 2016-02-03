package me.demerzel.entity.impl;

import me.demerzel.entity.*;
import me.demerzel.location.Location;
import me.demerzel.spell.impl.Fireball;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Dragon extends EntityMob implements EventKilled, EventBattle{
    public Dragon(Location location) {
        super("The Dragon", "The Final Boss", 300, 500, 7, location, 1000, 4000, 30, "The Dragon breathes fire at you! You offer him a breath mint, but he declines.", EntityBehavior.HOSTILE);
    }

    @Override
    public void onDeath(EntityPlayer player) {
        try{
            System.out.println();
            say("Did... I lose?", true);
            say("It wasn't even a close fight. You were much too powerful.", true);
            say("I was completely out of your league. But what will you do now?", true);
            say("Now that you are without a worthy match, when will the boredom set in as it did for me all those years ago?", true);
            say("Well, don't worry about that now. You are the victor! You have beaten the game.", true);
            say("Go celebrate with your friends. Take a load off. Congratulations, and thank you.", true);

            Thread.sleep(3000);
            System.out.println("===========================");
            System.out.println("         THE HUNT          ");
            System.out.println("===========================");
            System.out.println();
            Thread.sleep(1000);
            System.out.println("         CREDITS:          ");
            Thread.sleep(1000);
            System.out.println(" Main Developer | Jackson Yeager ");
            Thread.sleep(1000);
            System.out.println(" Main Developer | Brendan McCloskey ");
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

    @Override
    public void onBattle() {
        EntityPlayer player = GameManager.getInstance().getPlayer();
        say("Mortal, do you know who I am?", true);
        player.say("No... who are you?", true);
        say("I am The Dragon. The generic final boss in this video game.", true);
        player.say("Video Game?", true);
        say("Ah, I have forgotten you do not yet possess the power of the Fourth Wall.", true);
        say("Should you defeat me, you shall gain this power.", true);
        say("Well met, mortal. Let us begin our battle!", true);
    }
}
