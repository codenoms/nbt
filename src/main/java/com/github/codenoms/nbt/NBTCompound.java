package com.github.codenoms.nbt;

import java.util.*;
import java.util.stream.Collectors;

public final class NBTCompound
{
    private final Map<String, Object>          map        = new HashMap<>();
    private final Map<Class<?>, NBTAdapter<?>> adapterMap;

    public NBTCompound()
    {
        this(new HashMap<>());
    }

    public NBTCompound(Map<Class<?>, NBTAdapter<?>> adapterMap)
    {
        this.adapterMap = adapterMap;
    }

    public <T> void registerAdapter(Class<T> clazz, NBTAdapter<T> adapter)
    {
        adapterMap.put(clazz, adapter);
    }

    public void unregisterAdapter(Class<?> clazz)
    {
        adapterMap.remove(clazz);
    }

    public boolean contains(String name)
    {
        return map.containsKey(name);
    }

    public Set<String> keys()
    {
        return new HashSet<>(map.keySet());
    }

    public Set<Object> values()
    {
        return new HashSet<>(map.values());
    }

    public <T> Set<T> values(Class<T> typeFilter)
    {
        return map.values()
                  .stream()
                  .filter((o) -> typeFilter.isAssignableFrom(o.getClass()))
                  .map(typeFilter::cast)
                  .collect(Collectors.toSet());
    }

    public Set<Map.Entry<String, Object>> entries()
    {
        return new HashSet<>(map.entrySet());
    }

    public <T> Set<Map.Entry<String, T>> entries(Class<T> typeFilter)
    {
        return map.entrySet()
                  .stream()
                  .filter((entry) -> typeFilter.isAssignableFrom(entry.getValue().getClass()))
                  .map((entry) -> new AbstractMap.SimpleEntry<>(entry.getKey(), typeFilter.cast(entry.getValue())))
                  .collect(Collectors.toSet());
    }

    public <T> T get(String name, Class<T> expectedClass)
    {
        return opt(name, expectedClass).orElseThrow(() -> new NoSuchElementException(name));
    }

    public <T> Optional<T> opt(String name, Class<T> expectedClass)
    {
        Object value = map.get(name);
        if(value != null && value.getClass() == NBTCompound.class && expectedClass != NBTCompound.class)
        {
            @SuppressWarnings("unchecked")
            NBTAdapter<T> adapter = (NBTAdapter<T>) adapterMap.get(expectedClass);
            if(adapter == null)
                return Optional.empty();
            return Optional.of(adapter.deserializeFromNBT(getCompound(name)));
        }
        return Optional.ofNullable(expectedClass.cast(value));
    }

    public <T> void set(String name, T value)
    {
        @SuppressWarnings("unchecked")
        NBTAdapter<T> adapter = (NBTAdapter<T>) adapterMap.get(value.getClass());
        if(adapter == null)
            map.put(name, value);
        else
            map.put(name, adapter.serializeToNBT(value));
    }

    public void remove(String name)
    {
        map.remove(name);
    }

    public Optional<Class<?>> typeOf(String name)
    {
        return Optional.ofNullable(map.get(name)).flatMap((o) -> Optional.of(o.getClass()));
    }

    public byte getByte(String name)
    {
        return get(name, Byte.class);
    }

    public Optional<Byte> optByte(String name)
    {
        return opt(name, Byte.class);
    }

    public void setByte(String name, byte value)
    {
        set(name, value);
    }

    public byte[] getByteArray(String name)
    {
        return get(name, byte[].class);
    }

    public Optional<byte[]> optByteArray(String name)
    {
        return opt(name, byte[].class);
    }

    public void setByteArray(String name, byte[] value)
    {
        set(name, value);
    }

    public NBTCompound getCompound(String name)
    {
        return get(name, NBTCompound.class);
    }

    public Optional<NBTCompound> optCompound(String name)
    {
        return opt(name, NBTCompound.class);
    }

    public void setCompound(String name, NBTCompound compound)
    {
        set(name, compound);
    }

    public double getDouble(String name)
    {
        return get(name, Double.class);
    }

    public Optional<Double> optDouble(String name)
    {
        return opt(name, Double.class);
    }

    public void setDouble(String name, double value)
    {
        set(name, value);
    }

    public float getFloat(String name)
    {
        return get(name, Float.class);
    }

    public Optional<Float> optFloat(String name)
    {
        return opt(name, Float.class);
    }

    public void setFloat(String name, float value)
    {
        set(name, value);
    }

    public int getInt(String name)
    {
        return get(name, Integer.class);
    }

    public Optional<Integer> optInt(String name)
    {
        return opt(name, Integer.class);
    }

    public void setInt(String name, int value)
    {
        set(name, value);
    }

    public int[] getIntArray(String name)
    {
        return get(name, int[].class);
    }

    public Optional<int[]> optIntArray(String name)
    {
        return opt(name, int[].class);
    }

    public void setIntArray(String name, int[] value)
    {
        set(name, value);
    }

    public <T> TypedList<T> getList(String name, Class<T> expectedListType)
    {
        @SuppressWarnings("unchecked")
        TypedList<T> list = get(name, TypedList.class);
        if(expectedListType.isAssignableFrom(list.getListType()))
            return list;
        else if(list.getListType() == NBTCompound.class)
        {
            @SuppressWarnings("unchecked")
            NBTAdapter<T> adapter = (NBTAdapter<T>) adapterMap.get(expectedListType);
            if(adapter != null)
            {
                List<T> deserializedList = list.stream()
                                               .map((object) -> NBTCompound.class.cast(object.getClass()))
                                               .map(adapter::deserializeFromNBT)
                                               .collect(Collectors.toList());
                return new TypedList<>(expectedListType, deserializedList);
            }
        }
        throw new ClassCastException("cannot cast typed list of " + list.getListType().getName() + " to typed list of " + expectedListType.getName());
    }
    
    public <T> Optional<TypedList<T>> optList(String name, Class<T> expectedListType)
    {
        try
        {
            return Optional.of(getList(name, expectedListType));
        }
        catch(NoSuchElementException exception)
        {
            return Optional.empty();
        }
    }

    public <T> void setList(String name, TypedList<T> value)
    {
        @SuppressWarnings("unchecked")
        NBTAdapter<T> adapter = (NBTAdapter<T>) adapterMap.get(value.getListType());
        if(adapter == null)
            set(name, value);
        else
            set(name, new TypedList<>(NBTCompound.class, value.stream().map(adapter::serializeToNBT).collect(Collectors.toList())));
    }

    public <T> void setList(String name, Class<T> listType, List<T> list)
    {
        setList(name, new TypedList<>(listType, list));
    }

    @SafeVarargs
    public final <T> void setList(String name, Class<T> listType, T... elements)
    {
        setList(name, listType, Arrays.asList(elements));
    }

    public long getLong(String name)
    {
        return get(name, Long.class);
    }

    public Optional<Long> optLong(String name)
    {
        return opt(name, Long.class);
    }

    public void setLong(String name, long value)
    {
        set(name, value);
    }

    public long[] getLongArray(String name)
    {
        return get(name, long[].class);
    }

    public Optional<long[]> optLongArray(String name)
    {
        return opt(name, long[].class);
    }

    public void setLongArray(String name, long[] value)
    {
        set(name, value);
    }

    public short getShort(String name)
    {
        return get(name, Short.class);
    }

    public Optional<Short> optShort(String name)
    {
        return opt(name, Short.class);
    }

    public void setShort(String name, short value)
    {
        set(name, value);
    }

    public String getString(String name)
    {
        return get(name, String.class);
    }

    public Optional<String> optString(String name)
    {
        return opt(name, String.class);
    }

    public void setString(String name, String value)
    {
        set(name, value);
    }
}
