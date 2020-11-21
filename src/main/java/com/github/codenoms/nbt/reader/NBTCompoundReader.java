package com.github.codenoms.nbt.reader;

import com.github.codenoms.nbt.NBTCompound;
import com.github.codenoms.nbt.NBTElement;
import com.github.codenoms.nbt.NBTType;
import com.github.codenoms.nbt.NamedNBTElement;

import java.io.DataInputStream;
import java.io.IOException;

public final class NBTCompoundReader implements NBTElementReader<NBTCompound>
{
    @Override
    public NBTCompound readElement(DataInputStream stream) throws IOException
    {
        NBTCompound compound = new NBTCompound();
        NBTElement element;
        while((element = GenericNBTReader.INSTANCE.readElement(stream)).getType() != NBTType.END)
            if(element instanceof NamedNBTElement)
                compound.addElement((NamedNBTElement) element);
        return compound;
    }
}
