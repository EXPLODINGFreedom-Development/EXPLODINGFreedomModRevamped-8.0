package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
This is the ExplodingManage command. if you obtain the source code DO NOT remove this class or modify it.
Its here for the bad people that decide to rename the plugin and pass it as there own. Similar to the TFM_FrontDoor
This requires BarAPI for the project to compile
If you're wondering what this class exactly does I've noted it with the '//'s
The your wondering what (mode.equals("")) does it defines what you have to say for the command to go through.
*/

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Admin Fun.", //Description
        aliases = "af",
        usage = "/<command>") //Usage
public class Command_adminfun extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
    
         playerMsg("§e----§aAdmin Fun Commands§e----");
         playerMsg("§c/asshole§f: §eSomeone is an asshole? Blow em up.");
         playerMsg("§c/banhammer§f: §eObtain a banhammer");
         playerMsg("§c/fakesa§f: §ePretend to super a player");
         playerMsg("§c/blowjob§f: §eGive a player a blowjob");
         playerMsg("§c/balls§f:§e Fills someone's testicles with tnt and blows em up.");
         playerMsg("§c/camera§f: §eSelfies.");
         playerMsg("§c/k§f: §eNobody cares about what you said fucker.");
         playerMsg("§c/deafen§f: §eSpam this for the best effects");
         playerMsg("§c/expel§f:§e Blast them fuckers away.");
         playerMsg("§c/destroy§f: §eDestroys a faggot");	
         playerMsg("§c/destroypussy§f: §eDestroys a pussy");
         playerMsg("§c/orbit§f: §eLaunch someone into orbit");
         playerMsg("§c/pussy§f: §eKills pussies ");
         return true;
                   }
            }

