package net.ludocrypt.speconnectures.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.ludocrypt.speconnectures.access.CtmMetadataAccess;
import net.minecraft.client.renderer.texture.SpriteContents;

@Mixin(SpriteContents.class)
public class SpriteContentsMixin implements CtmMetadataAccess {

	int tileX = 1;
	int tileY = 1;

	@Override
	public int getSpecialTileX() {
		return tileX;
	}

	@Override
	public int getSpecialTileY() {
		return tileY;
	}

	@Override
	public void setSpecialTileX(int tileX) {
		this.tileX = tileX;
	}

	@Override
	public void setSpecialTileY(int tileY) {
		this.tileY = tileY;
	}

}
