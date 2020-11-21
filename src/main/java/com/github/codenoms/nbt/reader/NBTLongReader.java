package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTLong;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTLongReader implements NBTElementReader<NBTLong>
{
    @Override
    public NBTLong readElement(DataInputStream stream) throws IOException
    {
        return new NBTLong(stream.readLong());
    }
}
