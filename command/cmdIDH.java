package de.SlamWeasel.IDHelper.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class cmdIDH implements CommandExecutor
{
    public static HashMap<Player, Byte> active = new HashMap<Player, Byte>();         //0 = Nichts an, 1 = IDHelper and, 2 = Kompass an

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;

            try
            {
                if (active.get(p) != 1)
                    active.put(p, (byte)1);
                else
                    active.put(p, (byte)0);
            }
            catch(NullPointerException n)
            {
                n.printStackTrace();
            }
        }
        return false;
    }
}
