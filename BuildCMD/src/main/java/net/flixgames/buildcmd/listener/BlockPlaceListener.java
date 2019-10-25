package net.flixgames.buildcmd.listener;

import net.flixgames.buildcmd.BuildCMD;
import net.flixgames.buildcmd.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    public BlockPlaceListener(BuildCMD main) { main.getServer().getPluginManager().registerEvents(this, main); }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();

        if (Data.build.contains(player)){
            event.setCancelled(false);
        } else if (!Data.build.contains(player)){
            event.setCancelled(true);
        }


    }



}
