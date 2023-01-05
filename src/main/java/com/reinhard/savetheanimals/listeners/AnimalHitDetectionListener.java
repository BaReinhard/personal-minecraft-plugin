package com.reinhard.savetheanimals.listeners;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.permission.Permission;
import cn.nukkit.potion.Effect;
import cn.nukkit.utils.TextFormat;

public class AnimalHitDetectionListener implements Listener {

    @EventHandler
    public void onAnimalHit(EntityDamageByEntityEvent e) {

//        e.getEntity().addEffect(Effect.getEffect(Effect.LEVITATION));

        Entity attacker = e.getDamager();

        // Check if the damaged entity is a sheep, if so heal it 20 and damage the attacker
        if(e.getEntity().getName().equalsIgnoreCase("sheep")) {
            Entity sheep = e.getEntity();
            e.getEntity().heal(20);
            if (attacker instanceof Player) {
                Player player = (Player)attacker;
                player.sendMessage(TextFormat.DARK_RED + "Stop Hitting the Sheep");
                player.getServer().broadcastMessage(player.getName() + " is attacking a sheep, get them");
//                player.setExperience( player.getExperience() + 100000);
//                player.setExperience(1);
//                player.sendExperienceLevel(1);
                if(player.getExperience() < 1) {
                    player.addExperience(20);
                }
                player.addExperience(player.getExperience() * 2);
            }

            // attacker takes 2 damage
            attacker.attack(2);
            attacker.addEffect(Effect.getEffect(Effect.LEVITATION));
            attacker.setSneaking(true);

        } else if(e.getEntity().getName().equalsIgnoreCase("kamilaelsa1225")) {
            // Save Kamila
            // Reduce damage by 50%
            float finalDamage = e.getDamage() / 2;
            Entity kamila = e.getEntity();

            // Attacker takes 2 damage
            attacker.attack(2);

            // Kamila gets healed for 20
            kamila.heal(20);
            kamila.attack(finalDamage);
        } else if(e.getEntity().getName().equalsIgnoreCase("bareinhard")) {
            Entity bareinhard = e.getEntity();

            attacker.attack(1);
            // Bareinhard takes 50% damage reduction
            bareinhard.attack(e.getDamage()/2);
        }

    }
}
