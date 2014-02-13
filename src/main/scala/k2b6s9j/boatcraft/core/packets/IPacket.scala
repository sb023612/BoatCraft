package k2b6s9j.boatcraft.core.packets

import io.netty.buffer.ByteBuf;

trait IPacket
{
	def readBytes(buffer: ByteBuf)
	def writeBytes(buffer: ByteBuf)
}