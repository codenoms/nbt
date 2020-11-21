package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTLongArray;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTLongArrayReader implements NBTElementReader<NBTLongArray>
{
    @Override
    public NBTLongArray readElement(DataInputStream stream) throws IOException
    {
        long[] value = new long[stream.readInt()];
        for(int i = 0; i < value.length; i++)
            value[i] = stream.readLong();
        return new NBTLongArray(value);
    }
}
