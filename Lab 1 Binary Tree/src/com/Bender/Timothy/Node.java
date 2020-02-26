package com.Bender.Timothy;

public class Node<E>
{
    private E data;
    private Node<E> right;
    private Node<E> left;

    public Node (E data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public void setRight(Node<E> what)
    {
        this.right = what;
    }

    public void setLeft(Node<E> what)
    {
        this.left = what;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data){this.data = data;}

    public Node<E> getRight()
    {
        return right;
    }

    public Node<E> getLeft()
    {
        return left;
    }

}
