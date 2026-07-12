package de.jaunikapauni.axportals;

import de.jaunikapauni.axportals.command.PortalCommand;
import de.jaunikapauni.axportals.listener.PlayerMoveListener;
import de.jaunikapauni.axportals.listener.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AxPortals extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("portal").setExecutor(new PortalCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
