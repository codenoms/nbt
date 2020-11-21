package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTIntArray;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTIntArrayReader implements NBTElementReader<NBTIntArray>
{
    @Override
    public NBTIntArray readElement(DataInputStream stream) throws IOException
    {
        int[] value = new int[stream.readInt()];
        for(int i = 0; i < value.length; i++)
            value[i] = stream.readInt();
        return new NBTIntArray(value);
    }
}
