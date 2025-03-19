package com.luotf.clustering.max_min;


import java.util.*;

public class Max_Min {
    private double t;
    private ArrayList<Double[]> data;//数据集

    public Max_Min(double t, ArrayList<Double[]> data){
        this.t = t;
        this.data = data;
    }
    public List<List<Double[]>> max_min_cluster(){
        //返回的聚类中心结果
        ArrayList<Double[]> result = new ArrayList<>();
        //第一个聚类中心
        Double[] z1 = data.get(0);
        result.add(z1);
        data.remove(z1);
        //得到包含最大距离及对应模式样本的Map
        Map <Double, Double[]> dis_cluster = max_dis(z1, data);
        Double[] keysets = dis_cluster.keySet().toArray(new Double[0]);
        //阈值T
        double T = t * keysets[0];
        //第二个聚类中心
        Double[] z2 = dis_cluster.get(keysets[0]);
        result.add(z2);

        //得到剩余的聚类中心
        getcluster(result, data, T);

        //根据最近距离聚类
        List<List<Double[]>> finalresult = cluster_by_min_dis(result, data, T);

        return finalresult;

    }

    private List<List<Double[]>> cluster_by_min_dis(ArrayList<Double[]> result, ArrayList<Double[]> data, double T) {
        List<List<Double[]>> finalresult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++ ){
            List<Double[]> list = new ArrayList<>();
            list.add(result.get(i));
            finalresult.add(list);
        }
        for (int j = 0; j < data.size(); j++){
            double min_dis = T;
            int index = 0;
            for (int i = 0; i < result.size(); i++){
                double dis_temp = distance(data.get(j), result.get(i));
                if(dis_temp < min_dis){
                    min_dis = dis_temp;
                    index = i;
                }
            }
            //将每一个模式样本加到对应的聚类中心中
            finalresult.get(index).add(data.get(j));
        }
        return finalresult;
    }

    private void getcluster(ArrayList<Double[]> result, ArrayList<Double[]> data, double T) {
        double min_distance;
        double max_min_distance = 0;
        int index = 0;
        for (int i = 0; i < data.size(); i++){
            List<Double> min_dis = new ArrayList<>();
            for (int j = 0; j < result.size(); j++){
                double distance = distance(result.get(j), data.get(i));
                min_dis.add(distance);
            }
            min_distance = Collections.min(min_dis);
            if (min_distance > max_min_distance){
                max_min_distance = min_distance;
                index = i;
            }
        }
        if (max_min_distance> T){
            result.add(data.get(index));
            data.remove(data.get(index));
            getcluster(result, data, T);
        }
    }

    private Map<Double, Double[]> max_dis(Double[] z1, ArrayList<Double[]> data) {
        //记录最大距离
        double max_distance = 0;
        //记录出现最大距离的模式样本
        Double[] max_dis_list = null;
        //记录出现最大距离的元素位置
        int index = 0;
        Map<Double, Double[]> dis_cluster = new HashMap<>();
        for (int i = 0; i < data.size(); i++ ){
            double temp_distance = distance(z1, data.get(i));
            if (temp_distance > max_distance){
                max_distance = temp_distance;
                max_dis_list = data.get(i);
                index = i;
            }
        }
        dis_cluster.put(max_distance, max_dis_list);
        data.remove(data.get(index));
        return dis_cluster;
    }

    //求两个模式样本间的欧式距离
    private double distance(Double[] list1, Double[] list2) {
        double distance = 0;
        for (int i = 0; i < list1.length; i++){
            distance += Math.pow(list1[i] - list2[i], 2);
        }
        distance = Math.sqrt(distance);
        return distance;
    }


}
