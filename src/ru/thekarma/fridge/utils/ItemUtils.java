package ru.thekarma.fridge.utils;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class ItemUtils {
	
	public static ItemStack getSkullAsUrl(String url, String name, List<String> lore) {
		ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) i.getItemMeta();
		GameProfile profile = new GameProfile(UUID.randomUUID(), null);
		byte[] bytes = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
		profile.getProperties().put("textures", new Property("textures", new String(bytes)));
		Field field = null;
		try {
			field = meta.getClass().getDeclaredField("profile");
			field.setAccessible(true);
			field.set(meta, profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		meta.setDisplayName(ColorUtils.ColorChat(name));
		meta.setLore(ColorUtils.ColorLore(lore));
		i.setItemMeta(meta);
		return i;
	}
}