package com.luotf.clustering;


import java.util.ArrayList;

import com.luotf.clustering.isodata.ISODATA;

public class IsoData_test {
    public static void main(String[] args){
        ArrayList<Double[]> data = new ArrayList<Double[]>();
        Double x1[] = {0.0,0.0};
        Double x2[] = {1.0,1.0};
        Double x3[] = {2.0,2.0};
        Double x4[] = {4.0,3.0};
        Double x5[] = {5.0,3.0};
        Double x6[] = {4.0,4.0};
        Double x7[] = {5.0,4.0};
        Double x8[] = {6.0,5.0};

        data.add(x1);
        data.add(x2);
        data.add(x3);
        data.add(x4);
        data.add(x5);
        data.add(x6);
        data.add(x7);
        data.add(x8);

        int nc = 1; //预选nc个聚类中心
        int K = 2; //希望的聚类中心的数目
        int min_num = 1; //每个聚类中最少样本数
        double s = 1; //聚类域中样本的标准差阈值
        double c = 4; //两聚类中心之间的最短距离
        int L = 0; // 在一次迭代中允许合并的聚类中心的最大对数
        int I = 4; //允许迭代的次数
        double k = 0.5; // 分裂系数


        ISODATA isodata_test = new ISODATA(nc, K, min_num, s, c, L, I, k, data);

        new util_printCluster().printCluster(isodata_test.finalResult);


    }
}
