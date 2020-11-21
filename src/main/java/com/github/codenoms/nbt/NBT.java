package com.github.codenoms.nbt;

import com.github.codenoms.nbt.reader.NBTElementReader;
import com.github.codenoms.nbt.reader.NamePrefixReader;
import com.github.codenoms.nbt.writer.NBTElementWriter;
import com.github.codenoms.nbt.writer.NamePrefixWriter;
import com.github.codenoms.nbt.writer.TypePrefixWriter;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;

public final class NBT
{
    @SuppressWarnings("unchecked")
    public static NBTCompound read(InputStream inputStream) throws IOException
    {
        DataInputStream stream = new DataInputStream(inputStream);

        NBTType type = NBTType.getByOrdinal(stream.readByte());
        if(type != NBTType.COMPOUND)
            throw new IllegalArgumentException("read type was not a compound nbt");

        return new NamePrefixReader<>((NBTElementReader<NBTCompound>) type.getReader()).readElement(stream);
    }

    public static NBTCompound readAsGZip(InputStream stream) throws IOException
    {
        return read(new GZIPInputStream(stream));
    }

    public static NBTCompound readAsZLib(InputStream stream) throws IOException
    {
        return read(new InflaterInputStream(stream));
    }

    @SuppressWarnings("unchecked")
    public static void write(NBTCompound root, OutputStream outputStream) throws IOException
    {
        new TypePrefixWriter<>(new NamePrefixWriter<>((NBTElementWriter<NBTCompound>) NBTType.COMPOUND.getWriter())).writeElement(root, new DataOutputStream(outputStream));
    }

    public static void writeAsGZip(NBTCompound root, OutputStream outputStream) throws IOException
    {
        write(root, new GZIPOutputStream(outputStream));
    }

    public static void writeAsZLib(NBTCompound root, OutputStream outputStream) throws IOException
    {
        write(root, new DeflaterOutputStream(outputStream));
    }

    private NBT() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("instantiate");
    }
}
