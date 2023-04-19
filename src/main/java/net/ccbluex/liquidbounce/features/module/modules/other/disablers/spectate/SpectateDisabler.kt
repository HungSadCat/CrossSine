package net.ccbluex.liquidbounce.features.module.modules.other.disablers.spectate

import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.features.module.modules.other.disablers.DisablerMode
import net.minecraft.network.play.client.C03PacketPlayer
import net.minecraft.network.play.client.C18PacketSpectate

class SpectateDisabler : DisablerMode("Spectate") {
    override fun onPacket(event: PacketEvent) {
        val packet = event.packet
        if (packet is C03PacketPlayer) {
            mc.netHandler.addToSendQueue(C18PacketSpectate(mc.thePlayer.uniqueID))
            disabler.debugMessage("Packet C18")
        }
    }
}