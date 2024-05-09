package net.luke.firstmod;

import net.fabricmc.api.ModInitializer;

import net.luke.firstmod.block.ModBlocks;
import net.luke.firstmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	/**
	 * Used all throughout
	 */
	public static final String MOD_ID = "firstmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	/**
	 * Displays the register messages from blocks and items
	 */
	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}