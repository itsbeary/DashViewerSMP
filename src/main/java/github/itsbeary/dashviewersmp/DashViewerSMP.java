package github.itsbeary.dashviewersmp;

import github.itsbeary.dashviewersmp.managers.Registerer;
import github.itsbeary.dashviewersmp.runnables.AutoBroadcastRunnable;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DashViewerSMP extends JavaPlugin {

    @Getter
    private static DashViewerSMP instance;

    @Override
    public void onEnable() {
        instance = this;
        new Registerer().register();
        new AutoBroadcastRunnable().runTaskTimer(DashViewerSMP.getInstance(), 0, (DashViewerSMP.getInstance().getConfig().getInt("autobroadcast-interval")) * 20L);
        Bukkit.getConsoleSender().sendMessage("\nDash Viewer SMP Plugin --- https://github.com/itsbeary/DashViewerSMP\n");
    }

}
