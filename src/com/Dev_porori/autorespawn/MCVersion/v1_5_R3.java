package com.Dev_porori.autorespawn.MCVersion;

import org.bukkit.craftbukkit.v1_5_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.Dev_porori.autorespawn.Main;
import com.Dev_porori.autorespawn.NMS;

import net.minecraft.server.v1_5_R3.Packet205ClientCommand;

public class v1_5_R3 implements NMS, Listener {

	@Override
	public void registerDeathListener(Main main) {
		Main.instance.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			@Override
			public void run() {
				if (p.isDead()) {
					Packet205ClientCommand packet = new Packet205ClientCommand();
					packet.a = 1;
					((CraftPlayer) p).getHandle().playerConnection.a(packet);
				}
			}
		});
	}

}
