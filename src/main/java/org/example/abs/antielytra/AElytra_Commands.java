package org.example.abs.antielytra;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class AElytra_Commands implements CommandExecutor {

    public static AntiElytra plugin = AntiElytra.getInstace();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(strings.length == 0) {
            commandSender.sendMessage("§7Reload plugin : §6/antielytra reload");
        }

        if(strings[0].equalsIgnoreCase("reload")) {
            if(!commandSender.hasPermission("aelytra.reload")) {
                commandSender.sendMessage(plugin.getConfig().getString("messages.noPerm"));
                return true;
            }

            plugin.reloadConfig();
            commandSender.sendMessage(plugin.getConfig().getString("messages.reloaded"));
            return true;
        }

        return true;
    }
}
