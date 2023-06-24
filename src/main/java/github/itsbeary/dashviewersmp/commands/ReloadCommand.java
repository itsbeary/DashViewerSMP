package github.itsbeary.dashviewersmp.commands;

import github.itsbeary.dashviewersmp.DashViewerSMP;
import github.itsbeary.dashviewersmp.listeners.PlayerListener;
import github.itsbeary.dashviewersmp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!commandSender.hasPermission("dash.reload")) {
            commandSender.sendMessage(ChatUtils.format("&cSorry! You do not have permission to run this command."));
            return false;
        }
        DashViewerSMP.getInstance().reloadConfig();
        PlayerListener.motd = ChatUtils.format(DashViewerSMP.getInstance().getConfig().getString("motd"));
        commandSender.sendMessage(ChatUtils.format("&8| &7Reloaded the configuration!"));
        return false;
    }
}
