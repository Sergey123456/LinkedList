package telran.util;

class NodeList<E> {
	public E 			object;
	public NodeList<E> 	next;
	
	NodeList(E e) {
		object 		= e;
		this.next 	= null;
	}
	
	
}
