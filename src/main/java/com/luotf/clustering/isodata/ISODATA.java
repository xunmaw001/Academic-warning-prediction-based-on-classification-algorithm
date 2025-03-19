package com.luotf.clustering.isodata;

import java.util.*;

public class ISODATA {
    private int nc; //预选nc个聚类中心
    private int K; //希望的聚类中心的数目
    private int min_num; //每个聚类中最少样本数
    private double s; //聚类域中样本的标准差阈值
    private double c; //两聚类中心之间的最短距离
    private int L; // 在一次迭代中允许合并的聚类中心的最大对数
    private int I; //允许迭代的次数
    private int current_i = 1;//目前迭代的次数
    private double k; // 分裂系数
    private List<Double[]> data = new ArrayList<>(); // 数据集
    private List<Double[]> clusterCenter = new ArrayList<>(); //聚类中心list
    public List<List<Double[]>> finalResult = new ArrayList<>();//最终聚类结果
    private List<Double> innerMeanDis = new ArrayList<>();//类内平均距离
    private double allMeanDis = 0;//全部样本的总体平均距离

    public ISODATA(int nc, int k, int min_num, double s, double c, int l, int i, double k1, List<Double[]> data) {
        this.nc = nc;
        K = k;
        this.min_num = min_num;
        this.s = s;
        this.c = c;
        L = l;
        I = i;
        this.k = k1;
        this.data = data;
        step1();
    }

    //第一步： 预选nc个聚类中心
    private void step1(){
        for (int i = 0; i < nc; i++){

            clusterCenter.add(data.get(i));

            List<Double[]> list = new ArrayList<>();
            list.add(data.get(i));
            finalResult.add(list);
        }
        step2();
    }

    //第二步： 根据最近邻规则聚类
    private void step2(){
        finalResult.clear();
        for(int i = 0; i < clusterCenter.size(); i++){
            List<Double[]> list = new ArrayList<>();
            finalResult.add(list);
        }
        for (Double[] aData : data) {
            int index = 0;
            double min_dis = distance(aData, clusterCenter.get(0));
            for (int j = 0; j < clusterCenter.size(); j++) {
                double dis_temp = distance(aData, clusterCenter.get(j));
                if (dis_temp < min_dis) {
                    min_dis = dis_temp;
                    index = j;
                }
            }
            finalResult.get(index).add(aData);
        }
        step3();
    }

    //第三步：判断Sj中样本数Nj是否小于min_num
    private void step3(){
        for (int i = 0; i < finalResult.size(); i++){
            if (finalResult.get(i).size() < min_num){
                finalResult.remove(i);
                clusterCenter.remove(i);
                nc--;
            }
        }
        step4();
    }

    //第四步：修正各聚类中心值
    private void step4(){
        for (int i = 0; i < finalResult.size(); i++){
            Double[] center = new Double[clusterCenter.get(0).length];
            for (int j = 0; j < finalResult.get(i).get(0).length; j++){
                double mean = 0;
                for (int k = 0; k < finalResult.get(i).size(); k++){
                    mean += finalResult.get(i).get(k)[j];
                }
                mean = mean / finalResult.get(i).size();
                center[j] = mean;
            }
            clusterCenter.remove(i);
            clusterCenter.add(i, center);
        }
        step5();
    }

    //第五步：计算类内平均距离
    private void step5(){
        for (int i = 0; i < finalResult.size(); i++){
            double inner_dis = 0;
            for (int j = 0; j < finalResult.get(i).size(); j++){
                inner_dis += distance(finalResult.get(i).get(j), clusterCenter.get(i));
            }
            inner_dis = inner_dis / finalResult.get(i).size();
            innerMeanDis.add(inner_dis);
        }
        step6();
    }

    //第六步：计算全部样本的总体平均距离
    private void step6(){
        double allmeandis = 0;
        for (int i = 0; i < finalResult.size(); i++){
            allmeandis += finalResult.get(i).size() * innerMeanDis.get(i);
        }
        allMeanDis = allmeandis / data.size();
        step7();
    }

    //第七步：判断是进行分裂，还是进行合并
    private void step7(){
        if (current_i == I){
            c = 0;
            step11_12_13_14();
        }else if(nc <= K/2 ){
            step8_9_10();
        }else if(((current_i % 2 )==0) || nc >= 2*K ){
            step11_12_13_14();
        }
    }

    //第八、九、十步：计算每个聚类中样本的标准差向量；求每个标准差向量的最大分量；在最大分量集中，根据条件判断下一步
    private void step8_9_10() {
        //对应最大分量的分量序号
        int[] index_list = new int[finalResult.size()];
        //最大分量集
        Double[] max_standard_dev = new Double[finalResult.size()];

        for (int i = 0; i < finalResult.size(); i++){
            double temp = 0;
            //记录标准差向量的最大分量及对应分量序号
            double max_index = 0;
            int index = 0;
            for (int j = 0; j < data.get(0).length; j++){
                for (int k = 0; k < finalResult.get(i).size(); k++){
                    temp += Math.pow(finalResult.get(i).get(k)[j]-clusterCenter.get(i)[j], 2);
                }
                temp = Math.sqrt(temp / finalResult.get(i).size());
                if(temp > max_index){
                    max_index = temp;
                    index = j;
                }
                index_list[i] = index;
                max_standard_dev[i] = max_index;
            }
        }

        //第十步：判断
        for (int i = 0; i < max_standard_dev.length; i++){
            //分裂运算
            Double[] new_cluster1 = new Double[data.get(0).length];
            Double[] new_cluster2 = new Double[data.get(0).length];
            if (max_standard_dev[i] > s && ((innerMeanDis.get(i) > allMeanDis && finalResult.get(i).size() > 2 *(min_num+1)) || nc <= K / 2)){
                for (int j = 0; j < clusterCenter.get(i).length; j++){
                    if(j != index_list[i]){
                        new_cluster1[j] = clusterCenter.get(i)[j];
                        new_cluster2[j] = clusterCenter.get(i)[j];
                    }else{
                         new_cluster1[j] = clusterCenter.get(i)[index_list[i]] + k * max_standard_dev[i];
                         new_cluster2[j] = clusterCenter.get(i)[index_list[i]] - k * max_standard_dev[i];
                    }
                }
                clusterCenter.add(new_cluster1);
                clusterCenter.add(new_cluster2);
                clusterCenter.remove(i);
                current_i++;
                nc++;
                step2();
            }else{
                step11_12_13_14();
            }
        }
    }

    //第十一、十二、十三、十四步：
    private void step11_12_13_14() {
        //第十一、十二步：计算所有聚类中心之间的距离，并将小于c的值存入list按升序排列
        //储存小于c的距离以及对应聚类中心下标的map
        Map<Double, Integer[]> dis_index_map = new HashMap<>();
        for (int i = 1; i < nc-1; i++){
            for (int j = i+1; j < nc; j++){
                //下标数组
                Integer[] indexes = new Integer[2];
                double dis_temp = distance(clusterCenter.get(i), clusterCenter.get(j));
                if(dis_temp < c){
                    indexes[0] = i;
                    indexes[1] = j;
                    dis_index_map.put(dis_temp,indexes);
                }
            }
        }
        //距离按升序排列后的list
        List<Double> dis_list = new ArrayList<>(dis_index_map.keySet());
        Collections.sort(dis_list);
        //第十三步：合并
        for (int i = 0; i < L; i++){
            //即将合并的聚类中心的标号
            Integer[] index = dis_index_map.get(dis_list.get(i));
            //已经合并过的聚类的标号
            List<Integer> already_index = new ArrayList<>();
            // 判断是否合并过
            if (!(already_index.contains(index[0]) || already_index.contains(index[1]))){
                //新聚类中心
                Double[] new_cluster = new Double[data.get(0).length];
                for (int j = 0; j < new_cluster.length; j++){
                    new_cluster[j] = (finalResult.get(index[0]).size() * clusterCenter.get(index[0])[j]
                            + finalResult.get(index[1]).size() * clusterCenter.get(index[1])[j])
                            / (finalResult.get(index[0]).size() + finalResult.get(index[1]).size());
                }
                clusterCenter.add(new_cluster);
                clusterCenter.remove(index[0].intValue());
                clusterCenter.remove(index[1].intValue());
                already_index.add(index[0]);
                already_index.add(index[1]);
                nc--;
            }
        }
        //第十四步：判断
        if(current_i != I){
            Scanner sc = new Scanner(System.in);
            System.out.println("是否需要修改参数,输入“yes”确认修改");
            String next = sc.next();
            if(next.equals("yes")){
                System.out.println("nc:");
                this.nc = sc.nextInt();
                System.out.println("K:");
                this.K = sc.nextInt();
                System.out.println("min_num:");
                this.min_num = sc.nextInt();
                System.out.println("s:");
                this.s = sc.nextDouble();
                System.out.println("c:");
                this.c = sc.nextDouble();
                System.out.println("L:");
                this.L = sc.nextInt();
                System.out.println("I:");
                this.I = sc.nextInt();
                System.out.println("k:");
                this.k = sc.nextDouble();
                current_i++;
                step1();
            }else{
                current_i++;
                step2();
            }
        }

    }

    //欧氏距离
    private double distance(Double[] doubles, Double[] doubles1) {
        double distance = 0;
        for (int i = 0; i < doubles.length; i++){
            distance += Math.pow(doubles[i] -doubles1[i], 2);
        }
        distance = Math.sqrt(distance);
        return distance;
    }


}
