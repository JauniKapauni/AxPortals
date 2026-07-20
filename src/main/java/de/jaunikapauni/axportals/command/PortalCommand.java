package de.jaunikapauni.axportals.command;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class PortalCommand implements CommandExecutor {

    AxPortals reference;
    public PortalCommand(AxPortals reference){
        this.reference = reference;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command!");
            return true;
        }
        Player p = (Player) sender;
        if(args.length < 1){
            p.sendMessage("/portal create <name> <command>");
            p.sendMessage("/portal delete <name>");
            return true;
        }
        switch (args[0].toLowerCase()){
            case "create" -> {
                if(!p.hasPermission("axportals.create")){
                    p.sendMessage("No permission");
                    return true;
                }
                if(args.length < 3){
                    return false;
                }
                Location[] selection = reference.getSelectionManager().get(p.getUniqueId());
                if(selection == null || selection[0] == null || selection[1] == null){
                    p.sendMessage("Select two positions first!");
                    return true;
                }
                String cmd = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                String portalName = args[1].toLowerCase();
                if(reference.getPortalManager().exists(portalName)){
                    p.sendMessage("Portal already exists!");
                    return true;
                }
                reference.getPortalManager().create(portalName, selection[0], selection[1], cmd);
                p.sendMessage("Portal created!");
            }
            case "delete" -> {
                if(!p.hasPermission("axportals.delete")){
                    p.sendMessage("No permission");
                    return true;
                }
                if(args.length < 2){
                    return false;
                }
                String portalName = args[1].toLowerCase();
                if(!reference.getPortalManager().exists(portalName)){
                    p.sendMessage("Portal does not exist!");
                    return true;
                }
                reference.getPortalManager().delete(portalName);
                p.sendMessage("Portal deleted!");
            }
        }
        return true;
    }
}
