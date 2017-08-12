package lucky;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class luckymain extends JavaPlugin {

    ConsoleCommandSender clogger = this.getServer().getConsoleSender();
    public void onEnable() {
        clogger.sendMessage(ChatColor.GREEN + "正在開啟...");

        items.createItems();

        getServer().getPluginManager().registerEvents(new events(),this);

        getCommand(commands.cmd1).setExecutor(new commands());
        getCommand(commands.cmd2).setExecutor(new commands());
        getCommand(commands.cmd3).setExecutor(new commands());
        getCommand(commands.cmd4).setExecutor(new commands());
        getCommand(commands.cmd5).setExecutor(new commands());

        run();
    }

    public void onDisable() {
        clogger.sendMessage(ChatColor.RED + "正在關閉...");
    }

    public void run() {
        //this gives night vision to players that are wearing night vision helmet every 8 sec//

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers()) {
                    if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().equals(items.nightVisionHelm)) {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 0));
                    }
                }
            }
        }.runTaskTimer(this, 0, 160);
    }
}
