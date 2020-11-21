package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTElement;

import java.io.DataInputStream;
import java.io.IOException;

public interface NBTElementReader<T extends NBTElement>
{
    T readElement(DataInputStream stream) throws IOException;
}
