package com.gmail.filoghost.chestcommands.bridge;

import com.gmail.filoghost.chestcommands.api.EconomyType;
import com.gmail.filoghost.chestcommands.api.EconomyWrapper;
import com.gmail.filoghost.chestcommands.util.Utils;
import org.bukkit.entity.Player;

public class EconomyBridge {

    private static EconomyWrapper economy;

    public static boolean setupEconomy() {
        return true;
    }

    public static boolean hasValidEconomy() {
        return economy != null;
    }

    public static EconomyWrapper getEconomy() {
        if (!hasValidEconomy()) throw new IllegalStateException("Economy plugin was not found!");
        return economy;
    }

    public static double getMoney(Player player, EconomyType type) {
        if (!hasValidEconomy()) throw new IllegalStateException("Economy plugin was not found!");
        return economy.getBalance(type, player.getName());
    }

    public static boolean hasMoney(Player player, double minimum, EconomyType type) {
        if (!hasValidEconomy()) throw new IllegalStateException("Economy plugin was not found!");
        if (minimum < 0.0) throw new IllegalArgumentException("Invalid amount of money: " + minimum);

        double balance = economy.getBalance(type, player.getName());

        if (balance < minimum) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return true if the operation was successful.
     */
    public static boolean takeMoney(Player player, double amount, EconomyType type) {
        if (!hasValidEconomy()) throw new IllegalStateException("Economy plugin was not found!");
        if (amount < 0.0) throw new IllegalArgumentException("Invalid amount of money: " + amount);

        boolean result = economy.withdrawPlayer(type, player.getName(), amount);

        Utils.refreshMenu(player);

        return result;
    }

    public static boolean giveMoney(Player player, double amount, EconomyType type) {
        if (!hasValidEconomy()) throw new IllegalStateException("Economy plugin was not found!");
        if (amount < 0.0) throw new IllegalArgumentException("Invalid amount of money: " + amount);

        boolean result = economy.depositPlayer(type, player.getName(), amount);

        Utils.refreshMenu(player);

        return result;
    }

    public static String formatMoney(double amount) {
        return Double.toString(amount);
    }

    public static void setEconomy(EconomyWrapper economy) {
        EconomyBridge.economy = economy;
    }
}
