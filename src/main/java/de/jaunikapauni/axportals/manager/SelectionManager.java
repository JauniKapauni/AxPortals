package de.jaunikapauni.axportals.manager;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SelectionManager {

    Map<UUID, Location[]> selections = new HashMap<>();

    public void setPos1(UUID uuid, Location location){
        selections.putIfAbsent(uuid, new Location[2]);
        selections.get(uuid)[0]=location;
    }

    public void setPos2(UUID uuid, Location location){
        selections.putIfAbsent(uuid, new Location[2]);
        selections.get(uuid)[1]=location;
    }

    public Location[] get(UUID uuid){
        return selections.get(uuid);
    }

    public void remove(UUID uuid){
        selections.remove(uuid);
    }
}
