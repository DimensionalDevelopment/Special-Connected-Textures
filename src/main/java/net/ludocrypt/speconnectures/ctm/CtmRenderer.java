package net.ludocrypt.speconnectures.ctm;

import org.joml.Matrix4f;
import org.quiltmc.loader.api.minecraft.ClientOnly;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.specialmodels.api.TexturedSpecialModelRenderer;
import net.ludocrypt.specialmodels.impl.render.MutableQuad;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.ShaderProgram;
import net.minecraft.client.render.chunk.ChunkRenderRegion;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;

public abstract class CtmRenderer extends TexturedSpecialModelRenderer {

	public CtmRenderer() {
		super(false);
	}

	@Override
	@ClientOnly
	public void setup(MatrixStack matrices, Matrix4f viewMatrix, Matrix4f positionMatrix, float tickDelta,
			ShaderProgram shader, BlockPos origin) {
		super.setup(matrices, viewMatrix, positionMatrix, tickDelta, shader, origin);

		MinecraftClient
			.getInstance()
			.getTextureManager()
			.getTexture(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE)
			.setFilter(false, true);
	}

	@Override
	@ClientOnly
	public MutableQuad modifyQuad(ChunkRenderRegion chunkRenderRegion, BlockPos pos, BlockState state, BakedModel model,
			BakedQuad quadIn, long modelSeed, MutableQuad quad) {

		double texWidth = quadIn.getSprite().getMaxU() - quadIn.getSprite().getMinU();
		double texHeight = quadIn.getSprite().getMaxV() - quadIn.getSprite().getMinV();

		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		boolean upleft = false;
		boolean upright = false;
		boolean downleft = false;
		boolean downright = false;

		if (quadIn.getFace() == Direction.NORTH) {

			up = chunkRenderRegion.getBlockState(pos.up()).isOf(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.down()).isOf(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.east()).isOf(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.west()).isOf(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.up().east()).isOf(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.up().west()).isOf(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.down().east()).isOf(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.down().west()).isOf(state.getBlock());

		} else if (quadIn.getFace() == Direction.EAST) {

			up = chunkRenderRegion.getBlockState(pos.up()).isOf(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.down()).isOf(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.south()).isOf(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.north()).isOf(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.up().south()).isOf(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.up().north()).isOf(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.down().south()).isOf(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.down().north()).isOf(state.getBlock());

		} else if (quadIn.getFace() == Direction.SOUTH) {

			up = chunkRenderRegion.getBlockState(pos.up()).isOf(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.down()).isOf(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.west()).isOf(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.east()).isOf(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.up().west()).isOf(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.up().east()).isOf(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.down().west()).isOf(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.down().east()).isOf(state.getBlock());

		} else if (quadIn.getFace() == Direction.WEST) {

			up = chunkRenderRegion.getBlockState(pos.up()).isOf(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.down()).isOf(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.north()).isOf(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.south()).isOf(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.up().north()).isOf(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.up().south()).isOf(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.down().north()).isOf(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.down().south()).isOf(state.getBlock());

		} else if (quadIn.getFace() == Direction.UP) {

			up = chunkRenderRegion.getBlockState(pos.north()).isOf(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.south()).isOf(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.west()).isOf(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.east()).isOf(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.north().west()).isOf(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.north().east()).isOf(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.south().west()).isOf(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.south().east()).isOf(state.getBlock());

		} else if (quadIn.getFace() == Direction.DOWN) {

			up = chunkRenderRegion.getBlockState(pos.south()).isOf(state.getBlock());
			down = chunkRenderRegion.getBlockState(pos.north()).isOf(state.getBlock());
			left = chunkRenderRegion.getBlockState(pos.west()).isOf(state.getBlock());
			right = chunkRenderRegion.getBlockState(pos.east()).isOf(state.getBlock());
			upleft = chunkRenderRegion.getBlockState(pos.south().west()).isOf(state.getBlock());
			upright = chunkRenderRegion.getBlockState(pos.south().east()).isOf(state.getBlock());
			downleft = chunkRenderRegion.getBlockState(pos.north().west()).isOf(state.getBlock());
			downright = chunkRenderRegion.getBlockState(pos.north().east()).isOf(state.getBlock());

		}

		Pair<Integer, Integer> tile = getTile(up, down, left, right, upleft, upright, downleft, downright, chunkRenderRegion,
			pos, state, model, quadIn, modelSeed, quad);
		int x = tile.getFirst();
		int y = tile.getSecond();

		double spriteWidth = quadIn.getSprite().getContents().getWidth();
		double spriteHeight = quadIn.getSprite().getContents().getHeight();

		quad
			.getV1()
			.setUv(new Vec2f((float) (Math.round(quad.getV1().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV1().getUv().y * spriteHeight) / spriteHeight)));

		quad
			.getV2()
			.setUv(new Vec2f((float) (Math.round(quad.getV2().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV2().getUv().y * spriteHeight) / spriteHeight)));

		quad
			.getV3()
			.setUv(new Vec2f((float) (Math.round(quad.getV3().getUv().x * spriteWidth) / spriteWidth),
				(float) (Math.round(quad.getV3().getUv().y * spriteHeight) / spriteHeight)));

		quad
			.getV4()
			.setUv(new Vec2f((float) (Math.round(quad.getV4().getUv().x * spriteWidth) / spriteWidth),
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
	public ShaderProgram getShaderProgram(MatrixStack matrices, float tickDelta) {
		return GameRenderer.getRenderTypeSolidShader();
	}

	public abstract Pair<Integer, Integer> getTile(boolean up, boolean down, boolean left, boolean right, boolean upleft,
			boolean upright, boolean downleft, boolean downright, ChunkRenderRegion chunkRenderRegion, BlockPos pos,
			BlockState state, BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad);

	public abstract Pair<Integer, Integer> getAtlasSize(ChunkRenderRegion chunkRenderRegion, BlockPos pos, BlockState state,
			BakedModel model, BakedQuad quadIn, long modelSeed, MutableQuad quad);

}
