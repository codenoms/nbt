package com.github.codenoms.nbt;

import java.util.Arrays;

public final class NBTIntArray extends NBTWrappedElement<int[]>
{
    public NBTIntArray(int[] value)
    {
        this(null, value);
    }

    public NBTIntArray(String name)
    {
        this(name, new int[0]);
    }

    public NBTIntArray(String name, int[] value)
    {
        super(NBTType.INT_ARRAY, name, value);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + (name == null ? ": " : "('" + name + "'): ") + Arrays.toString(value);
    }
}
