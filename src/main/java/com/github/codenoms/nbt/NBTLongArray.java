package com.github.codenoms.nbt;

public final class NBTLongArray extends NBTWrappedElement<long[]>
{
    public NBTLongArray(long[] value)
    {
        this(null, value);
    }

    public NBTLongArray(String name)
    {
        this(name, new long[0]);
    }

    public NBTLongArray(String name, long[] value)
    {
        super(NBTType.LONG_ARRAY, name, value);
    }
}
