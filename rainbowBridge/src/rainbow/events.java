package rainbow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;


public class events implements Listener {

    private rainbowMain plugin = rainbowMain.getPlugin(rainbowMain.class);


    @EventHandler
    public void onInteract (PlayerInteractEvent event){
        //build a rainbow bridge when a player right clicks with "rainBridger"//
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (item != null && item.isSimilar(Items.feath)) {
                //check where the player is facing//
                Location loc = player.getLocation();
                double yaw = loc.getYaw();
                if (yaw < 0) {
                    yaw += 360;
                }
                int x = 0;
                int z = 0;
                if (0 <= yaw && yaw < 22.5) {
                    //S
                    x = 0;
                    z = 1;
                } else if (22.5 <= yaw && yaw < 67.5) {
                    //SW
                    x = -1;
                    z = 1;
                } else if (67.5 <= yaw && yaw < 112.5) {
                    //W
                    x = -1;
                    z = 0;
                } else if (112.5 <= yaw && yaw < 157.5) {
                    //NW
                    x = -1;
                    z = -1;
                } else if (157.5 <= yaw && yaw < 202.5) {
                    //N
                    x = 0;
                    z = -1;
                } else if (202.5 <= yaw && yaw < 247.5) {
                    //NE
                    x = 1;
                    z = -1;
                } else if (247.5 <= yaw && yaw < 292.5) {
                    //E
                    x = 1;
                    z = 0;
                } else if (292.5 <= yaw && yaw < 337.5) {
                    //SE
                    x = 1;
                    z = 1;
                } else if (337.5 <= yaw && yaw < 360.0) {
                    //S
                    x = 0;
                    z = 1;
                }
                loc.setY(loc.getY() - 1);
                placeblock(loc,x,z);
            }
        }
    }


    public Boolean isAir(Location loc) {
        //check if the block is air or water or lava//
        Material m = loc.getBlock().getType();
        if (m == Material.AIR || m == Material.WATER || m == Material.STATIONARY_WATER ||
                m == Material.LAVA || m == Material.STATIONARY_LAVA) {
            return true;
        }else{
            return false;
        }
    }

    public void placeblock(Location loc, int x, int z) {
        //place  4 blocks of glass under the player//
        if (x == 0) {
            if (loc.getX() > 0) {
                if (loc.getX() - (int)loc.getX() > 0.5) {
                    x = 1;
                }
                else if(loc.getX() - (int)loc.getX() < 0.5) {
                     x = -1;
                }
            }
            else if (loc.getX() < 0) {
                if ((int)loc.getX() - loc.getX() > 0.5) {
                    x = -1;
                }
                else if((int)loc.getX() - loc.getX() < 0.5) {
                    x = 1;
                }
            }
        }

        if (z == 0) {
            if (loc.getZ() > 0) {
                if (loc.getZ() - (int)loc.getZ() > 0.5) {
                    z = 1;
                } else if (loc.getZ() - (int)loc.getZ() < 0.5) {
                    z = -1;
                }
            }
            else if (loc.getZ() < 0) {
                if ((int)loc.getZ() - loc.getZ() > 0.5) {
                    z = -1;
                } else if ((int)loc.getZ() - loc.getZ() < 0.5) {
                    z = 1;
                }
            }
        }

        for (int i = 0;i < 2;i++) {
            for (int g = 0;g < 2;g++) {
                if (isAir(loc)) {
                    Block b = loc.getBlock();
                    Material m = b.getType();
                    Byte d = b.getData();
                    b.setType(Material.STAINED_GLASS);
                    b.setData((byte)rand(16));
                    run(b,m,d);
                }
                loc.setX(loc.getX() + x);
                if (g == 1) {
                    loc.setX(loc.getX() - 2*x);
                }
            }
            loc.setZ(loc.getZ() + z);
            if (i == 1) {
                loc.setZ(loc.getZ() - 2*z);
            }
        }
    }

    public int rand (int a) {
        //generate random numbers//
        Random r = new Random();
        return r.nextInt(a);
    }

    public void run(Block b, Material m, Byte d) {
        //reset the block after 5 sec//
        new BukkitRunnable() {
            @Override
            public void run() {
                b.setType(m);
                b.setData(d);
            }
        }.runTaskLater(plugin,100);

    }
}
