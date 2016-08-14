package de.SebastianMikolai.PlanetFx.AkoniaHider;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AkoniaHider extends JavaPlugin {
	
	private static AkoniaHider instance;
	public String toggleon;
	public String toggleoff;
	public Boolean itemonjoin;
	public String itemname;
	public String itemlore;
	public Integer InventorySlot;
	public List<Player> ToggelOn = new ArrayList<Player>();
	
	public static AkoniaHider getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
	    instance = this;
		saveDefaultConfig();
		InventorySlot = (getConfig().getInt("AkoniaHider.InventorySlot") - 1);
		toggleon = ChatColor.translateAlternateColorCodes('&', getConfig().getString("AkoniaHider.ToggleOn"));
		toggleoff = ChatColor.translateAlternateColorCodes('&', getConfig().getString("AkoniaHider.ToggleOff"));
		itemonjoin = getConfig().getBoolean("AkoniaHider.OnJoin");
	    PluginManager pm = Bukkit.getPluginManager();
	    pm.registerEvents(new EventListener(), this);
	}
	
	@Override
	public void onDisable() {
	    for (Player p : Bukkit.getOnlinePlayers()) {
	    	for (Player player : Bukkit.getOnlinePlayers()) {
	    	    p.showPlayer(player);
	    	}
	    }
	    ToggelOn.clear();
	}
	
	public void UseItem(Player p) {
		if (ToggelOn.contains(p)) {
	    	ToggelOn.remove(p);
	    	p.sendMessage(toggleoff);
	    	for (Player player : Bukkit.getOnlinePlayers()) {
	    		p.showPlayer(player);
	    	}
	    } else {
	    	ToggelOn.add(p);
	    	p.sendMessage(toggleon);
	    	for (Player player : Bukkit.getOnlinePlayers()) {
	    		if (!player.hasPermission("pfx.AkoniaHiders.nohide")) {
	    			p.hidePlayer(player);
	    		} else {
	    			p.showPlayer(player);
	    		}
	    	}
	    }
	}
}