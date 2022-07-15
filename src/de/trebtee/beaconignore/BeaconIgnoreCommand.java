package de.trebtee.beaconignore;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class BeaconIgnoreCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("zf.beaconignore.toggle")) {
				@SuppressWarnings("unchecked")
				List<String> list = (List<String>) Main.getPlugin().getConfig().getList("toggled-off");
				String msg = "error";
				
				if (list.contains(p.getUniqueId().toString())) {
					list.remove(p.getUniqueId().toString());
					msg = ChatColor.GREEN + "Beacons on!";
					
				} else {
					list.add(p.getUniqueId().toString());
					msg = ChatColor.RED + "Beacons off!";
				}
				Main.getPlugin().getConfig().set("toggled-off", list);
				Main.getPlugin().saveConfig();
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
			}
		}
		return false;
	}

}
