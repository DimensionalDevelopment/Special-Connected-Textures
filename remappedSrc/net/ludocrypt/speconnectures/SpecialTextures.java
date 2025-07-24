package net.ludocrypt.speconnectures;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import net.ludocrypt.specialmodels.api.SpecialModelRenderer;
import net.ludocrypt.speconnectures.ctm.CtmColumnRenderer;
import net.ludocrypt.speconnectures.ctm.CtmFullColumnRenderer;
import net.ludocrypt.speconnectures.ctm.CtmFullRenderer;
import net.ludocrypt.speconnectures.ctm.CtmFullRowRenderer;
import net.ludocrypt.speconnectures.ctm.CtmRowRenderer;
import net.ludocrypt.speconnectures.ctm.CtmTileRenderer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class SpecialTextures implements ModInitializer {

	public static final SpecialModelRenderer CTM_FULL = Registry
		.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, new ResourceLocation("speconnectures", "ctm_full"),
			new CtmFullRenderer());

	public static final SpecialModelRenderer CTM_COLUMN = Registry
		.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, new ResourceLocation("speconnectures", "ctm_column"),
			new CtmColumnRenderer());

	public static final SpecialModelRenderer CTM_ROW = Registry
		.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, new ResourceLocation("speconnectures", "ctm_row"),
			new CtmRowRenderer());

	public static final SpecialModelRenderer CTM_FULL_ROW = Registry
		.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, new ResourceLocation("speconnectures", "ctm_full_row"),
			new CtmFullRowRenderer());

	public static final SpecialModelRenderer CTM_FULL_COLUMN = Registry
		.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, new ResourceLocation("speconnectures", "ctm_full_column"),
			new CtmFullColumnRenderer());

	public static final SpecialModelRenderer CTM_TILE = Registry
		.register(SpecialModelRenderer.SPECIAL_MODEL_RENDERER, new ResourceLocation("speconnectures", "ctm_tile"),
			new CtmTileRenderer());

	@Override
	public void onInitialize(ModContainer mod) {
	}

}
