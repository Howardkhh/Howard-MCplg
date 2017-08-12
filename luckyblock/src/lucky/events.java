package lucky;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class events implements Listener {

    @EventHandler
    public void placeLuckyBlock(PlayerInteractEvent event) {
        //this generates result when a lucky block is placed//
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (event.getClickedBlock() != null) {
            if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {
                ItemStack item = player.getItemInHand();
                if (item.isSimilar(items.luckyBlock)) {
                    Location loc = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation();
                    prizes.generateResult(loc, player);
                    item.setAmount(item.getAmount()-1);
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void playercantpickupdiamonds(PlayerPickupItemEvent event) {
        //this prevents player picking up the diamond blocks from the "diamondsInLava" prize//
        if (event.getItem().getItemStack().getType().equals(Material.DIAMOND_BLOCK) && !prizes.pickDiamond) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void useThunderStick(PlayerInteractEvent event) {
        //this spawns a lightning strike when a player uses the ThunderStick//
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getItemInHand().isSimilar(items.thunderStick)) {
                Location loc = player.getTargetBlock((Set<Material>) null, 100).getLocation();
                Block block = loc.getBlock();
                if (block.getType() != Material.AIR) {
                    loc.getWorld().strikeLightning(loc);
                }
            }
        }
    }

    @EventHandler
    public void explodeHit(EntityDamageByEntityEvent event) {
        //this lets the player explode when the player is hit and wearing explosiveChestplate and has gunpowder in their inventory//
        ItemStack gunpowder = null;
        if (event.getEntity() instanceof Player) {
            Player player = (Player)event.getEntity();
            if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().isSimilar(items.explosiveChestplate)) {
                for (ItemStack inv : player.getInventory().getContents()) {
                    if (inv != null && inv.isSimilar(new ItemStack(Material.SULPHUR))) {
                        gunpowder = inv;
                        int amount = gunpowder.getAmount();
                        player.getWorld().createExplosion(player.getLocation(), 1);
                        gunpowder.setAmount(amount - 1);
                        break;
                    }
                }


            }

        }
    }
}
