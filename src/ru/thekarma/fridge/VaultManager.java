package ru.thekarma.fridge;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.economy.Economy;

public class VaultManager
{
    public static void withdraw(final Player p, final int summ) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
		final RegisteredServiceProvider<Economy> rsp = (RegisteredServiceProvider<Economy>)Bukkit.getServicesManager().getRegistration((Class)Economy.class);
        if (rsp == null) {
            return;
        }
        final Economy econ = (Economy)rsp.getProvider();
        econ.withdrawPlayer((OfflinePlayer)p, (double)summ);
    }
    
    public static void deposite(final Player p, final int summ) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
        final RegisteredServiceProvider<Economy> rsp = (RegisteredServiceProvider<Economy>)Bukkit.getServicesManager().getRegistration((Class)Economy.class);
        if (rsp == null) {
            return;
        }
        final Economy econ = (Economy)rsp.getProvider();
        econ.depositPlayer((OfflinePlayer)p, (double)summ);
    }
   
    public static long getmoney(final Player p) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
		final RegisteredServiceProvider<Economy> rsp = (RegisteredServiceProvider<Economy>)Bukkit.getServicesManager().getRegistration((Class)Economy.class);
        if (rsp == null) {
            return 0;
        }
        final Economy econ = (Economy)rsp.getProvider();
        final long me = (int)econ.getBalance((OfflinePlayer)p);
        return me;
    }
}