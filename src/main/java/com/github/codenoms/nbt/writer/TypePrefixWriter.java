package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTElement;

import java.io.DataOutputStream;
import java.io.IOException;

public final class TypePrefixWriter<T extends NBTElement> extends ElementWriterDecorator<T>
{
    public TypePrefixWriter(NBTElementWriter<T> parent)
    {
        super(parent);
    }

    @Override
    public void writeElement(T element, DataOutputStream stream) throws IOException
    {
        stream.writeByte(element.getType().ordinal());
        super.writeElement(element, stream);
    }
}
