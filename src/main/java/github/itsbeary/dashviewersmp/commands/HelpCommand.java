package github.itsbeary.dashviewersmp.commands;

import github.itsbeary.dashviewersmp.DashViewerSMP;
import github.itsbeary.dashviewersmp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        for(String message : DashViewerSMP.getInstance().getConfig().getStringList("help-information"))
            commandSender.sendMessage(ChatUtils.format(message));
        return false;
    }
}
