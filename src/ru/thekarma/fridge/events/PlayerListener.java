package ru.thekarma.fridge.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import ru.thekarma.fridge.*;
import ru.thekarma.fridge.utils.*;

public class PlayerListener implements Listener
{
    SpigotPlugin plugin;
    
    public PlayerListener(final SpigotPlugin m) {
        this.plugin = m;
    }
    
    @EventHandler
    public void fridgelocation(PlayerInteractEvent event) {
        final String l = event.getClickedBlock().getLocation().getWorld().getName() + "; " + event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ();
        if (plugin.getConfig().getStringList("settings.location").contains(l)) {
            event.getPlayer().openInventory(SpigotPlugin.inv);
            return;
        }
    }
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
		Player p = (Player)event.getWhoClicked();
		if(SpigotPlugin.inv == null) return;
		if(event.getClickedInventory() != null && event.getClickedInventory().equals(SpigotPlugin.inv)) {
			event.setCancelled(true);
			if(p.getFoodLevel() > 20) {
				p.sendMessage(ColorUtils.ColorChat(plugin.getConfig().getString("messages.full").replace("%prefix%", ConfigUtils.getPrefix())));
				p.closeInventory();
				return;
			}
			if(event.getSlot() == 0) {
				InvClickUtils.getClicked(p, 1);
			}
			if(event.getSlot() == 1) {
				InvClickUtils.getClicked(p, 2);
			}
			if(event.getSlot() == 2) {
				InvClickUtils.getClicked(p, 3);
			}
			if(event.getSlot() == 3) {
				InvClickUtils.getClicked(p, 4);
			}
			if(event.getSlot() == 4) {
				InvClickUtils.getClicked(p, 5);
			}
			if(event.getSlot() == 5) {
				InvClickUtils.getClicked(p, 6);
			}
			if(event.getSlot() == 6) {
				InvClickUtils.getClicked(p, 7);
			}
			p.closeInventory();
		}
    }
    
}
