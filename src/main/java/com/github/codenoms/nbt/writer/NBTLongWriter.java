package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTLong;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTLongWriter implements NBTElementWriter<NBTLong>
{
    @Override
    public void writeElement(NBTLong element, DataOutputStream stream) throws IOException
    {
        stream.writeLong(element.getValue());
    }
}
