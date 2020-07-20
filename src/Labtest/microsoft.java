package Labtest;

public class microsoft {
    public int volume(int[] pillar, int first, int last){
        int vol = 0;
        int min = Math.min(pillar[first], pillar[last]);
        for(int i = first; i <= last; i++){
            vol += min > pillar[i] ? min - pillar[i] : 0;
        }
        System.out.println(vol);
        return vol;
    }

    public int capacity(int[] pillar){
        int first = 0, last;
        int l = 0;
        while(pillar[first + l + 1] >= pillar[first + l])
            l++;
        first = l;
        int capacity = 0;
        while(first < pillar.length){
            int l2 = 0;
            while(first + l2 + 1 < pillar.length && pillar[first + 1 + l2] <= pillar[first + l2])
                l2++;
            last = first + l2 + 1;
            if(last >= pillar.length)
                break;
            int l3 = 0;
            while(last + l3 + 1 < pillar.length && pillar[last + 1 + l3] >= pillar[last + l3])
                l3++;
            last += l3;
            capacity += volume(pillar, first, last);
            first = last;
        }
        return capacity;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        microsoft m = new microsoft();
        System.out.println(m.capacity(test));
    }
}
