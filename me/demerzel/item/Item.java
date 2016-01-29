package me.demerzel.item;


public abstract class Item {
    private int id;
    private int armor;
    private int damage;
    private int price;
    private String name;
    private String description;
    private String useText;
    private boolean permanent;
    private ItemSlot slot;
    private ItemType type;

    public Item(int id, int armor, int damage, int price, String name, String description, String useText, boolean permanent, ItemSlot slot, ItemType type){
        this.id = id;
        this.name = name;
        this.armor = armor;
        this.damage = damage;
        this.price = price;
        this.description = description;
        this.useText = useText;
        this.permanent = permanent;
        this.slot = slot;
        this.type = type;
    }

    public Item(){
        this(0, 0, 0, 0, "Null item", "Null desc", "Nothing", true, ItemSlot.DEFAULT, ItemType.DEFAULT);
    }

    public String toString(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUseText() {
        return useText;
    }

    public void setUseText(String useText) {
        this.useText = useText;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public ItemSlot getSlot() {
        return slot;
    }

    public void setSlot(ItemSlot slot) {
        this.slot = slot;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ItemType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
