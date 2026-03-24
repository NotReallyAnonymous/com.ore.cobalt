package com.ore.cobalt;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public final class CobaltItems {
    public static final Item RAW_COBALT = registerItem("raw_cobalt", Item::new, new Item.Properties());

    public static final Item COBALT_ORE_BLOCK = registerItem(
            "cobalt_ore_block",
            properties -> new BlockItem(CobaltBlocks.COBALT_ORE_BLOCK, properties),
            new Item.Properties()
    );

    public static final Item COBALT_BLOCK = registerItem(
            "cobalt_block",
            properties -> new BlockItem(CobaltBlocks.COBALT_BLOCK, properties),
            new Item.Properties()
    );

    private CobaltItems() {
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        Identifier id = Identifier.fromNamespaceAndPath(Cobalt.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item item = itemFactory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> entries.accept(RAW_COBALT));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> entries.accept(COBALT_ORE_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> entries.accept(COBALT_BLOCK));
        Cobalt.LOGGER.info("Registering items for {}", Cobalt.MOD_ID);
    }
}
