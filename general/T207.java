package com.company.leetcode.general;

import java.util.HashMap;
import java.util.Map;

public class T207 {

	/*
	你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
	在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
	给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<prerequisites.length;i++){
			if(hm.containsKey(prerequisites[i][0])){

			}
		}
		return false;
	}
}
