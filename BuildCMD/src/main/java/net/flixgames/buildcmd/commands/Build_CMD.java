package net.flixgames.buildcmd.commands;

import net.flixgames.buildcmd.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Build_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("buildcmd.use")) {
                if (args.length == 0) {
                    if (!Data.build.contains(player)) {
                        Data.build.add(player);
                        player.sendMessage(Data.prefix + "§aDu wurdest in den Baumodus gesetzt");
                    } else if (Data.build.contains(player)) {
                        Data.build.remove(player);
                        player.sendMessage(Data.prefix + "§cDu kannst nun nicht mehr Bauen!");
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if (target.getName() == player.getName()){
                            if (!Data.build.contains(target)) {
                                Data.build.add(target);
                                target.sendMessage(Data.prefix + "§aDu wurdest in den Baumodus gesetzt");
                            } else if (Data.build.contains(target)) {
                                Data.build.remove(target);
                                target.sendMessage(Data.prefix + "§cDu kannst nun nicht mehr Bauen");
                            }
                        } else if (target.getName() != player.getName()){
                            if (!Data.build.contains(target)) {
                                Data.build.add(target);
                                target.sendMessage(Data.prefix + "§aDu wurdest in den Baumodus gesetzt");
                                player.sendMessage(Data.prefix + "§aDer Spieler " + target.getName() + " wurde in den Baumodus gesetzt");
                            } else if (Data.build.contains(target)) {
                                Data.build.remove(target);
                                target.sendMessage(Data.prefix + "§cDu kannst nun nicht mehr Bauen");
                                player.sendMessage(Data.prefix + "§cDer Spieler " + target.getName() + " kann nun nicht mehr Bauen");
                            }
                        }
                    } else {
                        player.sendMessage(Data.prefix + "§cDieser Spieler ist nicht Online");
                    }
                }
            } else {
                player.sendMessage(Data.noPerms);
            }
        } else {
            sender.sendMessage(Data.prefix + "§cDazu musst du ein Spieler sein!");
        }


        return false;
    }
}
