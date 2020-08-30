package me.plugner.poweressentials.commands.randomic;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.utils.TextFormat;

public class RandomNumberCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NukkitRandom nr = new NukkitRandom();
        int num = nr.nextRange(0,100);
        sender.sendMessage(TextFormat.GOLD + "A number given by 0 to 100 is " + TextFormat.RED + num + TextFormat.GOLD + ".");
        return false;
    }
}
