package net.ludocrypt.speconnectures.ctm;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.ludocrypt.speconnectures.access.CtmMetadataAccess;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.chunk.ChunkRenderRegion;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;

public class CtmTileRenderer extends CtmRenderer {

	public CtmTileRenderer() {
		super();
	}

	@Override
	public Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, ChunkRenderRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {

		int x = 0;
		int y = 0;

		int atlasX = ((CtmMetadataAccess) quadIn.getSprite().getContents()).getSpecialTileX();
		int atlasY = ((CtmMetadataAccess) quadIn.getSprite().getContents()).getSpecialTileY();

		if (quadIn.getFace() == Direction.UP) {
			x = MathHelper.floorMod(pos.getX(), atlasX);
			y = MathHelper.floorMod(pos.getZ(), atlasY);
		} else if (quadIn.getFace() == Direction.DOWN) {
			x = MathHelper.floorMod(pos.getX(), atlasX);
			y = atlasY - MathHelper.floorMod(pos.getZ(), atlasY) - 1;
		} else if (quadIn.getFace() == Direction.NORTH) {
			x = atlasX - MathHelper.floorMod(pos.getX(), atlasX) - 1;
			y = atlasY - MathHelper.floorMod(pos.getY(), atlasY) - 1;
		} else if (quadIn.getFace() == Direction.EAST) {
			x = atlasX - MathHelper.floorMod(pos.getZ(), atlasX) - 1;
			y = atlasY - MathHelper.floorMod(pos.getY(), atlasY) - 1;
		} else if (quadIn.getFace() == Direction.SOUTH) {
			x = MathHelper.floorMod(pos.getX(), atlasX);
			y = atlasY - MathHelper.floorMod(pos.getY(), atlasY) - 1;
		} else if (quadIn.getFace() == Direction.WEST) {
			x = MathHelper.floorMod(pos.getZ(), atlasX);
			y = atlasY - MathHelper.floorMod(pos.getY(), atlasY) - 1;
		}

		return Pair.of(x, y);
	}

	@Override
	public Pair<Integer, Integer> getAtlasSize(ChunkRenderRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		return Pair
			.of(((CtmMetadataAccess) quadIn.getSprite().getContents()).getSpecialTileX(),
				((CtmMetadataAccess) quadIn.getSprite().getContents()).getSpecialTileY());
	}

}
