package me.demerzel.util;

import me.demerzel.Window;
import me.demerzel.command.Command;
import me.demerzel.command.CommandManager;
import me.demerzel.command.impl.*;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.impl.weapon.Fists;
import me.demerzel.location.Exit;
import me.demerzel.location.Location;
import me.demerzel.location.impl.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager extends JPanel{
    private static GameManager gameManager;
    private CommandManager factory = new CommandManager();
    private BattleManager battleManager;
    private ArrayList<Class<? extends Command>> allowedCommands;
    private EntityPlayer player;

    private JTextArea infoBox;
    private JTextField cmdBox;

    private Window window;

    private GameManager(){
        allowedCommands = new ArrayList<>();
        allowedCommands.add(Battle.class);
        allowedCommands.add(Buy.class);
        allowedCommands.add(Crap.class);
        allowedCommands.add(Dance.class);
        allowedCommands.add(Die.class);
        allowedCommands.add(Equip.class);
        allowedCommands.add(Examine.class);
        allowedCommands.add(Go.class);
        allowedCommands.add(Interact.class);
        allowedCommands.add(Inventory.class);
        allowedCommands.add(Pickup.class);
        allowedCommands.add(Spellbook.class);
        allowedCommands.add(Use.class);
        allowedCommands.add(Wallet.class);
        allowedCommands.add(Cheat.class);
        allowedCommands.add(Help.class);

        battleManager = new BattleManager();

        infoBox = new JTextArea();
        infoBox.setBounds(5, Window.WINDOW_SIZE + 30, Window.WINDOW_SIZE - 10, Window.WINDOW_SIZE - 40);
        infoBox.setEditable(false);
        infoBox.setLineWrap(true);
        infoBox.setVisible(true);
        infoBox.setText("Info area!");

        cmdBox = new JTextField();
        cmdBox.setBounds(5, Window.WINDOW_SIZE, Window.WINDOW_SIZE, 30);
        cmdBox.addActionListener(e -> action());
        cmdBox.setEditable(true);
        cmdBox.setText("Command area!");

        window = new Window();
        window.addComponent(this);
        window.addComponent(infoBox);
        window.addComponent(cmdBox);

    }

    public static GameManager getInstance(){
        if(gameManager != null){
            return gameManager;
        }

        gameManager = new GameManager();
        return gameManager;
    }

    public void begin(){
        showLocation();

        while(player.getHealth() > 0){
            action();
        }

        System.out.println("Your player's health has reached zero! Game Over! Retry?");
    }

    public void setup(){
        Location start = new Start();
        Location ventEntrance = new VentEntrance();
        Location ventWest = new VentWest();
        Location ventEast = new VentEast();
        Location ventMoreWest = new VentMoreWest();

        start.addExit(new Exit(Exit.WEST, ventEntrance, true));

        ventEntrance.addExit(new Exit(Exit.WEST, ventWest, true));
        ventEntrance.addExit(new Exit(Exit.EAST, ventEast, true));
        ventEntrance.addExit(new Exit(Exit.OUT, start, true));

        ventEast.addExit(new Exit(Exit.WEST, ventEntrance, true));

        ventWest.addExit(new Exit(Exit.EAST, ventEntrance, true));
        ventWest.addExit(new Exit(Exit.WEST, ventMoreWest, true));

        ventMoreWest.addExit(new Exit(Exit.EAST, ventWest, true));

        player = new EntityPlayer("Main Character", "Character Bio", start);

        Item fist = new Fists();
        player.addItem(fist);
        player.equip(fist);
    }

    public void showLocation(){
        System.out.println(player.getLocation().getTitle());
        System.out.println(player.getLocation().getDescription() + "\n");

        showExits();
        showEntities();
    }

    public void showExits(){
        System.out.println("Possible exits:");

        ArrayList<Exit> exits = player.getLocation().getExits();
        for(Exit exit : exits){
            System.out.println(exit.toString() + " | " + exit.getLeadsTo().getTitle());
        }
    }

    public void showEntities(){
        if(player.getLocation().getMobs().size() > 0){
            System.out.println("\nEntities in room:");
            for(EntityMob mob: player.getLocation().getMobs()){
                System.out.println("[" + player.getLocation().getMobs().indexOf(mob) + "] " + mob.getName() + " [HP: " + mob.getHealth() + " | Damage: " + mob.getStrength() + "]");
            }
        }
    }

    public boolean action(){
        String command = cmdBox.getText();
        cmdBox.setText("");
        String[] args = Utilities.parseInput(command);

        if(args.length < 1){
            return false;
        }

        Command cmd = factory.getCommand(args[0]);
        if(cmd != null){
            if(isAllowed(command)){
                cmd.execute(args, player);
            }else{
                System.out.println("You can't use that command outside of battle!");
            }
        }else{
            System.out.println("You're spouting gibberish.");
        }
        return true;
    }

    public EntityPlayer getPlayer(){
        return player;
    }

    public CommandManager getFactory(){
        return factory;
    }

    private boolean isAllowed(String cmd){
        for(Class<? extends Command> command : allowedCommands){
            if(factory.getAliases(command).contains(Utilities.parseInput(cmd)[0])){
                return true;
            }
        }

        return false;
    }

    public BattleManager getBattleManager(){
        return battleManager;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.getLocation().render(g);

        infoBox.repaint();
        cmdBox.repaint();
    }
}
