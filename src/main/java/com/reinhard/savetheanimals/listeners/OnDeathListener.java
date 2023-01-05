package com.reinhard.savetheanimals.listeners;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerDeathEvent;


public class OnDeathListener implements Listener {

    @EventHandler
    public void onMiningEvent(PlayerDeathEvent e) {


//        e.getDrops()
        e.setDeathMessage("Oh no!");
        e.setKeepInventory(true);
        e.setKeepExperience(true);
    }
}
