package net.flixgames.buildcmd;

import net.flixgames.buildcmd.commands.Build_CMD;
import net.flixgames.buildcmd.listener.BlockBreakListener;
import net.flixgames.buildcmd.listener.BlockPlaceListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BuildCMD extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        sendMessage(true);
        registerCommands();
        registerListener();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        sendMessage(false);
    }

    private void sendMessage(boolean enable) {
        Bukkit.getConsoleSender().sendMessage(getSpacer("§4§lFlixGames"));
        Bukkit.getConsoleSender().sendMessage("§6Plugin §7» §6" + getDescription().getName());
        Bukkit.getConsoleSender().sendMessage("§bDeveloper §7» §b" + getDescription().getAuthors().toString().replace("[", "").replace("]", ""));
        Bukkit.getConsoleSender().sendMessage("§4§lIn order of §7» §4§lFlixGames");
        Bukkit.getConsoleSender().sendMessage("§aVersion §7» §a" + getDescription().getVersion());
        if(enable) {
            Bukkit.getConsoleSender().sendMessage("§7Status » §aenabled");
        } else {
            Bukkit.getConsoleSender().sendMessage("§7Status » §cdisabled");
        }
        Bukkit.getConsoleSender().sendMessage(getSpacer("§4§lFlixGames"));
    }

    private String getSpacer(String name) {
        return "§8§m}----------[§r " + name + " §8§m]----------{";
    }


    public void registerCommands(){
        getCommand("build").setExecutor(new Build_CMD());
    }

    public void registerListener(){
        new BlockBreakListener(this);
        new BlockPlaceListener(this);
    }


}
