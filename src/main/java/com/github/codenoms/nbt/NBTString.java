package com.github.codenoms.nbt;

public final class NBTString extends NBTWrappedElement<String>
{
    public NBTString(String value)
    {
        super(NBTType.STRING, value);
    }

    public NBTString(String name, String value)
    {
        super(NBTType.STRING, name, value);
    }
}
