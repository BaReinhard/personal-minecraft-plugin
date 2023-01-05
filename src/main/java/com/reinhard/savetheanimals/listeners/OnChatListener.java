package com.reinhard.savetheanimals.listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.inventory.CraftingGrid;
import cn.nukkit.item.Item;

import java.util.ArrayList;
import java.util.Collection;

public class OnChatListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();
        if(message.startsWith("item")) {
            String[] msgParts = message.split(" ");
            String prefix = msgParts[0];
            String command = msgParts[1];
            Integer quantity = Integer.valueOf(msgParts[2]);

            if(quantity > 64) {
                player.sendMessage("Please select an integer of 64 or less");
            }
            if(command.equalsIgnoreCase(Item.get(Item.DIAMOND).getName())) {
                dropItems(player, quantity, Item.DIAMOND);
            }else if(command.equalsIgnoreCase(Item.get(Item.TORCH).getName())) {
                dropItems(player, quantity, Item.TORCH);
            }
        }

    }

    private void dropItems(Player player, Integer quantity, Integer itemID) {
        for(int i=0;i<quantity;i++){
            player.dropItem(Item.get(itemID));
        }
    }
}
