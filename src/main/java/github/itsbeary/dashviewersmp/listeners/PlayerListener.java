package github.itsbeary.dashviewersmp.listeners;

import github.itsbeary.dashviewersmp.DashViewerSMP;
import github.itsbeary.dashviewersmp.commands.MuteChatCommand;
import github.itsbeary.dashviewersmp.utils.ChatUtils;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerListener implements Listener {

    // Better to load motd to memory.
    public static Component motd = ChatUtils.format(DashViewerSMP.getInstance().getConfig().getString("motd"));

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.motd(motd);
    }

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        if(MuteChatCommand.chatEnabled)
            return;
        if(event.getPlayer().hasPermission("chat.mute.bypass"))
            return;
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatUtils.format("&8| &cChat is currently muted."));
    }

}
