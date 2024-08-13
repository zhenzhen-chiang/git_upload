package com.cathaybk.javaedu.lesson1;

import java.awt.geom.Area;

/**
 * <pre>
 * overload（多載）
 * </pre>
 */
public class Overload {

	private static Area area;
	private static Area area2;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* 正方形面積 */
		System.out.println(calculateArea(2));

		/* 長方形面積 */
	    int area ; calculateArea(2, 5);
		System.out.println(calculateArea(2, 5));
	}

	/**
	 * 計算正方形面積
	 * 
	 * @param length 邊長
	 * @return
	 */
	public static int calculateArea(int length) {
		return length * length;
	}

	/**
	 * 計算長方形面積
	 * 
	 * @param length 長
	 * @param width  寬
	 * @return
	 */
	public static int calculateArea(int length, int width) {
		return length * width;
	}

}
