package nl.sleepinglaura.antibedbomb;

import nl.sleepinglaura.antibedbomb.commands.MainCommand;
import nl.sleepinglaura.antibedbomb.listeners.BedExplode;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import nl.sleepinglaura.antibedbomb.bukkit.Metrics;

public final class AntiBedBomb extends JavaPlugin implements Listener {

    public final BedExplode bedListener = new BedExplode(this);

    public void onEnable() {
        int pluginId = 11898;
        Metrics metrics = new Metrics(this, pluginId);
        saveDefaultConfig();
        this.getCommand("antibedbomb").setExecutor(new MainCommand(this));
        getServer().getPluginManager().registerEvents(this.bedListener, this);
    }

}
