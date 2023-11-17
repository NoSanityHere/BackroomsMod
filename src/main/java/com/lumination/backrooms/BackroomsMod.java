package com.lumination.backrooms;

import com.lumination.backrooms.blocks.BackroomsBlocks;
import com.lumination.backrooms.blocks.entity.BackroomsBlockEntities;
import com.lumination.backrooms.blocks.interactable.Radio;
import com.lumination.backrooms.entities.BackroomsEntities;
import com.lumination.backrooms.items.BackroomsItems;
import com.lumination.backrooms.sounds.BackroomsSounds;
import com.lumination.backrooms.world.biome.BackroomsBiomes;
import com.lumination.backrooms.world.dimensions.BackroomsDimensions;
import net.minecraft.text.Text;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class BackroomsMod implements ModInitializer {

	public static final String MOD_ID = "backrooms";

	public static final Logger LOGGER = LoggerFactory.getLogger(BackroomsMod.MOD_ID);

	private static final String VERSION_ID = QuiltLoader
			.getModContainer(BackroomsMod.MOD_ID)
			.orElseThrow()
			.metadata()
			.version()
			.toString();

	public static final String SETTINGS_NAME = "the_backrooms";

	private static final List<Radio.RadioRecord> records = Arrays.asList(
			new Radio.RadioRecord(Text.translatable("item.backrooms.halls_tape.desc").getString(), BackroomsSounds.HALLS),
			new Radio.RadioRecord(Text.translatable("item.backrooms.duet_tape.desc").getString(), BackroomsSounds.DUET),
			new Radio.RadioRecord(Text.translatable("item.backrooms.drifting_tape.desc").getString(), BackroomsSounds.DRIFTING),
			new Radio.RadioRecord(Text.translatable("item.backrooms.no_time_to_explain_tape.desc").getString(), BackroomsSounds.NO_TIME_TO_EXPLAIN),
			new Radio.RadioRecord(Text.translatable("item.backrooms.tell_me_you_know_tape.desc").getString(), BackroomsSounds.TELL_ME_YOU_KNOW),
			new Radio.RadioRecord(Text.translatable("item.backrooms.orbit_tape.desc").getString(), BackroomsSounds.ORBIT),
			new Radio.RadioRecord(Text.translatable("item.backrooms.slingshot_tape.desc").getString(), BackroomsSounds.SLINGSHOT),
			new Radio.RadioRecord(Text.translatable("item.backrooms.thalassophobia_tape.desc").getString(), BackroomsSounds.THALASSOPHOBIA ),
			new Radio.RadioRecord(Text.translatable("item.backrooms.no_surprises_tape.desc").getString(), BackroomsSounds.NO_SURPRISES),
			new Radio.RadioRecord(Text.translatable("item.backrooms.its_just_a_burning_memory_tape.desc").getString(), BackroomsSounds.BURNING_MEMORY),
			new Radio.RadioRecord(Text.translatable("item.backrooms.government_funding_tape.desc").getString(), BackroomsSounds.GOVERNMENT_FUNDING )
	);

	public static String NAME = "The Backrooms";

	@Override
	public void onInitialize(ModContainer mod) {
		BackroomsBlocks.registerModBlock();
		BackroomsBlockEntities.registerBlockEntities();
		BackroomsItems.registerModItems();
		BackroomsSounds.registerSoundEvents();
		BackroomsBiomes.init();
		BackroomsDimensions.registerPortals();
		BackroomsEntities.registerMobs();
		print("Initialized Main Backrooms");
	}

	public static void print(String s) {
		LOGGER.info("[" + NAME + "] " + s);
	}

	public static void changeName(String name) {
		NAME = name;
	}

	public static List<Radio.RadioRecord> getRecords() {
		return records;
	}
}
