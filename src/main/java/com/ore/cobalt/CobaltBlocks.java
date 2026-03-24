package com.ore.cobalt;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public final class CobaltBlocks {
    public static final Block COBALT_ORE_BLOCK = registerBlock(
            "cobalt_ore_block",
            Block::new,
            BlockBehaviour.Properties.of().strength(4.0F, 4.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)
    );

    public static final Block COBALT_BLOCK = registerBlock(
            "cobalt_block",
            Block::new,
            BlockBehaviour.Properties.of().strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)
    );

    private CobaltBlocks() {
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Identifier id = Identifier.fromNamespaceAndPath(Cobalt.MOD_ID, name);
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        Block block = blockFactory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void register() {
        Cobalt.LOGGER.info("Registering blocks for {}", Cobalt.MOD_ID);
    }
}
