package cn.rtast.rauth.mixins;

import cn.rtast.rauth.listeners.OnPlayerConnect;
import cn.rtast.rauth.listeners.OnPlayerLeave;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Inject(method = "onPlayerConnect", at = @At("TAIL"))
    public void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        new OnPlayerConnect().listen(player);
    }

    @Inject(method = "remove", at = @At("TAIL"))
    public void remove(ServerPlayerEntity player, CallbackInfo ci) {
        new OnPlayerLeave().listen(player);
    }
}