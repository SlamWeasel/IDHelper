package de.SlamWeasel.IDHelper.command;

import de.SlamWeasel.IDHelper.listener.MoveListener;
import de.SlamWeasel.IDHelper.util.Waypoint;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class cmdWaypoint implements CommandExecutor
{
    public static HashMap<Player, Waypoint> points = new HashMap<Player, Waypoint>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if(args.length == 3)
        {
            Waypoint wp = new Waypoint(p);
            wp.setWorld(p.getWorld());
            wp.setActive(true);

            if(args[0].contains("~"))
            {
                if(args[0].length() > 1)
                    wp.setX(p.getLocation().getBlockX() + Integer.parseInt(args[0].substring(1)));
                else
                    wp.setX(p.getLocation().getBlockX());
            }
            else
                wp.setX(Integer.parseInt(args[0]));

            if(args[1].contains("~"))
            {
                if(args[1].length() > 1)
                    wp.setY(p.getLocation().getBlockY() + Integer.parseInt(args[1].substring(1)));
                else
                    wp.setY(p.getLocation().getBlockY());
            }
            else
                wp.setY(Integer.parseInt(args[1]));

            if(args[2].contains("~"))
            {
                if(args[2].length() > 1)
                    wp.setZ(p.getLocation().getBlockZ() + Integer.parseInt(args[2].substring(1)));
                else
                    wp.setZ(p.getLocation().getBlockZ());
            }
            else
                wp.setZ(Integer.parseInt(args[2]));


            points.put(p, wp);
            p.sendMessage("Waypoint has been set!");
        }
        else if(args.length == 1)
        {
            Waypoint wp = new Waypoint(p, Bukkit.getPlayer(args[0]).getWorld(), Bukkit.getPlayer(args[0]).getLocation().getBlockX(), Bukkit.getPlayer(args[0]).getLocation().getBlockY(), Bukkit.getPlayer(args[0]).getLocation().getBlockZ(), true);
            points.put(p, wp);
            p.sendMessage("Waypoint has been set at " + args[0] + "s Location!");
        }
        else if(args.length == 0)
        {
            try
            {
                Waypoint wp = points.get(sender);
                if(wp.isActive())
                {
                    wp.setActive(false);
                    points.put((Player) sender, wp);
                    sender.sendMessage("The waypoint at " + wp.getX() + " " + wp.getY() + " " + wp.getZ() + " has been deactivated");
                    MoveListener.CompVis.put(p,MoveListener.Compass);
                }
                else
                {
                    wp.setActive(true);
                    points.put((Player) sender, wp);
                    sender.sendMessage("The waypoint at " + wp.getX() + " " + wp.getY() + " " + wp.getZ() + " has been reactivated");
                }
            }
            catch(NullPointerException n)
            {
                sender.sendMessage(ChatColor.RED + "Use the command as follows: " + ChatColor.LIGHT_PURPLE + "/waypoint X Y Z");
            }
        }
        else sender.sendMessage(ChatColor.RED + "Use the command as follows: " + ChatColor.LIGHT_PURPLE + "/waypoint X Y Z");

        return false;
    }
}
