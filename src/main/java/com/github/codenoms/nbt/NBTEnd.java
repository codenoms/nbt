package com.github.codenoms.nbt;

public final class NBTEnd extends NBTElement
{
    public static final NBTEnd INSTANCE = new NBTEnd();

    public NBTEnd()
    {
        super(NBTType.END);
    }
}
