package nl.sleepinglaura.antibedbomb.commands;

import nl.sleepinglaura.antibedbomb.AntiBedBomb;
import nl.sleepinglaura.antibedbomb.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private AntiBedBomb plugin;

    public MainCommand(AntiBedBomb pl) {
        plugin = pl;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("antibedbomb.use")) {
            if (args.length == 0) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix")) + "§cAntiBedBomb V1.1 made by SleepingLaura.");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&aConfig reloaded."));
                return true;
            } else if (args[0].equalsIgnoreCase("radius")) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&cThe current radius is &4" + plugin.getConfig().getInt("radius") + " blocks&c."));
                return true;
            } else if (args[0].equalsIgnoreCase("set")) {
                if (args.length > 1) {
                    int v = Integer.parseInt(args[1].trim());
                    if (v > 0) {
                        plugin.getConfig().set("radius", v);
                        plugin.saveConfig();
                        sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&cRadius changed to &4" + v + "&c."));
                        return true;
                    } else {
                        sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&cThe radius has to be a number bigger than 0."));
                        return true;
                    }
                } else {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&4Usage: &c/antibedbomb set <radius>"));
                    return true;
                }
            } else {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix")) + "§cAntiBedBomb V1.1 made by SleepingLaura.");
                return true;
            }
        } else {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("noPermission")));
            return true;
        }
    }
}
