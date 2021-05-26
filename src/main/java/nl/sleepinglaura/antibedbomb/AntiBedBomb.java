package nl.sleepinglaura.antibedbomb;

import nl.sleepinglaura.antibedbomb.listeners.BedExplode;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiBedBomb extends JavaPlugin implements Listener {

    public final BedExplode  bedListener = new BedExplode();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this.bedListener, this);
    }


}
