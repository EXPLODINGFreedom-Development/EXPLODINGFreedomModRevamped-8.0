package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import static me.StevenLawson.TotalFreedomMod.TotalFreedomMod.server;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent; 
import static org.spigotmc.SpigotConfig.config;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Views the message of the day", usage = "/<command>")
public class Command_votelinks extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {        
        playerMsg("§b********************************************************", ChatColor.GOLD);
        playerMsg("§b*         §aEXPLODINGFreedom Vote Links§b                  *", ChatColor.GOLD);
        playerMsg("§b*        §aMake EF More Popular and Vote!                §b*", ChatColor.GOLD);
        playerMsg("§b********************************************************", ChatColor.AQUA);
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 1:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK1.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 2:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK2.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 3:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK3.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 4:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK4.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 5:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK5.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 6:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK6.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 7:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK7.getString());
        sender.sendMessage(ChatColor.AQUA + "§aVoteLink 8:§b" + TFM_ConfigEntry.VOTELINKS_VOTELINK8.getString());
        playerMsg("§b********************************************************", ChatColor.AQUA);
        playerMsg("§b*    §a Thank You for voting and have a good day!        §b*", ChatColor.GOLD);
        playerMsg("§b********************************************************", ChatColor.GOLD);
        return true;  
       }

          {
        }
    }
