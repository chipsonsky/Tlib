package chipsonsky.tLib;

import org.bukkit.plugin.java.JavaPlugin;

public final class TLib extends JavaPlugin {

    private static TLib instance;

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("TridentLibrary enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TLib getInstance() {
        return instance;
    }
}
