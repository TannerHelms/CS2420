package com.example.assign2webbrowser;

public class Queue {
    private Node Head;
    private Node Current;

    public void Add(String data) {
        Node newNode = new Node(data);
        if (this.Head == null) {
            this.Head = newNode;
            this.Current = newNode;
            return;
        }
        this.Current.Next = newNode;
        newNode.Previous = this.Current;
        this.Current = newNode;
    }
    public void Print() {
        Node currentNode = this.Head;
        System.out.println(currentNode.Data);
        while (currentNode.Next != null) {
            System.out.println(currentNode.Next.Data);
            currentNode = currentNode.Next;
        }
    }
    public boolean Previous() {
        if (this.Current.Previous != null) {
            this.Current = this.Current.Previous;
            return true;
        }
        return false;
    }
    public boolean Next() {
        if (this.Current.Next != null) {
            this.Current = this.Current.Next;
            return true;
        }
        return false;
    }
    public String GetUrl() {
        return this.Current.Data;
    }

    private class Node {
        public String Data;
        public Node Next;
        public Node Previous;
        public Node(String data) {
            this.Data = data;
        }
    }
}


