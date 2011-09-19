/*
 * CreativeWorld - by drampelt
 * http://drmc2.tk/
 *
 * powered by Kickstarter
 */

package me.drampelt.creativeworld.listeners;


import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;

import org.bukkit.event.player.PlayerMoveEvent;

import me.drampelt.creativeworld.CreativeWorld;


public class Listener_Player extends PlayerListener {
	private CreativeWorld plugin;

	public Listener_Player(CreativeWorld plugin){
		this.plugin = plugin;
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event){
		Player p = event.getPlayer();
		String configuredWorld = plugin.getConfig_world();
		World worldConfig = plugin.getServer().getWorld(configuredWorld);
		World world = p.getWorld();
		
		if(world == worldConfig){
			if(p.getGameMode() != GameMode.CREATIVE){
				p.setGameMode(GameMode.CREATIVE);
			}
		}else{
			if(p.getGameMode() != GameMode.SURVIVAL){
				p.setGameMode(GameMode.SURVIVAL);
			}
		}
	}


}
