package com.reinhard.savetheanimals.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleSprintEvent;

public class OnRunListener implements Listener {

    @EventHandler
    public void onRun(PlayerToggleSprintEvent e) {
        Player player = e.getPlayer();
        Server server = player.getServer();
//        System.out.println(player.getMovementSpeed());
//        server.broadcastMessage(player.getName() + " has decreased their movement speed to " + player.getMovementSpeed());
        player.setMovementSpeed(0.1f);
        e.setCancelled(true);
    }
}
