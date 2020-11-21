package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NamedNBTElement;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class NamePrefixReader<T extends NamedNBTElement> extends ElementReaderDecorator<T>
{
    public NamePrefixReader(NBTElementReader<T> parent)
    {
        super(parent);
    }

    @Override
    public T readElement(DataInputStream stream) throws IOException
    {
        byte[] nameBytes = new byte[stream.readUnsignedShort()];
        stream.readFully(nameBytes);
        String name = new String(nameBytes, StandardCharsets.UTF_8);

        T element = super.readElement(stream);
        element.setName(name);

        return element;
    }
}
