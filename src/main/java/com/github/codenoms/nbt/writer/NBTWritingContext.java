package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTCompound;
import com.github.codenoms.nbt.TypedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class NBTWritingContext
{
    private static final NBTWritingContext DEFAULT_CONTEXT;

    public static NBTWritingContext getDefaultContext()
    {
        return DEFAULT_CONTEXT;
    }

    static
    {
        DEFAULT_CONTEXT = new NBTWritingContext();
        DEFAULT_CONTEXT.registerTypeWriter(0, Void.class, (object, stream) -> {});
        DEFAULT_CONTEXT.registerTypeWriter(1, Byte.class, (object, stream) -> stream.writeByte(object));
        DEFAULT_CONTEXT.registerTypeWriter(2, Short.class, (object, stream) -> stream.writeShort(object));
        DEFAULT_CONTEXT.registerTypeWriter(3, Integer.class, (object, stream) -> stream.writeInt(object));
        DEFAULT_CONTEXT.registerTypeWriter(4, Long.class, (object, stream) -> stream.writeLong(object));
        DEFAULT_CONTEXT.registerTypeWriter(5, Float.class, (object, stream) -> stream.writeFloat(object));
        DEFAULT_CONTEXT.registerTypeWriter(6, Double.class, (object, stream) -> stream.writeDouble(object));
        DEFAULT_CONTEXT.registerTypeWriter(7,
                                           byte[].class,
                                           new NBTWriterMapper<>(
                                                   (byte[] primitiveBytes) ->
                                                   {
                                                       Byte[] bytes = new Byte[primitiveBytes.length];
                                                       Arrays.setAll(bytes, (index) -> primitiveBytes[index]);
                                                       return bytes;
                                                   },
                                                   new NBTArrayWriter<>((object, stream) -> stream.writeByte(object))));
        DEFAULT_CONTEXT.registerTypeWriter(8, String.class, NBTStringWriter.getInstance());
        DEFAULT_CONTEXT.registerTypeWriter(9, TypedList.class, new NBTListWriter());
        DEFAULT_CONTEXT.registerTypeWriter(10, NBTCompound.class, new NBTCompoundWriter());
        DEFAULT_CONTEXT.registerTypeWriter(11,
                                           int[].class,
                                           new NBTWriterMapper<>(
                                                   (int[] primitiveInts) ->
                                                   {
                                                       Integer[] ints = new Integer[primitiveInts.length];
                                                       Arrays.setAll(ints, (index) -> primitiveInts[index]);
                                                       return ints;
                                                   },
                                                   new NBTArrayWriter<>((object, stream) -> stream.writeInt(object))));
        DEFAULT_CONTEXT.registerTypeWriter(12,
                                           long[].class,
                                           new NBTWriterMapper<>(
                                                   (long[] primitiveLongs) ->
                                                   {
                                                       Long[] longs = new Long[primitiveLongs.length];
                                                       Arrays.setAll(longs, (index) -> primitiveLongs[index]);
                                                       return longs;
                                                   },
                                                   new NBTArrayWriter<>((object, stream) -> stream.writeLong(object))));
    }

    private final Map<Class<?>, Byte>         indexByTypeMap  = new HashMap<>();
    private final Map<Class<?>, NBTWriter<?>> writerByTypeMap = new HashMap<>();

    public byte getIndexByType(Class<?> type)
    {
        return indexByTypeMap.get(type);
    }

    @SuppressWarnings("unchecked")
    public <T> NBTWriter<T> getWriterByType(Class<T> clazz)
    {
        return (NBTWriter<T>) writerByTypeMap.get(clazz);
    }

    public <T> void registerTypeWriter(int index, Class<T> clazz, NBTWriter<T> reader)
    {
        indexByTypeMap.put(clazz, (byte) index);
        writerByTypeMap.put(clazz, reader);
    }
}
