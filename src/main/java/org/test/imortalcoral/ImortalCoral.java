package org.test.imortalcoral;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ImortalCoral extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register the event listener
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        Material blockType = event.getBlock().getType();
        if (isCoral(blockType)) {
            event.setCancelled(true);
        }
    }

    private boolean isCoral(Material material) {
        switch (material) {
            case BRAIN_CORAL:
            case BRAIN_CORAL_BLOCK:
            case BRAIN_CORAL_FAN:
            case BUBBLE_CORAL:
            case BUBBLE_CORAL_BLOCK:
            case BUBBLE_CORAL_FAN:
            case FIRE_CORAL:
            case FIRE_CORAL_BLOCK:
            case FIRE_CORAL_FAN:
            case HORN_CORAL:
            case HORN_CORAL_BLOCK:
            case HORN_CORAL_FAN:
            case TUBE_CORAL:
            case TUBE_CORAL_BLOCK:
            case TUBE_CORAL_FAN:
                return true;
            default:
                return false;
        }
    }
}
