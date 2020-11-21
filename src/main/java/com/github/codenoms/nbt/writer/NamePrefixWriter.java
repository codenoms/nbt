package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NamedNBTElement;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class NamePrefixWriter<T extends NamedNBTElement> extends ElementWriterDecorator<T>
{
    public NamePrefixWriter(NBTElementWriter<T> parent)
    {
        super(parent);
    }

    @Override
    public void writeElement(T element, DataOutputStream stream) throws IOException
    {
        stream.writeShort(element.getName().length());
        stream.write(element.getName().getBytes(StandardCharsets.UTF_8));
        super.writeElement(element, stream);
    }
}
