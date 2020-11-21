package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTDouble;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTDoubleReader implements NBTElementReader<NBTDouble>
{
    @Override
    public NBTDouble readElement(DataInputStream stream) throws IOException
    {
        return new NBTDouble(stream.readDouble());
    }
}
