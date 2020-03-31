package com.yunhui;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Date : 2020-01-09 10:08
 * @Author : dushaoyun
 */
@Data
@NoArgsConstructor
public class Item implements Delayed {


    private String name;

    private Long delay;


    public Item(String name, Integer expire, TimeUnit unit) {
        this.name = name;
        switch (unit) {
            case DAYS:
                this.delay = System.currentTimeMillis() + 24 * 60 * 60 * 1000 * expire;
                break;
            case HOURS:
                this.delay = System.currentTimeMillis() + 60 * 60 * 1000 * expire;
                break;
            case MINUTES:
                this.delay = System.currentTimeMillis() + 60 * 1000 * expire;
                break;
            case SECONDS:
                this.delay = System.currentTimeMillis() + 1000 * expire;
                break;
            case MILLISECONDS:
                this.delay = System.currentTimeMillis() + expire;
                break;
            default:
                throw new UnsupportedOperationException("Upsupported TimeUnit Parameter");
        }
    }

    /**
     * 剩余时间=到期时间-当前时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }
}
