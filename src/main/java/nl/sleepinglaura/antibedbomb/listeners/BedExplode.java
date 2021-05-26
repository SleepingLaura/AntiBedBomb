package nl.sleepinglaura.antibedbomb.listeners;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.ArrayList;
import java.util.List;

public class BedExplode implements Listener {

    private boolean playerNearby(Player plr) {
        List<Entity> entityList = plr.getNearbyEntities(16,16,16);
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
                e.getPlayer().sendMessage("§c[AntiBedBomb] You're not allowed to explode a bed near another player.");
            }
        }
    }
}
