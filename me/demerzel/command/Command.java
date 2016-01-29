package me.demerzel.command;


import me.demerzel.entity.EntityPlayer;

public abstract class Command {
    private String[] aliases;
    private String description;

    public Command(String... aliases){
        this.aliases = aliases;
    }

    public abstract boolean execute(String[] args, EntityPlayer player);

    public void register(Commands commandManager){
        for(String name : aliases){
            commandManager.add(name, this);
        }
    }

    public String[] getAliases() {
        return aliases;
    }

    public String getDescription() {
        return description;
    }

    public Command setDescription(String description) {
        this.description = description;
        return this;
    }
}
