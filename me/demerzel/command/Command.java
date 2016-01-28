package me.demerzel.command;


public abstract class Command {
    private String[] aliases;
    private String description;

    public Command(String[] aliases){
        this.aliases = aliases;
    }

    public abstract boolean execute(String[] args);

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
