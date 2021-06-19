package strings;

public class Test1 {

	public static void main(String[] args) {
		StringBuilder sb1=new StringBuilder("testing");
		System.out.println("contents : "+sb1);//toString
		System.out.println("length "+sb1.length()+" capa "+sb1.capacity());//7 23
		StringBuilder sb2=sb1.append(12345);
		System.out.println(sb1);//testing12345
		System.out.println(sb2);//testing12345
		System.out.println(sb1==sb2);//true
		StringBuilder sb22=new StringBuilder("testing");
		StringBuilder sb3=new StringBuilder("testing");//NEW
		System.out.println(sb22==sb3);//f
		System.out.println(sb22.equals(sb3));//f : StringBuilder HAS NOT overriden equals (chks by ref equality)
		sb1.append(false).append(new char[] {'a','b'}).append(123.45);
		System.out.println(sb1);
		System.out.println(sb1.reverse());//reversed
		System.out.println(sb1);//reversed
		System.out.println(sb1.length()+" "+sb1.capacity());
		sb1.setLength(0);
		System.out.println(sb1+" "+sb1.length()+" "+sb1.capacity());
		sb1.trimToSize();
		System.out.println(sb1+" "+sb1.length()+" "+sb1.capacity());

	}

}
