package de.SlamWeasel.IDHelper.command;

import de.SlamWeasel.IDHelper.listener.MoveListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Set;

public class cmdIDB implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (CraftPlayer) sender;

            MoveListener.sendActionBar(p, "§6§l"
                    + Integer.toString((p.getTargetBlock((Set<Material>) null, 100).getType().getId())) + ":"
                    + Integer.toString((p.getTargetBlock((Set<Material>) null, 100).getData())) + " §r§6| minecraft:"
                    + Corrector(p.getTargetBlock((Set<Material>) null, 100).getType().name().toLowerCase()));
        }
        return false;
    }
    private static String Corrector(String IN)
    {
        String OUT = new String();

        switch(IN)
        {
            case "red_rose" : 		OUT = "red_flower";break;
            case "long_grass":		OUT = "tallgrass";break;
            case "dead_bush":		OUT = "deadbush";break;
            case "wood":			OUT = "planks";break;
            case "trap_door":		OUT = "trapdoor";break;
            case "step":			OUT = "stone_slab";break;
            case "double_step":		OUT = "double_stone_slab";break;
            case "wood_stairs":		OUT = "oak_stairs";break;
            case "spruce_wood_stairs":OUT = "spruce_stairs";break;
            case "birch_wood_stairs":OUT = "birch_stairs";break;
            case "jungle_wood_stairs":OUT = "jungle_stairs";break;
            case "smooth_stairs":	OUT = "stone_brick_stairs";break;
            case "jack_o_lantern":	OUT = "lit_pumpkin";break;
            case "stained_clay":	OUT = "stained_hardened_clay";break;
            case "smooth_brick":	OUT = "stonebrick";break;
            case "mycel":			OUT = "mycelium";break;
            case "ender_stone":		OUT = "end_stone";break;
            case "hard_clay":		OUT = "hardened_clay";break;
            case "log_2":			OUT = "log2";break;
            case "workbench":		OUT = "crafting_table";break;
            case "burning_furnace":	OUT = "lit_furnace";break;
            case "snow_block":		OUT = "snow";break;
            case "snow":			OUT = "snow_layer";break;
            case "ender_portal_frame":OUT = "end_portal_frame";break;
            case "iron_fence":		OUT = "iron_bars";break;
            case "thin_glass":		OUT = "glass_pane";break;
            case "water_lily":		OUT = "waterlily";break;
            case "nether_fence":	OUT = "nether_brick_fence";break;
            case "leaves_2":		OUT = "leaves2";break;
            case "sign_post":		OUT = "standing_sign";break;
            case "bed_block":		OUT = "bed";break;
            case "note_block":		OUT = "noteblock";break;
            case "piston_base":		OUT = "piston";break;
            case "piston_sticky_base":OUT = "sticky_base";break;
            case "piston_extension":OUT = "piston_head";break;
            case "stone_plate":		OUT = "stone_pressure_plate";break;
            case "wood_plate":		OUT = "wooden_pressure_plate";break;
            case "redstone_torch_on":OUT = "redstone_torch";break;
            case "redstone_torch_off":OUT = "unlit_redstone_torch";break;
            case "diode_block_on":	OUT = "powered_repeater";break;
            case "diode_block_off":	OUT = "unpowered_repeater";break;
            case "redstone_lamp_on":OUT = "lit_redstone_lamp";break;
            case "redstone_lamp_off":OUT = "restone_lamp";break;
            case "iron_plate":		OUT = "heavy_weighted_pressure_plate";break;
            case "gold_plate":		OUT = "light_weighted_pressure_plate";break;
            case "iron_door_block":	OUT = "iron_door";break;
            case "redstone_comparator_off":OUT = "unpowered_comparator";break;
            case "redstone_comparator_on":OUT = "powered_comparator";break;
            case "powered_rail":	OUT = "golden_rail";break;
            default: 				OUT = IN;break;
        }
        return OUT;
    }
}
