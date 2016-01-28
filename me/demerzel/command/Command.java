package me.demerzel.command;


public abstract class Command {
    private String[] aliases;
    private String description;

    public Command(String[] aliases, String description){
        this.aliases = aliases;
        this.description = description;
    }

    public abstract boolean execute(String[] args);

    public void register(Commands commandManager){
        for(String name : aliases){
            commandManager.add(name, this);
        }
    }
}
