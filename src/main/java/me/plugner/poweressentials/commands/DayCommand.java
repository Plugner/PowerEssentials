package me.plugner.poweressentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.utils.TextFormat;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
                return false;
            }
            Player p = (Player)sender;
            p.getPosition().level.setTime(1600);
            p.sendMessage(TextFormat.GOLD + "Defined " + TextFormat.RED + "day " + TextFormat.GOLD + "in world " + TextFormat.RED + p.getPosition().level.getName() + TextFormat.GOLD + ".");
        }
        if(args.length == 1) {
            Level level = Server.getInstance().getLevelByName(args[0]);
            if(level == null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown level "+TextFormat.RED+" (" + args[0].toLowerCase() + ").");
                return false;
            }
           level.setTime(1600);
            sender.sendMessage(TextFormat.GOLD + "Defined " + TextFormat.RED + "day " + TextFormat.GOLD + "in world " + TextFormat.RED + level.getName() + TextFormat.GOLD + ".");
        }
        return false;
    }
}
