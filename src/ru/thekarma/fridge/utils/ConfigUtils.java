package ru.thekarma.fridge.utils;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.thekarma.fridge.SpigotPlugin;
import ru.thekarma.fridge.VaultManager;

public class ConfigUtils {
	public static Plugin plugin = (Plugin)SpigotPlugin.getPlugin(SpigotPlugin.class);

	public static String getPrefix() {
		 return ColorUtils.ColorChat(plugin.getConfig().getString("settings.prefix"));
	}
	
	public static double getBalance(Player p, int i) {
		 return getPrice(i) - VaultManager.getmoney(p);
	}

	public static String noBalance(Player p, int i) {
		 return ColorUtils.ColorChat(plugin.getConfig().getString("messages.notmoney").replace("%prefix%", getPrefix()).replace("%money%", String.valueOf(getBalance(p, i))).replace("%price%", String.valueOf(getPrice(i))));
	}
	
	public static String getBuyer() {
		 return ColorUtils.ColorChat(plugin.getConfig().getString("messages.buy").replace("%prefix%", getPrefix()));
	}
	
	public static int getFood(int i) {
		 return plugin.getConfig().getInt("inventory.items."+i+".food");
	}
	
	public static int getPrice(int i) {
		 return plugin.getConfig().getInt("inventory.items."+i+".price");
	}
	
	public static String getName(int i) {
		 return plugin.getConfig().getString("inventory.items."+i+".name");
	}
	
	public static List<String> getLore(int i) {
		 return plugin.getConfig().getStringList("inventory.items."+i+".lore");
	}
	
	public static String getMaterial(int i) {
		 return plugin.getConfig().getString("inventory.items."+i+".material");
	}
}
