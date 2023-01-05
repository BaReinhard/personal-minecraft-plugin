package com.reinhard.savetheanimals.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.TextFormat;

import java.util.ArrayList;
import java.util.Collection;

public class MiningListener implements Listener {
    @EventHandler
    public void onMiningEvent(BlockBreakEvent e) {
        // Get Player
        Player player = e.getPlayer();
        Server server = player.getServer();


        // Multiply Drop Exp * 10
        e.setDropExp(e.getDropExp() * 40);

        Item[] items = e.getDrops();
        Collection<Item> finalItems = new ArrayList<>();

        for (Item item : items) {
            finalItems.add(item);

            switch(item.getId()) {
                case Item.DIAMOND:
                    server.broadcastMessage(TextFormat.GREEN + " " + player.getName() + " just found a Diamond");
                    break;
                case Item.DIRT:
//                    server.broadcastMessage(TextFormat.GREEN + " " + player.getName() + "just found dirt");
//                    break;
                default:
                    finalItems.add(item);
                    finalItems.add(item);
                    finalItems.add(item);
//                    server.broadcastMessage(TextFormat.GREEN + " " + player.getName() + "just found " + item.getName());
            }

        }
        // Todo: add config to enable this or disable this
        if(false) {
            Item bonusDiamond = new Item(Item.DIAMOND);
            finalItems.add(bonusDiamond);
        }
        e.setDrops(finalItems.toArray(new Item[finalItems.size()]));
    }
}
