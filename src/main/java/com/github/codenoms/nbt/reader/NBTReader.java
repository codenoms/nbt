package com.github.codenoms.nbt.reader;

import java.io.DataInputStream;
import java.io.IOException;

public interface NBTReader<T>
{
    T readFromNBTData(DataInputStream stream) throws IOException;
}
