package ru.thekarma.fridge;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import ru.thekarma.fridge.events.PlayerListener;
import ru.thekarma.fridge.utils.*;

public class SpigotPlugin extends JavaPlugin {
	public SpigotPlugin plugin;
	public static Inventory inv;
	
    @Override
    public void onEnable() {
    	openFridgeGui();
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
          getLogger().info("Creating new file config...");
          getConfig().options().copyDefaults(true);
          saveDefaultConfig();
        } 
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
        this.getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Plugin disabled!");
    }
	
	private void openFridgeGui() {
		inv = Bukkit.createInventory(null, InventoryType.DISPENSER, ColorUtils.ColorChat(getConfig().getString("inventory.name")));
		inv.setItem(0, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(1), ConfigUtils.getName(1), ConfigUtils.getLore(1)));
		inv.setItem(1, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(2), ConfigUtils.getName(2), ConfigUtils.getLore(2)));
		inv.setItem(2, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(3), ConfigUtils.getName(3), ConfigUtils.getLore(3)));
		inv.setItem(3, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(4), ConfigUtils.getName(4), ConfigUtils.getLore(4)));
		inv.setItem(4, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(5), ConfigUtils.getName(5), ConfigUtils.getLore(5)));
		inv.setItem(5, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(6), ConfigUtils.getName(6), ConfigUtils.getLore(6)));
		inv.setItem(6, ItemUtils.getSkullAsUrl(ConfigUtils.getMaterial(7), ConfigUtils.getName(7), ConfigUtils.getLore(7)));
	}
}