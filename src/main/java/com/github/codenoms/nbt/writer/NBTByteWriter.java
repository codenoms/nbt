package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTByte;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTByteWriter implements NBTElementWriter<NBTByte>
{
    @Override
    public void writeElement(NBTByte element, DataOutputStream stream) throws IOException
    {
        stream.writeByte(element.getValue());
    }
}
