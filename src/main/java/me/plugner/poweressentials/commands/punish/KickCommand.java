package me.plugner.poweressentials.commands.punish;

import cn.nukkit.OfflinePlayer;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class KickCommand implements CommandExecutor {
    public static final String USAGE_MESSAGE = "Use: /kick <player> to kick a player.";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(USAGE_MESSAGE);

            return false;
        }
        if(args.length == 1) {
            Player t = Server.getInstance().getPlayer(args[0]);
            
            if(t == null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+" (" + args[0].toLowerCase() + ")");
                return false;
            }
            t.kick("You have been kicked from this server.");
            Server.getInstance().broadcastMessage(TextFormat.GOLD + "The player " + TextFormat.RED + t.getName() + TextFormat.GOLD + " has been kicked by " + TextFormat.RED + sender.getName() + TextFormat.GOLD + ".");
        }
        return false;
    }
}
