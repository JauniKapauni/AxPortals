package de.jaunikapauni.axportals.listener;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    AxPortals reference;
    public PlayerInteractListener(AxPortals reference){
        this.reference = reference;
    }

    @EventHandler
    public void onSelection(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getType() != Material.WOODEN_SHOVEL){
            return;
        }
        if(p.getGameMode() != GameMode.CREATIVE){
            return;
        }
        if(!p.hasPermission("axportals.selection")){
            p.sendMessage("You don't have the permission! [axportals.selection]");
            return;
        }
        if(e.getClickedBlock() == null){
            return;
        }
        if(e.getAction() == Action.LEFT_CLICK_BLOCK){
            reference.getSelectionManager().setPos1(p.getUniqueId(), e.getClickedBlock().getLocation());
            p.sendMessage("Pos 1 set!");
            e.setCancelled(true);
        }
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            reference.getSelectionManager().setPos2(p.getUniqueId(), e.getClickedBlock().getLocation());
            p.sendMessage("Pos 2 set!");
            e.setCancelled(true);
        }
    }
}
