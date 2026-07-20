package de.jaunikapauni.axportals.listener;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    AxPortals reference;
    public PlayerQuitListener(AxPortals reference){
        this.reference = reference;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        reference.getSelectionManager().remove(e.getPlayer().getUniqueId());
    }
}
