
import java.math.BigInteger;


public class rsa {
    
        public static BigInteger msg;
        public static BigInteger p;
        public static BigInteger q;
        public static BigInteger n;
        public static BigInteger phi;
        public static BigInteger e;
        public static BigInteger d;
        
    public static void main(String[] args) {
        
        BigInteger newmsg = new BigInteger("12345670");
        BigInteger newe = new BigInteger("65537");

        rsa r = new rsa(newmsg,newe);
        System.out.println(msg);
        System.out.println(p);
        System.out.println(q);
        System.out.println(n);
        System.out.println(phi);
        System.out.println(e);
        System.out.println(d);
        BigInteger rr = r.enc(msg, e);
        System.out.println(r.enc(msg, e));
        System.out.println(r.dec(rr, d));

    }
      // Any integer in the range [0, n)
    
    public rsa(){
    msg = new BigInteger("5635");
    p = new BigInteger("125617");
    q = new BigInteger("105829");
    n = p.multiply(q);
    phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    e = new BigInteger("65537");
    d = e.modInverse(phi); 
    }
    public rsa(BigInteger newmsg,BigInteger newe){
    msg = newmsg;
    p = new BigInteger("125617");
    q = new BigInteger("105829");
    n = p.multiply(q);
    phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    e = newe;
    d = e.modInverse(phi);
    }
    BigInteger enc(BigInteger msg,BigInteger e){
    BigInteger enc = msg.modPow(e, n);
    return enc;
    }
    BigInteger dec(BigInteger enc,BigInteger d){
    BigInteger dec = enc.modPow(d, n);
    return dec;
    }
}
