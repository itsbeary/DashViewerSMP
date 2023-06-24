package github.itsbeary.dashviewersmp.commands;

import github.itsbeary.dashviewersmp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!commandSender.hasPermission("cc.clear")) {
            commandSender.sendMessage(ChatUtils.format("&cSorry! You do not have permission to run this command."));
            return false;
        }
        for(int i = 0; i < 300; i++) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(" "));
        }
        Bukkit.broadcast(ChatUtils.format("&8| &7Server chat was cleared by &c" + commandSender.getName() + "&f!"));
        return false;
    }
}
