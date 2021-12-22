package ru.thekarma.fridge.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

public class ColorUtils {
	public static String ColorChat(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static List<String> ColorLore(List<String> list) {
		List<String> parsed = new ArrayList<>();
		if (list != null) list.forEach((str) -> { parsed.add(ColorChat(str)); });
		return parsed;
	}
}
