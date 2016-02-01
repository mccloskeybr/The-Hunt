package me.demerzel.location;


public class Exit {
    // Numerical codes
    public static final int UNDEFINED = 0;
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;
    public static final int UP = 5;
    public static final int DOWN = 6;
    public static final int NORTHEAST = 7;
    public static final int NORTHWEST = 8;
    public static final int SOUTHEAST = 9;
    public static final int SOUTHWEST = 10;
    public static final int IN = 11;
    public static final int OUT = 12;

    private boolean active;

    public static final String[] dirName = {
            "UNDEFINED",
            "NORTH",
            "SOUTH",
            "EAST",
            "WEST",
            "UP",
            "DOWN",
            "NORTHEAST",
            "NORTHWEST",
            "SOUTHEAST",
            "SOUTHWEST",
            "IN",
            "OUT"
    };

    public static final String[] shortDirName = {
            "NULL",
            "N",
            "S",
            "E",
            "W",
            "U",
            "D",
            "NE",
            "NW",
            "SE",
            "SW",
            "I",
            "O"
    };

    private Location m_leadsTo = null;
    private int m_direction;

    private String m_directionName;

    private String m_shortDirectionName;

    public Exit() {
        m_direction = Exit.UNDEFINED;
        m_leadsTo = null;
        m_directionName = dirName[UNDEFINED];
        m_shortDirectionName = shortDirName[UNDEFINED];
    }

    public Exit(int direction, Location leadsTo, boolean active) {
        m_direction = direction;

        if (direction <= dirName.length)
            m_directionName = dirName[m_direction];
        if (direction <= shortDirName.length)
            m_shortDirectionName = shortDirName[m_direction];

        m_leadsTo = leadsTo;
        this.active = active;
    }

    @Override
    public String toString() {
        return m_directionName;
    }

    public void setDirectionName(String dirname) {
        m_directionName = dirname;
    }

    public String getDirectionName() {
        return m_directionName;
    }

    public void setShortDirectionName(String shortName) {
        m_shortDirectionName = shortName;
    }

    public String getShortDirectionName() {
        return m_shortDirectionName;
    }

    public void setLeadsTo(Location leadsTo) {
        m_leadsTo = leadsTo;
    }

    public Location getLeadsTo() {
        return m_leadsTo;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}