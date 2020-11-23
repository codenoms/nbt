package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTCompound;
import com.github.codenoms.nbt.NBTAdapter;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class NBTCompoundReader implements NBTReader<NBTCompound>
{
    private final NBTReadingContext context;

    public NBTCompoundReader()
    {
        this(NBTReadingContext.getDefaultContext());
    }

    public NBTCompoundReader(NBTReadingContext context)
    {
        this.context = context;
    }

    @Override
    public NBTCompound readFromNBTData(DataInputStream stream) throws IOException
    {
        NBTCompound compound = new NBTCompound(new HashMap<>(context.getDefaultAdapters()));
        byte index;
        while((index = stream.readByte()) != 0)
        {
            byte[] nameBytes = new byte[stream.readUnsignedShort()];
            stream.readFully(nameBytes);
            compound.set(new String(nameBytes, StandardCharsets.UTF_8), context.getReaderByIndex(index).readFromNBTData(stream));
        }
        return compound;
    }
}
