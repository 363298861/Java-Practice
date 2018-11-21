package Abstract_type.ArrayList;

public class LinkedList<T> implements List<T> {
    private LinkedL first, last;
    int elements;

    class LinkedL {
        LinkedL next;
        private T value;
        LinkedL(T value, LinkedL next){
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString(){
            return value + ((next == null) ? "" : " " + next);
        }
    }



    @Override
    public void add(T value) {
        if(first == null)
            first = last = new LinkedL(value, null);
        else{
            last.next = new LinkedL(value, null);
            last = last.next;
        }
        elements++;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= elements)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            first = first.next;
            if (first == null)
                last = null;
        }
        else {
            LinkedL prev = getLinkedL(first, index - 1);
            prev.next = prev.next.next;
            if(prev.next == null)
                last = prev;
        }
        elements--;
    }

    private LinkedL getLinkedL (LinkedL start, int index){
        return index == 0 ? start : getLinkedL(start.next, index - 1);
    }


    @Override
    public T get(int index) {
        if(index < 0 || index >= elements)
            throw new IndexOutOfBoundsException();
        return getLinkedL(first, index).value;
    }

    @Override
    public int size() {
        return elements;
    }

    private LinkedL reversal (LinkedL oldFirst){
        if(oldFirst.next == null)
            return oldFirst;
        else {
            LinkedL newPrev = oldFirst.next;
            LinkedL first = reversal(newPrev);
            newPrev.next = oldFirst;
            return first;
        }

    }

    @Override
    public void reverse() {
        if(first == null) return;
        last = first;
        first = reversal(first);
        last.next = null;

    }
    @Override
    public String toString(){
        return first == null ? "" : first.toString();
    }
}
