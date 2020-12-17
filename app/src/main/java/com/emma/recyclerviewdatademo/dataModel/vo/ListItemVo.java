package com.emma.recyclerviewdatademo.dataModel.vo;

import androidx.databinding.BaseObservable;

//public class ListItemVo extends BaseObservable {    //BaseObservable -> 供需要即時改動item 資料時使用 ex:商品加入最愛 供點擊的愛心樣式要不一樣時
public class ListItemVo {
    private String title;
    private String content;
    private boolean imgShow;

    public ListItemVo(String title, String content, boolean imgShow) {
        this.title = title;
        this.content = content;
        this.imgShow = imgShow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isImgShow() {
        return imgShow;
    }

    public void setImgShow(boolean imgShow) {
        this.imgShow = imgShow;
    }
}
