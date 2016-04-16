package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.BUILDERPLUSS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.BUILDERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.CHIEFEXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.LEADSYSS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.LEAD_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.LWEBDEVS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.MULTICRAFTS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_ADMINS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_COOWNERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.WEBDEVS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    LEAD_DEVELOPER("a " + ChatColor.DARK_PURPLE + "Lead-Developer", ChatColor.DARK_PURPLE + "[Lead-Developer]"),
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Developer]"),
    LWEBDEV("the " + ChatColor.BLUE + "Lead Web-Developer", ChatColor.BLUE + "[Lead Web-Dev]"),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]"),
    WEBDEV("the " + ChatColor.BLUE + "Web-Developer", ChatColor.BLUE + "[Web-Developer]"),
    OWNER("the " + ChatColor.DARK_RED + "System-Owner", ChatColor.DARK_RED + "[System-Owner]"),
    SYS_COOWNER("the " + ChatColor.DARK_BLUE + "System Co-Owner", ChatColor.DARK_BLUE + "[System Co-Owner]"),
    LEADSYS("the " + ChatColor.DARK_RED + "Lead System-Admin", ChatColor.DARK_RED + "[Lead System-Admin]"),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin", ChatColor.DARK_RED + "[System-Admin]"),
    CHIEFEXEC("the " + ChatColor.RED + "Chief Executive Officer", ChatColor.RED + "[Chief Executive Officer]"),
    SPEC_EXEC("an " + ChatColor.BLUE + "Special-Executive", ChatColor.BLUE + "[Special-Executive]"),
    EXEC("an " + ChatColor.BLUE + "Executive", ChatColor.BLUE + "[Executive]"),
    HONORARY("a " + ChatColor.YELLOW + "Honorary Senior Administrator", ChatColor.YELLOW + "[Honorary-SrA]"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    MULTICRAFT("a " + ChatColor.GREEN + "Telnet MultiCraft Admin", ChatColor.GREEN + "[Telnet MultiCraft Admin]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "[STA]"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "[SA]"),
    BUILDERPLUS("a " + ChatColor.GOLD + "Master-Builder+", ChatColor.GOLD + "[Master-Builder+]"),
    BUILDER("a " + ChatColor.GOLD + "Master-Builder", ChatColor.GOLD + "[Master-Builder]"),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "[OP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]");
    private String loginMessage;
    private String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }
        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }  
       if (LEAD_DEVELOPERS.contains(sender.getName()))
            {
                return LEAD_DEVELOPER;
            }
            if (LWEBDEVS.contains(sender.getName()))
            {
                return LWEBDEV;
            }
            if (WEBDEVS.contains(sender.getName()))
            {
                return WEBDEV;
            }
            if (SYS_COOWNERS.contains(sender.getName()))
            {
                return SYS_COOWNER;
            }
            if (BUILDERPLUSS.contains(sender.getName()))
            {
                return BUILDERPLUS;
            }
            if (LEADSYSS.contains(sender.getName()))
            {
                return LEADSYS;
            }
            if (SYS_ADMINS.contains(sender.getName()))
            {
                return SYS_ADMIN;
            }
            if (CHIEFEXECS.contains(sender.getName()))
            {
                return CHIEFEXEC;
            }
            if (SPECIAL_EXECS.contains(sender.getName()))
            {
                return SPEC_EXEC;
            }
            if (EXECS.contains(sender.getName()))
            {
                return EXEC;
            }
            if (MULTICRAFTS.contains(sender.getName()))
            {
                return MULTICRAFT;
            }
            if (BUILDERS.contains(sender.getName()))
            {
                return BUILDER;
            }
            
        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }
                        
            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
            
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
