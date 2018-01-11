/*
 * John Sweet with help from Nick Mojica
 */

package JosephusList;

public class JosephusList<T> {
	
	public Node<T> first;
	public Node<T> last;
	public int size;
	
	public JosephusList(){
		first = null;
		last = null;
		size = 0;
	}
	
	public void add(T element){
		Node<T> node = new Node<T>(element);
		
		if(size == 0){
			first = node;
			last = node;
		}
		else{
			if(size == 1){
				last = node;
				last.next = first;
				first.next = last;
			}
			else{
				last.next = node;
				last = node;
				last.next = first;
			}	
		}	
		size++;
	}
	
	public T remove(){
		if(size == 0)
			return null;
		else{
			if(size == 1){
				T node = first.value;
				first = null;
				last = null;
				size--;
				return node;
			}
			if(size == 2){
				T node = first.value;
				first = last;
				first.next = null;
				last.next = null;
				size--;
				return node;
			}
			else{
				T node = first.value;
				first = first.next;
				last.next = first;
				size--;
				return node;
			}
		}
	}
	
	public void rotate(){
		if(size == 0 || size == 1)
			return;
		first = first.next;
		last = last.next;
	}
	
	public JosephusList<T> copy(){
		JosephusList<T> list = new JosephusList<T>();
		Node<T> temp = first;
		while(list.size != size){
			list.add(temp.value);
			temp = temp.next;
		}
		return list;
	}
	
	public T runProblem(int num){
		JosephusList<T> list = copy();
		if(size == 0)
			return null;
		while(list.size != 1){
			for(int i = 0; i < num - 1; i++)
				list.rotate();
			list.remove();
		}
		return list.first.value;
	}
}
