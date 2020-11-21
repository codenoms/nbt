package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTElement;
import com.github.codenoms.nbt.NBTList;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTListWriter implements NBTElementWriter<NBTList>
{
    @Override
    @SuppressWarnings("unchecked")
    public void writeElement(NBTList element, DataOutputStream stream) throws IOException
    {
        stream.writeByte(element.getListType().ordinal());
        stream.writeInt(element.size());
        for(NBTElement child : element)
            ((NBTElementWriter<NBTElement>) element.getListType().getWriter()).writeElement(child, stream);
    }
}
