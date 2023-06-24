package github.itsbeary.dashviewersmp.managers;

import github.itsbeary.dashviewersmp.DashViewerSMP;
import github.itsbeary.dashviewersmp.commands.ClearChatCommand;
import github.itsbeary.dashviewersmp.commands.HelpCommand;
import github.itsbeary.dashviewersmp.commands.MuteChatCommand;
import github.itsbeary.dashviewersmp.commands.ReloadCommand;
import github.itsbeary.dashviewersmp.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Registerer {

    public void register() {
        DashViewerSMP.getInstance().saveDefaultConfig();
        registerListeners(new PlayerListener());
        DashViewerSMP.getInstance().getCommand("clearchat").setExecutor(new ClearChatCommand());
        DashViewerSMP.getInstance().getCommand("mutechat").setExecutor(new MuteChatCommand());
        DashViewerSMP.getInstance().getCommand("help").setExecutor(new HelpCommand());
        DashViewerSMP.getInstance().getCommand("dashreload").setExecutor(new ReloadCommand());
    }


    public void registerListeners(Listener... listeners) {
        for(Listener listener : listeners)
            Bukkit.getPluginManager().registerEvents(listener, DashViewerSMP.getInstance());
    }

}
