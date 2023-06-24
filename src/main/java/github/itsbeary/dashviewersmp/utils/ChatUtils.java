package github.itsbeary.dashviewersmp.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;

public class ChatUtils {

    public static Component format(String message) {
        return Component.text(ChatColor.translateAlternateColorCodes('&', message));
    }
}
