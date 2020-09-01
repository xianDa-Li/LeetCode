package com.company.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: XianDaLi
 * Date: 2020/8/25 16:21
 * Remark:
 * 哲学家进餐问题 The Dining Philosophers
 */
public class DiningPhilosophers {
	private final ReentrantLock[] lockList = {new ReentrantLock(),
			new ReentrantLock(),
			new ReentrantLock(),
			new ReentrantLock(),
			new ReentrantLock()};
	public DiningPhilosophers() {

	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher,
	                       Runnable pickLeftFork,
	                       Runnable pickRightFork,
	                       Runnable eat,
	                       Runnable putLeftFork,
	                       Runnable putRightFork) throws InterruptedException {

	}
}
