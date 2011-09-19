/*
 * CreativeWorld - by drampelt
 * http://drmc2.tk/
 *
 * powered by Kickstarter
 */

package me.drampelt.creativeworld;


import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.util.config.Configuration;
import me.drampelt.creativeworld.commands.CommandExecutor_Creativeworld;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import me.drampelt.creativeworld.listeners.Listener_Player;


public class CreativeWorld extends JavaPlugin{
	private Logger log;
	private PluginDescriptionFile description;

	private String prefix;
	private String config_world;
	private Listener_Player listenerPlayer;

	
	@Override
	public void onEnable(){
		log = Logger.getLogger("Minecraft");
		description = getDescription();
		prefix = "["+description.getName()+"] ";

		log("loading "+description.getFullName());

		setupConfiguration();
		listenerPlayer = new Listener_Player(this);

		
		getServer().getPluginManager().registerEvent(Type.PLAYER_MOVE, listenerPlayer, Priority.Normal, this);

		
		getCommand("creativeworld").setExecutor(new CommandExecutor_Creativeworld(this));

		

	}
	
	@Override
	public void onDisable(){
		log("disabled "+description.getFullName());

	}
	public void log(String message){
		log.info(prefix+message);
	}


	private void setupConfiguration(){
		Configuration cfg = getConfiguration();
		
		cfg.setHeader("#Set creative world manually");
		
		config_world = cfg.getString("world", "world");
		
		cfg.save();
	}

	
	public String getConfig_world(){
		return config_world;
	}
	
	public void addConfig(String worldName){
		Configuration cfg = getConfiguration();
		config_world = worldName;
		cfg.setProperty("world", worldName);
		cfg.save();
	}


}
