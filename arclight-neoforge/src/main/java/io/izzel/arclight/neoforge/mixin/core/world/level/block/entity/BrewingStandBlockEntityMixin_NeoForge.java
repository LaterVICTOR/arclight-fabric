package io.izzel.arclight.neoforge.mixin.core.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.neoforged.neoforge.event.EventHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingStandBlockEntity.class)
public class BrewingStandBlockEntityMixin_NeoForge {

    @Inject(method = "doBrew", cancellable = true, at = @At("HEAD"))
    private static void arclight$forgeBrew(Level arg, BlockPos arg2, NonNullList<ItemStack> stacks, CallbackInfo ci) {
        if (EventHooks.onPotionAttemptBrew(stacks)) {
            ci.cancel();
        }
    }
}
