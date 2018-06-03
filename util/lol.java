package util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import util.Visitable;

/**
 * A simple linked list. One may go through this list by {@link #advance()}
 * until the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class MyList<E> implements Cloneable, Iterable<E>, Visitable<E> {

	/**
	 * Reference on the first Entry of this List
	 */
	private MyEntry<E> begin;
	/**
	 * References before the actual Entry of this List
	 */
	private MyEntry<E> pos;

	
	
	private int zaehler;
	
	
	
	/**
	 * Create a new empty List.
	 */
	public MyList() {
		pos = begin = new MyEntry<E>();
		zaehler = 0;
	}

	/**
	 * Determines if this List is empty or not.
	 * 
	 * @return <code>true</code>, if there are no elements in this List
	 */
	public boolean empty() {
		return begin.next == null;
	}

	/**
	 * Determines if it is possible to {@link #advance()} in this List. Returns
	 * <code>true</code> if the last position of this List has been reached. An
	 * {@link #empty()} List will alway deliver <code>true</code>
	 * 
	 * @return <code>true</code> if the last Entry in this List already has been
	 *         reached.
	 */
	public boolean endpos() { // true, wenn am Ende
		return pos.next == null;
	}

	/**
	 * Returns to the beginning of this List.
	 */
	public void reset() {
		pos = begin;
	}

	/**
	 * Advances one step in this List.
	 * 
	 * @throws NoSuchElementException
	 *             if the last Entry of this List already has been reached.
	 */
	public void advance() {
		if (endpos()) {
			throw new NoSuchElementException("Already at the end of this List");
		}
		pos = pos.next;
	}

	/**
	 * Returns the actual element of this List.
	 * 
	 * @return the actual element
	 * 
	 * @throws RuntimeException
	 *             if the last Entry of this List already has been reached.
	 */
	public E elem() {
		if (endpos()) {
			throw new NoSuchElementException("Already at the end of this List");
		}
		return pos.next.o;
	}

	/**
	 * Inserts <code>o</code> in this List. It will be placed before the actual
	 * element. After insertion the inserted element will become the actual
	 * element.
	 * 
	 * @param x
	 *            the element to be inserted
	 */
	public void add(E x) {
		MyEntry<E> newone = new MyEntry<E>(x, pos.next);

		pos.next = newone;
		zaehler++;
	}

	/**
	 * Deletes the actual element of this List. The element after the actual
	 * element will become the new actual element.
	 * 
	 * @throws NoSuchElementException
	 *             if the last Entry of this List already has been reached.
	 */
	public void delete() {
		if (endpos()) {
			throw new NoSuchElementException("Already at the end of this List");
		}
		pos.next = pos.next.next;
		zaehler++;
	}

	/**
	 * Clones this MyList. Will create a new independent MyList which actual
	 * position lies at the beginning of this MyList. This clone operation also
	 * fulfills the optional requirements defined by the {@link Object#clone()}
	 * operation. NOTE: Inserted elements will not be cloned, due to the fact,
	 * that the {@link Object#clone()} is <code>protected</code>.
	 * 
	 * @see Object#clone()
	 */
	public MyList<E> clone() {
		try {

			MyList<E> clone = (MyList<E>) super.clone();
			clone.begin = this.begin.clone();
			clone.pos = clone.begin;

			return clone;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin == null) ? 0 : begin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyList other = (MyList) obj;
		if (!begin.equals(other.begin))
			return false;
		return true;
	}

	@Override
	public Iterator<E> iterator() {							// Methode die Iterator für MyList erstellt
		// TODO Auto-generated method stub
		return new MyListIterator();
	}

	/**
	 * Iterator für MyList definieren
	 * @author Shafig
	 *
	 */
	
	public class MyListIterator implements Iterator<E> {	// Mylist implementiert das Interface Iterator

		private int erwZaehler;
		private MyEntry<E> current;							// wir benötigen 3 Variable aktuelles,letztes und nächstes Entry der liste
		private MyEntry<E> before;
		private MyEntry<E> next;

		/**
		 * Konstruktor der benötigte Variablen instanziert
		 */
		
		public MyListIterator() {							// Konstruktor für MyListIterator
			current = begin;								// das aktuelle  ist begin in myentry
			before = null;									// das element before vor current wird auf null gesetzt
			next = current.next;							// das nächste ist das nächste von dem aktuellen
			
			this.erwZaehler = zaehler;
		}

	/**
	 * zeigt ob es einen nächsten gibt
	 */
		
		@Override
		public boolean hasNext() {							// solange das folgende von current ungleich null ist gibt es ein nächstes element
			return current.next != null;

		}

		/**
		 * Gibt das nächste Element wieder
		 */
		
		@Override
		public E next() {
			if (erwZaehler != MyList.this.zaehler) {
				 throw new ConcurrentModificationException();	// ConcurrentModificationException wird dann geworfen wenn 
			}
			if (next == null) {							// getestet wird, ob der gemerkte expectedModCount(zaehler) mit dem aktuellen modCount(erwZaehler) übereinstimmt.
				 throw new NoSuchElementException();		// wir dürfen nicht über das Ende der liste Hinweg lesen.
			}
			// TODO Auto-generated method stub
			before = current;								// before rutscht nun auf current
			current = current.next;							// current wird  zu next
			next = next.next;								// next wird zu dessen nächstes
			return current.o;								// rückgabe von dem nächsten

		}

		/**
		 * "löscht" current element  
		 */
		
		public void remove() {
			if (erwZaehler != MyList.this.zaehler) {
				 throw new ConcurrentModificationException();	
			}
			if (before == null) {				
				throw new IllegalStateException();			//  Object before befindet sich in einem Zustand, der Aufruf nicht erlaubt
			}												// wenn before null ist gibt es nichts zu löschen und die Methode braucht nichts machen!
			
			
			before.next = current.next;						//	um ein element zu umgehen muss das auf bevor folgende  element geändert werden. 
															//  nach before folgt statt current nun current.next
			current = next;									// current rutscht auch einen platz weiter auf next
			next = next.next;								// next wird zu next.next
			before = null;									// und before wird zu null
		}

	}

	/**
	 * Visitor besucht alle Elemente
	 */
	@Override
	public void accept(util.Visitor<E> v) {	// Durchlaufe alle Elemente in dieser Liste solange es noch weitere Elemente zu besuchen gibt
											// und solange der Visitor, dem die Elemente vorgestellt werden, true zurueck gibt.

		MyEntry<E> current = this.begin;					// fangen beim ersten an
	
		while (current != null && v.visit(current.o)) {		// solange noch Elemente da und solange weiter besucht werden soll

			current = current.next;							// gehe einen Schritt weiter

		}

	}
}