package com.skintrphoenix;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase{

    public static Main INSTANCE;
    
    public static Config config;
    
    public void onLoad() {
        this.saveResource("config.yml");
        config = new Config(this.getDataFolder() + "/config.yml", Config.YAML);
        this.getServer().getCommandMap().register("test", new PluginCommand("test", this));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName() == "test") {
            int i = 0;
            while (i < config.getSection(args[0]).size()) {
                sender.sendMessage(this.getConfig().getString(args[0] + "." + String.valueOf(i) + ".name"));
                i++;
            }
        }
        return super.onCommand(sender, command, label, args); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}