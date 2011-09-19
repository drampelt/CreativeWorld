/*
 * CreativeWorld - by drampelt
 * http://drmc2.tk/
 *
 * powered by Kickstarter
 */

package me.drampelt.creativeworld.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.drampelt.creativeworld.CreativeWorld;


public class CommandExecutor_Creativeworld implements CommandExecutor {
	private CreativeWorld plugin;

	public CommandExecutor_Creativeworld(CreativeWorld plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if (command.getName().equalsIgnoreCase("creativeworld")) {

			if(args.length > 1){
				sender.sendMessage("Too many arguments. Worlds with spaces are not allowed.");
			}else if(args.length == 0){
				sender.sendMessage("Usage: /creativeworld <world name>");
			}else if(args.length == 1){
				plugin.addConfig(args[0]);
				sender.sendMessage("Config successfully saved.");
			}else{
				sender.sendMessage("Something went really bad.");
			}
			return true;
		}
		return false;
	}
}
