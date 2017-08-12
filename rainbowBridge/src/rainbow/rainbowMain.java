package rainbow;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class rainbowMain extends JavaPlugin{
    ConsoleCommandSender clogger = this.getServer().getConsoleSender();

    public void onEnable(){
        clogger.sendMessage(ChatColor.GREEN + "rainbowBridge plugin 正在開啟...");

        getServer().getPluginManager().registerEvents(new events(),this);

        Items.createItem();
        Items.customRecipe();

    }

    public void onDisable(){
        clogger.sendMessage(ChatColor.RED + "rainbowBridge plugin 正在關閉...");
    }
}
