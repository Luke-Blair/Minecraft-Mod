package net.luke.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.firstmod.FirstMod;
import net.luke.firstmod.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    /**
     * Adds items to the game
     * Must create .json files (copy previous ones) and update them
     */
    public static final Item BOOF = registerItem("boof",
            new Item(new Item.Settings()));
    public static final Item RAW_BOOF = registerItem("raw_boof",
            new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }


    /**
     * Sets up for adding items to the creative inventory
     */
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(BOOF);
        entries.add(RAW_BOOF);

        entries.add(ModBlocks.BLOCK_OF_BOOF);
        entries.add(ModBlocks.RAW_BLOCK_OF_BOOF);
    }

    /**
     * Helper method for creating items
     * Adds the items to the creative inventory
     */
    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items for "+ FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::itemGroupIngredients);
    }
}
