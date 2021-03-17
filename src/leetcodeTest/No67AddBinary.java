package leetcodeTest;

public class No67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ai = a.length() - 1, bi = b.length() - 1;
        int carry = 0;
        int sum;
        while(ai >= 0 || bi >= 0){
            sum = 0;
            if(ai >= 0)
                sum += a.charAt(ai--) - '0';
            if(bi >= 0)
                sum += b.charAt(bi--) - '0';
            sum += carry;
            if(sum < 2) {
                sb.append(sum);
                carry = 0;
            } else if(sum == 2) {
                sb.append(0);
                carry = 1;
            }else if(sum == 3){
                sb.append(1);
                carry = 1;
            }
        }
        if(carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
