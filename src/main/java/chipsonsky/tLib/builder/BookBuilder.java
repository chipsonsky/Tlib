package chipsonsky.tLib.builder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;

public class BookBuilder {

    private final ItemStack book;
    private final ItemMeta meta;

    public BookBuilder() {
        book = new ItemStack(Material.ENCHANTED_BOOK);
        meta = book.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                "&r&6Чародейская книга"));
    }

    public BookBuilder setEnchantment(String value, byte lvl) {

        String lore = ChatColor.translateAlternateColorCodes('&',
                "&r&7" + value + toRoman(lvl));

        meta.setLore(Collections.singletonList(lore));
        return this;
    }

    public BookBuilder setPersistentValue(String key, PersistentDataType type, Object value) {

        meta.getPersistentDataContainer().set(NamespacedKey.fromString(key), type, value);

        return this;
    }

    public ItemStack build() {
        book.setItemMeta(meta);

        return book;
    }


    private String toRoman(byte num) {
        switch (num) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 11: return "XI";
            case 12: return "XII";
            case 13: return "XIII";
            case 14: return "XIV";
            case 15: return "XV";
            case 16: return "XVI";
            case 17: return "XVII";
            case 18: return "XVIII";
            case 19: return "XIX";
            case 20: return "XX";
            default: return "?";
        }

    }
}
