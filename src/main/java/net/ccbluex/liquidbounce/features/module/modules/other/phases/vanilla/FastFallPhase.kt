package net.ccbluex.liquidbounce.features.module.modules.other.phases.vanilla

import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.features.module.modules.other.phases.PhaseMode
import net.ccbluex.liquidbounce.utils.block.BlockUtils
import net.minecraft.block.Block
import net.minecraft.block.BlockAir

class FastFallPhase : PhaseMode("FastFall") {
    override fun onUpdate(event: UpdateEvent) {
        mc.thePlayer.noClip = true
        mc.thePlayer.motionY -= 10.0
        mc.thePlayer.setPositionAndUpdate(mc.thePlayer.posX, mc.thePlayer.posY - 0.5, mc.thePlayer.posZ)
        mc.thePlayer.onGround = BlockUtils.collideBlockIntersects(mc.thePlayer.entityBoundingBox) { block: Block? -> block !is BlockAir }
    }
}