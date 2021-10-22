package de.SlamWeasel.IDHelper.listener;

import de.SlamWeasel.IDHelper.command.cmdIDH;
import de.SlamWeasel.IDHelper.command.cmdWaypoint;
import de.SlamWeasel.IDHelper.util.Waypoint;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MoveListener implements Listener
{
    public static String Compass = "§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|";
    public static HashMap<Player, String> CompVis = new HashMap<Player, String>();

    @EventHandler
    public void onPlayerMovement(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();

            try{
            if(cmdIDH.active.get(p) == 1)
                {
                try{
                    sendActionBar(p, "§6§l"
                        + Integer.toString((p.getTargetBlock((Set<Material>) null, 100).getType().getId())) + ":"
                        + Integer.toString((p.getTargetBlock((Set<Material>) null, 100).getData())) + " §r§6| minecraft:"
                        + Corrector(p.getTargetBlock((Set<Material>) null, 100).getType().name().toLowerCase()));
                }
                catch(NullPointerException n)
                {
                    sendActionBar(p, "§6§l"
                            + Integer.toString((p.getTargetBlock((Set<Material>) null, 100).getType().getId())) + ":"
                            + Integer.toString((p.getTargetBlock((Set<Material>) null, 100).getData())) + " §r§6| minecraft:"
                            + Corrector(p.getTargetBlock((Set<Material>) null, 100).getType().name().toLowerCase()));
                }
            }
            else if(cmdIDH.active.get(p) == 2)
            {
                try
                {
                    if(cmdWaypoint.points.get(p).isActive() && cmdWaypoint.points.get(p).getLocation().getWorld().equals(p.getWorld()))
                    {
                        Location l = p.getLocation();
                        Waypoint w  = cmdWaypoint.points.get(p);

                        if(l.getBlockZ() < w.getZ())
                        {
                            if(l.getBlockX() < w.getX())
                            {//8
                                int deg = Math.round((long)(
                                                        Math.toDegrees(
                                                                Math.asin(                                              //sin^-1  umkehrung von Sinus zu Gradzahlen
                                                                        (w.getX()-l.getBlockX()) /                      // a getilt durch b (b = alles hierunter)
                                                                                Math.sqrt(                              //Wurzel von a^2 + b^2
                                                                                    Math.pow(
                                                                                        w.getX()-l.getBlockX(), 2       //a^2
                                                                                    ) + Math.pow(                       //+
                                                                                        w.getZ()-l.getBlockZ(), 2       //b^2
                                                                                    )
                                                                        )
                                                                )
                                                            )
                                                        )
                                );

                                //p.sendMessage("" + deg);

                                if(deg <= 90 && deg >= 75)
                                    CompVis.put(p,"§aE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §aE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 75 && deg >= 45)
                                    CompVis.put(p,"§cE §f  §f  §a| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §a| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 45 && deg >= 15)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §a| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §a| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §aS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §aS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                            }
                            else if(l.getBlockX() > w.getX())
                            {//2
                                int deg = Inverter(Math.round((long)(
                                        Math.toDegrees(
                                                Math.asin(                                                              //sin^-1  umkehrung von Sinus zu Gradzahlen
                                                        (w.getX()-l.getBlockX()) /                                      // a getilt durch b (b = alles hierunter)
                                                                Math.sqrt(                                              //Wurzel von a^2 + b^2
                                                                        Math.pow(
                                                                                l.getBlockX()-w.getX(), 2               //a^2
                                                                        ) + Math.pow(                                   //+
                                                                                w.getZ()-l.getBlockZ(), 2               //b^2
                                                                        )
                                                                )
                                                )
                                        )
                                        ))
                                , 90);

                                //p.sendMessage("" + deg);

                                if(deg <= 90 && deg >= 75)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §aS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §aS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 75 && deg >= 45)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §a| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §a| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 45 && deg >= 15)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §a| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §a| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §aW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §aW §f  §f  §f| §f  §f  §f|");
                            }
                            else
                            {//1
                                CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §aS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §aS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                            }
                        }
                        else if(l.getBlockZ() > w.getZ())
                        {
                            if(l.getBlockX() < w.getX())
                            {//6
                                int deg = Math.round((long)(
                                        Math.toDegrees(
                                                Math.asin(                                                              //sin^-1  umkehrung von Sinus zu Gradzahlen
                                                        (w.getX()-l.getBlockX()) /                                      // a getilt durch b (b = alles hierunter)
                                                                Math.sqrt(                                              //Wurzel von a^2 + b^2
                                                                        Math.pow(
                                                                                w.getX()-l.getBlockX(), 2               //a^2
                                                                        ) + Math.pow(                                   //+
                                                                                l.getBlockZ()-w.getZ(), 2               //b^2
                                                                        )
                                                                )
                                                )
                                        )
                                        ));

                                //p.sendMessage("" + deg);

                                if(deg <= 90 && deg >= 75)
                                    CompVis.put(p,"§aE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §aE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 75 && deg >= 45)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §a| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 45 && deg >= 15)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §a| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §aN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                            }
                            else if(l.getBlockX() > w.getX())
                            {//4
                                int deg = Inverter(Math.round((long)(
                                        Math.toDegrees(
                                                Math.asin(                                                              //sin^-1  umkehrung von Sinus zu Gradzahlen
                                                        (w.getX()-l.getBlockX()) /                                      // a getilt durch b (b = alles hierunter)
                                                                Math.sqrt(                                              //Wurzel von a^2 + b^2
                                                                        Math.pow(
                                                                                l.getBlockX()-w.getX(), 2               //a^2
                                                                        ) + Math.pow(                                   //+
                                                                                l.getBlockZ()-w.getZ(), 2               //b^2
                                                                        )
                                                                )
                                                )
                                        )
                                        ))
                                        , 90);

                                //p.sendMessage("" + deg);

                                if(deg <= 90 && deg >= 75)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §aN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                else if(deg < 75 && deg >= 45)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §a| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §a|");
                                else if(deg < 45 && deg >= 15)
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §a| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §a| §f  §f  §f|");
                                else
                                    CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §aW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §aW §f  §f  §f| §f  §f  §f|");
                            }
                            else
                            {//5
                                CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §aN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                            }
                        }
                        else
                        {
                            if(l.getBlockX() < w.getX())
                            {//7
                                CompVis.put(p,"§aE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §aE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                            }
                            else if(l.getBlockX() > w.getX())
                            {//3
                                CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §aW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §aW §f  §f  §f| §f  §f  §f|");
                            }
                            else
                            {//Die gleichen Koordinaten
                                CompVis.put(p,"§cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f| §f  §f  §cN §f  §f  §f| §f  §f  §f| §f  §f  §cE §f  §f  §f| §f  §f  §f| §f  §f  §cS §f  §f  §f| §f  §f  §f| §f  §f  §cW §f  §f  §f| §f  §f  §f|");
                                p.sendMessage(ChatColor.GREEN + "You reached your destination");
                                cmdWaypoint.points.get(p).setActive(false);
                            }
                        }
                    }
                }
                catch(NullPointerException nu)
                {
                    CompVis.put(p, Compass);
                }

                try
                {
                    sendActionBar(p, CompVis.get(p).substring(Math.round(p.getLocation().getYaw() / 10) * 4, (Math.round(p.getLocation().getYaw() / 10) * 4 + 75)));
                }
                catch (StringIndexOutOfBoundsException n)
                {
                    sendActionBar(p, CompVis.get(p).substring(Inverter(Math.round(p.getLocation().getYaw() / 10), 36) * 4, Inverter(Math.round(p.getLocation().getYaw() / 10), 36) * 4 + 75));
                }
            }}
            catch(NullPointerException m)
            {
                cmdIDH.active.put(p, (byte)0);
            }
    }
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e)
    {
        CompVis.put(e.getPlayer(),Compass);
    }

    public static void sendActionBar(Player player, String Nachricht)
    {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(Nachricht));
    }
    private static String Corrector(String IN)
    {
        switch(IN)
        {
            case "red_rose" : 		        return "red_flower";
            case "long_grass":		        return "tallgrass";
            case "dead_bush":		        return "deadbush";
            case "wood":			        return "planks";
            case "trap_door":		        return "trapdoor";
            case "step":			        return "stone_slab";
            case "double_step":		        return "double_stone_slab";
            case "wood_stairs":		        return "oak_stairs";
            case "spruce_wood_stairs":      return "spruce_stairs";
            case "birch_wood_stairs":       return "birch_stairs";
            case "jungle_wood_stairs":      return "jungle_stairs";
            case "smooth_stairs":	        return "stone_brick_stairs";
            case "jack_o_lantern":	        return "lit_pumpkin";
            case "stained_clay":	        return "stained_hardened_clay";
            case "smooth_brick":	        return "stonebrick";
            case "mycel":			        return "mycelium";
            case "ender_stone":		        return "end_stone";
            case "hard_clay":		        return "hardened_clay";
            case "log_2":			        return "log2";
            case "workbench":		        return "crafting_table";
            case "burning_furnace":	        return "lit_furnace";
            case "snow_block":		        return "snow";
            case "snow":			        return "snow_layer";
            case "ender_portal_frame":      return "end_portal_frame";
            case "iron_fence":		        return "iron_bars";
            case "thin_glass":		        return "glass_pane";
            case "water_lily":		        return "waterlily";
            case "nether_fence":	        return "nether_brick_fence";
            case "leaves_2":		        return "leaves2";
            case "sign_post":		        return "standing_sign";
            case "bed_block":		        return "bed";
            case "note_block":		        return "noteblock";
            case "piston_base":		        return "piston";
            case "piston_sticky_base":      return "sticky_base";
            case "piston_extension":        return "piston_head";
            case "stone_plate":		        return "stone_pressure_plate";
            case "wood_plate":		        return "wooden_pressure_plate";
            case "redstone_torch_on":       return "redstone_torch";
            case "redstone_torch_off":      return "unlit_redstone_torch";
            case "diode_block_on":	        return "powered_repeater";
            case "diode_block_off":	        return "unpowered_repeater";
            case "redstone_lamp_on":        return "lit_redstone_lamp";
            case "redstone_lamp_off":       return "restone_lamp";
            case "iron_plate":		        return "heavy_weighted_pressure_plate";
            case "gold_plate":		        return "light_weighted_pressure_plate";
            case "iron_door_block":	        return "iron_door";
            case "redstone_comparator_off": return "unpowered_comparator";
            case "redstone_comparator_on":  return "powered_comparator";
            case "powered_rail":	        return "golden_rail";
            default: 				        return IN;
        }
    }

    private int Inverter(int IN, int range)
    {
        if(IN < 0)
            return range + IN;
        else
            return (range - IN)*-1;
    }
}
