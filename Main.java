package de.SlamWeasel.IDHelper.main;

import de.SlamWeasel.IDHelper.command.cmdCompass;
import de.SlamWeasel.IDHelper.command.cmdIDB;
import de.SlamWeasel.IDHelper.command.cmdIDH;
import de.SlamWeasel.IDHelper.command.cmdWaypoint;
import de.SlamWeasel.IDHelper.listener.MoveListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    private static Main plugin;

    public void onEnable()
    {
        plugin = this;

        this.getCommand("idh").setExecutor(new cmdIDH());
        this.getCommand("idb").setExecutor(new cmdIDB());
        this.getCommand("compass").setExecutor(new cmdCompass());
        this.getCommand("waypoint").setExecutor(new cmdWaypoint());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MoveListener(), this);

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[IDH]" + ChatColor.GREEN + "IDHelper wurde geladen");
    }
    public void onDisable()
    {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[IDH]" + ChatColor.RED + "IDHelper wurde entladen");
    }
    public static Main getplugin()
    {
        return plugin;
    }
}
