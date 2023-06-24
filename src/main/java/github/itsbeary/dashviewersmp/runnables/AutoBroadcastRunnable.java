package github.itsbeary.dashviewersmp.runnables;

import github.itsbeary.dashviewersmp.DashViewerSMP;
import github.itsbeary.dashviewersmp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class AutoBroadcastRunnable extends BukkitRunnable {

    @Override
    public void run() {
        String message = DashViewerSMP.getInstance().getConfig().getStringList("announcements").get(new Random().nextInt(DashViewerSMP.getInstance().getConfig().getStringList("announcements").size()));
        Bukkit.broadcast(ChatUtils.format(message));
    }
}
