package leastRecentlyUsedCache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implemented an LRU Cache for practice.
 * 
 * @author Jaime Guajardo
 *
 * @param <KK>
 * @param <VV>
 */
public class LRUCache<KK,VV> {
	final static private int MAX_CACHE_ENTRIES = 128;

	public interface DeadElementCallBack<KK, VV> {
		public void notify(KK key, VV elements);
	}
	private Object lock = new Object();
	private long minAge;
	private HashMap<KK, Item<VV>> cache;
	private DeadElementCallBack<KK,VV> callback;

	public LRUCache(long minAgeMillis) {
		this (minAgeMillis, MAX_CACHE_ENTRIES);
	}

	public LRUCache(long minAgeMillis, int maxCacheEntries) {
		this(minAgeMillis, maxCacheEntries, null);
	}

	public LRUCache(
			long minAgeMillis, int maxCacheEntries, final DeadElementCallBack<KK, VV> callback) {
		minAge = minAgeMillis;
		this.callback = callback;
		cache = new LinkedHashMap<KK, Item<VV>>(maxCacheEntries + 1, .75F, true) {
			private static final long serialVersionUID = 1L;

			// Called every time a new entry is added to cache.
			public boolean removeEldestEntry(Map.Entry<KK, Item<VV>> eldest) {
				long age = System.currentTimeMillis() - eldest.getValue().birth;
				if (age > minAge) {
					if (LRUCache.this.callback != null) {
						LRUCache.this.callback.notify(eldest.getKey(), eldest.getValue().payload);
					}
					return true;
				}
				return false;
			}
		};
	}

	public void put(KK key, VV value) {
		synchronized(lock) {
			cache.put(key, new Item<VV>(value));
		}
	}

	public VV get(KK key) {
		synchronized(lock) {
			Item<VV> item = getItem(key);
			return item == null ? null : item.payload;
		}
	}

	public VV remove(String key) {
		synchronized(lock) {
			Item<VV> item = cache.remove(key);
			return item == null ? null : item.payload;
		}
	}

	public int size() {
		synchronized(lock) {
			return cache.size();
		}
	}

	private Item<VV> getItem(KK key) {
		Item<VV> item = cache.get(key);
		if (item == null) {
			return null;
		}
		// Update when item was last accessed.
		item.touch();
		return item;
	}
	private static class Item<T> {
		long birth;
		T payload;

		Item(T payload) {
			birth = System.currentTimeMillis();
			this.payload = payload;
		}

		public void touch() {
			birth = System.currentTimeMillis();
		}
	}
}
