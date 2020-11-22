package com.github.codenoms.nbt;

import java.util.*;

public final class NBTList extends NamedNBTElement implements List<NBTElement>
{
    private final NBTType listType;
    private final List<NBTElement> elements;

    public NBTList(NBTType listType)
    {
        this(null, listType, new ArrayList<>());
    }

    public NBTList(NBTType listType, List<NBTElement> elements)
    {
        this(null, listType, elements);
    }

    public NBTList(String name, NBTType listType)
    {
        this(name, listType, new ArrayList<>());
    }

    public NBTList(String name, NBTType listType, List<NBTElement> elements)
    {
        super(NBTType.LIST, name);
        this.listType = listType;
        elements.forEach(this::checkType);
        this.elements = elements;
    }

    public NBTType getListType()
    {
        return listType;
    }

    private void checkType(NBTElement element)
    {
        if(element.getType() != listType)
            throw new IllegalArgumentException("tried to add element of type " + element.getType().name() + " to a list of type " + listType.name());
    }

    @Override
    public int size()
    {
        return elements.size();
    }

    @Override
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return elements.contains(o);
    }

    @Override
    public Iterator<NBTElement> iterator()
    {
        return elements.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return elements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts)
    {
        return elements.toArray(ts);
    }

    @Override
    public boolean add(NBTElement element)
    {
        checkType(element);
        return elements.add(element);
    }

    @Override
    public boolean remove(Object o)
    {
        return elements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return elements.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends NBTElement> collection)
    {
        collection.forEach(this::checkType);
        return elements.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends NBTElement> collection)
    {
        collection.forEach(this::checkType);
        return elements.addAll(i, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection)
    {
        return elements.remove(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection)
    {
        return elements.retainAll(collection);
    }

    @Override
    public void clear()
    {
        elements.clear();
    }

    @Override
    public NBTElement get(int i)
    {
        return elements.get(i);
    }

    @Override
    public NBTElement set(int i, NBTElement element)
    {
        checkType(element);
        return elements.set(i, element);
    }

    @Override
    public void add(int i, NBTElement element)
    {
        checkType(element);
        elements.add(i, element);
    }

    @Override
    public NBTElement remove(int i)
    {
        return elements.remove(i);
    }

    @Override
    public int indexOf(Object o)
    {
        return elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return elements.lastIndexOf(o);
    }

    @Override
    public ListIterator<NBTElement> listIterator()
    {
        return elements.listIterator();
    }

    @Override
    public ListIterator<NBTElement> listIterator(int i)
    {
        return elements.listIterator(i);
    }

    @Override
    public List<NBTElement> subList(int i, int i1)
    {
        return elements.subList(i, i1);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder(getType().name()).append("(").append(listType.name()).append(")");
        if(name == null)
            builder.append(": {\n");
        else
            builder.append("('").append(name).append("'): {\n");

        for(NBTElement element : elements)
        {
            String elementAsString = element.toString();
            String[] lines;
            if(elementAsString.contains("\n"))
                lines = element.toString().split("\n");
            else
                lines = new String[]{elementAsString};
            for(String line : lines)
                builder.append("  ").append(line).append("\n");
        }

        return builder.append("}").toString();
    }
}
