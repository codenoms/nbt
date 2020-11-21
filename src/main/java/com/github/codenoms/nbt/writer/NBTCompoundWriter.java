package com.github.codenoms.nbt.writer;

import com.github.codenoms.nbt.NBTCompound;
import com.github.codenoms.nbt.NBTEnd;
import com.github.codenoms.nbt.NBTType;
import com.github.codenoms.nbt.NamedNBTElement;

import java.io.DataOutputStream;
import java.io.IOException;

public final class NBTCompoundWriter implements NBTElementWriter<NBTCompound>
{
    @Override
    @SuppressWarnings("unchecked")
    public void writeElement(NBTCompound element, DataOutputStream stream) throws IOException
    {
        for(NamedNBTElement child : element.getElements())
            new TypePrefixWriter<>(new NamePrefixWriter<>((NBTElementWriter<NamedNBTElement>) child.getType().getWriter())).writeElement(child, stream);
        ((NBTElementWriter<NBTEnd>) NBTType.END.getWriter()).writeElement(NBTEnd.INSTANCE, stream);
    }
}
