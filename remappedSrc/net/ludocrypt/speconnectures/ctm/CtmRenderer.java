package net.ludocrypt.speconnectures.ctm;

import org.joml.Matrix4f;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.api.TexturedSpecialModelRenderer;
import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.chunk.RenderChunkRegion;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;

public abstract class CtmRenderer extends TexturedSpecialModelRenderer {

	public CtmRenderer() {
		super(false);
	}

	@Override
	@ClientOnly
	public void setup(PoseStack matrices, Matrix4f viewMatrix, Matrix4f positionMatrix, float tickDelta,
			ShaderInstance shader, BlockPos origin) {
		super.setup(matrices, viewMatrix, positionMatrix, tickDelta, shader, origin);

		Minecraft
			.getInstance()
			.getTextureManager()
			.getTexture(InventoryMenu.BLOCK_ATLAS)
			.setFilter(false, true);
	}

	@Override
	@ClientOnly
	public MutableQuad modifyQuad(RenderChunkRegion chunkRenderRegion, BlockPos pos, BlockState state, BakedModel model,
			BakedQuad quadIn, long modelSeed, MutableQuad quad) {

		double texWidth = quadIn.getSprite().getU1() - quadIn.getSprite().getU0();
		double texHeight = quadIn.getSprite().getV1() - quadIn.getSprite().getV0();

		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		boolean upleft = false;
		boolean upright = false;
		boolean downleft = false;
		boolean downright = false;

		if (quadIn.getDirection() == Direction.NORTH) {

			up = chunkRenderRegion.getBlockState(pos.above()).is(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.below()).is(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.east()).is(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.west()).is(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.above().east()).is(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.above().west()).is(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.below().east()).is(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.below().west()).is(state.getBlock());

		} else if (quadIn.getDirection() == Direction.EAST) {

			up = chunkRenderRegion.getBlockState(pos.above()).is(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.below()).is(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.south()).is(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.north()).is(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.above().south()).is(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.above().north()).is(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.below().south()).is(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.below().north()).is(state.getBlock());

		} else if (quadIn.getDirection() == Direction.SOUTH) {

			up = chunkRenderRegion.getBlockState(pos.above()).is(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.below()).is(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.west()).is(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.east()).is(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.above().west()).is(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.above().east()).is(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.below().west()).is(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.below().east()).is(state.getBlock());

		} else if (quadIn.getDirection() == Direction.WEST) {

			up = chunkRenderRegion.getBlockState(pos.above()).is(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.below()).is(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.north()).is(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.south()).is(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.above().north()).is(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.above().south()).is(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.below().north()).is(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.below().south()).is(state.getBlock());

		} else if (quadIn.getDirection() == Direction.UP) {

			up = chunkRenderRegion.getBlockState(pos.north()).is(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.south()).is(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.west()).is(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.east()).is(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.north().west()).is(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.north().east()).is(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.south().west()).is(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.south().east()).is(state.getBlock());

		} else if (quadIn.getDirection() == Direction.DOWN) {

			up = chunkRenderRegion.getBlockState(pos.south()).is(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.north()).is(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.west()).is(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.east()).is(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.south().west()).is(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.south().east()).is(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.north().west()).is(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.north().east()).is(state.getBlock());

		}

		Pair<Integer, Integer> tile = getTile(up, down, left, right, upleft, upright, downleft, downright, chunkRenderRegion,
			pos, state, model, quadIn, modelSeed, quad);
		int x = tile.getFirst();
		int y = tile.getSecond();

		double spriteWidth = quadIn.getSprite().contents().width();
		double spriteHeight = quadIn.getSprite().contents().height();

		quad
			.getV1()
			.setUv(new Vec2((float) (Math.round(quad.getV1().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV1().getUv().y * spriteHeight) / spriteHeight)));

		quad
			.getV2()
			.setUv(new Vec2((float) (Math.round(quad.getV2().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV2().getUv().y * spriteHeight) / spriteHeight)));

		quad
			.getV3()
			.setUv(new Vec2((float) (Math.round(quad.getV3().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV3().getUv().y * spriteHeight) / spriteHeight)));

		quad
			.getV4()
			.setUv(new Vec2((float) (Math.round(quad.getV4().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV4().getUv().y * spriteHeight) / spriteHeight)));

		Pair<Integer, Integer> atlas = getAtlasSize(chunkRenderRegion, pos, state, model, quadIn, modelSeed, quad);
		int w = atlas.getFirst();
		int h = atlas.getSecond();

		quad.getV1().shift(x * (texWidth / w), y * (texHeight / h));
		quad.getV2().shift(x * (texWidth / w), -(h - y - 1) * (texHeight / h));
		quad.getV3().shift(-(w - x - 1) * (texWidth / w), -(h - y - 1) * (texHeight / h));
		quad.getV4().shift(-(w - x - 1) * (texWidth / w), y * (texHeight / h));

		return quad;
	}

	@Override
	@ClientOnly
	public ShaderInstance getShaderProgram(PoseStack matrices, float tickDelta) {
		return GameRenderer.getRendertypeSolidShader();
	}

	public abstract Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, RenderChunkRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad);

	public abstract Pair<Integer, Integer> getAtlasSize(RenderChunkRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad);

}
