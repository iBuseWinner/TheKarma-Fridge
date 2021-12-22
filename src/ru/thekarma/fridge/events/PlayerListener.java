package ru.thekarma.fridge.events;

import org.bukkit.Material;
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
        if (event.getClickedBlock() != null && event.getClickedBlock().getType().equals((Object)Material.STONE_BUTTON)) {
            final String l = event.getClickedBlock().getLocation().getBlockX() + " " + event.getClickedBlock().getLocation().getBlockY() + " " + event.getClickedBlock().getLocation().getBlockZ();
            if (plugin.getConfig().getStringList("settings.location").contains(l)) {
                event.getPlayer().openInventory(SpigotPlugin.inv);
                return;
            }
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
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(1)) {
					p.sendMessage(ConfigUtils.noBalance(p, 1));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(1));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(1));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			if(event.getSlot() == 1) {
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(2)) {
					p.sendMessage(ConfigUtils.noBalance(p, 2));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(2));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(2));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			if(event.getSlot() == 2) {
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(3)) {
					p.sendMessage(ConfigUtils.noBalance(p, 3));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(3));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(3));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			if(event.getSlot() == 3) {
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(4)) {
					p.sendMessage(ConfigUtils.noBalance(p, 4));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(4));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(4));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			if(event.getSlot() == 4) {
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(5)) {
					p.sendMessage(ConfigUtils.noBalance(p, 5));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(5));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(5));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			if(event.getSlot() == 5) {
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(6)) {
					p.sendMessage(ConfigUtils.noBalance(p, 6));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(6));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(6));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			if(event.getSlot() == 6) {
				if(VaultManager.getmoney(p) < ConfigUtils.getPrice(7)) {
					p.sendMessage(ConfigUtils.noBalance(p, 7));
					p.closeInventory();
					return;
				}
				VaultManager.withdraw(p, ConfigUtils.getPrice(7));
				p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(7));
				p.sendMessage(ConfigUtils.getBuyer());
			}
			p.closeInventory();
		}
    }
    
}
