package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTElement;
import com.github.codenoms.nbt.NBTType;
import com.github.codenoms.nbt.NamedNBTElement;

import java.io.DataInputStream;
import java.io.IOException;

public final class GenericNBTReader implements NBTElementReader<NBTElement>
{
    public static final GenericNBTReader INSTANCE = new GenericNBTReader();

    private GenericNBTReader() {}

    @Override
    @SuppressWarnings("unchecked")
    public NBTElement readElement(DataInputStream stream) throws IOException
    {
        NBTType type = NBTType.getByOrdinal(stream.readByte());
        NBTElementReader<?> reader = type.getReader();
        if(type.isNamed())
            reader = new NamePrefixReader<>((NBTElementReader<? extends NamedNBTElement>) reader);

        return reader.readElement(stream);
    }
}
