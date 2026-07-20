package de.jaunikapauni.axportals.listener;

import de.jaunikapauni.axportals.AxPortals;
import de.jaunikapauni.axportals.manager.Portal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    AxPortals reference;

    public PlayerMoveListener(AxPortals reference) {
        this.reference = reference;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getTo() == null) {
            return;
        }
        if(e.getFrom().getBlockX() == e.getTo().getBlockX() && e.getFrom().getBlockY() == e.getTo().getBlockY() && e.getFrom().getBlockZ() == e.getTo().getBlockZ()){
            return;
        }
        Player p = e.getPlayer();
        for (Portal portal : reference.getPortalManager().getPortals()) {
            if(portal.contains(e.getTo()) && !portal.contains(e.getFrom())){
                reference.getServer().dispatchCommand(reference.getServer().getConsoleSender(), portal.getCommand().replace("%player%", p.getName()));
                return;
            }
        }
    }
}
