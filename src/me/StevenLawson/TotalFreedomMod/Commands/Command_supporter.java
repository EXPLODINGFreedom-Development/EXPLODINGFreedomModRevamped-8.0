package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_Donator;
import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_DonatorList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Manage donors.", usage = "/<command> <list | <add|delete|info> <username>>")
public class Command_supporter extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0 || args.length > 2)
        {
            return false;
        }

        if (args.length == 1)
        {
            if (args[0].equals("list"))
            {
                playerMsg("Donors: " + StringUtils.join(EFMR_DonatorList.getDonatorNames(), ", "), ChatColor.GOLD);
                return true;
            }

            return false;
        }

        if (args[0].equalsIgnoreCase("info"))
        {
            if (!EFMR_DonatorList.isSuperDonor(sender))
            {
                playerMsg(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }

            EFMR_Donator donor = EFMR_DonatorList.getEntry(args[1].toLowerCase());

            if (donor == null)
            {
                try
                {
                    donor = EFMR_DonatorList.getEntry(getPlayer(args[1]).getName().toLowerCase());
                }
                catch (Exception ex)
                {
                }
            }

            if (donor == null)
            {
                playerMsg("Superadmin not found: " + args[1]);
            }
            else
            {
                playerMsg(donor.toString());
            }

            return true;
        }

        if (!senderIsConsole)
        {
            playerMsg("This command may only be used from the console.");
            return true;
        }

        if (args[0].equalsIgnoreCase("add"))
        {
            OfflinePlayer player;

            try
            {
                player = getPlayer(args[1]);
            }
            catch (Exception ex)
            {
                final EFMR_Donator donor = EFMR_DonatorList.getEntry(args[1]);

                if (donor == null)
                {
                    playerMsg(ex.getMessage(), ChatColor.RED);
                    return true;
                }

                player = Bukkit.getOfflinePlayer(donor.getLastLoginName());
            }

            TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the donor list", true);
            EFMR_DonatorList.addSuperadmin(player);

            return true;
        }

        if ("remove".equals(args[0]))
        {
            if (!TFM_Util.OWNERS.contains(sender.getName()))
            {
                playerMsg(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }

            String targetName = args[1];

            try
            {
                targetName = getPlayer(targetName).getName();
            }
            catch (Exception ex)
            {
            }

            if (!EFMR_DonatorList.getLowerSuperNames().contains(targetName.toLowerCase()))
            {
                playerMsg("Donor not found: " + targetName);
                return true;
            }

            TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the donor list", true);
            EFMR_DonatorList.removeSuperadmin(Bukkit.getOfflinePlayer(targetName));

            return true;
        }
        return false;

    }
}
