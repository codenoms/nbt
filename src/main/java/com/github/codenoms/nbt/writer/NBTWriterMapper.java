package com.github.codenoms.nbt.writer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.function.Function;

public final class NBTWriterMapper<T, S> implements NBTWriter<T>
{
    private final Function<T, S> mappingFunction;
    private final NBTWriter<S>   writer;

    public NBTWriterMapper(Function<T, S> mappingFunction, NBTWriter<S> writer)
    {
        this.mappingFunction = mappingFunction;
        this.writer          = writer;
    }

    @Override
    public void writeAsNBTData(T object, DataOutputStream stream) throws IOException
    {
        writer.writeAsNBTData(mappingFunction.apply(object), stream);
    }
}
