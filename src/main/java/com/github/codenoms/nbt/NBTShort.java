package com.github.codenoms.nbt;

public final class NBTShort extends NBTWrappedElement<Short>
{
    public NBTShort(short value)
    {
        super(NBTType.SHORT, value);
    }

    public NBTShort(String name)
    {
        super(NBTType.SHORT, name, (short) 0);
    }

    public NBTShort(String name, short value)
    {
        super(NBTType.SHORT, name, value);
    }
}
