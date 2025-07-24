package net.ludocrypt.speconnectures.ctm;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.chunk.RenderChunkRegion;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CtmFullRenderer extends CtmRenderer {

	@Override
	public Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, RenderChunkRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		int x = 0;
		int y = 0;

		if (up && down && left && right && upleft && upright && downleft && downright) {
			x = 2;
			y = 2;
		} else if (up && down && left && !right && upleft && downleft) {
			x = 3;
			y = 2;
		} else if (up && down && !left && right && upright && downright) {
			x = 1;
			y = 2;
		} else if (up && !down && left && right && upleft && upright) {
			x = 2;
			y = 3;
		} else if (!up && down && left && right && downleft && downright) {
			x = 2;
			y = 1;
		} else if (!up && down && !left && right && downright) {
			x = 1;
			y = 1;
		} else if (up && !down && left && !right && upleft) {
			x = 3;
			y = 3;
		} else if (up && !down && !left && right && upright) {
			x = 1;
			y = 3;
		} else if (!up && down && left && !right && downleft) {
			x = 3;
			y = 1;
		} else if (up && down && left && right && !upleft && upright && downleft && downright) {
			x = 1;
			y = 7;
		} else if (up && down && left && right && upleft && !upright && downleft && downright) {
			x = 0;
			y = 7;
		} else if (up && down && left && right && upleft && upright && !downleft && downright) {
			x = 1;
			y = 6;
		} else if (up && down && left && right && upleft && upright && downleft && !downright) {
			x = 0;
			y = 6;
		} else if (up && down && !left && !right) {
			x = 0;
			y = 2;
		} else if (!up && !down && left && right) {
			x = 2;
			y = 0;
		} else if (up && !down && left && !right && !upleft) {
			x = 5;
			y = 1;
		} else if (up && !down && !left && right && !upright) {
			x = 4;
			y = 1;
		} else if (!up && down && !left && right && !downright) {
			x = 4;
			y = 0;
		} else if (!up && down && left && !right && !downleft) {
			x = 5;
			y = 0;
		} else if (!up && down && left && right && !downleft && !downright) {
			x = 7;
			y = 0;
		} else if (up && !down && left && right && !upleft && !upright) {
			x = 6;
			y = 1;
		} else if (up && down && left && !right && !upleft && !downleft) {
			x = 7;
			y = 1;
		} else if (up && down && !left && right && !upright && !downright) {
			x = 6;
			y = 0;
		} else if (up && down && left && right && !upleft && !upright && !downleft && !downright) {
			x = 2;
			y = 7;
		} else if (!up && !down && !left && right) {
			x = 1;
			y = 0;
		} else if (!up && !down && left && !right) {
			x = 3;
			y = 0;
		} else if (!up && down && !left && !right) {
			x = 0;
			y = 1;
		} else if (up && !down && !left && !right) {
			x = 0;
			y = 3;
		} else if (up && down && left && right && !upleft && !upright && !downleft && downright) {
			x = 1;
			y = 4;
		} else if (up && down && left && right && !upleft && !upright && downleft && !downright) {
			x = 1;
			y = 5;
		} else if (up && down && left && right && upleft && !upright && !downleft && !downright) {
			x = 0;
			y = 5;
		} else if (up && down && left && right && !upleft && upright && !downleft && !downright) {
			x = 0;
			y = 4;
		} else if (up && down && left && right && upleft && upright && !downleft && !downright) {
			x = 3;
			y = 4;
		} else if (up && down && left && right && upleft && !upright && downleft && !downright) {
			x = 2;
			y = 4;
		} else if (up && down && left && right && !upleft && !upright && downleft && downright) {
			x = 2;
			y = 5;
		} else if (up && down && left && right && !upleft && upright && !downleft && downright) {
			x = 3;
			y = 5;
		} else if (up && down && left && right && !upleft && upright && downleft && !downright) {
			x = 2;
			y = 6;
		} else if (up && down && left && right && upleft && !upright && !downleft && downright) {
			x = 3;
			y = 6;
		} else if (up && !down && left && right && upleft && !upright) {
			x = 6;
			y = 3;
		} else if (up && !down && left && right && !upleft && upright) {
			x = 4;
			y = 3;
		} else if (!up && down && left && right && downleft && !downright) {
			x = 5;
			y = 2;
		} else if (!up && down && left && right && !downleft && downright) {
			x = 7;
			y = 2;
		} else if (up && down && !left && right && !upright && downright) {
			x = 4;
			y = 2;
		} else if (up && down && !left && right && upright && !downright) {
			x = 6;
			y = 2;
		} else if (up && down && left && !right && !upleft && downleft) {
			x = 7;
			y = 3;
		} else if (up && down && left && !right && upleft && !downleft) {
			x = 5;
			y = 3;
		}

		return Pair.of(x, y);
	}

	@Override
	public Pair<Integer, Integer> getAtlasSize(RenderChunkRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad) {
		return Pair.of(8, 8);
	}

}
