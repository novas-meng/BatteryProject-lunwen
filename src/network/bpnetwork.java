package network;

import math.Vector;

import java.util.ArrayList;

/**
 * Created by novas on 2016/2/4.
 */
public class bpnetwork
{
    /*
     ��������4����Ԫ�����ز����6����Ԫ����������1����Ԫ,4-6-1�ṹ
     */
    int inputLayout=4;
    int hiddenLayout=8;
    int outputLayout=1;
    //o��ʾ��ֵ
    public static double o=0.9;
    //ѧϰ���ʲ��� 0.1-0.4֮��
    double n=0.1;
    //������
    ArrayList<Vector> inputSampleList=new ArrayList<Vector>();
    //�������
    ArrayList<Vector> expectOutputSampleList=new ArrayList<Vector>();
    //����㵽���ز��Ȩϵ�������4����Ԫ�����ز�6����Ԫ
    Vector[] inputToHiddenMartix=Vector.getRandomVectorArray(inputLayout+1,hiddenLayout);
    //���ز㵽������Ȩϵ�����ز�6����Ԫ�������1����Ԫ
    Vector[] hiddenToOutputMartix=Vector.getRandomVectorArray(hiddenLayout+1 ,1);
    //���ز����
    Vector hiddenOutputVector;
    //��������
    Vector outputVector;
    public bpnetwork(ArrayList<Vector> inputSampleList,ArrayList<Vector> expectOutputSampleList)
    {
        this.inputSampleList=inputSampleList;
        this.expectOutputSampleList=expectOutputSampleList;
        train();
    }
    public Vector train(Vector vector)
    {
        for(int l=0;l<inputToHiddenMartix.length;l++)
        {
            System.out.println(inputToHiddenMartix[l]);
        }
        Vector hiddenVector=CalHiddenOutputVector(vector, inputToHiddenMartix);
        System.out.println("输出的隐藏层"+hiddenVector);
        for(int l=0;l<inputToHiddenMartix.length;l++)
        {
            System.out.println(inputToHiddenMartix[l]);
        }
        //Ȼ�������������
        Vector outputtempVector=CalOutputVector(hiddenVector,hiddenToOutputMartix);
        System.out.println("输出向量" + outputtempVector);
        return outputtempVector;
    }
    public void train()
    {
        int count=0;
        double errorhold = 0;
        do
        {
            errorhold=0;
            count++;
            for(int i=0;i<inputSampleList.size();i++) {
           //  System.out.println(i);
              Vector inputVector = inputSampleList.get(i);
            //   System.out.println("输入向量"+inputVector);
              //���ȼ������ز����
              Vector hiddenVector = CalHiddenOutputVector(inputVector, inputToHiddenMartix);
             //  System.out.println("hidden layout output:"+hiddenVector);
              //Ȼ�������������
              Vector outputtempVector = CalOutputVector(hiddenVector, hiddenToOutputMartix);
              //System.out.println("实际输出" + outputtempVector);
              //��ʵ���
              Vector realOutputVector = expectOutputSampleList.get(i);
              //System.out.println("期望输出" + realOutputVector);
              errorhold = getError(outputtempVector, realOutputVector)+errorhold;
              //����ÿһ���D
              //�����D
             // double a = outputtempVector.getValue()[0];
            //  double b = realOutputVector.getValue()[0];
              Vector outputDVector = outputtempVector.subInteger(1).multipleVector(outputtempVector).multipleVector(outputtempVector.subVector(realOutputVector));
              Vector vector1 = outputtempVector.subInteger(1);
              // System.out.println("============="+vector1+"   "+outputtempVector);
              Vector vector2 = vector1.multipleVector(outputtempVector);
              // System.out.println("����ֵ �����"+outputDVector+"    "+(a*(1-a)*(b-a))+"   "+vector2+"    "+(1-a)*a);
              //�������ز�D
              Vector hiddenDVector = CalD(hiddenVector, hiddenToOutputMartix[0], outputDVector);

              //����Ȩϵ��
              //�������ز㵽�����ϵ��
              // System.out.println("hiddenVector="+hiddenDVector.getLength());
              justW(hiddenToOutputMartix, outputDVector, hiddenVector);
              //  System.out.println("У��ǰ");
              //  for( int k=0;k<inputToHiddenMartix.length;k++)
              //  {
              //  System.out.println(inputToHiddenMartix[k]);
              //  }
              //  System.out.println("����"+i+"��������"+inputVector);
              //   System.out.println("���ز����"+hiddenDVector);
              //��������㵽���ز�ϵ��
              justW(inputToHiddenMartix, hiddenDVector, inputVector);
              //  System.out.println("У���");
              //  for( int k=0;k<inputToHiddenMartix.length;k++)
              // {
              // System.out.println(inputToHiddenMartix[k]);
              //  }
          }
          //  System.out.println("hold="+errorhold+"count="+count);
        }while (count<500000);
    }
    //����Ȩϵ��
    public void justW(Vector[] W,Vector d,Vector outputVector)
    {
        double[] dd=d.getValue();
        double[] oo=outputVector.getValue();
        for(int i=0;i<W.length;i++)
        {
            double[] ww=W[i].getValue();
            int j=0;
            for(j=0;j<ww.length-1;j++)
            {
               // System.out.println("oo="+oo[j]);
                ww[j]=ww[j]-this.n*dd[i]*oo[j];
            }
            ww[j]=ww[j]-this.n*dd[i];
            W[i]=new Vector(ww);
        }
    }
    //����D
    public Vector CalD(Vector currentout,Vector W,Vector d)
    {
        //System.out.println("W="+W);
       // System.out.println("���ز����"+currentout);
        Vector vector=currentout.subInteger(1);
      //  System.out.println("��1"+vector);
        Vector vector1=currentout.multipleVector(vector);
      //  System.out.println("��1���֮��"+vector1+"   "+d.getLength());
        double[] temp=new double[W.getLength()];
        for(int i=0;i<temp.length;i++)
        {
            temp[i]=W.getValue()[i]*d.getValue()[0];
        }
        return vector.multipleVector(new Vector(temp));
    }
    //计算隐藏层输出
    public Vector CalHiddenOutputVector(Vector inputVector,Vector[] VectorMartix)
    {
        double[] tempout=new double[VectorMartix.length];
       // System.out.println("length="+VectorMartix.length+"   "+VectorMartix[0]);
        for(int i=0;i<VectorMartix.length;i++)
        {
            tempout[i]=sigmoid.sigmoid(inputVector.multipleADDVector(VectorMartix[i]));
           // System.out.println("tempout[i]="+tempout[i]);
        }
        return new Vector(tempout);
    }
    //计算输出层输出
    public Vector CalOutputVector(Vector inputVector,Vector[] VectorMartix)
    {
        double[] tempout=new double[VectorMartix.length];
        // System.out.println("length="+VectorMartix.length+"   "+VectorMartix[0]);
        for(int i=0;i<VectorMartix.length;i++)
        {
            tempout[i]=sigmoid.purelin(inputVector.multipleADDVector(VectorMartix[i]));
            // System.out.println("tempout[i]="+tempout[i]);
        }
        return new Vector(tempout);
    }
    public double getError(Vector vector2,Vector vector1)
    {
        double error=0;
        double[] data1=vector1.getValue();
        double[] data2=vector2.getValue();
        for(int i=0;i<data1.length;i++)
        {
            error=error+0.5*(data1[i]-data2[i])*(data1[i]-data2[i]);
        }
       // System.out.println("vecttor:"+vector2+"vector:"+vector1+"当前误差"+error);
        return error;
    }
}
