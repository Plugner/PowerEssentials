package me.plugner.poweressentials.commands;

import cn.nukkit.Nukkit;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import me.plugner.poweressentials.PowerEssentials;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Running PowerEssentials " + PowerEssentials.VERSION + " in " + Nukkit.CODENAME + Nukkit.VERSION + " (api-version: " + Nukkit.API_VERSION + "), mc version "+Nukkit.MINECRAFT_VERSION+", " + Server.getInstance().getPluginManager().getPlugins().size() + " plugins loaded.");
        return false;
    }
}
