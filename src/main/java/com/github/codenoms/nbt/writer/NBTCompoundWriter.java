package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTCompound;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class NBTCompoundWriter implements NBTWriter<NBTCompound>
{
    private final NBTWritingContext context;

    public NBTCompoundWriter()
    {
        this(NBTWritingContext.getDefaultContext());
    }

    public NBTCompoundWriter(NBTWritingContext context)
    {
        this.context = context;
    }

    @Override
    public void writeAsNBTData(NBTCompound compound, DataOutputStream stream) throws IOException
    {
        for(Map.Entry<String, Object> entry : compound.entries())
        {
            Object value = entry.getValue();
            stream.writeByte(context.getIndexByType(value.getClass()));

            byte[] nameBytes  = entry.getKey().getBytes(StandardCharsets.UTF_8);
            stream.writeShort(nameBytes.length);
            stream.write(nameBytes);

            @SuppressWarnings("unchecked")
            NBTWriter<Object> writer = (NBTWriter<Object>) context.getWriterByType(value.getClass());
            writer.writeAsNBTData(value, stream);
        }
        // end tag
        stream.writeByte(0);
    }
}
