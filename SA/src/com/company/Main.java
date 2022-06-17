package com.company;

import java.util.*;

import static java.lang.Math.abs;

public class Main {

    public static double main(String[] args) {

        int L_max = 1000; // 최대 반복수
        int temp = 1000; // 초기온도
        double s = 1000; // 초기해
        double new_s; // 이웃해

        double q = (double) Math.random(); // 확률값
        double r = 0.99;

        // 랜덤 문자 배열 생성
        double result = 0;
        Random rand = new Random();
        String[] point = {"A", "B", "C", "D", "E", "F", "G", "H"};
        System.out.println(point[rand.nextInt(point.length)]);// 랜덤 문자 출력

        double rand_value = Math.random(); // 랜덤 문자 값 출력

        double point[][] = new double[][]; // 거점
        double distance[] = new double[]; // 거리

        double travel ( double src, double dis){

            for (int i = 0; i < distance.length; i++) {

                distance[i] = rand_value;
            } // 거리값(소수) 입력

            int mid;
            int j;
            for (int i = 0; i < distance.length; i++) {
                j = distance.length / 2;
                mid = (int) distance[j];
            } // 중간값 결정

            int i = 0;
            int two = (rand + rand) >> 1; // 두번째 랜덤값
            int d = (int) abs(distance[two] - mid);
            s = abs(distance[j] - distance[j + 1]);


            while (i < L_max) {
                if (d > s) {
                    new_s = s;
                    result = s;
                } else {
                    result = d;
                }
                return result;
            }


            System.out.println();
            System.out.println("최소 지역점 : " + result);
        }
    }
}