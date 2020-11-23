package com.github.codenoms.nbt.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class NBTStringReader implements NBTReader<String>
{
    private static final NBTStringReader INSTANCE = new NBTStringReader();

    public static NBTStringReader getInstance()
    {
        return INSTANCE;
    }

    private NBTStringReader() {}

    @Override
    public String readFromNBTData(DataInputStream stream) throws IOException
    {
        byte[] valueBytes = new byte[stream.readUnsignedShort()];
        stream.readFully(valueBytes);
        return new String(valueBytes, StandardCharsets.UTF_8);
    }
}
