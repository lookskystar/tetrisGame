package com.test1.area;

//图形的工具类
public class ShapeUtil {
	public static void maxArea(Shape[] shapes){
		double max=shapes[0].area();
		int maxIndex=0;
		for (int i = 0; i < shapes.length; i++) {
			double area=shapes[i].area();
			if(area>max){
				max=area;
				maxIndex=i;
			}
		}
		System.out.println("数组中索引为"+maxIndex+"的图形的面积最大，面积为："+max);
	}
}
