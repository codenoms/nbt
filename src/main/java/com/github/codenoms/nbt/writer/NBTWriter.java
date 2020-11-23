package com.github.codenoms.nbt.writer;

import java.io.DataOutputStream;
import java.io.IOException;

public interface NBTWriter<T>
{
    void writeAsNBTData(T object, DataOutputStream stream) throws IOException;
}
