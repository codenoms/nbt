package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTShort;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTShortWriter implements NBTElementWriter<NBTShort>
{
    @Override
    public void writeElement(NBTShort element, DataOutputStream stream) throws IOException
    {
        stream.writeShort(element.getValue());
    }
}
