package com.github.codenoms.nbt;

public abstract class NamedNBTElement extends NBTElement
{
    protected String name;

    public NamedNBTElement(NBTType type, String name)
    {
        super(type);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
