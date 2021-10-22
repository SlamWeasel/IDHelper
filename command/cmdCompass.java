package de.SlamWeasel.IDHelper.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdCompass implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;

            try
            {
                if (cmdIDH.active.get(p) != 2)                                                      //0 = Nichts an, 1 = IDHelper and, 2 = Kompass an
                    cmdIDH.active.put(p, (byte)2);
                else
                    cmdIDH.active.put(p, (byte)0);
            }
            catch(NullPointerException n)
            {
                n.printStackTrace();
            }
        }
        return false;
    }
}
