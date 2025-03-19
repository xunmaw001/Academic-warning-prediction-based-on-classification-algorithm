package com.luotf.clustering;


import java.util.ArrayList;

import com.luotf.clustering.k_means.K_Means;

public class K_mean_test {
    public static void main(String[] args){
        int K = 2;
        ArrayList<Double[]> data = new ArrayList<Double[]>();
        Double x1[] = {0.0,0.0};
        Double x2[] = {1.0,0.0};
        Double x3[] = {0.0,1.0};
        Double x4[] = {1.0,1.0};
        Double x5[] = {2.0,1.0};
        Double x6[] = {1.0,2.0};
        Double x7[] = {2.0,2.0};
        Double x8[] = {3.0,2.0};
        Double x9[] = {6.0,6.0};
        Double x10[] = {7.0,6.0};
        Double x11[] = {8.0,6.0};
        Double x12[] = {6.0,7.0};
        Double x13[] = {7.0,7.0};
        Double x14[] = {8.0,7.0};
        Double x15[] = {9.0,7.0};
        Double x16[] = {7.0,8.0};
        Double x17[] = {8.0,8.0};
        Double x18[] = {9.0,8.0};
        Double x19[] = {8.0,9.0};
        Double x20[] = {9.0,9.0};




        data.add(x9);
        data.add(x10);
        data.add(x11);
        data.add(x12);
        data.add(x13);
        data.add(x14);
        data.add(x15);
        data.add(x16);
        data.add(x17);
        data.add(x18);
        data.add(x19);
        data.add(x20);
        K_Means k_mean_test = new K_Means(K, data);
        new util_printCluster().printCluster(k_mean_test.finalResult);


    }
}
