package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTElement;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ElementWriterDecorator<T extends NBTElement> implements NBTElementWriter<T>
{
    private final NBTElementWriter<T> parent;

    public ElementWriterDecorator(NBTElementWriter<T> parent)
    {
        this.parent = parent;
    }

    @Override
    public void writeElement(T element, DataOutputStream stream) throws IOException
    {
        if(parent != null)
            parent.writeElement(element, stream);
    }
}
