package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTFloat;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTFloatReader implements NBTElementReader<NBTFloat>
{
    @Override
    public NBTFloat readElement(DataInputStream stream) throws IOException
    {
        return new NBTFloat(stream.readFloat());
    }
}
