package com.github.codenoms.nbt;

public final class NBTLong extends NBTWrappedElement<Long>
{
    public NBTLong(long value)
    {
        super(NBTType.LONG, value);
    }

    public NBTLong(String name)
    {
        super(NBTType.LONG, name, 0L);
    }

    public NBTLong(String name, long value)
    {
        super(NBTType.LONG, name, value);
    }
}
