package com.github.codenoms.nbt.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Function;

public final class NBTArrayReader<T> implements NBTReader<T[]>
{
    private final Function<Integer, T[]> arrayCreator;
    private final NBTReader<T>           typeReader;

    public NBTArrayReader(Function<Integer, T[]> arrayCreator, NBTReader<T> typeReader)
    {
        this.arrayCreator = arrayCreator;
        this.typeReader   = typeReader;
    }

    @Override
    public T[] readFromNBTData(DataInputStream stream) throws IOException
    {
        T[] array = arrayCreator.apply(stream.readInt());
        for(int i = 0; i < array.length; i++)
            array[i] = typeReader.readFromNBTData(stream);
        return array;
    }
}
