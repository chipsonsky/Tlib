package chipsonsky.tLib.builder;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.UUID;

public class HeadBuilder {

    private final ItemStack head;
    private final SkullMeta meta;

    public HeadBuilder() {
        head = new ItemStack(Material.PLAYER_HEAD);
        meta = (SkullMeta) head.getItemMeta();
    }

    public HeadBuilder setName(String value) {
        meta.setDisplayName(
                ChatColor.translateAlternateColorCodes(
                        '&', value));

        return this;
    }
    public HeadBuilder setLore(List<String> value) {
        meta.setLore(value);

        return this;
    }

    public HeadBuilder setBase64Texture(String uuid, String value) {
        final PlayerProfile profile = Bukkit.createProfile(UUID.fromString(uuid), uuid.toString().substring(0, 16));

        profile.setProperty(new ProfileProperty("textures", value));

        return this;
    }

    public HeadBuilder setBase64Texture(UUID uuid, String value) {
        final PlayerProfile profile = Bukkit.createProfile(uuid, uuid.toString().substring(0, 16));

        profile.setProperty(new ProfileProperty("textures", value));

        return this;
    }

    public HeadBuilder setBase64Texture(String value) {
        final PlayerProfile profile = Bukkit.createProfile(UUID.randomUUID());

        profile.setProperty(new ProfileProperty("textures", value));

        return this;
    }

    public HeadBuilder setPersistentValue(String key, PersistentDataType type, Object value) {

        meta.getPersistentDataContainer().set(NamespacedKey.fromString(key), type, value);

        return this;
    }

    public HeadBuilder removePersistentValue(String key) {
        meta.getPersistentDataContainer().remove(NamespacedKey.fromString(key));

        return this;
    }

    public HeadBuilder addEnchant(Enchantment e, int lvl, boolean b) {
        meta.addEnchant(e, lvl, b);

        return this;
    }

    public HeadBuilder addFlag(ItemFlag flag) {
        meta.addItemFlags(flag);

        return this;
    }

    public HeadBuilder setOwner(OfflinePlayer player) {
        meta.setOwningPlayer(player);

        return this;
    }

    public HeadBuilder setOwner(String name) {
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));

        return this;
    }

    public HeadBuilder addAttribute(Attribute attribute, UUID uuid, String name, Double value, AttributeModifier.Operation operation, EquipmentSlot slot) {
        meta.addAttributeModifier(attribute, new AttributeModifier(
                uuid,
                name,
                value,
                operation,
                slot
        ));

        return this;
    }

    public HeadBuilder removeAttribute(Attribute attribute) {
        meta.removeAttributeModifier(attribute);

        return this;
    }

    public HeadBuilder setCustomModelData(int value) {
        meta.setCustomModelData(value);

        return this;
    }

    public ItemStack build() {
        head.setItemMeta(meta);

        return head;
    }
}
