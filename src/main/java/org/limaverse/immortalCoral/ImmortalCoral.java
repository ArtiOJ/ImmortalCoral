package org.limaverse.immortalCoral;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ImmortalCoral extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
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
        return switch (material) {
            case BRAIN_CORAL, BRAIN_CORAL_BLOCK, BRAIN_CORAL_FAN, BUBBLE_CORAL, BUBBLE_CORAL_BLOCK, BUBBLE_CORAL_FAN,
                 FIRE_CORAL, FIRE_CORAL_BLOCK, FIRE_CORAL_FAN, HORN_CORAL, HORN_CORAL_BLOCK, HORN_CORAL_FAN, TUBE_CORAL,
                 TUBE_CORAL_BLOCK, TUBE_CORAL_FAN -> true;
            default -> false;
        };
    }
}
