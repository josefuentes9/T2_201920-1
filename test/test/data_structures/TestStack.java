package test.data_structures;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Stack;
public class TestStack {
	
	private Stack pila;
	private final static int cantidad=10;
	private int size;
	
	@Before
	public void setUp1() {
		pila=new Stack();
		size++;
	}

	public void setUp2() {
		for(int i =0; i<cantidad; i++){
			pila.push(i);
			size++;
		}
	}
	@Test
	public void TestStack(){
		size=0;
		assertTrue(pila!=null);
		assertEquals(0, pila.size());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void TestPush(){
		setUp2();
		pila.push(7);
		size++;
		assertTrue("no se modifico el tamaño de la pila ",size==pila.size());
		assertTrue("no se agrego correctamente a la pila", (Integer)pila.pop()==7);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void TestPush2(){
		setUp1();
		pila.push(7);
		assertTrue("no se modifico el tamaño de la pila ",size==pila.size());
		assertFalse("no se agrego correctamente a la pila", (Integer)pila.pop()==1);
		
		
	}
	
	public void TestPop(){
	setUp2();
	pila.push(7);
	assertTrue("no salio correctamente a la pila", (Integer)pila.pop()==7);
	assertTrue("La pila no quedo vacia ",pila.isEmpty());
	}
	
	public void TestPop2(){
		setUp1();
		pila.push(7);
		assertTrue("no salio correctamente a la pila", (Integer)pila.pop()==7);
		assertTrue("La pila no quedo vacia ",pila.isEmpty());
		}
	

}
