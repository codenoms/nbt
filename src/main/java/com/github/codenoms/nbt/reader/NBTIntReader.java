package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTInt;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTIntReader implements NBTElementReader<NBTInt>
{
    @Override
    public NBTInt readElement(DataInputStream stream) throws IOException
    {
        return new NBTInt(stream.readInt());
    }
}
