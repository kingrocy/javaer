package com.yunhui.arithmetic.cosine_similarity;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2019-06-19 17:00
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class IKUtils {

    /**
     * 以List的格式返回文本分词的结果
     * @param text
     * @return
     */
    public static List<String> divideText(String text){
        if(null == text || "".equals(text.trim())){
            return null;
        }
        List<String> resultList = new ArrayList<>();
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex = null;
        try {
            while ((lex = ik.next()) != null) {
                resultList.add(lex.getLexemeText());
            }
        } catch (Exception e) {
            //TODO
        }
        return resultList;
    }
}
