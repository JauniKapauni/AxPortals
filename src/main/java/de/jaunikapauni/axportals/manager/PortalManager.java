package de.jaunikapauni.axportals.manager;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PortalManager {

    AxPortals reference;
    Map<String, Portal> portals = new HashMap<>();

    File file;
    YamlConfiguration configuration;

    public PortalManager(AxPortals reference){
        this.reference = reference;
        file = new File(reference.getDataFolder(), "portals.yml");
    }

    public void load() {
        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        configuration = YamlConfiguration.loadConfiguration(file);
        if(configuration.getConfigurationSection("portals") == null){
            return;
        }
        for(String name : configuration.getConfigurationSection("portals").getKeys(false)){
            String nameLower = name.toLowerCase();
            String path = "portals." + name;
            World world = reference.getServer().getWorld(configuration.getString(path + ".world"));
            if(world == null){
                reference.getLogger().warning("Portal '" + name + "' references an unloaded world, skipping.");
                continue;
            }
            Location pos1 = new Location(
                    reference.getServer().getWorld(configuration.getString(path + ".world")),
                    configuration.getInt(path + ".pos1.x"),
                    configuration.getInt(path + ".pos1.y"),
                    configuration.getInt(path + ".pos1.z")
            );
            Location pos2 = new Location(
                    reference.getServer().getWorld(configuration.getString(path + ".world")),
                    configuration.getInt(path + ".pos2.x"),
                    configuration.getInt(path + ".pos2.y"),
                    configuration.getInt(path + ".pos2.z")
            );
            portals.put(nameLower, new Portal(name, pos1, pos2, configuration.getString(path + ".command")));
        }
    }

    public void create(String name, Location pos1, Location pos2, String command){
        String nameLower = name.toLowerCase();
        String path = "portals." + name;
        configuration.set(path + ".world", pos1.getWorld().getName());
        configuration.set(path + ".pos1.x", pos1.getBlockX());
        configuration.set(path + ".pos1.y", pos1.getBlockY());
        configuration.set(path + ".pos1.z", pos1.getBlockZ());
        configuration.set(path + ".pos2.x", pos2.getBlockX());
        configuration.set(path + ".pos2.y", pos2.getBlockY());
        configuration.set(path + ".pos2.z", pos2.getBlockZ());
        configuration.set(path + ".command", command);
        save();
        portals.put(nameLower, new Portal(name, pos1, pos2, command));
    }

    public void delete(String name){
        String nameLower = name.toLowerCase();
        portals.remove(nameLower);
        configuration.set("portals." + name, null);
    }

    public Collection<Portal> getPortals(){
        return portals.values();
    }

    public void save(){
        try{
            configuration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exists(String name){
        return portals.containsKey(name.toLowerCase());
    }
}
