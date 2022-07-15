package de.trebtee.beaconignore;

import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Cause;

public class BeaconListener implements Listener {
	
	@EventHandler
	public void onBeaconTrigger(EntityPotionEffectEvent e) {
		if (e.getCause() == Cause.BEACON) {
			if (e.getEntityType() == EntityType.PLAYER) {
				Player p = (Player) e.getEntity();
				@SuppressWarnings("unchecked")
				List<String> list = (List<String>) Main.getPlugin().getConfig().getList("toggled-off");
				if (list.contains(p.getUniqueId().toString())) {
					e.setCancelled(true);
				}
			}
		}		
	}
}
