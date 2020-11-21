package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTString;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class NBTStringWriter implements NBTElementWriter<NBTString>
{
    @Override
    public void writeElement(NBTString element, DataOutputStream stream) throws IOException
    {
        stream.writeShort(element.getValue().length());
        stream.write(element.getValue().getBytes(StandardCharsets.UTF_8));
    }
}
