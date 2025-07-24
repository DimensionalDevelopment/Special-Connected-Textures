package net.ludocrypt.speconnectures.ctm;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.chunk.RenderChunkRegion;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class CtmRowRenderer extends CtmRenderer {

	@Override
	public Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, RenderChunkRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		int x = 0;
		int y = 0;

		if (quadIn.getDirection().getAxis() != Direction.Axis.Y) {

			if (!left && right) {
				x = 1;
				y = 0;
			} else if (left && !right) {
				x = 1;
				y = 1;
			} else if (left && right) {
				x = 0;
				y = 1;
			}

		}

		return Pair.of(x, y);
	}

	@Override
	public Pair<Integer, Integer> getAtlasSize(RenderChunkRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		return Pair.of(2, 2);
	}

}
