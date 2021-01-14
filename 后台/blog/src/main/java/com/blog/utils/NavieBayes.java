/**
 * 
 */
package com.blog.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Title: NavieBayes  
* Description: 朴素贝叶斯情感分类 
* @author 杨惠  
* @date 2020年5月8日  
 */
public class NavieBayes {
	private double priorPro=0.5;  //先验概率
	private double posPro=0;      //后验概率--积极
	private double negPro=0;      //后验概率--消极 
	private List<String> features=null;  //特征词
	public NavieBayes(String sentence){
		TextPreprocessing tp=new TextPreprocessing(sentence);
		this.features=tp.getFeatures();
		this.getPospro();
		this.getNegpro();
	}
	
	public String getClassify(){
		System.out.println("积极的概率："+posPro);
		System.out.println("消极的概率："+negPro);
		if(posPro<negPro){
			return "消极";
		}else{
			return "积极";
		}
	}
	
	/**
	 * 获取分类为积极的概率
	 */
	public void getPospro(){
		posPro=priorPro;
		int wordsNum=features.size();
		double count=0;
		double condPro=0;  //条件概率P(Ai|积极)
		double total=0;
//		Path classpath = Paths.get("trainData/pos.txt");
		String fileName = NavieBayes.class.getResource("/pos.txt").getFile();// 读取src下pos.txt
//		File file = new File("trainData/pos.txt");
		File file = new File(fileName);
		for(int i=0;i<wordsNum;i++){
			count=0;
			total=0;
			try{
				InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
				BufferedReader bf = new BufferedReader(inputReader);
				// 按行读取字符串
				String str;
				while ((str = bf.readLine()) != null) {
					total++;
					if(str.indexOf(features.get(i))!=-1){  
						count++; 
					}
				}
				bf.close();
				inputReader.close();
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("读取文件失败！");
			} 
			condPro=(count+1)/(total+wordsNum);  //平滑，避免0概率
			posPro=posPro*condPro;
		}
	}
	
	/**
	 * 获取分类为消极的概率
	 */
	public void getNegpro(){
		negPro=priorPro;
		int wordsNum=features.size();
		double count=0;
		double condPro=0;  //条件概率P(Ai|消极)
		double total=0;
		String fileName = NavieBayes.class.getResource("/neg.txt").getFile();// 读取src下neg.txt
		File file = new File(fileName);
	//	File file = new File("trainData/neg.txt");
		for(int i=0;i<wordsNum;i++){
			count=0;
			total=0;
			try{
				InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
				BufferedReader bf = new BufferedReader(inputReader);
				// 按行读取字符串
				String str;
				while ((str = bf.readLine()) != null) {
					total++;
					if(str.indexOf(features.get(i))!=-1){  
						count++; 
					}
				}
				bf.close();
				inputReader.close();
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("读取文件失败！");
			} 
			condPro=(count+1)/(total+wordsNum);  //平滑，避免0概率
			negPro=negPro*condPro;
		}
	}
	
}
