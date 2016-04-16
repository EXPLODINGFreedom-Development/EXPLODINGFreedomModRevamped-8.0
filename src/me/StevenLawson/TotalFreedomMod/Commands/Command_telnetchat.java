package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.TELNET, source = SourceType.BOTH)
@CommandParameters(
        description = "Senior AdminChat - Talk privately with other senior admins.",
        usage = "/<command> [message...]",
        aliases = "tc")
public class Command_telnetchat extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_AdminList.isTelnetAdmin(sender))
        {
            TFM_Util.playerMsg(sender, "You do not have permission to access the Telnet Admin Chat.", ChatColor.RED);
            return true;
        }
        if (args.length == 0)
        {
            return false;
        }
        else
        {
            TFM_Util.TelnetChatMessage(sender, org.apache.commons.lang.StringUtils.join(args, " "), senderIsConsole);
        }
        return true;
    }
}
