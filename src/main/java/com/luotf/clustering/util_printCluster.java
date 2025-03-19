package com.luotf.clustering;


import java.util.List;
public class util_printCluster {
    //打印
    public void printCluster(List<List<Double[]>> finalresult){
        for (List<Double[]> aFinalresult : finalresult) {
            int j = 0;
            while (j < aFinalresult.size()) {
                System.out.print("(");
                for (int k = 0; k < aFinalresult.get(j).length; k++) {
                    System.out.print(aFinalresult.get(j)[k] + ",");
                }
                System.out.print(")");
                j++;
            }
            System.out.println("\n");
        }
    }
}
