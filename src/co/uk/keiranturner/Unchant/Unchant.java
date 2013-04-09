package co.uk.keiranturner.Unchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Unchant extends JavaPlugin
{
  public String unchant = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "Unchant" + ChatColor.AQUA + "]";

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if ((cmd.getName().equalsIgnoreCase("unchant")) &&  ((sender instanceof Player))) {
      Player player = (Player)sender;
      if (player.getItemInHand().getType() != Material.AIR) {
        for (Enchantment e : player.getItemInHand().getEnchantments().keySet()) 
        	player.getItemInHand().removeEnchantment(e);
          player.sendMessage(this.unchant + ChatColor.GOLD + " Succesfully Unchanted!");
      } else {
        player.sendMessage(this.unchant + ChatColor.GOLD + " There must be something in your had to unchant!");
      }
    }

    return false;
  }
}