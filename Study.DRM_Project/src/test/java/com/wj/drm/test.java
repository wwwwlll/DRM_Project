package com.wj.drm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;

		try {
			input = Integer.parseInt(br.readLine());

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < input; i++) {
			try {
				arr.add(Integer.parseInt(br.readLine()));
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
