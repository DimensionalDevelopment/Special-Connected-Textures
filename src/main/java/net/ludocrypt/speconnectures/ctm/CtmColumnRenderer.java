package net.ludocrypt.speconnectures.ctm;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.chunk.ChunkRenderRegion;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class CtmColumnRenderer extends CtmRenderer {

	@Override
	public Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, ChunkRenderRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		int x = 0;
		int y = 0;

		if (quadIn.getFace().getAxis() != Direction.Axis.Y) {

			if (!up && down) {
				x = 0;
				y = 1;
			} else if (up && !down) {
				x = 1;
				y = 1;
			} else if (up && down) {
				x = 1;
				y = 0;
			}

		}

		return Pair.of(x, y);
	}

	@Override
	public Pair<Integer, Integer> getAtlasSize(ChunkRenderRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		return Pair.of(2, 2);
	}

}
