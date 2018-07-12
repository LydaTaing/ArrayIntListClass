public class ArrayIntListClient {

	public static void main(String[] args) {
		ArrayIntList List1 = new ArrayIntList();
		ArrayIntList List2 = new ArrayIntList();
		//List1.add(0);
		for (int i= 1; i<10; i++) {
			List1.add(i);
		}
		
		for (int i= 1; i<20; i+=2) {
			List2.add(i);
		}
		System.out.println("list 1 = "+ List1);
		List1.remove(3);
		List1.add(1, 10);
		System.out.println("list 1 = "+ List1);

	}

}
