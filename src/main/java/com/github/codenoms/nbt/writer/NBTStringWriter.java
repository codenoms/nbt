package com.github.codenoms.nbt.writer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class NBTStringWriter implements NBTWriter<String>
{
    private static final NBTStringWriter INSTANCE = new NBTStringWriter();

    public static NBTStringWriter getInstance()
    {
        return INSTANCE;
    }

    private NBTStringWriter() {}

    @Override
    public void writeAsNBTData(String element, DataOutputStream stream) throws IOException
    {
        byte[] bytes = element.getBytes(StandardCharsets.UTF_8);
        stream.writeShort(bytes.length);
        stream.write(bytes);
    }
}
