package de.SlamWeasel.IDHelper.util;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Waypoint
{
    private int X = 0, Y = 0, Z = 0;
    private Player player;
    private boolean active = false;
    private World world;

    public Waypoint(Player p, World w, int coX, int coY, int coZ, boolean use)
    {
        this.world  = w;
        this.X      = coX;
        this.Y      = coY;
        this.Z      = coZ;
        this.player = p;
        this.active = use;
    }
    public Waypoint(Player p)
    {
        this.world  = p.getWorld();
        this.X      = p.getLocation().getBlockX();
        this.Y      = p.getLocation().getBlockY();
        this.Z      = p.getLocation().getBlockZ();
        this.player = p;
        this.active = true;
    }

    public World getWorld()
    {
        return world;
    }

    public int getX()
    {
        return X;
    }

    public int getY()
    {
        return Y;
    }

    public int getZ()
    {
        return Z;
    }

    public Player getPlayer()
    {
        return player;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setWorld(World world)
    {
        this.world = world;
    }

    public void setX(int x)
    {
        X = x;
    }

    public void setY(int y)
    {
        Y = y;
    }

    public void setZ(int z)
    {
        Z = z;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public Location getLocation()
    {
        return new Location(world, X, Y, Z);
    }

    public void setLocation(Location l)
    {
        this.world = l.getWorld();
        this.X = l.getBlockX();
        this.Y = l.getBlockY();
        this.Z = l.getBlockZ();
    }
}
