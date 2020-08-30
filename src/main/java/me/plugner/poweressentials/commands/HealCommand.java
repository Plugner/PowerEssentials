package me.plugner.poweressentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.utils.TextFormat;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0 ) {
            if(sender instanceof ConsoleCommandSender) {
                sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
                return false;
            }
            Player p = (Player)sender;
            p.setHealth(p.getMaxHealth());
            p.sendMessage(TextFormat.GOLD + "Healed.");
        }
        if(args.length == 1) {
            Player t = Server.getInstance().getPlayer(args[0]);
            if(t==null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+"(" + args[0].toLowerCase() + ")");
                return false;
            }
            t.sendMessage(TextFormat.GOLD + "Healed.");
            sender.sendMessage(TextFormat.GOLD + "Healed player " + TextFormat.RED + t.getName() + TextFormat.GOLD + " successfully.");
            t.setHealth(t.getMaxHealth());
        }
        return false;
    }
}
