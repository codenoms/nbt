package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTString;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class NBTStringReader implements NBTElementReader<NBTString>
{
    @Override
    public NBTString readElement(DataInputStream stream) throws IOException
    {
        byte[] valueBytes = new byte[stream.readUnsignedShort()];
        stream.readFully(valueBytes);
        return new NBTString(new String(valueBytes, StandardCharsets.UTF_8));
    }
}
