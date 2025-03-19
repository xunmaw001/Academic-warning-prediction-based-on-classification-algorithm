package com.luotf.clustering;

//一些常用聚类算法的java实现：包括最大最小距离算法、近邻聚类算法、层次聚类算法、K均值聚类算法、ISODATA算法


import java.util.ArrayList;
import java.util.List;

import com.luotf.clustering.hierarchical.Hierarchical;

public class Hierarchical_test {

    public static void main(String[] args) {
        //阈值T：根号5
        double T = Math.sqrt(5);
        //数据集
        ArrayList<Double[]> data = new ArrayList<Double[]>();

        Double[] x1 = {0.0, 3.0, 1.0, 2.0, 0.0};
        Double[] x2 = {1.0, 3.0, 0.0, 1.0, 0.0};
        Double[] x3 = {3.0, 3.0, 0.0, 0.0, 1.0};
        Double[] x4 = {1.0, 1.0, 0.0, 2.0, 0.0};
        Double[] x5 = {3.0, 2.0, 1.0, 2.0, 1.0};
        Double[] x6 = {4.0, 1.0, 1.0, 1.0, 0.0};

        data.add(x1);
        data.add(x2);
        data.add(x3);
        data.add(x4);
        data.add(x5);
        data.add(x6);

        Hierarchical hierarchical_test = new Hierarchical(T, data);
        List<List<Double[]>> list = hierarchical_test.hierarchical();
        new util_printCluster().printCluster(list);
    }

}
