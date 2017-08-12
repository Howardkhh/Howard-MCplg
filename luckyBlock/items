package lucky;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class items {

    public static ItemStack luckyBlock = new ItemStack(Material.MONSTER_EGG, 1);
    public static ItemStack brokenSword = new ItemStack(Material.DIAMOND_SWORD, 1);
    public static ItemStack nightVisionHelm = new ItemStack(Material.DIAMOND_HELMET, 1);
    public static ItemStack thunderStick = new ItemStack(Material.STICK, 1);
    public static ItemStack explosiveChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);

    public static void createItems() {

        //luckyBlock//
        ItemMeta luckyMeta = luckyBlock.getItemMeta();
        ArrayList<String> luckyLore = new ArrayList<>();
        luckyLore.add(ChatColor.LIGHT_PURPLE + "Right click on a block to use!!");
        luckyMeta.setDisplayName(ChatColor.GREEN + "Lucky" + ChatColor.AQUA + "Block");
        luckyMeta.setLore(luckyLore);
        luckyMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 100, true);
        luckyBlock.setItemMeta(luckyMeta);

        /***********************************************************/

        //brokenSword//
        ItemMeta swordMeta = brokenSword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.GRAY + "Broken Sword");
        brokenSword.setDurability((short)1541);
        brokenSword.setItemMeta(swordMeta);
        net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(brokenSword);
        NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
        NBTTagList modifiers = new NBTTagList();
        NBTTagCompound damage = new NBTTagCompound();
        damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
        damage.set("Name", new NBTTagString("generic.attackDamage"));
        damage.set("Amount", new NBTTagInt(1));
        damage.set("Operation", new NBTTagInt(0));
        damage.set("UUIDLeast", new NBTTagInt(894654));
        damage.set("UUIDMost", new NBTTagInt(2872));
        modifiers.add(damage);
        compound.set("AttributeModifiers", modifiers);
        nmsStack.setTag(compound);
        brokenSword = CraftItemStack.asBukkitCopy(nmsStack);

        /***********************************************************/

        //nightVisionHelmet//
        ItemMeta nightHelmMeta = nightVisionHelm.getItemMeta();
        nightHelmMeta.setDisplayName(ChatColor.DARK_AQUA + "Night Vision Helmet");
        nightHelmMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ArrayList<String> nightHelmLore = new ArrayList<>();
        nightHelmLore.add(ChatColor.LIGHT_PURPLE + "This magic helmet gives you night vision");
        nightHelmLore.add(ChatColor.LIGHT_PURPLE + "when you are wearing it!!");
        nightHelmMeta.setLore(nightHelmLore);
        nightHelmMeta.setUnbreakable(true);
        nightVisionHelm.setItemMeta(nightHelmMeta);

        /***********************************************************/

        //thunderStick//
        ItemMeta thunderMeta = thunderStick.getItemMeta();
        ArrayList<String> thunderLore = new ArrayList<>();
        thunderLore.add(ChatColor.LIGHT_PURPLE + "Right click to use!");
        thunderMeta.setLore(thunderLore);
        thunderMeta.setDisplayName(ChatColor.GOLD + "ThunderStick");
        thunderMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        thunderStick.setItemMeta(thunderMeta);

        /***********************************************************/

        //explosiveChestplate//
        ItemMeta explosiveMeta = explosiveChestplate.getItemMeta();
        ArrayList<String> explosiveLore = new ArrayList<>();
        explosiveLore.add(ChatColor.LIGHT_PURPLE  + "This chestplate makes you explode when you get hit");
        explosiveLore.add(ChatColor.LIGHT_PURPLE + "It takes a gunpowder per explosion");
        explosiveMeta.setLore(explosiveLore);
        explosiveMeta.setDisplayName(ChatColor.RED + "Explosive Chestplate");
        explosiveMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10, true);
        explosiveMeta.setUnbreakable(true);
        explosiveChestplate.setItemMeta(explosiveMeta);
    }
}
