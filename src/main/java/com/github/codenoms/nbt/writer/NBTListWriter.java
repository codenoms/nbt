package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.TypedList;
import com.github.codenoms.nbt.reader.NBTListReader;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTListWriter implements NBTWriter<TypedList>
{
    private final NBTWritingContext context;

    public NBTListWriter()
    {
        this(NBTWritingContext.getDefaultContext());
    }

    public NBTListWriter(NBTWritingContext context)
    {
        this.context = context;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void writeAsNBTData(TypedList element, DataOutputStream stream) throws IOException
    {
        stream.writeByte(context.getIndexByType(element.getListType()));
        stream.writeInt(element.size());
        NBTWriter<Object> writer = context.getWriterByType(element.getListType());
        for(Object child : element)
            writer.writeAsNBTData(child, stream);
    }
}
