package net.luke.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.firstmod.FirstMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BOOF = registerItem("boof",
            new Item(new Item.Settings()));
    public static final Item RAW_BOOF = registerItem("raw_boof",
            new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(BOOF);
        entries.add(RAW_BOOF);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items for "+ FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::itemGroupIngredients);
    }
}