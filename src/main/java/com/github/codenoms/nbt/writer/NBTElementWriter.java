package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTElement;

import java.io.DataOutputStream;
import java.io.IOException;

public interface NBTElementWriter<T extends NBTElement>
{
    void writeElement(T element, DataOutputStream stream) throws IOException;
}
