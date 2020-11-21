package com.github.codenoms.nbt;

public final class NBTInt extends NBTWrappedElement<Integer>
{
    public NBTInt(int value)
    {
        super(NBTType.INT, value);
    }

    public NBTInt(String name)
    {
        super(NBTType.INT, name, 0);
    }

    public NBTInt(String name, int value)
    {
        super(NBTType.INT, name, value);
    }
}
