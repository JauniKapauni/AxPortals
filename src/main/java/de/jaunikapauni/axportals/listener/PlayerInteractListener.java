package de.jaunikapauni.axportals.listener;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    AxPortals reference;
    public PlayerInteractListener(AxPortals reference){
        this.reference = reference;
    }

    @EventHandler
    public void onSelection(PlayerInteractEvent e){

    }
}
