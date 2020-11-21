package com.github.codenoms.nbt;

public abstract class NBTElement
{
    private final NBTType type;

    public NBTElement(NBTType type)
    {
        this.type = type;
    }

    public final NBTType getType()
    {
        return type;
    }
}
