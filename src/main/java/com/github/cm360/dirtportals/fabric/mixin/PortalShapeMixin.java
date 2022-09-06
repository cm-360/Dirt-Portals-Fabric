/*
 * This is the latest source code of Dirt Portals, based on Crying Portals 1.6.
 * Minecraft version: 1.19.2, mod version: 1.0.
 *
 * Please don't distribute without permission.
 * This mod was only made possible by the efforts of serilum, go check out their work too!
 *  CurseForge: https://curseforge.com/members/serilum/projects
 *  Modrinth: https://modrinth.com/user/serilum
 */

package com.github.cm360.dirtportals.fabric.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;

@Mixin(value = PortalShape.class, priority = 1001, remap = false)
public class PortalShapeMixin {
	@Inject(method = "method_30487", at = @At(value = "TAIL"), cancellable = true)
	private static void PortalShape_FRAME(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
		if (blockState.is(Blocks.DIRT)) {
			cir.setReturnValue(true);
		}
	}
}
