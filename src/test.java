import FileUtils.VectorUtils;
import math.Vector;
import network.bpnetwork;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by novas on 2016/2/4.
 */
public class test {

    public static void main(String[] args)throws Exception
    {
        double[] data= VectorUtils.getData("B0005.txt");
        double max=VectorUtils.getMax(data);
        double min=VectorUtils.getMin(data);
       // max=50;
       // min=0;
        data=VectorUtils.toOne(data,max,min);
        for(int i=0;i<data.length;i++)
        {
           // System.out.println(data[i]);
        }
        //train
        ArrayList<Vector> allInputList=VectorUtils.getInputVectors(data, 5);
      //  ArrayList<Vector> allOutputList=VectorUtils.getOutputVectors(data, 4);
        FileWriter fw=new FileWriter(new File("train_B0005.txt"));
        for(int i=0;i<allInputList.size();i++)
        {
            System.out.println(allInputList.size());
            fw.write(allInputList.get(i).getText()+"\r\n");
        }
        fw.close();
       // ArrayList<Vector> inputSampleList=VectorUtils.getInputSampleVectors(data, 4);
       // ArrayList<Vector> outputSampleList=VectorUtils.getOutputSampleVectors(data, 4);
        /*
        ArrayList<Vector> inputSampleList=new ArrayList<Vector>();
        for(int i=0;i<100;i++)
        {
           // System.out.println(allInputList.get(i));
            inputSampleList.add(allInputList.get(i));
        }
        ArrayList<Vector> outputSampleList=new ArrayList<Vector>();
        for(int i=0;i<100;i++)
        {
            outputSampleList.add(allOutputList.get(i));
        }
        bpnetwork bpnetwork=new bpnetwork(inputSampleList,outputSampleList);

        //get result
        Vector inputVector=allInputList.get(allInputList.size()-100);
        System.out.println("输入向量"+inputVector);
        System.out.println("期望输出向量"+(allOutputList.get(allOutputList.size()-100).getValue()[0]*(max-min)+min));
        Vector resultVector=bpnetwork.train(inputVector);
        System.out.println(resultVector.getValue()[0]*(max-min)+min);
        */
    }
}
