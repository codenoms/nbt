package com.github.codenoms.nbt;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class NBTCompound extends NamedNBTElement
{
    private final Map<String, NamedNBTElement> elementMap;

    public NBTCompound()
    {
        this(null);
    }

    public NBTCompound(String name)
    {
        this(name, new LinkedHashMap<>());
    }

    public NBTCompound(String name, Map<String, NamedNBTElement> elementMap)
    {
        super(NBTType.COMPOUND, name);
        this.elementMap = elementMap;
    }

    public NamedNBTElement getElement(String name)
    {
        return elementMap.get(name);
    }

    @SuppressWarnings("unchecked")
    public <T extends NamedNBTElement> T getElement(String name, NBTType expectedType)
    {
        NamedNBTElement element = getElement(name);
        if(element.getType() != expectedType)
            throw new IllegalArgumentException("'" + name + "' is not of expected type " + expectedType.name());
        return (T) element;
    }

    public byte getByte(String name)
    {
        return ((NBTByte) getElement(name, NBTType.BYTE)).getValue();
    }

    public void setByte(String name, int value)
    {
        addElement(new NBTByte(name, (byte) value));
    }

    public byte[] getByteArray(String name)
    {
        return ((NBTByteArray) getElement(name, NBTType.BYTE_ARRAY)).getValue();
    }

    public void setByteArray(String name, byte[] value)
    {
        addElement(new NBTByteArray(name, value));
    }

    public NBTCompound getCompound(String name)
    {
        return getElement(name, NBTType.COMPOUND);
    }

    public double getDouble(String name)
    {
        return ((NBTDouble) getElement(name, NBTType.DOUBLE)).getValue();
    }

    public void setDouble(String name, double value)
    {
        addElement(new NBTDouble(name, value));
    }

    public float getFloat(String name)
    {
        return ((NBTFloat) getElement(name, NBTType.FLOAT)).getValue();
    }

    public void getFloat(String name, float value)
    {
        addElement(new NBTFloat(name, value));
    }

    public int getInt(String name)
    {
        return ((NBTInt) getElement(name, NBTType.INT)).getValue();
    }

    public void setInt(String name, int value)
    {
        addElement(new NBTInt(name, value));
    }

    public int[] getIntArray(String name)
    {
        return ((NBTIntArray) getElement(name, NBTType.INT_ARRAY)).getValue();
    }

    public void setIntArray(String name, int[] value)
    {
        addElement(new NBTIntArray(name, value));
    }

    public NBTList getList(String name)
    {
        return getElement(name, NBTType.LIST);
    }

    public long getLong(String name)
    {
        return ((NBTLong) getElement(name, NBTType.LONG)).getValue();
    }

    public void setLong(String name, long value)
    {
        addElement(new NBTLong(name, value));
    }

    public long[] getLongArray(String name)
    {
        return ((NBTLongArray) getElement(name, NBTType.LONG_ARRAY)).getValue();
    }

    public void setLongArray(String name, long[] value)
    {
        addElement(new NBTLongArray(name, value));
    }

    public short getShort(String name)
    {
        return ((NBTShort) getElement(name, NBTType.SHORT)).getValue();
    }

    public void setShort(String name, short value)
    {
        addElement(new NBTShort(name, value));
    }

    public String getString(String name)
    {
        return ((NBTString) getElement(name, NBTType.STRING)).getValue();
    }

    public void setString(String name, String value)
    {
        addElement(new NBTString(name, value));
    }

    public void addElement(NamedNBTElement element)
    {
        elementMap.put(element.getName(), element);
    }

    public void removeElement(String name)
    {
        elementMap.remove(name);
    }

    public void removeElement(NamedNBTElement element)
    {
        elementMap.remove(element.getName(), element);
    }

    public Set<NamedNBTElement> getElements()
    {
        return new LinkedHashSet<>(elementMap.values());
    }
}
