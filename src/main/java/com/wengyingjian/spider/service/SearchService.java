package com.wengyingjian.spider.service;

import com.wengyingjian.spider.components.BossDriver;

public class SearchService {


    public void doSearch() throws InterruptedException {
        //提示点击"知道了"
        //*[@id="wrap"]/div[1]/div[2]/div[1]/div[2]/a
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[1]/div[2]/a");
        //== 筛选
        doSearchByConditions();

    }


    private void doSearchByConditions() throws InterruptedException {
        //点击筛选
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[2]/div/span");
        //点击3-5年
        setExp3_5();
        Thread.sleep(1000);

        //继续筛选
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[2]/div/span");
        //点击本科
        setSt_benke();
        Thread.sleep(1000);
    }


    private void setExp1_3() {
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[2]/div/div/div/dl[2]/dd/a[4]");
    }

    private void setExp3_5() {
        //*[@id="wrap"]/div[1]/div[2]/div[2]/div/div/div/dl[2]/dd/a[5]
        //*[@id="wrap"]/div[1]/div[2]/div[2]/div/div/div/dl[2]/dd/a[5]
        //*[@id="wrap"]/div[1]/div[2]/div[2]/div/div/div/dl[2]/dd/a[5]
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[2]/div/div/div/dl[2]/dd/a[5]");
    }

    private void setSt_benke() {
        //*[@id="wrap"]/div[1]/div[2]/div[2]/div/div/div/dl[3]/dd/a[6]
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[2]/div/div/div/dl[3]/dd/a[6]");
    }

    private void setSt_shuoshi() {
        BossDriver.clickByXpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[2]/div/div/div/dl[3]/dd/a[7]");
    }

}
