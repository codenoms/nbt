package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTByteArray;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTByteArrayWriter implements NBTElementWriter<NBTByteArray>
{
    @Override
    public void writeElement(NBTByteArray element, DataOutputStream stream) throws IOException
    {
        stream.writeInt(element.getValue().length);
        stream.write(element.getValue());
    }
}
