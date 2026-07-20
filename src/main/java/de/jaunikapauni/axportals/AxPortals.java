package de.jaunikapauni.axportals;

import de.jaunikapauni.axportals.command.PortalCommand;
import de.jaunikapauni.axportals.listener.PlayerMoveListener;
import de.jaunikapauni.axportals.listener.PlayerInteractListener;
import de.jaunikapauni.axportals.listener.PlayerQuitListener;
import de.jaunikapauni.axportals.manager.PortalManager;
import de.jaunikapauni.axportals.manager.SelectionManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AxPortals extends JavaPlugin {

    PortalManager portalManager;
    public PortalManager getPortalManager(){
        return portalManager;
    }
    SelectionManager selectionManager;
    public SelectionManager getSelectionManager(){
        return selectionManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        portalManager = new PortalManager(this);
        portalManager.load();
        selectionManager = new SelectionManager();
        getCommand("portal").setExecutor(new PortalCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        portalManager.save();
    }
}
