package com.zl.music.util;

public enum PageEnum {

//    主页的页面容量
    PAGE_SIZE_HOME(4),
//    歌单页面的页面容量
    PAGE_SIZE_LIST(12),
//    歌手页面的页面容量
    PAGE_SIZE_SINGER(15),
//    榜单页面的页面容量
    PAGE_SIZE_RANK(7);
    private PageEnum(int pageSize){
        this.pageSize = pageSize;
    }

    private int pageSize;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
