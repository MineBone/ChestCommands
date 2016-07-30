package com.gmail.filoghost.chestcommands.api;

/**
 * The Interface EconomyWrapper.
 */
public interface EconomyWrapper {

    /**
     * Withdraw money from the player.
     *
     * @param type        the type
     * @param player      the param player
     * @param paramDouble the param double
     * @return true, if successful
     */
    public boolean withdrawPlayer(EconomyType type, String player, double paramDouble);

    /**
     * Deposit to the player.
     *
     * @param type        the type
     * @param player      the param player
     * @param paramDouble the param double
     * @return true, if successful
     */
    public boolean depositPlayer(EconomyType type, String player, double paramDouble);

    /**
     * Gets the balance of the player.
     *
     * @param type   the type
     * @param player the param player
     * @return the balance
     */
    public double getBalance(EconomyType type, String player);

}
