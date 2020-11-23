package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTAdapter;
import com.github.codenoms.nbt.NBTCompound;
import com.github.codenoms.nbt.TypedList;

import java.io.DataInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class NBTReadingContext
{
    private static final NBTReadingContext DEFAULT_CONTEXT;

    public static NBTReadingContext getDefaultContext()
    {
        return DEFAULT_CONTEXT;
    }

    static
    {
        DEFAULT_CONTEXT = new NBTReadingContext();
        DEFAULT_CONTEXT.registerTypeReader(0, Void.class, (stream) -> null);
        DEFAULT_CONTEXT.registerTypeReader(1, Byte.class, DataInputStream::readByte);
        DEFAULT_CONTEXT.registerTypeReader(2, Short.class, DataInputStream::readShort);
        DEFAULT_CONTEXT.registerTypeReader(3, Integer.class, DataInputStream::readInt);
        DEFAULT_CONTEXT.registerTypeReader(4, Long.class, DataInputStream::readLong);
        DEFAULT_CONTEXT.registerTypeReader(5, Float.class, DataInputStream::readFloat);
        DEFAULT_CONTEXT.registerTypeReader(6, Double.class, DataInputStream::readDouble);
        DEFAULT_CONTEXT.registerTypeReader(7,
                                           byte[].class,
                                           new NBTReaderMapper<>(
                                                   (Byte[] bytes) ->
                                                   {
                                                       byte[] primitiveBytes = new byte[bytes.length];
                                                       for(int i = 0; i < bytes.length; i++)
                                                           primitiveBytes[i] = bytes[i];
                                                       return primitiveBytes;
                                                   },
                                                   new NBTArrayReader<>(Byte[]::new, DataInputStream::readByte)));
        DEFAULT_CONTEXT.registerTypeReader(8, String.class, NBTStringReader.getInstance());
        DEFAULT_CONTEXT.registerTypeReader(9, TypedList.class, new NBTListReader());
        DEFAULT_CONTEXT.registerTypeReader(10, NBTCompound.class, new NBTCompoundReader());
        DEFAULT_CONTEXT.registerTypeReader(11,
                                           int[].class,
                                           new NBTReaderMapper<>(
                                                   (Integer[] ints) ->
                                                   {
                                                       int[] primitiveInts = new int[ints.length];
                                                       Arrays.setAll(primitiveInts, (index) -> ints[index]);
                                                       return primitiveInts;
                                                   },
                                                   new NBTArrayReader<>(Integer[]::new, DataInputStream::readInt)));
        DEFAULT_CONTEXT.registerTypeReader(12,
                                           long[].class,
                                           new NBTReaderMapper<>(
                                                   (Long[] longs) ->
                                                   {
                                                       long[] primitiveLongs = new long[longs.length];
                                                       Arrays.setAll(primitiveLongs, (index) -> longs[index]);
                                                       return primitiveLongs;
                                                   },
                                                   new NBTArrayReader<>(Long[]::new, DataInputStream::readLong)));
    }

    private final Map<Byte, Class<?>>          typeByIndexMap       = new HashMap<>();
    private final Map<Class<?>, NBTReader<?>>  readerByTypeIndexMap = new HashMap<>();
    private final Map<Class<?>, NBTAdapter<?>> defaultAdapters      = new HashMap<>();

    public Class<?> getTypeByIndex(byte index)
    {
        return typeByIndexMap.get(index);
    }

    @SuppressWarnings("unchecked")
    public <T> NBTReader<T> getReaderByType(Class<T> clazz)
    {
        return (NBTReader<T>) readerByTypeIndexMap.get(clazz);
    }

    public NBTReader<?> getReaderByIndex(byte index)
    {
        return getReaderByType(getTypeByIndex(index));
    }

    public <T> void registerTypeReader(int index, Class<T> clazz, NBTReader<T> reader)
    {
        typeByIndexMap.put((byte) index, clazz);
        readerByTypeIndexMap.put(clazz, reader);
    }

    public Map<Class<?>, NBTAdapter<?>> getDefaultAdapters()
    {
        return defaultAdapters;
    }

    public <T> void registerAdapter(Class<T> clazz, NBTAdapter<T> adapter)
    {
        defaultAdapters.put(clazz, adapter);
    }

    public void unregisterAdapter(Class<?> clazz)
    {
        defaultAdapters.remove(clazz);
    }
}
