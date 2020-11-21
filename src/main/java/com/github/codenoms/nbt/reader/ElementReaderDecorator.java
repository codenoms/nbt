package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTElement;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class ElementReaderDecorator<T extends NBTElement> implements NBTElementReader<T>
{
    private final NBTElementReader<T> parent;

    public ElementReaderDecorator(NBTElementReader<T> parent)
    {
        this.parent = parent;
    }

    @Override
    public T readElement(DataInputStream stream) throws IOException
    {
        return parent.readElement(stream);
    }
}
