package com.github.codenoms.nbt;

import java.util.*;

public final class TypedList<T> implements List<T>
{
    private final Class<T> listType;
    private final List<T>  model;

    public TypedList(Class<T> listType)
    {
        this(listType, new ArrayList<>());
    }

    @SuppressWarnings("unchecked")
    public TypedList(Class<T> listType, List<?> elements)
    {
        this.listType = listType;
        this.model    = new ArrayList<>();
        elements.forEach((element) ->
        {
            ensureType(element);
            this.model.add((T) element);
        });
    }

    private void ensureType(Object o)
    {
        if(o != null && !listType.isAssignableFrom(o.getClass()))
            throw new ClassCastException("bad element type: " + o.getClass().getName() + ", expected: " + listType.getName());
    }

    public Class<T> getListType()
    {
        return listType;
    }

    @Override
    public int size()
    {
        return model.size();
    }

    @Override
    public boolean isEmpty()
    {
        return model.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return model.contains(o);
    }

    @Override
    public Iterator<T> iterator()
    {
        return model.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return model.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return model.toArray(a);
    }

    @Override
    public boolean add(T t)
    {
        ensureType(t);
        return model.add(t);
    }

    @Override
    public boolean remove(Object o)
    {
        return model.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return model.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        c.forEach(this::ensureType);
        return model.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        c.forEach(this::ensureType);
        return model.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return model.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return model.removeAll(c);
    }

    @Override
    public void clear()
    {
        model.clear();
    }

    @Override
    public T get(int index)
    {
        return model.get(index);
    }

    @Override
    public T set(int index, T element)
    {
        ensureType(element);
        return model.set(index, element);
    }

    @Override
    public void add(int index, T element)
    {
        ensureType(element);
        model.add(index, element);
    }

    @Override
    public T remove(int index)
    {
        return model.remove(index);
    }

    @Override
    public int indexOf(Object o)
    {
        return model.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return model.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return model.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        return model.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        return model.subList(fromIndex, toIndex);
    }
}
