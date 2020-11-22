package com.github.codenoms.nbt;

public abstract class NBTWrappedElement<T> extends NamedNBTElement
{
    protected T value;

    public NBTWrappedElement(NBTType type, T value)
    {
        this(type, null, value);
    }

    public NBTWrappedElement(NBTType type, String name, T value)
    {
        super(type, name);
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return getType().name() + (name == null ? ": " : "('" + name + "'): ") + value;
    }
}
