package com.github.codenoms.nbt;

public final class NBTByte extends NBTWrappedElement<Byte>
{
    public NBTByte(byte value)
    {
        super(NBTType.BYTE, value);
    }

    public NBTByte(String name)
    {
        super(NBTType.BYTE, name, (byte) 0);
    }

    public NBTByte(String name, byte value)
    {
        super(NBTType.BYTE, name, value);
    }
}
