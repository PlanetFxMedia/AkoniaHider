package de.SebastianMikolai.PlanetFx.AkoniaHider;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.SebastianMikolai.PlanetFx.AkoniaHider.utils.ChatUtils;

public class EventListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getItem() != null && (e.getItem().isSimilar(ItemStacks.getHide()) || e.getItem().isSimilar(ItemStacks.getShow()))) {
			if (p.hasPermission("pfx.hideplayers.use")) {
				UseItem(p);
	        } else {
	        	ChatUtils.sendMessageConfig(p, "nopermission");
	        }
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (AkoniaHider.getInstance().ToggelOn.contains(p)) {
			AkoniaHider.getInstance().ToggelOn.remove(p);
		}
	}
	
	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	    for (Player player : Bukkit.getOnlinePlayers()) {
	    	p.showPlayer(player);
	    }
	    if (AkoniaHider.getInstance().itemonjoin) {
	    	e.getPlayer().getInventory().setItem(AkoniaHider.getInstance().InventorySlot, ItemStacks.getHide());
	    }
	}
	  
	public static void UseItem(Player p) {
		if (AkoniaHider.getInstance().ToggelOn.contains(p)) {
			AkoniaHider.getInstance().ToggelOn.remove(p);
			ChatUtils.sendMessage(p, AkoniaHider.getInstance().toggleoff);
	    	for (Player player : Bukkit.getOnlinePlayers()) {
	    		p.showPlayer(player);
	    	}
	    	p.getInventory().setItem(AkoniaHider.getInstance().InventorySlot, ItemStacks.getHide());
	    } else {
	    	AkoniaHider.getInstance().ToggelOn.add(p);
	    	ChatUtils.sendMessage(p, AkoniaHider.getInstance().toggleon);
	    	for (Player player : Bukkit.getOnlinePlayers()) {
	    		if (!player.hasPermission("pfx.hideplayers.nohide")) {
	    			p.hidePlayer(player);
	    		} else {
	    			p.showPlayer(player);
	    		}
	    	}
	    	p.getInventory().setItem(AkoniaHider.getInstance().InventorySlot, ItemStacks.getShow());
	    }
	}
}