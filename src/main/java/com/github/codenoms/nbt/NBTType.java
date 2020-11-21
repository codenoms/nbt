package com.github.codenoms.nbt;

import com.github.codenoms.nbt.reader.*;
import com.github.codenoms.nbt.writer.*;

public enum NBTType
{
    END(false, new NBTEndReader(), new TypePrefixWriter<>(null)),
    BYTE(new NBTByteReader(), new NBTByteWriter()),
    SHORT(new NBTShortReader(), new NBTShortWriter()),
    INT(new NBTIntReader(), new NBTIntWriter()),
    LONG(new NBTLongReader(), new NBTLongWriter()),
    FLOAT(new NBTFloatReader(), new NBTFloatWriter()),
    DOUBLE(new NBTDoubleReader(), new NBTDoubleWriter()),
    BYTE_ARRAY(new NBTByteArrayReader(), new NBTByteArrayWriter()),
    STRING(new NBTStringReader(), new NBTStringWriter()),
    LIST(new NBTListReader(), new NBTListWriter()),
    COMPOUND(new NBTCompoundReader(), new NBTCompoundWriter()),
    INT_ARRAY(new NBTIntArrayReader(), new NBTIntArrayWriter()),
    LONG_ARRAY(new NBTLongArrayReader(), new NBTLongerArrayWriter());

    public static NBTType getByOrdinal(int ordinal)
    {
        assert ordinal >= 0 && ordinal < NBTType.values().length;
        return values()[ordinal];
    }

    private final boolean isNamed;
    private final NBTElementReader<?> reader;
    private final NBTElementWriter<?> writer;

    NBTType(NBTElementReader<?> reader, NBTElementWriter<?> writer)
    {
        this(true, reader, writer);
    }

    NBTType(boolean isNamed, NBTElementReader<?> reader, NBTElementWriter<?> writer)
    {
        this.isNamed = isNamed;
        this.reader = reader;
        this.writer = writer;
    }

    public boolean isNamed()
    {
        return isNamed;
    }

    public NBTElementReader<?> getReader()
    {
        return reader;
    }

    public NBTElementWriter<?> getWriter()
    {
        return writer;
    }
}
