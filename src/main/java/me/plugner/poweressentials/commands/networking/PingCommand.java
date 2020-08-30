package me.plugner.poweressentials.commands.networking;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.utils.TextFormat;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
            return false;
        }
        Player p = (Player)sender;
        p.sendMessage(TextFormat.GOLD + "Your ping is " + TextFormat.RED + p.getPing() + "ms" + TextFormat.GOLD + ".");
        return false;
    }
}
