package chipsonsky.tLib.builder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.UUID;

/**
 * Удобный билдeр для создания и настройки {@link ItemStack} с помощью цепочек вызовов.
 * <p>
 * Позволяет задавать имя, лор, энчанты, флаги, кастомные данные и атрибуты.
 * Используется для упрощения генерации предметов в Spigot и Paper плагинах.
 *
 * Пример использования:
 * <pre>{@code
 * ItemStack sword = new ItemBuilder(Material.DIAMOND_SWORD)
 *     .setName("&bМеч Бога")
 *     .addEnchant(Enchantment.SHARPNESS, 5)
 *     .setUnbreakable(true)
 *     .setGlint(true)
 *     .build();
 * }</pre>
 */

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemBuilder(Material material) {
        itemStack = new ItemStack(material);
        meta = itemStack.getItemMeta();
    }

    public ItemBuilder setAmount(int value) {
        itemStack.setAmount(value);
        return this;
    }

    public ItemBuilder setName(String value) {
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', value));

        return this;
    }

    public ItemBuilder setLore(List<String> value) {

        for (int i = 0; i < value.size(); i++) {
            value.set(i, ChatColor.translateAlternateColorCodes('&', value.get(i)));
        }
        meta.setLore(value);

        return this;
    }

    public ItemBuilder setPersistentValue(String key, PersistentDataType persistentDataType, Object value) {

        meta.getPersistentDataContainer().set(NamespacedKey.fromString(key), persistentDataType, value);

        return this;
    }

    public ItemBuilder removePersistentValue(String key) {

        meta.getPersistentDataContainer().remove(NamespacedKey.fromString(key));

        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {

        meta.addEnchant(enchantment, level, true);

        return this;
    }

    public ItemBuilder removeEnchant(Enchantment enchantment) {

        meta.removeEnchant(enchantment);

        return this;
    }

    public ItemBuilder setCustomModelData(int value) {

        meta.setCustomModelData(value);

        return this;
    }

    public ItemBuilder setGlint(Boolean value) {
        setGlint(meta, value);

        return this;
    }

    public ItemBuilder setUnbreakable(Boolean value) {
        meta.setUnbreakable(value);

        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment value) {
        meta.removeEnchant(value);

        return this;
    }

    public ItemBuilder addFlag(ItemFlag flag) {
        meta.addItemFlags(flag);

        return this;
    }

    public ItemBuilder addAttribute(Attribute attribute, UUID uuid, String name, Double value, AttributeModifier.Operation operation, EquipmentSlot slot) {
        meta.addAttributeModifier(attribute, new AttributeModifier(
                uuid,
                name,
                value,
                operation,
                slot
        ));

        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(meta);

        return itemStack;
    }



    public ItemMeta setGlint(ItemMeta meta, Boolean value)
    {
        meta.addEnchant(Enchantment.LUCK, 1, value);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        return meta;
    }
}