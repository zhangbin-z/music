package com.zl.music.pojo;

public class Music {
    private int mId;
//    音乐名称
    private  String mName;
//    歌手id
    private int sinId;
//    级联对象=歌手对象
    private Singer singer;
//    语种
    private String mLanguage;
//    心情
    private String mMood ;
//    风格
    private String mStyle;
//    发行日期
    private String issueDate;
//    歌曲路径
    private String mURL ;
//    点击率
    private int mScanNum;
//    歌曲图片
    private String mPicture;
//    歌曲时长
    private String mDuration;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getSinId() {
        return sinId;
    }

    public void setSinId(int sinId) {
        this.sinId = sinId;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String getmMood() {
        return mMood;
    }

    public void setmMood(String mMood) {
        this.mMood = mMood;
    }

    public String getmStyle() {
        return mStyle;
    }

    public void setmStyle(String mStyle) {
        this.mStyle = mStyle;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getmURL() {
        return mURL;
    }

    public void setmURL(String mURL) {
        this.mURL = mURL;
    }

    public int getmScanNum() {
        return mScanNum;
    }

    public void setmScanNum(int mScanNum) {
        this.mScanNum = mScanNum;
    }

    public String getmPicture() {
        return mPicture;
    }

    public void setmPicture(String mPicture) {
        this.mPicture = mPicture;
    }

    public String getmDuration() {
        return mDuration;
    }

    public void setmDuration(String mDuration) {
        this.mDuration = mDuration;
    }

    public Music() {
        super();
    }

    public Music(int mId, String mName, int sinId, Singer singer, String mLanguage, String mMood, String mStyle, String issueDate, String mURL, int mScanNum, String mPicture, String mDuration) {
        this.mId = mId;
        this.mName = mName;
        this.sinId = sinId;
        this.singer = singer;
        this.mLanguage = mLanguage;
        this.mMood = mMood;
        this.mStyle = mStyle;
        this.issueDate = issueDate;
        this.mURL = mURL;
        this.mScanNum = mScanNum;
        this.mPicture = mPicture;
        this.mDuration = mDuration;
    }
}
