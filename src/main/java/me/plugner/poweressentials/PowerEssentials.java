package me.plugner.poweressentials;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.plugin.PluginBase;

public class PowerEssentials extends PluginBase {
    @Override
    public void onEnable() {
        getLogger().info("Started PowerEssentials Version 1.0.0-SNAPSHOT");
        ((PluginCommand<?>) getCommand("gm")).setExecutor(new GamemodeCommand());
        ((PluginCommand<?>) getCommand("tp")).setExecutor(new TeleportCommand());
        ((PluginCommand<?>) getCommand("bc")).setExecutor(new BroadcastCommand());
        // You must register your listeners to capture events
        // You can make this class implement the Listener itself and invoke registerEvents(this, this)
        // But again, if the listener gets too complicated it might be better to group them in different classes
        // getServer().getPluginManager().registerEvents(new CloneListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Stopping PowerEssentials Version 1.0.0-SNAPSHOT");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // You can also override this command instead of setting an executor in onEnable if you prefer
        return false;
    }
}
