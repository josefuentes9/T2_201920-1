package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;
import model.data_structures.Stack;

public class TestQueue {
	
	private Queue Cola;
	private final static int cantidad=10;
	private int size;
	
	@Before
	public void setUp1() {
		Cola=new Queue();
		size++;
	}

	public void setUp2() {
		for(int i =0; i<cantidad; i++){
			Cola.enqueue(i);;
			size++;
		}
	}
	@Test
	public void TestQueue(){
		size=0;
		assertTrue(Cola!=null);
		assertEquals(0, Cola.size());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void TestPush(){
		setUp2();
		Cola.enqueue(7);
		size++;
		assertTrue("no se modifico el tamaño de la pila ",size==Cola.size());
		int dato=0;
		while(size!=0){
			dato=(Integer)Cola.dequeue();
		}
		assertTrue("no se agrego correctamente a la pila", dato==7);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void TestPush2(){
		setUp1();
		Cola.enqueue(7);
		assertTrue("no se modifico el tamaño de la pila ",size==Cola.size());
		assertFalse("no se agrego correctamente a la pila", (Integer)Cola.dequeue()==1);
		
		
	}
	
	public void TestDequeue(){
	setUp2();
	int i=0;
	while(size!=0){
	assertTrue("no salio correctamente a la pila",(Integer) Cola.dequeue()==i);
	
	i++;
	}
	}
	
	public void TestDequeue2(){
		setUp1();
		Cola.enqueue(7);
		assertTrue("no salio correctamente a la pila", (Integer)Cola.dequeue()==7);
		assertTrue("La pila no quedo vacia ",Cola.isEmpty());
		}
}
