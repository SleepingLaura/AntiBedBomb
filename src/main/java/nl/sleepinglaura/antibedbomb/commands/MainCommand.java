package nl.sleepinglaura.antibedbomb.commands;

import nl.sleepinglaura.antibedbomb.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCommand extends JavaPlugin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("antibedbomb.use")) {
            if (args.length == 0) {
                sender.sendMessage(Utils.chat(getConfig().getString("prefix")) + "§cAntiBedBomb V1.1 made by SleepingLaura.");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                reloadConfig();
                sender.sendMessage(Utils.chat(getConfig().getString("prefix") + "&aConfig reloaded."));
                return true;
            }
            sender.sendMessage(Utils.chat(getConfig().getString("prefix")) + "§cAntiBedBomb V1.1 made by SleepingLaura.");
            return true;
        } else {
            sender.sendMessage(Utils.chat(getConfig().getString("prefix") + getConfig().getString("noPermission")));
            return true;
        }
    }
}
