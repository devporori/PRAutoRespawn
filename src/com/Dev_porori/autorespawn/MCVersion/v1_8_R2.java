package com.Dev_porori.autorespawn.MCVersion;

import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.Dev_porori.autorespawn.Main;
import com.Dev_porori.autorespawn.NMS;

import net.minecraft.server.v1_8_R2.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R2.PacketPlayInClientCommand.EnumClientCommand;

public class v1_8_R2 implements NMS, Listener {

	@Override
	public void registerDeathListener(Main main) {
		Main.instance.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
		((CraftPlayer) p).getHandle().playerConnection.a(packet);
	}
}
