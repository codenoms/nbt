package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTShort;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTShortReader implements NBTElementReader<NBTShort>
{
    @Override
    public NBTShort readElement(DataInputStream stream) throws IOException
    {
        return new NBTShort(stream.readShort());
    }
}
