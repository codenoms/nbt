package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTIntArray;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTIntArrayWriter implements NBTElementWriter<NBTIntArray>
{
    @Override
    public void writeElement(NBTIntArray element, DataOutputStream stream) throws IOException
    {
        stream.writeInt(element.getValue().length);
        for(int value : element.getValue())
            stream.writeInt(value);
    }
}
