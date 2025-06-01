package chipsonsky.tLib.util;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.time.Duration;

public class ChatUtil {

    public static void sendColorMessage (Player player, String text) {
        player.sendMessage(
                ChatColor.translateAlternateColorCodes(
                        '&', text)
        );
    }

    public static void sendColorActionBar(Player player, String text) {
        player.sendActionBar(
                Component.text(ChatColor.translateAlternateColorCodes(
                        '&', text))
        );
    }

    public static void sendColorTitle(Player player, String main, String sub, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(
                ChatColor.translateAlternateColorCodes('&', main),
                ChatColor.translateAlternateColorCodes('&', sub),
                fadeIn,
                stay,
                fadeOut);
    }



}
