package me.plugner.poweressentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.utils.TextFormat;

public class InvseeCommand implements CommandExecutor {
    public static final String USAGE_MESSAGE = "Use: /invsee [player] to see a inventory of a player.";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
            return false;
        }
        if(args.length == 0) {sender.sendMessage(USAGE_MESSAGE);return false;}
        Player t = Server.getInstance().getPlayer(args[0]);
        if(t==null) {
            sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+"(" + args[0].toLowerCase() + ")");
            return false;
        }
        Player p = (Player) sender;
        p.sendMessage(TextFormat.GOLD+"Opening...");
        t.getInventory().open(p);
        return false;
    }
}
