package cn.rtast.multiauth

import cn.rtast.multiauth.commands.LoginCommand
import cn.rtast.multiauth.commands.RegisterCommand
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import java.io.File

class MultiAuth : ModInitializer {
    override fun onInitialize() {
        CommandRegistrationCallback.EVENT.register { dispatcher, _, _ ->
            LoginCommand().register(dispatcher)
            RegisterCommand().register(dispatcher)
        }
        val file = File("./registered.json")
        if (!file.exists()) {
            file.createNewFile()
            file.writeText("[]")
        }
    }
}