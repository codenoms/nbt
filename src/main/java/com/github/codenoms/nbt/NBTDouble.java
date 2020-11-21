package com.github.codenoms.nbt;

public final class NBTDouble extends NBTWrappedElement<Double>
{
    public NBTDouble(double value)
    {
        super(NBTType.DOUBLE, value);
    }

    public NBTDouble(String name)
    {
        super(NBTType.DOUBLE, name, 0D);
    }

    public NBTDouble(String name, double value)
    {
        super(NBTType.DOUBLE, name, value);
    }
}
