package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTByteArray;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTByteArrayReader implements NBTElementReader<NBTByteArray>
{
    @Override
    public NBTByteArray readElement(DataInputStream stream) throws IOException
    {
        byte[] value = new byte[stream.readInt()];
        stream.readFully(value);
        return new NBTByteArray(value);
    }
}
