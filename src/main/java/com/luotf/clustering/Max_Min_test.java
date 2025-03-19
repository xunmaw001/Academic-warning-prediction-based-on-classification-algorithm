package com.luotf.clustering;

/*
测试数据形式：[{},{},{},...,{}]
聚类中心结果形式：[[{}, {}, ... {}], [{}, {}, ... {}], ... ,[{}, {}, ... {}]]
 */




import java.util.ArrayList;
import java.util.List;

import com.luotf.clustering.max_min.Max_Min;

public class Max_Min_test {

    public static void main(String[] args){
        double t = 0.5;
        ArrayList<Double[]> data = new ArrayList<Double[]>();
        Double x1[] = {0.0,0.0};
        Double x2[] = {3.0,8.0};
        Double x3[] = {1.0,1.0};
        Double x4[] = {2.0,2.0};
        Double x5[] = {5.0,3.0};
        Double x6[] = {4.0,8.0};
        Double x7[] = {6.0,3.0};
        Double x8[] = {5.0,4.0};
        Double x9[] = {6.0,4.0};
        Double x10[] = {7.0,5.0};

        data.add(x1);
        data.add(x2);
        data.add(x3);
        data.add(x4);
        data.add(x5);
        data.add(x6);
        data.add(x7);
        data.add(x8);
        data.add(x9);
        data.add(x10);

        //最大最小距离算法测试
        Max_Min max_min_test = new Max_Min(t, data);
        List<List<Double[]>> list = max_min_test.max_min_cluster();
        new util_printCluster().printCluster(list);



    }

}
