package lucky;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class commands implements CommandExecutor,Listener {

    static String cmd1 = "getluckyblock";
    static String cmd2 = "getbrokensword";
    static String cmd3 = "getnightvisionhelm";
    static String cmd4 = "getthunderstick";
    static String cmd5 = "getexplosivechestplate";

    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args){
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (lable.equalsIgnoreCase(cmd1)) {
                player.getInventory().addItem(items.luckyBlock);
                return true;
            }

            if (lable.equalsIgnoreCase(cmd2)) {
                player.getInventory().addItem(items.brokenSword);
                return true;
            }

            if (lable.equalsIgnoreCase(cmd3)) {
                player.getInventory().addItem(items.nightVisionHelm);
                return true;
            }

            if (lable.equalsIgnoreCase(cmd4)) {
                player.getInventory().addItem(items.thunderStick);
                return true;
            }

            if (lable.equalsIgnoreCase(cmd5)) {
                player.getInventory().addItem(items.explosiveChestplate);
                return true;
            }
        }
        sender.sendMessage(ChatColor.DARK_RED + "You must be a player to use this command!!");
        return false;
    }
}
