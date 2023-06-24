package github.itsbeary.dashviewersmp.commands;

import github.itsbeary.dashviewersmp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MuteChatCommand implements CommandExecutor {

    public static boolean chatEnabled = true;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!commandSender.hasPermission("chat.mute")) {
            commandSender.sendMessage(ChatUtils.format("&cSorry! You do not have permission to run this command."));
            return false;
        }
        chatEnabled = !chatEnabled;
        Bukkit.broadcast(ChatUtils.format("&8| &7Chat is now " + ((chatEnabled) ? "&aunmuted" : "&cmuted") + "&7."));
        return false;
    }
}
