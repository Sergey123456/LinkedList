package telran.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


// Class LinkedList immitates queue
// implements interface List
// **************************API:***********************************************
// boolean 			add(E) 								- overrided  
// void 			add(int, E)							- overrided
// boolean 			addAll(Collection<? extends E>)
// boolean			addAll(int, Collection<? extends E>)
// void 			clear()								- overrided
// boolean 			contains(Object)					- overrided
// boolean			containsAll(Collection<?>)
// E				get(int)							- overrided
// int				indexOf(Object)						- overrided
// boolean			isEmpty()							- overrided
// Iterator<E>		iterator()							- overrided
// int				lastIndexOf(Object)					- overrided
// ListIterator<E>	listIterator()						- in the work
// ListIterator<E>	listIterator(int)
// E				remove(int)							- overrided
// boolean			remove(Object)						- overrided
// boolean			removeAll(Collection<?>)
// boolean			retainAll(Collection<?>)
// E				set(int, E)							- overrided
// int				size()								- overrided
// List<E>			subList(int, int)
// Object[]			toArray()							- overrided
// <T> T[]			toArray(T[])
//****************************API***********************************************
public class LinkedList<E> implements List<E> {

	private NodeList<E> head;
	private NodeList<E> tail;
	private int 		size;
	
	LinkedList() {
		initialize();
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		boolean res = false;
		if (!isEmpty()) {
			NodeList<E> currentNode = head;
			while (currentNode != null && !res) {
				if (o.equals(currentNode.object))
					res = true;
				currentNode = currentNode.next;
			}
		}
		return res;
	}

	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<E> {
		int cursor = 0;       		// index of next element to return
		NodeList<E> currentNode = head;

		@Override
		public boolean hasNext() {
			return (!isEmpty()) && (currentNode != null);
		}

		@Override
		public E next() {
			E currentNodeValue = currentNode.object;
			cursor++;
			currentNode = currentNode.next;
			return currentNodeValue;
		}
		
	}

	@Override
	public Object[] toArray() {
		Object[] res = new Object[size];
		if (!isEmpty()) {
			NodeList<E> current	= head;
			for (int i = 0; i < size; i++) {
				res[i] = current.object;
				current = current.next;
			}
		}
		return res;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		NodeList<E> newNode = new NodeList<>(e);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next 	= newNode;
			tail 		= newNode;
		}
		size++;
		return true;
	}
	
	@Override
	public void add(int index, E element) {
		if (!validateIndex(index)) return;
		// empty List or add last element
		if (index == (size - 1) || isEmpty()) {
			add(element);
		} else {
			// add first element
			if (index == 0) {
				NodeList<E> nodeList = new NodeList<>(element);
				nodeList.next 	= head;
				head			= nodeList;
				size++;
			// add middle element
			} else {
				NodeList<E> newElement 	= new NodeList<>(element);
				NodeList<E> previous 	= getNodeList(index - 1);
				newElement.next 		= previous.next;
				previous.next 			= newElement;
				size++;
			}
		}
	}

	public E remove() {
		return remove(0); 
	}
	
	
	@Override
	public E remove(int index) {
		E res = null;
		if (!isEmpty() && validateIndex(index)) {
			NodeList<E> currentNode 	= head;
			NodeList<E> previousNode 	= null;
			for (int i = 0; i < index; i++) {
				previousNode 	= currentNode;
				currentNode 	= currentNode.next;
			}
			res = currentNode.object;
			removeNode(previousNode, currentNode);
		}
		return res;
	}

	public E removeByGranovsky(int index) {
		if (index < 0 || index > size - 1)
			return null;
		if (index == 0) 
			return removeFirst();
		if (index == size - 1) 
			return removeLast();
		
		return removeAtIndex(index);
	}
	
	private E removeAtIndex(int index) {
		NodeList<E> previousNode = getNodeList(index - 1);
		E res = previousNode.next.object;
		previousNode.next.object = null;
		previousNode.next.object = res;
		previousNode.next = previousNode.next.next;
		size--;
		return res;
	}

	public E removeLast() {
		if (head == null) 
			return null;
		E res = tail.object;
		if (head == tail) {
			head = tail = null;
		} else {
			tail = getNodeList(size - 2);
			tail.next = null;
		}
		size--;
		return res;
	}
	
	public E removeFirst() {
		if (head == null) 
			return null;
		E res = head.object;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return res;
	}

	@Override
	public boolean remove(Object o) {
		boolean res = false;
		if (!isEmpty()) {
			NodeList<E> currentNode 	= head;
			NodeList<E> previousNode 	= null;
			for (int i = 0; i < size && !res; i++) {
				if (o.equals(currentNode.object)) {
					res = true;
				} else {
					previousNode 	= currentNode;
					currentNode		= currentNode.next;
				}
			}
			if (res) {
				removeNode(previousNode, currentNode);
			}
		}
		return res;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		initialize();
	}

	@Override
	public E get(int index) {
		E res = null;
		if (validateIndex(index)) {
			if (index == 0) {
				res = head.object;
			} else if (index == size -1) {
				res = tail.object;
			} else {
				NodeList<E> currentNode = getNodeList(index);
				if (currentNode != null) {
					res = currentNode.object;
				}	
			}
		}
		return res;
	}

	@Override
	public E set(int index, E element) {
		E res = null;
		if (validateIndex(index)) {
			NodeList<E> currentNode = getNodeList(index);
			if (currentNode != null) {
				currentNode.object = element;
				res = get(index);
			}
		}
		return res;
	}
	
	@Override
	public int indexOf(Object o) {
		int res = -1;
		NodeList<E> currentNode = head;
		for (int i = 0; i < size && res == -1; i++) {
			if (o.equals(currentNode.object)) {
				res = i;
			}
			currentNode = currentNode.next;
		}
		return res;
	}
	
	public int indexOfGranovsky(Object o) {
		if (o == null)
			return indexOfNull();
		
		return indexOfNonNull(o);
	}

	private int indexOfNonNull(Object o) {
		int index = 0;
		NodeList<E> current = null;
		for (current = head; 
				current != null && !o.equals(current.object);
				current = current.next, index++) {
		}
		return current == null ? -1 : index;
	}

	private int indexOfNull() {
		int index = 0;
		NodeList<E> current = null;
		for (current = head; 
				current != null && current.object != null;
				current = current.next, index++) {
		}
		return current == null ? -1 : index;
	}

	public int lastIndexOfGranovsky(Object o) {
		return o == null ? lastIndexOfNull() : lastIndexNonNull(o);
	}
	
	private int lastIndexNonNull(Object o) {
		int res = -1;
		int index = 0;
		for (NodeList<E> current = head; current != null; 
				current = current.next, index++) {
			if (o.equals(current.object)) {
				res = index;
			}
		}
		return res;
	}
	
	private int lastIndexOfNull() {
		int res = -1;
		int index = 0;
		for (NodeList<E> current = head; current != null; 
				current = current.next, index++) {
			if (current.object == null) {
				res = index;
			}
		}
		return res;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		int res = -1;
		NodeList<E> currentNode = head;
		for (int i = 0; i < size && res == -1; i++) {
			if (o.equals(currentNode.object)) {
				res = i;
			}
			currentNode = currentNode.next;
		}
		return res;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListItr(this);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public NodeList<E> getHead() {
		return head;
	}
	
	public E getHeadValue() {
		return head == null ? null : head.object;
	}
	
	public E getTailValue() {
		return tail == null ? null : tail.object;
	}
	
	
	//*********************************************************
	// Private
	//*********************************************************
	
	private void removeNode(NodeList<E> previousNode, NodeList<E> currentNode) {
		// Single Node
		if (size == 1) {
			head = null;
			tail = null;
		// first Node
		} else if (previousNode == null) {
			head 				= currentNode.next;
			currentNode.next 	= null;
		// last Node
		} else if (currentNode.next == null) {
			tail				= previousNode;
			previousNode.next  	= null;
		// middle Node
		} else {
			previousNode.next 	= currentNode.next;
			currentNode.next	= null;
		}
		size--;
	}

	private NodeList<E> getNodeList(int index) {
		NodeList<E> res = null;
		if (validateIndex(index)) {
			NodeList<E> currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			res = currentNode;
		}
		return res;
	}
	
	private NodeList<E> getNodeList(Object o) {
		if (validate(o)) return null;
		NodeList<E> res 		= null;
		NodeList<E> currentNode = head;
		for (int i = 0; i < size && res == null; i++) {
			if (o.equals(currentNode.object)) {
				res = currentNode;
			}
			currentNode = currentNode.next;
		}
		return res;
	}

	private void initialize() {
		head = null;
		tail = null;
		size = 0;
	}

	private boolean validateIndex(int index) {
		return index >= 0 && index < size() ? true : false;
	}
	
	private boolean validate(Object o) {
		return o != null ? true : false;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(5);
		linkedList.add(10);
		linkedList.add(15);
		
		Iterator<Integer> it = linkedList.iterator();
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
		
	}
}