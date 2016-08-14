package de.SebastianMikolai.PlanetFx.AkoniaHider.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import de.SebastianMikolai.PlanetFx.AkoniaHider.AkoniaHider;

public class ChatUtils {

	public static void sendMessage(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', AkoniaHider.getInstance().getConfig().getString("AkoniaHider.Prefix") + " " + msg));
	}
	
	public static void sendMessageConfig(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', AkoniaHider.getInstance().getConfig().getString("AkoniaHider.Prefix") + " " + AkoniaHider.getInstance().getConfig().getString("Messages." + msg)));
	}
}