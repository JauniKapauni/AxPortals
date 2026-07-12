package de.jaunikapauni.axportals.listener;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    AxPortals reference;
    public PlayerMoveListener(AxPortals reference){
        this.reference = reference;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){

    }
}
