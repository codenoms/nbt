package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.TypedList;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class NBTListReader implements NBTReader<TypedList>
{
    private final NBTReadingContext context;

    public NBTListReader()
    {
        this(NBTReadingContext.getDefaultContext());
    }

    public NBTListReader(NBTReadingContext context)
    {
        this.context = context;
    }

    @Override
    public TypedList<?> readFromNBTData(DataInputStream stream) throws IOException
    {
        Class<?>     expectedListType = context.getTypeByIndex(stream.readByte());
        NBTReader<?> reader           = context.getReaderByType(expectedListType);
        int          length           = stream.readInt();
        List<Object> elements         = new ArrayList<>(length);
        for(int i = 0; i < length; i++)
            elements.add(reader.readFromNBTData(stream));
        return new TypedList<>(expectedListType, elements);
    }
}
