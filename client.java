
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.ArrayList;
public class client {
   public static void main(String[] args) throws IOException, ClassNotFoundException {
   rsa r = new rsa();
   tdes cipher = new tdes();
   Socket s = new Socket("localhost",4999);
   PrintWriter pr = new PrintWriter(s.getOutputStream());
   ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
   InputStreamReader in = new InputStreamReader(s.getInputStream());
   BufferedReader bf = new BufferedReader(in);
   pr.println(r.e);
   pr.flush();
   System.out.println("my public key is "+r.e);
   Object o = oi.readObject();
   ArrayList<BigInteger> my  =  (ArrayList<BigInteger>) o;
   System.out.println("encrypted keys is ");
   System.out.println("first half of key1 is "+my.get(0));
   System.out.println("second half of key1 is "+my.get(1));
   System.out.println("first half of key2 is "+my.get(2));
   System.out.println("second half of key2 is "+my.get(3));
   System.out.println("first half of key3 is "+my.get(4));
   System.out.println("second half of key3 is "+my.get(5));
   StringBuilder key111=(new StringBuilder()).append(r.dec(my.get(0),r.d).toString()).append(r.dec(my.get(1),r.d).toString());
   StringBuilder key222=(new StringBuilder()).append(r.dec(my.get(2),r.d).toString()).append(r.dec(my.get(3),r.d).toString());
   StringBuilder key333=(new StringBuilder()).append(r.dec(my.get(4),r.d).toString()).append(r.dec(my.get(5),r.d).toString());
   String key1=key111.toString();
   String key2=key222.toString();
   String key3=key333.toString();
   System.out.println("decrypted keys is ");
   System.out.println("first key is "+key1);
   System.out.println("second key is "+key2);
   System.out.println("third key is "+key3);
   String M = bf.readLine();
   System.out.println("encrypted msg is "+M);
   String tdest = cipher.decrypt(cipher.encrypt(cipher.decrypt(M, key3), key2), key1);
   System.out.println("decrypted msg is "+tdest);
}
 
}
