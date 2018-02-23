package OOPs;
//In this example we are demonstrating the garbage collection by calling System.gc(). In this code we have overridden a finalize() method. This method is invoked just before a object is destroyed by java garbage collection process. This is the reason you would see in the output that this method has been invoked twice.
public class GarbageCollectionDemo {
	public static void main(String args[]){  
		/* Here we are intentionally assigning a null 
		 * value to a reference so that the object becomes
		 * non reachable
		 */
		GarbageCollectionDemo obj=new GarbageCollectionDemo();  
		obj=null;  

		/* Here we are intentionally assigning reference a 
		 * to the another reference b to make the object referenced
		 * by b unusable.
		 */
		GarbageCollectionDemo a = new GarbageCollectionDemo();
		GarbageCollectionDemo b = new GarbageCollectionDemo();
		b = a;
		System.gc();  
	}  
	protected void finalize() throws Throwable
	{
		System.out.println("Garbage collection is performed by JVM");
	}
}
