package com.github.codenoms.nbt.writer;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTArrayWriter<T> implements NBTWriter<T[]>
{
    private final NBTWriter<T> typeWriter;

    public NBTArrayWriter(NBTWriter<T> typeWriter)
    {
        this.typeWriter   = typeWriter;
    }

    @Override
    public void writeAsNBTData(T[] array, DataOutputStream stream) throws IOException
    {
        stream.writeInt(array.length);
        for(T object : array)
            typeWriter.writeAsNBTData(object, stream);
    }
}
