package de.SebastianMikolai.PlanetFx.AkoniaHider;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStacks {
	
	@SuppressWarnings("deprecation")
	public static ItemStack getShow() {
		ArrayList<String> lore = new ArrayList<String>();
		String[] serializedID = AkoniaHider.getInstance().getConfig().getString("ItemStacks.shown.ItemID").split(":");
		int id = Integer.valueOf(serializedID[0]).intValue();
		int b = 0;
		if (serializedID.length > 1) {
			b = Integer.valueOf(serializedID[1]).intValue();
		}
		ItemStack item = new ItemStack(Material.getMaterial(id), 1, (short)0, Byte.valueOf((byte)b));
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', AkoniaHider.getInstance().getConfig().getString("ItemStacks.shown.ItemName")));
		String[] lores = AkoniaHider.getInstance().getConfig().getString("ItemStacks.shown.ItemLore").split(":");
		for (int i = 0; i < lores.length; i++) {
			lore.add(ChatColor.translateAlternateColorCodes('&', lores[i]));
		}
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack getHide() {
		ArrayList<String> lore = new ArrayList<String>();
		String[] serializedID = AkoniaHider.getInstance().getConfig().getString("ItemStacks.hidden.ItemID").split(":");
		int id = Integer.valueOf(serializedID[0]).intValue();
		int b = 0;
		if (serializedID.length > 1) {
			b = Integer.valueOf(serializedID[1]).intValue();
		}
		ItemStack item = new ItemStack(Material.getMaterial(id), 1, (short)0, Byte.valueOf((byte)b));
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', AkoniaHider.getInstance().getConfig().getString("ItemStacks.hidden.ItemName")));
		String[] lores = AkoniaHider.getInstance().getConfig().getString("ItemStacks.hidden.ItemLore").split(":");
		for (int i = 0; i < lores.length; i++) {
			lore.add(ChatColor.translateAlternateColorCodes('&', lores[i]));
		}
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
}