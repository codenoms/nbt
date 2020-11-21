package com.github.codenoms.nbt;

public final class NBTFloat extends NBTWrappedElement<Float>
{
    public NBTFloat(float value)
    {
        super(NBTType.FLOAT, value);
    }

    public NBTFloat(String name)
    {
        super(NBTType.FLOAT, name, 0F);
    }

    public NBTFloat(String name, float value)
    {
        super(NBTType.FLOAT, name, value);
    }
}
