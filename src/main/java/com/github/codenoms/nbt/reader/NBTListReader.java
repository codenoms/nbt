package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTElement;
import com.github.codenoms.nbt.NBTList;
import com.github.codenoms.nbt.NBTType;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class NBTListReader implements NBTElementReader<NBTList>
{
    @Override
    public NBTList readElement(DataInputStream stream) throws IOException
    {
        NBTType listType = NBTType.getByOrdinal(stream.readByte());
        int length = stream.readInt();
        List<NBTElement> elements = new ArrayList<>(length);
        for(int i = 0; i < length; i++)
            elements.add(listType.getReader().readElement(stream));
        return new NBTList(listType, elements);
    }
}
