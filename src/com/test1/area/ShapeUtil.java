package com.test1.area;

//ͼ�εĹ�����
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
		System.out.println("����������Ϊ"+maxIndex+"��ͼ�ε����������Ϊ��"+max);
	}
}
