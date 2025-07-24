package net.ludocrypt.speconnectures.mixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.ludocrypt.speconnectures.access.CtmMetadataAccess;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;

@Mixin(SpriteLoader.class)
public class SpriteLoaderMixin {

	@Shadow
	@Final
	private static Logger LOGGER;

	@Inject(method = "Lnet/minecraft/client/texture/SpriteLoader;loadSprite(Lnet/minecraft/util/Identifier;Lnet/minecraft/resource/Resource;)Lnet/minecraft/client/texture/SpriteContents;", at = @At(value = "RETURN", ordinal = 2))
	private static void loadSprite(ResourceLocation id, Resource resource, CallbackInfoReturnable<SpriteContents> ci) {

		try {
			Resource metadata = Minecraft
				.getInstance()
				.getResourceManager()
				.getResource(new ResourceLocation(id.getNamespace() + ":textures/" + id.getPath() + ".png.mcmeta"))
				.get();

			if (metadata != null) {

				try {
					InputStream inputStream = metadata.open();

					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
						StringBuilder stringBuilder = new StringBuilder();
						String str;

						while ((str = reader.readLine()) != null) {
							stringBuilder.append(str);
						}

						JsonElement element = JsonParser.parseString(stringBuilder.toString());

						if (element != null) {

							if (element.getAsJsonObject().has("special_ctm")) {
								JsonObject jsonObject = element.getAsJsonObject().get("special_ctm").getAsJsonObject();
								int x = jsonObject.get("tile_x").getAsInt();
								int y = jsonObject.get("tile_y").getAsInt();

								((CtmMetadataAccess) ci.getReturnValue()).setSpecialTileX(x);
								((CtmMetadataAccess) ci.getReturnValue()).setSpecialTileY(y);
							}

						}

						reader.close();
					} catch (Throwable var9) {

						if (inputStream != null) {

							try {
								inputStream.close();
							} catch (Throwable var7) {
								var9.addSuppressed(var7);
							}

						}

						throw var9;
					}

					if (inputStream != null) {
						inputStream.close();
					}

				} catch (IOException io) {
					LOGGER.error("Unable to read, {}", id, io);
				}

			}

		} catch (Exception e) {

		}

	}

}
