package me.plugner.poweressentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.utils.TextFormat;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if(sender instanceof ConsoleCommandSender) {
                sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
                return false;
            }

            Player p = (Player)sender;
            if(p.getAllowFlight()) {
                p.sendMessage(TextFormat.GOLD + "Flying mode " + TextFormat.RED + "disabled" + TextFormat.GOLD + ".");
                p.setAllowFlight(false);
            }else{
                p.sendMessage(TextFormat.GOLD + "Flying mode " + TextFormat.RED + "enabled" + TextFormat.GOLD + ".");
                p.setAllowFlight(true);
            }
        return false;
        }
        if(args.length == 1) {
            Player t = Server.getInstance().getPlayer(args[0]);
            if(t==null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+"(" + args[0].toLowerCase() + ")");
                return false;
            }
            if(t.getAllowFlight()) {
                sender.sendMessage(TextFormat.GOLD + "Flying mode " + TextFormat.RED + "disabled" + TextFormat.GOLD + " for " + TextFormat.RED + t.getName() + TextFormat.GOLD + ".");
                t.sendMessage(TextFormat.GOLD + "Flying mode " + TextFormat.RED + "disabled" + TextFormat.GOLD + ".");
                t.setAllowFlight(false);
            }else{
                sender.sendMessage(TextFormat.GOLD + "Flying mode " + TextFormat.RED + "enabled" + TextFormat.GOLD + " for " + TextFormat.RED + t.getName() + TextFormat.GOLD + ".");
                t.sendMessage(TextFormat.GOLD + "Flying mode " + TextFormat.RED + "enabled" + TextFormat.GOLD + ".");
                t.setAllowFlight(true);
            }
        }

        return false;
    }
}
