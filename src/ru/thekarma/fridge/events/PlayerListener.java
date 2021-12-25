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
			if(event.getSlot() >= 0 && event.getSlot() <= 6) {
				InvClickUtils.getClicked(p, event.getSlot()+1);
			}
			p.closeInventory();
		}
    }
    
}
