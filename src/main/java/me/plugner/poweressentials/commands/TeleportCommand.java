package me.plugner.poweressentials;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Position;
import cn.nukkit.utils.TextFormat;

public class TeleportCommand implements CommandExecutor {
    public static final String USAGE_MESSAGE = "Use: /tp <player1> [player2] to make a teleportation across players.";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {sender.sendMessage(USAGE_MESSAGE);return false;}
        if(args.length == 1) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
                return false;
            }
            Player p = (Player) sender;
            Player t = Server.getInstance().getPlayer(args[0]);
            if(t == null) {
                p.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+" (" + args[0].toLowerCase() + ").");
                return false;
            }
            p.teleport(t.getPosition());
            p.sendMessage(TextFormat.GOLD + "Teleporting to " + TextFormat.RED + t.getName() + TextFormat.GOLD + "...");
        }
        if(args.length == 2) {
            String arg1 = args[0];
            String arg2 = args[1];

            Player p = Server.getInstance().getPlayer(arg1);
            Player t = Server.getInstance().getPlayer(arg2);

            if(p == null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+" (" + arg1.toLowerCase() + ")");
                return false;
            }
            if(t == null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+" (" + arg2.toLowerCase() + ")");
                return false;
            }

            p.teleport(t.getPosition());
            p.sendMessage(TextFormat.GOLD + "Teleporting...");
            sender.sendMessage(TextFormat.GOLD + "Teleported " + TextFormat.RED + p.getName() + TextFormat.GOLD + " to " + TextFormat.RED + t.getName() + TextFormat.GOLD + " successfully");
        }

        if(args.length == 3) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(TextFormat.DARK_RED + "Only players can execute this action.");
                return false;
            }
            String xs,ys,zs;
            xs=args[0];
            ys=args[1];
            zs=args[2];

            int x,y,z;
            try {
             x=Integer.parseInt(xs);
             y=Integer.parseInt(ys);
             z=Integer.parseInt(zs);
            }catch(Exception e) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown coordinates.");
                return false;
            }
            Position pos = new Position(x,y,z);
            Player p = (Player)sender;
            p.sendMessage(TextFormat.GOLD + "Teleporting...");
            p.teleport(pos);
        }

        if(args.length == 4) {
            Player p = Server.getInstance().getPlayer(args[0]);
            if(p == null) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown player "+TextFormat.RED+" (" + args[0].toLowerCase() + ")");
                return false;
            }
            String xs,ys,zs;
            xs=args[1];
            ys=args[2];
            zs=args[3];

            int x,y,z;
            try {
                x=Integer.parseInt(xs);
                y=Integer.parseInt(ys);
                z=Integer.parseInt(zs);
            }catch(Exception e) {
                sender.sendMessage(TextFormat.DARK_RED + "Unknown coordinates.");
                return false;
            }
            Position pos = new Position(x,y,z);
            sender.sendMessage(TextFormat.GOLD + "Teleported " + TextFormat.RED + p.getName() + TextFormat.GOLD + " to the coordinates " + TextFormat.RED + x + ", " + y + ", " + z + TextFormat.GOLD + " successfully.");
            p.sendMessage(TextFormat.GOLD + "Teleporting...");
            p.teleport(pos);
        }


        return false;
    }
}
