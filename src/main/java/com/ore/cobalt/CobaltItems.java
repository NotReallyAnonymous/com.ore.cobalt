package com.ore.cobalt;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public final class CobaltItems {
    public static final Item RAW_COBALT = registerItem("raw_cobalt", new Item(new Item.Properties()));

    public static final Item COBALT_ORE_BLOCK = registerItem(
            "cobalt_ore_block",
            new BlockItem(CobaltBlocks.COBALT_ORE_BLOCK, new Item.Properties())
    );

    public static final Item COBALT_BLOCK = registerItem(
            "cobalt_block",
            new BlockItem(CobaltBlocks.COBALT_BLOCK, new Item.Properties())
    );

    private CobaltItems() {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Cobalt.MOD_ID, name), item);
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> entries.accept(RAW_COBALT));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> entries.accept(COBALT_ORE_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> entries.accept(COBALT_BLOCK));
        Cobalt.LOGGER.info("Registering items for {}", Cobalt.MOD_ID);
    }
}
