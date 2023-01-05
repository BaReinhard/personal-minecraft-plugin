package com.reinhard.savetheanimals.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleSneakEvent;
import cn.nukkit.potion.Effect;

public class OnSneakListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        Server server = player.getServer();
//        player.addEffect(Effect.getEffect(Effect.SPEED));
//        server.broadcastMessage(player.getName() + " has increased their movement speed to " + player.getMovementSpeed());

        if(e.isSneaking()) {
            player.setMovementSpeed(player.getMovementSpeed() + 0.1f);



        }
//        e.setCancelled(true);
    }
}
