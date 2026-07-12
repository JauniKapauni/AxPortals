package de.jaunikapauni.axportals.manager;

import org.bukkit.Location;

public class Portal {

    String name;
    Location pos1;
    Location pos2;
    String command;

    public Portal(String name, Location pos1, Location pos2, String command){
        this.name = name;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.command = command;
    }

    public String getName(){
        return name;
    }

    public String getCommand(){
        return command;
    }

    public boolean contains(Location loc){
        if(!loc.getWorld().equals(pos1.getWorld())) return false;
        System.out.println("Checking" + loc.getWorld().getName() + loc.getBlockX() + loc.getBlockY() + loc.getBlockZ());
        return loc.getBlockX() >= Math.min(pos1.getBlockX(), pos2.getBlockX())
                && loc.getBlockX() <= Math.max(pos1.getBlockX(), pos2.getBlockX())
                && loc.getBlockY() >= Math.min(pos1.getBlockY(), pos2.getBlockY())
                && loc.getBlockY() <= Math.max(pos1.getBlockY(), pos2.getBlockY())
                && loc.getBlockZ() >= Math.min(pos1.getBlockZ(), pos2.getBlockZ())
                && loc.getBlockZ() <= Math.max(pos1.getBlockZ(), pos2.getBlockZ());
    }

    public Location getPos1(){
        return pos1;
    }

    public Location getPos2(){
        return pos2;
    }
}
