package me.plugner.poweressentials;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.TextFormat;

import java.util.TreeMap;

public class GamemodeCommand implements CommandExecutor {

    public GamemodeCommand() {
        GAMEMODES.put("0",0);
        GAMEMODES.put("1",1);
        GAMEMODES.put("2",2);
        GAMEMODES.put("3",3);
        GAMEMODES.put("survival", 0);
        GAMEMODES.put("creative", 1);
        GAMEMODES.put("adventure", 2);
        GAMEMODES.put("spectator", 3);
        GAMEMODES.put("s",0);
        GAMEMODES.put("c",1);
        GAMEMODES.put("a",2);
        GAMEMODES.put("sp",3);

        GAMEMODE_NAME.put(0,"survival");
        GAMEMODE_NAME.put(1,"creative");
        GAMEMODE_NAME.put(2,"adventure");
        GAMEMODE_NAME.put(3,"spectator");
    }
    private TreeMap<Integer,String> GAMEMODE_NAME = new TreeMap<>();
    private TreeMap<String,Integer> GAMEMODES = new TreeMap<>();
    public static final String USAGE_MESSAGE = "Use: /gm <0/1/2/3> [player] to change your gamemode or a gamemode of other player.";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(args.length == 0) {commandSender.sendMessage(USAGE_MESSAGE);return false;}
        if(args.length == 1) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
                return false;
            }
            Player p = (Player)commandSender;
            String argument = args[0].toLowerCase();

            if(!GAMEMODES.containsKey(argument)) {
                p.sendMessage(TextFormat.DARK_RED + "Unknown gamemode "+TextFormat.RED+" (" + argument + ")");
                return false;
            }

            int gamemode = GAMEMODES.get(argument);
            String gamemodeName = GAMEMODE_NAME.get(gamemode);

            p.setGamemode(gamemode);
            p.sendMessage(TextFormat.GOLD + "Your gamemode has been changed to " + TextFormat.RED + gamemodeName + TextFormat.GOLD + " mode.");

        }
       if(args.length == 2) {
           String arg1 = args[0];
           if(!GAMEMODES.containsKey(arg1)) {
               commandSender.sendMessage(TextFormat.DARK_RED + "Unknown gamemode "+TextFormat.RED+" (" + arg1.toLowerCase() + ")");
               return false;
           }
           String targetStr = args[1];
           Player t = Server.getInstance().getPlayer(targetStr);
           if(t == null) {
               commandSender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+" (" + targetStr.toLowerCase() + ")");
               return false;
           }

           int gamemode = GAMEMODES.get(arg1);
           String gamemodeName = GAMEMODE_NAME.get(gamemode);



           t.setGamemode(gamemode);
           t.sendMessage(TextFormat.GOLD + "Your gamemode has been changed to " + TextFormat.RED + gamemodeName + TextFormat.GOLD + " mode.");
           commandSender.sendMessage(TextFormat.GOLD + "The gamemode of the player " + t.getName() + " was changed to " + TextFormat.RED + gamemodeName.toLowerCase() + TextFormat.GOLD + " successfully.");
       }
        return true;
    }
}
