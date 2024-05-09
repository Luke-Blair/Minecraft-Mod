package net.luke.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.luke.firstmod.FirstMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    /**
     * Adds blocks to the game
     * Must create .json files (copy previous ones) and update them
     */
    public static final Block BLOCK_OF_BOOF = registerBlock("block_of_boof",
            new Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)));
    public static final Block RAW_BLOCK_OF_BOOF = registerBlock("raw_block_of_boof",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK)));


    /**
     * Helper method for creating blocks
     * @param name unique identifier for the block
     * @param block the block type being added (usually copies from an existing block)
     * @return a block
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    /**
     * Helper method for creating blocks
     * @param name unique identifier for the block
     * @param block the block being added
     * @return an item version of the block
     */
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    /**
     * Helper method for creating blocks
     */
    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering ModBlocks for " + FirstMod.MOD_ID);
    }
}
