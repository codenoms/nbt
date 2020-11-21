package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTInt;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTIntWriter implements NBTElementWriter<NBTInt>
{
    @Override
    public void writeElement(NBTInt element, DataOutputStream stream) throws IOException
    {
        stream.writeInt(element.getValue());
    }
}
