package telran.util;

import java.util.ListIterator;

public class ListItr<E> implements ListIterator<E> {

	NodeList<E> 	currentNode;
	LinkedList<E> 	linkedList;
	
	ListItr(LinkedList<E> linkedList) {
		this.linkedList = linkedList;
		currentNode = linkedList.getHead();
	}
	
	@Override
	public boolean hasNext() {
		return (!linkedList.isEmpty()) && (currentNode != null);
	}

	@Override
	public E next() {
		if (!hasNext()) return null;
		E currentNodeValue = currentNode.object;
		currentNode = currentNode.next;
		return currentNodeValue;
	}

	@Override
	public boolean hasPrevious() {
		return (!linkedList.isEmpty()) && (linkedList.getHead() != currentNode);
	}

	@Override
	public E previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}
}
