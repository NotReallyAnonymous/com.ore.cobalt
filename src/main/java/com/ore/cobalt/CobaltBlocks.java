package com.ore.cobalt;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class CobaltBlocks {
    public static final Block COBALT_ORE_BLOCK = registerBlock(
            "cobalt_ore_block",
            new Block(BlockBehaviour.Properties.of().strength(4.0F, 4.0F).requiresCorrectToolForDrops().sound(SoundType.STONE))
    );

    public static final Block COBALT_BLOCK = registerBlock(
            "cobalt_block",
            new Block(BlockBehaviour.Properties.of().strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL))
    );

    private CobaltBlocks() {
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Cobalt.MOD_ID, name), block);
    }

    public static void register() {
        Cobalt.LOGGER.info("Registering blocks for {}", Cobalt.MOD_ID);
    }
}
