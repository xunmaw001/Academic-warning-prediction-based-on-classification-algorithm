package k_means;

import java.util.ArrayList;
import java.util.List;

public class K_Means {
    private int K;
    private List<Double[]> data;
    public List<List<Double[]>> finalResult = new ArrayList<>();//最终聚类的结果
    private List<Double[]> start_centerList = new ArrayList<>(); //聚类中心的list

    public K_Means(int k, List<Double[]> data){
        this.K = k;
        this.data = data;
        initCluster(k);
    }

    //根据K初始化K个聚类中心
    private void initCluster(int k) {
        for(int i = 0; i < k; i++){
            List<Double[]> list = new ArrayList<>();
            finalResult.add(list);
            start_centerList.add(data.get(i));
        }
        //根据初始聚类中心聚类
        getCluster(start_centerList,data);
        k_mean(start_centerList);
    }

    public void k_mean(List<Double[]> oldCenterList){
        //得到新的聚类中心的位置
        List<Double[]> newCenterList = get_newCenter();

        //判断新老聚类中心是否相等
        boolean flag = isEqual(oldCenterList, newCenterList);

        if(!flag){
            //根据新聚类中心聚类
            for(int i = 0; i < K; i++) {
                finalResult.get(i).clear();
            }
            getCluster(newCenterList,data);
            //新聚类中心作为参数，继续计算
            k_mean(newCenterList);
        }
    }

    //判断新老聚类中心是否相等
    private boolean isEqual(List<Double[]> oldCenterList, List<Double[]> newCenterList) {
        boolean flag = true;
        loop:
        for(int i = 0; i < oldCenterList.get(0).length; i++){
            for (int j = 0; j < oldCenterList.size(); j++){
                if (oldCenterList.get(j)[i].doubleValue() != newCenterList.get(j)[i].doubleValue()){
                    flag = false;
                    break loop;
                }
            }
        }
        return flag;
    }

    //根据聚类中心list 和数据集聚类
    private void getCluster(List<Double[]> centerList, List<Double[]> data) {
        for(int j = 0;j < data.size(); j++ ){
            double min_dis = distance(data.get(j), centerList.get(0));
            int index = 0;
            for (int i = 0; i < centerList.size(); i++){
                double dis_temp = distance(data.get(j), centerList.get(i));
                if (dis_temp <= min_dis){
                    min_dis = dis_temp;
                    index = i;
                }
            }
            finalResult.get(index).add(data.get(j));
        }
    }

    //欧氏距离
    private double distance(Double[] aData, Double[] aCenter) {
        double distance = 0;
        for (int i = 0; i < aData.length; i++){
            distance += Math.pow(aData[i] -aCenter[i], 2);
        }
        distance = Math.sqrt(distance);
        return distance;
    }

    //得到新聚类中心
    public List<Double[]> get_newCenter() {
        List<Double[]> newCenter = new ArrayList<>();
        for (int i = 0; i < K; i++){
            Double[] center = new Double[finalResult.get(i).get(0).length];
            for ( int j = 0; j < finalResult.get(i).get(0).length; j++ ){
                double temp_center = 0;
                for (int k = 0; k < finalResult.get(i).size(); k++){
                    temp_center += finalResult.get(i).get(k)[j];
                }
                temp_center = temp_center / finalResult.get(i).size();
                center[j] = temp_center;
            }
            newCenter.add(center);
        }
        return newCenter;
    }
}
