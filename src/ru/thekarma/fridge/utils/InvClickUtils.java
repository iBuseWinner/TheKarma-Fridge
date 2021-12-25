package ru.thekarma.fridge.utils;

import org.bukkit.entity.Player;

import ru.thekarma.fridge.VaultManager;

public class InvClickUtils {
	public static void getClicked(Player p, int i) {
		if(VaultManager.getmoney(p) < ConfigUtils.getPrice(i)) {
			p.sendMessage(ConfigUtils.noBalance(p, i));
			p.closeInventory();
			return;
		}
		VaultManager.withdraw(p, ConfigUtils.getPrice(i));
		p.setFoodLevel(p.getFoodLevel() + ConfigUtils.getFood(i));
		p.sendMessage(ConfigUtils.getBuyer());
	}
}
