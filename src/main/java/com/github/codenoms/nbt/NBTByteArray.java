package com.github.codenoms.nbt;

public final class NBTByteArray extends NBTWrappedElement<byte[]>
{
    public NBTByteArray(byte[] value)
    {
        super(NBTType.BYTE_ARRAY, value);
    }

    public NBTByteArray(String name)
    {
        super(NBTType.BYTE_ARRAY, name, new byte[0]);
    }

    public NBTByteArray(String name, byte[] value)
    {
        super(NBTType.BYTE_ARRAY, name, value);
    }
}
