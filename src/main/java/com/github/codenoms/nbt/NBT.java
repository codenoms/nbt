package com.github.codenoms.nbt;

import com.github.codenoms.nbt.reader.NBTCompoundReader;
import com.github.codenoms.nbt.writer.NBTCompoundWriter;
import com.github.codenoms.nbt.writer.NBTWritingContext;

import java.io.*;
import java.util.zip.*;

public final class NBT
{
    public static NBTCompound readNBT(DataInputStream stream) throws IOException
    {
        // skip root type, we assume it is a compound tag
        stream.readByte();

        // skip name, we don't use it
        byte[] nameBytes = new byte[stream.readUnsignedShort()];
        stream.readFully(nameBytes);

        return new NBTCompoundReader().readFromNBTData(stream);
    }

    public static NBTCompound readNBT(InputStream stream, NBTCompression compression) throws IOException
    {
        switch(compression)
        {
            case GZIP -> stream = new GZIPInputStream(stream);
            case ZLIB -> stream = new InflaterInputStream(stream);
        }

        if(stream instanceof DataInputStream)
            return readNBT((DataInputStream) stream);
        else
            return readNBT(new DataInputStream(stream));
    }

    public static void writeNBT(NBTCompound root, DataOutputStream stream) throws IOException
    {
        // write compound type index
        stream.writeByte(NBTWritingContext.getDefaultContext().getIndexByType(NBTCompound.class));

        // write name of 0 length
        stream.writeShort(0);

        new NBTCompoundWriter().writeAsNBTData(root, stream);
    }

    public static void writeNBT(NBTCompound root, OutputStream stream, NBTCompression compression) throws IOException
    {
        switch(compression)
        {
            case GZIP -> stream = new GZIPOutputStream(stream);
            case ZLIB -> stream = new DeflaterOutputStream(stream);
        }

        if(stream instanceof DataOutputStream)
            writeNBT(root, (DataOutputStream) stream);
        else
            writeNBT(root, new DataOutputStream(stream));
    }

    private NBT() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("instantiate");
    }
}
