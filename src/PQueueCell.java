/**
 * Priority Queue with elements of type Cell constructor: PQueueCell(int size)
 * 
 * Public Methods: void insert (Cell element) Cell deleteMin() boolean isEmpty()
 * boolean isFull() void display() <<<< used to see the internal location of
 * elements for debugging purposes private methods: void percolateUp(int hole,
 * Cell element) void percolateDown(int hole, Cell element)
 * 
 * 
 * 
 */
public class PQueueCell {

	private Cell[] heap;
	private int currentSize; // Current size of the heap
	private int maxSize; // max declared size

	private int hole, parent, left, right;

	/* -------------- constructor - size given ---------------------- */
	public PQueueCell(int size) {
		currentSize = 0; // set current size to 0
		maxSize = size + 1; // set maxsize to the declared
		heap = new Cell[maxSize]; // size of heap

		for (int i = 0; i < maxSize; i++)
			heap[i] = new Cell();
	}

	/* -------------------------------------------------------------- */
	public int Size() {
		return (maxSize - 1);

	}

	/*--------------------------DeleteMin ---------------------------*/
	public Cell deleteMin() {
		Cell min_el = new Cell();
		Cell tmp = new Cell();
		min_el.setKey(heap[1].getKey()); // save the top element and
		min_el.setItem(heap[1].getItem()); // create a hole at the top

		tmp.setKey(heap[currentSize].getKey()); // take the last element and
		tmp.setItem(heap[currentSize].getItem()); // and attempt to store it in
													// hole

		percolateDown(1, tmp); // percolate down the hole
		currentSize--; // new size is less by 1
		return min_el; // return the min element
	}

	/*--------------------------------------INSERT NODE ------------------------*/
	public void insert(Cell element) {

		hole = currentSize + 1; // create a new hole
		percolateUp(hole, element); // percolate up the hole
		currentSize++; // new size greater by 1
	}

	/*-------------------------------------is EMPTY --------------------------*/
	public boolean isEmpty() {
		if (currentSize == 0)
			return true;
		else
			return false;
	}

	/*-------------------------------------is FULL ---------------------------*/
	public boolean isFull() {
		if (currentSize + 1 == maxSize)
			return true;
		else
			return false;
	}

	/*------------------------------ display heap -----------------------*/
	public void display() {
		// Display New Heap
		System.out.println();
		System.out.println("PQ Heap:");
		for (int j = 1; j <= currentSize; j++) {
			System.out.println(heap[j].getKey() + " " + heap[j].getItem());
		}

		System.out.println();
	}

	/*-------------------------------------PERCOLATE UP ------------------------*/
	private void percolateUp(int hole, Cell element) {

		parent = hole / 2;
		boolean insert = false; // percolate up until we reach
								// the top or make the insert
		while (hole != 1 && !insert) {
			if (heap[parent].getKey() <= element.getKey()) // if the parent of
															// the hole has
			{ // greater priority, insert key
				heap[hole].setKey(element.getKey());
				heap[hole].setItem(element.getItem());
				insert = true;
			} else {
				heap[hole].setKey(heap[parent].getKey()); // store the parent
															// into the hole
				heap[hole].setItem(heap[parent].getItem());
				hole = parent; // make the parent's position
								// - the new hole,
				parent = hole / 2; // set parent to be the parent
			} // of the new hole

		} // end of while loop

		if (!insert) // if key is still not inserted
		{

			heap[hole].setKey(element.getKey()); // store it in the hole (the
													// top)
			heap[hole].setItem(element.getItem());
		}
	}

	/*-------------------------------------PERCOLATE DOWN ----------------------*/
	private void percolateDown(int hole, Cell element) {
		boolean insert = false; // true if we have filled the hole
		do {
			left = hole * 2; // compute left and right children
			right = left + 1; // of the hole

			if (right > currentSize) // at the last level - insert in hole
			{
				heap[hole].setKey(element.getKey());
				heap[hole].setItem(element.getItem());
				insert = true;
			}

			else // if key has a greater priority than
					// the hole's children
			if (element.getKey() <= heap[left].getKey()
					&& element.getKey() <= heap[right].getKey()) {
				heap[hole].setKey(element.getKey()); // insert key in the hole
				heap[hole].setItem(element.getItem());
				insert = true;
			}

			else // if key's priority is less than
					// the hole's children
			if (heap[left].getKey() <= heap[right].getKey())
			// choose among the children to fill
			{ // the hole
				heap[hole].setKey(heap[left].getKey()); // left child stored in
														// the hole
				heap[hole].setItem(heap[left].getItem());
				hole = left; // new hole one level down
			} else {
				heap[hole].setKey(heap[right].getKey()); // right child stored
															// in the hole
				heap[hole].setItem(heap[right].getItem());
				hole = right; // new hole one level down
			}
		} while (!insert);
	}

}
