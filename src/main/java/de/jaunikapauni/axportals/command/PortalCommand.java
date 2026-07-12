package de.jaunikapauni.axportals.command;

import de.jaunikapauni.axportals.AxPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PortalCommand implements CommandExecutor {

    AxPortals reference;
    public PortalCommand(AxPortals reference){
        this.reference = reference;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return false;
    }
}
