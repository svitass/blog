/**
 * 
 */
package com.blog.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;

/**
* Title: TextPreprocessing  
* Description: 文本预处理 
* @author 杨惠  
* @date 2020年5月11日  
 */
public class TextPreprocessing {
	private String sentence;
	
	public TextPreprocessing(){
		
	}
	
	public TextPreprocessing(String sentence){
		this.sentence=sentence;
	}
	
	/**
	 * 文本处理，并返回关键特征
	 * @return
	 */
	public List<String> getFeatures(){
		List<String> features=new ArrayList<String>();
		List<String> words=JieBa(this.sentence);
		//若分词后的单词数，小于10，则不用筛选
		if(words.size()<=10){
			features=words;
		}else{
			features=getKeyWords(words);
		}
		return features;
	}
	
	/**
	 * 结巴分词
	 * @return
	 */
	public List<String> JieBa(String str){
		JiebaSegmenter segmenter = new JiebaSegmenter();
		WordDictionary.getInstance().init(Paths.get("conf"));
		List<String> strList=segmenter.sentenceProcess(str);
		int length=strList.size();
		for(int i=0;i<length;i++){
			System.out.print(strList.get(i)+" ");
		}
		System.out.println();
		return strList;
	}
	
	/**
	 * 计算每个单词的TFIDF值，根据该值筛选关键词
	 * 保留TFIDF前10大的关键词
	 * @param words
	 * @return
	 */
	public List<String> getKeyWords(List<String> words){
		Map<String,Double> wordsTFIDF=new HashMap<String,Double>();
		List<String> keyWords=new ArrayList<String>();
		int length=words.size();
		for(int i=0;i<length;i++){
			String elem=words.get(i);
			//获取TF值（词频）
			double tf=getTF(words,elem);
			//获取IDF值（文件频率）
			double idf=getIDF(elem);
			double tfidf=tf*idf;
			wordsTFIDF.put(elem, tfidf);
		}
		//根据TFIDF排序
		List<Map.Entry<String,Double>> list = new ArrayList<Map.Entry<String,Double>>(wordsTFIDF.entrySet()); //转换为list
	    list.sort(new Comparator<Map.Entry<String,Double>>() {
	    	public int compare(Map.Entry<String,Double> o1, Map.Entry<String,Double> o2) {
	    		return o2.getValue().compareTo(o1.getValue());
	        }
	    });
	    int size=list.size();
	    if(size>=10){
	    	//获取TFIDF值前10大的关键词（过滤一些不重要的特征）
		    for (int i=0;i<10;i++) {
		    	keyWords.add(list.get(i).getKey());
	        }     
	    }else{
		    for (int i=0;i<size;i++) {
		    	keyWords.add(list.get(i).getKey());
	        }     
	    }
	    return keyWords;
	}
	
	/**
	 * 获取指定单词的词频TF
	 * TF(词频)=(词语出现的次数)/(总的词语数)
	 * @param words
	 * @param word
	 * @return
	 */
	public double getTF(List<String> words,String word){
		int length=words.size();
		double count=0;
		for(int i=0;i<length;i++){
			String str=words.get(i);
			if(word.equals(str)){
				count++;
			}
		}
		double tf=count/(double)length;
		return tf;
	}
	
	/**
	 * 获取指定单词的文件频率IDF(训练集)
	 * IDF=(记录总数)/(指定单词出现的记录数)
	 * @param word
	 * @return
	 */
	public double getIDF(String word){
		double total=0;  //记录总数
		double count=0;  //指定单词出现的记录数
		try{
			String fileName1 = NavieBayes.class.getResource("/pos.txt").getFile();// 读取src下pos.txt
			String fileName2 = NavieBayes.class.getResource("/neg.txt").getFile();// 读取src下pos.txt
			File file1 = new File(fileName1);
			InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1),"UTF-8");
			BufferedReader bf1 = new BufferedReader(inputReader1);
			File file2 = new File(fileName2);
			InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2),"UTF-8");
			BufferedReader bf2 = new BufferedReader(inputReader2);
			// 按行读取字符串
			String str;
			while ((str = bf1.readLine()) != null) {
				total++;
				if(str.indexOf(word)!=-1){  
					count++; 
				}
			}
			while ((str = bf2.readLine()) != null) {
				total++;
				if(str.indexOf(word)!=-1){  
					count++; 
				}
			}
			bf1.close();
			bf2.close();
			inputReader1.close();
			inputReader1.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("读取文件失败！");
		} 
		double idf=total/count;
		return idf;
	}

}
