package net.ludocrypt.speconnectures.ctm;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.ludocrypt.speconnectures.access.CtmMetadataAccess;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.chunk.RenderChunkRegion;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;

public class CtmTileRenderer extends CtmRenderer {

	public CtmTileRenderer() {
		super();
	}

	@Override
	public Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, RenderChunkRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {

		int x = 0;
		int y = 0;

		int atlasX = ((CtmMetadataAccess) quadIn.getSprite().contents()).getSpecialTileX();
		int atlasY = ((CtmMetadataAccess) quadIn.getSprite().contents()).getSpecialTileY();

		if (quadIn.getDirection() == Direction.UP) {
			x = Mth.positiveModulo(pos.getX(), atlasX);
			y = Mth.positiveModulo(pos.getZ(), atlasY);
		} else if (quadIn.getDirection() == Direction.DOWN) {
			x = Mth.positiveModulo(pos.getX(), atlasX);
			y = atlasY - Mth.positiveModulo(pos.getZ(), atlasY) - 1;
		} else if (quadIn.getDirection() == Direction.NORTH) {
			x = atlasX - Mth.positiveModulo(pos.getX(), atlasX) - 1;
			y = atlasY - Mth.positiveModulo(pos.getY(), atlasY) - 1;
		} else if (quadIn.getDirection() == Direction.EAST) {
			x = atlasX - Mth.positiveModulo(pos.getZ(), atlasX) - 1;
			y = atlasY - Mth.positiveModulo(pos.getY(), atlasY) - 1;
		} else if (quadIn.getDirection() == Direction.SOUTH) {
			x = Mth.positiveModulo(pos.getX(), atlasX);
			y = atlasY - Mth.positiveModulo(pos.getY(), atlasY) - 1;
		} else if (quadIn.getDirection() == Direction.WEST) {
			x = Mth.positiveModulo(pos.getZ(), atlasX);
			y = atlasY - Mth.positiveModulo(pos.getY(), atlasY) - 1;
		}

		return Pair.of(x, y);
	}

	@Override
	public Pair<Integer, Integer> getAtlasSize(RenderChunkRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		return Pair
			.of(((CtmMetadataAccess) quadIn.getSprite().contents()).getSpecialTileX(),
				((CtmMetadataAccess) quadIn.getSprite().contents()).getSpecialTileY());
	}

}
