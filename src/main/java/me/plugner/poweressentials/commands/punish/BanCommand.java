package me.plugner.poweressentials.commands.punish;

import cn.nukkit.IPlayer;
import cn.nukkit.OfflinePlayer;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.player.PlayerKickEvent;
import cn.nukkit.utils.TextFormat;

public class BanCommand implements CommandExecutor {
    public static final String USAGE_MESSAGE = "Use: /ban <player> to ban a player.";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(USAGE_MESSAGE);
            return false;
        }
        if(args.length == 1) {
            IPlayer t =  Server.getInstance().getOfflinePlayer(args[0]);
            if(t.hasPlayedBefore()) {
                sender.sendMessage(TextFormat.GOLD + "WARN! This player never joined the server.");
            }
            Server.getInstance().broadcastMessage(TextFormat.GOLD + "The player " + TextFormat.RED + t.getName() + TextFormat.GOLD + " has been banned by " + TextFormat.RED + sender.getName() + TextFormat.GOLD+".");
            if(t.isOnline()) {

                t.getPlayer().kick("You are banned from this server.");
            }
            t.setBanned(true);

        }
        return false;
    }
}
