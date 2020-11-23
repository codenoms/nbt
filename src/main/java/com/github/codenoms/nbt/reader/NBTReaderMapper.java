package com.github.codenoms.nbt.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Function;

public final class NBTReaderMapper<T, S> implements NBTReader<T>
{
    private final Function<S, T> mappingFunction;
    private final NBTReader<S>   reader;

    public NBTReaderMapper(Function<S, T> mappingFunction, NBTReader<S> reader)
    {
        this.mappingFunction = mappingFunction;
        this.reader          = reader;
    }

    @Override
    public T readFromNBTData(DataInputStream stream) throws IOException
    {
        return mappingFunction.apply(reader.readFromNBTData(stream));
    }
}
