package net.ludocrypt.speconnectures.ctm;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.chunk.ChunkRenderRegion;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class CtmFullRowRenderer extends CtmFullRenderer {

	@Override
	public Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, ChunkRenderRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {

		Pair<Integer, Integer> tile = super.getTile(up, down, left, right, upleft, upright, downleft, downright,
			chunkRenderRegion, pos, state, model, quadIn, modelSeed, quad);

		int x = 0;
		int y = 0;

		if (quadIn.getFace().getAxis() != Direction.Axis.Y) {

			if (!left && right) {
				x = 1;
				y = 0;
			} else if (left && !right) {
				x = 3;
				y = 0;
			} else if (left && right) {
				x = 2;
				y = 0;
			}

		} else {
			x = tile.getFirst();
			y = tile.getSecond();
		}

		return Pair.of(x, y);
	}

}
