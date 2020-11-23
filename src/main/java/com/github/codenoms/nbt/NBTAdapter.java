package com.github.codenoms.nbt;

public interface NBTAdapter<T>
{
    NBTCompound serializeToNBT(T object);

    T deserializeFromNBT(NBTCompound compound);
}
