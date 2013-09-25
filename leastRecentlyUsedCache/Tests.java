package leastRecentlyUsedCache;

import static org.junit.Assert.*;
import leastRecentlyUsedCache.LRUCache.DeadElementCallBack;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() throws InterruptedException {
		DeadElementCallBack<String, Integer> callback = new DeadElementCallBack<String, Integer>() {

			@Override
			public void notify(String key, Integer elements) {
				assertEquals("hello", key);
				assertEquals(new Integer(1), elements);
			}
		}; 
		LRUCache<String, Integer> cache = new LRUCache<String, Integer>(2000, 2, callback);
		cache.put("hello", 1);
		Thread.sleep(2500);
		cache.put("yo", 2);
		assertTrue(cache.size() == 1);
		assertTrue(cache.get("yo") != null);
	}
	
	@Test
	public void test2() throws InterruptedException {
		DeadElementCallBack<String, Integer> callback = new DeadElementCallBack<String, Integer>() {

			@Override
			public void notify(String key, Integer elements) {
			}
		}; 
		LRUCache<String, Integer> cache = new LRUCache<String, Integer>(2000, 2, callback);
		cache.put("hello", 1);
		cache.put("yo", 2);
		Thread.sleep(1500);
		cache.get("yo"); // Using a value.
		Thread.sleep(1000);
		cache.put("sup", 3);
		assertTrue(cache.size() == 2);
		assertTrue(cache.get("sup") != null);
		assertTrue(cache.get("yo") != null);
	}
	
	// Special case where even though "hola" is also expired, only one item is removed everytime
	// another is added.
	@Test
	public void test3() throws InterruptedException {
		DeadElementCallBack<String, Integer> callback = new DeadElementCallBack<String, Integer>() {

			@Override
			public void notify(String key, Integer elements) {
			}
		}; 
		LRUCache<String, Integer> cache = new LRUCache<String, Integer>(2000, 2, callback);
		cache.put("hello", 1);
		cache.put("yo", 2);
		cache.put("hola", 4);
		Thread.sleep(1500);
		cache.get("yo"); // Using a value.
		Thread.sleep(1000);
		cache.put("sup", 3);
		assertTrue(cache.size() == 3);
		assertTrue(cache.get("sup") != null);
		assertTrue(cache.get("yo") != null);
	}

}
