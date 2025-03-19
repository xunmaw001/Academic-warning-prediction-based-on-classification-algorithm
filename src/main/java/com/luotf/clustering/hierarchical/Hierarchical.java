package com.luotf.clustering.hierarchical;


import java.util.ArrayList;
import java.util.List;

public class Hierarchical {
    private double T;//阈值
    private ArrayList<Double[]> data;//数据集
    private List<List<Double[]>> finalResult;
    public Hierarchical(double T, ArrayList<Double[]> data){
        this.T = T;
        this.data = data;
        this.finalResult = initFinalResult();
    }

    //初始化，N个初始模式样本自成一类
    private List<List<Double[]>> initFinalResult() {
        List<List<Double[]>> startResult = new ArrayList<>();
        //首先将每一样本看成单独一类
        for (Double[] aData : data) {
            List<Double[]> list = new ArrayList<>();
            list.add(aData);
            startResult.add(list);
        }
        return startResult;
    }

    public List<List<Double[]>> hierarchical(){

        //计算每类间的欧式距离，保存在二维数组中
        double[][] distanceArray = new double[finalResult.size()][finalResult.size()];
        //最短距离 初始化为1,2类的距离
        double min_dis = min_distance(finalResult.get(0),finalResult.get(1));
        //即将合并的类的标号
        int index1 = 0;
        int index2 = 1;
        for(int i = 0; i< finalResult.size(); i++){
            for (int j = i+1; j < finalResult.size(); j++) {
                distanceArray[i][j] = min_distance(finalResult.get(i), finalResult.get(j));
                if (distanceArray[i][j] < min_dis){
                    min_dis = distanceArray[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        //阈值判断
        if(min_dis > T){
            return finalResult;
        }else {
            //将最短距离对应的类合并。
            merge(finalResult.get(index1), finalResult.get(index2));
            finalResult.remove(index2);
            hierarchical();
        }
        return finalResult;
    }

    //合并最短距离对应的类
    private void merge(List<Double[]> list1, List<Double[]> list2) {
        list1.addAll(list2);
    }

    //每个类间的最小距离
    private double min_distance(List<Double[]> list1, List<Double[]> list2) {
        double min_dis = distance(list1.get(0), list2.get(0));
        for (int i = 0; i < list1.size(); i++){
            for (int j = 0; j < list2.size(); j++){
                double dis_temp = distance(list1.get(i), list2.get(j));
                if (dis_temp < min_dis){
                    min_dis = dis_temp;
                }
            }
        }
        return min_dis;
    }

    //欧式距离
    private double distance(Double[] array1, Double[] array2){
        double distance = 0;
        for (int i = 0; i < array1.length; i++){
            distance += Math.pow(array1[i] - array2[i], 2);
        }
        distance = Math.sqrt(distance);
        return distance;
    }
}
