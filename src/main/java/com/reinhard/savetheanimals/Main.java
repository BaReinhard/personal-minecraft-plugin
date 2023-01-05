package com.reinhard.savetheanimals;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import com.reinhard.savetheanimals.listeners.*;

public class Main extends PluginBase {
    @Override
    public void onEnable() {
        getLogger().info("Loading our new animal thorns plugin");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new AnimalHitDetectionListener(), this);
        pm.registerEvents(new MiningListener(), this);
        pm.registerEvents(new OnDeathListener(), this);
        pm.registerEvents(new OnSneakListener(), this);
        pm.registerEvents(new OnRunListener(), this);
        pm.registerEvents(new OnChatListener(), this);
        pm.registerEvents(new OnMoveListener(), this);


        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        return super.onCommand(sender, command, label, args);
//    }
}
