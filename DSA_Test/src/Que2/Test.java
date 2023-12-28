package Que2;

public class Test {

	public static void main(String[] args) {
		Stack st=new Stack(10);
		System.out.println(st.isEmpty());
		st.push(1, "Tejas", 88);
		st.push(2, "Sahil", 90);
		st.push(3, "Siddhant", 82);
		System.out.println(st.isEmpty());
		System.out.println(st.isFull());
		st.display();
        System.out.println("Pop : "+st.pop());
        st.display();
        System.out.println("Peek : "+st.peek());
	}

}
