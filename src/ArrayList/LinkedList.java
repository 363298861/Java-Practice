package ArrayList;

public class LinkedList<T> implements List<T> {

    LL first, last;
    int n;

    class LL{
        T value;
        LL next;

        LL(T value, LL next){
            this.value = value;
            this.next = next;
        }
        @Override
        public String toString(){
            if(next == null)
                return value.toString();
            else
                return value + " " + next;
        }
    }


    @Override
    public void add(T value) {
        if(first == null)
            first = last = new LL(value, null);
        else{
            last.next = new LL(value, null);
            last = last.next;
        }
        n++;
    }

    @Override
    public void remove(int index) {
        if(index == 0){
            first = first.next;
            if(first == null)
                last = null;
        }else{
            LL prev = getLL(first, index - 1);
            prev.next = prev.next.next;
            if(prev.next == null)
                last = prev;
        }
        n--;
    }

    @Override
    public T get(int index) {
        if(index == 0)
            return first.value;
        else
            return getLL(first, index).value;
    }

    private LL getLL(LL start, int index){
        if(index == 0)
            return start;
        else
            return getLL(start.next, index - 1);
    }

    @Override
    public int size() {
        return n;
    }

    private LL re(LL oldfirst){
        if(oldfirst.next == null)
            return oldfirst;
        else{
            LL newPre = oldfirst.next;
            LL first = re(newPre);
            newPre.next = oldfirst;
            return first;
        }
    }

    @Override
    public void reverse() {
        if(first.next == null)
            return;
        else{
            last = first;
            first = re(first);
            last.next = null;
        }
    }

    @Override
    public String toString(){
        String r = "";
        if(first == null)
            return r;
        else
            return first.toString();
    }
}
