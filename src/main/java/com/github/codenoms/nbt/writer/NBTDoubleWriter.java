package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTDouble;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTDoubleWriter implements NBTElementWriter<NBTDouble>
{
    @Override
    public void writeElement(NBTDouble element, DataOutputStream stream) throws IOException
    {
        stream.writeDouble(element.getValue());
    }
}
