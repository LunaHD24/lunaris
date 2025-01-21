package de.lunaa.lunaris;

import org.bukkit.plugin.java.JavaPlugin;

public final class LunarisPlugin extends JavaPlugin {

    public static LunarisPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        Lunaris.setEffectRegistry(new EffectRegistryImpl());
        Lunaris.setEffectBuilderAccess(new EffectBuilderAccessImpl());
    }

}