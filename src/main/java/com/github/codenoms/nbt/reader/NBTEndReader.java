package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTEnd;

import java.io.DataInputStream;

public final class NBTEndReader implements NBTElementReader<NBTEnd>
{
    @Override
    public NBTEnd readElement(DataInputStream stream)
    {
        return NBTEnd.INSTANCE;
    }
}
