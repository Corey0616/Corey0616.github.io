import java.util.PriorityQueue;

public class KeywordHeap
{
	private PriorityQueue<Keyword> heap;

	public KeywordHeap()
	{
		this.heap = new PriorityQueue<Keyword>(10, new KeywordComparator());
	}

	public void add(Keyword k)
	{
		heap.offer(k);
	}

	public void peek()
	{
		if (heap.peek() == null)
		{
			System.out.println("InvalidOperation");
			return;
		}

		Keyword k = heap.peek();
		System.out.println(k.toString());
	}

	public void removeMin()
	{
		// YOUR TURN
		// 2. remove minimal element and print it
		peek();
		
		if(heap.peek() != null) {
			heap.poll();
		}

	}

	public void output()
	{
		// YOUR TURN
		// 3. print the output in order and remove all element
		StringBuilder sb = new StringBuilder();
		Keyword k;
		int j = heap.size();
		
		for(int i = 1 ; i <= j ; i++) {
			sb.append(heap.peek());
			heap.poll();
		}

		System.out.println(sb.toString());
	}
}