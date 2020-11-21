package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTByte;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTByteReader implements NBTElementReader<NBTByte>
{
    @Override
    public NBTByte readElement(DataInputStream stream) throws IOException
    {
        return new NBTByte(stream.readByte());
    }
}
