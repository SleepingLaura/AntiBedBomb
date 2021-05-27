package nl.sleepinglaura.antibedbomb.listeners;

import nl.sleepinglaura.antibedbomb.utils.Utils;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class BedExplode extends JavaPlugin implements Listener {

    int radius = getConfig().getInt("radius");

    private boolean playerNearby(Player plr) {
        List<Entity> entityList = plr.getNearbyEntities(radius,radius,radius);
        List<Entity> toRemove = new ArrayList<Entity>();
        for (Entity e : entityList) {
            if (!(e instanceof Player)) {
                toRemove.add(e);
            }
        }
        entityList.removeAll(toRemove);
        if (!(entityList.isEmpty())) {
            return true;
        } else return false;
    }

    @EventHandler
    public void cancelBed(PlayerBedEnterEvent e) {
        if (e.getPlayer().getLocation().getWorld().getEnvironment() == World.Environment.NETHER || e.getPlayer().getLocation().getWorld().getEnvironment() == World.Environment.THE_END) {
            if (playerNearby(e.getPlayer())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("explosionDeniedMessage")));
            }
        }
    }
}
