package net.flixgames.buildcmd.listener;

import net.flixgames.buildcmd.BuildCMD;
import net.flixgames.buildcmd.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    public BlockBreakListener(BuildCMD main) { main.getServer().getPluginManager().registerEvents(this, main); }


    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();

        if (Data.build.contains(player)){
            event.setCancelled(false);
        } else if (!Data.build.contains(player)){
            event.setCancelled(true);
        }


    }


}
