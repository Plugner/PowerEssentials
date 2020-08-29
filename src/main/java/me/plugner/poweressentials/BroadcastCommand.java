package me.plugner.poweressentials;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class BroadcastCommand implements CommandExecutor {
    public static final String USAGE_MESSAGE = "Use: /bc <message> to broadcast a message to all the server.";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {sender.sendMessage(USAGE_MESSAGE);return false;}
        String message = "";
        for(String toPut : args) {
            message+=toPut + " ";
        }
        Server.getInstance().broadcastMessage(TextFormat.DARK_GRAY + "["+ TextFormat.DARK_RED + "Broadcast" + TextFormat.DARK_GRAY + "] " + TextFormat.GOLD + message);
        return false;
    }
}
