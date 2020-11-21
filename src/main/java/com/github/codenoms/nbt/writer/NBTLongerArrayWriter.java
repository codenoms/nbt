package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTLongArray;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTLongerArrayWriter implements NBTElementWriter<NBTLongArray>
{
    @Override
    public void writeElement(NBTLongArray element, DataOutputStream stream) throws IOException
    {
        stream.writeInt(element.getValue().length);
        for(long value : element.getValue())
            stream.writeLong(value);
    }
}
