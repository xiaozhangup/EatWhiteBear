package me.xiaozhangup.bear;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.Buffer;

public class ILoveBear extends JavaPlugin implements Listener {

    ItemStack bear = new ItemStack(Material.PORKCHOP);

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        ItemMeta meta = bear.getItemMeta();
        meta.displayName(Component.text("白熊肉排").decoration(TextDecoration.ITALIC, false));
        bear.setItemMeta(meta);
    }

    @EventHandler
    public void on(EntityDeathEvent e) {
        if (e.getEntityType() == EntityType.POLAR_BEAR) {
            e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), bear);
        }
    }
}
