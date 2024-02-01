
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class server {
    public static void main(String[] args) throws IOException,UnknownHostException {
    String key11 = "59182736";
    String key12 = "78965441";
    String key21 = "56237945";
    String key22 = "74125630";
    String key31 = "65231470";
    String key32 = "66523014";
    String text = "123456ABCD132536";
    BigInteger k11 = new BigInteger(key11);
    BigInteger k12 = new BigInteger(key12);
    BigInteger k21 = new BigInteger(key21);
    BigInteger k22 = new BigInteger(key22);
    BigInteger k31 = new BigInteger(key31);
    BigInteger k32 = new BigInteger(key32);
    ServerSocket ss = new ServerSocket(4999);
    Socket s = ss.accept();
    rsa r = new rsa();
    tdes cipher = new tdes();
    ObjectOutputStream oi = new ObjectOutputStream(s.getOutputStream());
    InputStreamReader in = new InputStreamReader(s.getInputStream());
    BufferedReader bf = new BufferedReader(in);
    PrintWriter pr = new PrintWriter(s.getOutputStream());
    System.out.println("client connected");
    BigInteger e = new BigInteger(bf.readLine());
    System.out.println("client public key is "+e);
    System.out.println("keys is ");
    System.out.println("first key is "+key11+key12);
    System.out.println("second key is "+key21+key22);
    System.out.println("third key is "+key31+key32);
    System.out.println("encrypted keys is ");
    System.out.println("first half of key1 is "+r.enc(k11,e));
    BigInteger k1h1=r.enc(k11,e);
    System.out.println("second half of key1 is "+r.enc(k12,e));
    BigInteger k1h2=r.enc(k12,e);
    System.out.println("first half of key2 is "+r.enc(k21,e));
    BigInteger k2h1=r.enc(k21,e);
    System.out.println("second half of key2 is "+r.enc(k22,e));
    BigInteger k2h2=r.enc(k22,e);
    System.out.println("first half of key3 is "+r.enc(k31,e));
    BigInteger k3h1=r.enc(k31,e);
    System.out.println("second half of key3 is "+r.enc(k32,e));
    BigInteger k3h2=r.enc(k32,e);
    ArrayList<BigInteger> my =  new ArrayList<BigInteger>();
    my.add(k1h1);
    my.add(k1h2);
    my.add(k2h1);
    my.add(k2h2);
    my.add(k3h1);
    my.add(k3h2);
    oi.writeObject(my);
    String key1=key11+key12;
    String key2=key21+key22;
    String key3=key31+key32;
    String tdes = cipher.encrypt(cipher.decrypt(cipher.encrypt(text, key1), key2), key3);
    System.out.println("original msg is "+text);
    System.out.println("encrypted msg is "+tdes);
    pr.println(tdes);
    pr.flush();
    }

    
    
}
