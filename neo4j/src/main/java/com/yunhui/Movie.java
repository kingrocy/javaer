package com.yunhui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date : 2019-07-16 14:50
 * @Author :
 * @CopyRight :
 * @Desc :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String title;
    private int rating;

    public Movie(String title){
        this.title=title;
    }
}
