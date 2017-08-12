package rainbow;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {

    private static rainbowMain plugin = rainbowMain.getPlugin(rainbowMain.class);

    public static ItemStack feath;

    public static void createItem() {
        //create "rainbowBridger"//
        feath = new ItemStack(Material.FEATHER, 1);
        ItemMeta feathmeta = feath.getItemMeta();
        ArrayList<String> feathlore = new ArrayList<>();
        feathmeta.addEnchant(Enchantment.PROTECTION_FALL,100,true);
        feathmeta.setDisplayName("§4R§6a§ei§an§9b§1o§5w§4b§6r§ei§ad§9g§1e§5r");
        feathlore.add("Right click to use");
        feathmeta.setLore(feathlore);
        feath.setItemMeta(feathmeta);
    }

    public static void customRecipe () {
        //make the recipe of "rainbowBridger"//
        ShapedRecipe rainbow = new ShapedRecipe(feath);
        rainbow.shape("!@#","$%$","#@!");
        rainbow.setIngredient('!', Material.DIAMOND_BLOCK);
        rainbow.setIngredient('@', Material.GOLD_BLOCK);
        rainbow.setIngredient('#', Material.EMERALD_BLOCK);
        rainbow.setIngredient('$', Material.LAPIS_BLOCK);
        rainbow.setIngredient('%', Material.FEATHER);
        plugin.getServer().addRecipe(rainbow);
    }

}
