package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTFloat;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTFloatWriter implements NBTElementWriter<NBTFloat>
{
    @Override
    public void writeElement(NBTFloat element, DataOutputStream stream) throws IOException
    {
        stream.writeFloat(element.getValue());
    }
}
