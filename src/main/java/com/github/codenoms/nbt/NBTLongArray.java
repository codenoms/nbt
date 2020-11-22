package com.github.codenoms.nbt;

import java.util.Arrays;

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

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + (name == null ? ": " : "('" + name + "'): ") + Arrays.toString(value);
    }
}
