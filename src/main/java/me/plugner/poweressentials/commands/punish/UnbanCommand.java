package me.plugner.poweressentials.commands.punish;

import cn.nukkit.OfflinePlayer;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.player.PlayerKickEvent;
import cn.nukkit.utils.TextFormat;

public class UnbanCommand implements CommandExecutor {
    public static final String USAGE_MESSAGE = "Use: /unban <player> to pardon a player.";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(USAGE_MESSAGE);
            return false;
        }
        if(args.length == 1) {
            OfflinePlayer t = (OfflinePlayer) Server.getInstance().getOfflinePlayer(args[0]);
            if(!t.isBanned()) {
                sender.sendMessage(TextFormat.DARK_RED + "This user isn't banned.");
                return false;
            }
            t.setBanned(false);
            Server.getInstance().broadcastMessage(TextFormat.GOLD + "The player " + TextFormat.RED + t.getName() + TextFormat.GOLD + " has been unbanned by " + TextFormat.RED + sender.getName() + TextFormat.GOLD+".");



        }
        return false;
    }
}
