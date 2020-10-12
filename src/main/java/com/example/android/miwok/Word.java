package com.example.android.miwok;

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;
    private int mMiworkPronumciation;
    private int mImageResourceId=noImagefound;
    private static final int noImagefound=-1;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation,int miworkPronunciation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mMiworkPronumciation=miworkPronunciation;
    }
    /**
     * Create a new constructor for 3 input
     */
    public Word(String DefaultTranslation,String MiwokTranslation,int ImageResId,int miworkPronunciation){
        mDefaultTranslation=DefaultTranslation;
        mImageResourceId=ImageResId;
        mMiwokTranslation=MiwokTranslation;
        mMiworkPronumciation=miworkPronunciation;

    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    /**
     * Get the image resource
     */
    public int getGetImageResourceId(){return mImageResourceId;}

    /**
     * Cheack for presence of image
     */
    public boolean hasImage(){
        return mImageResourceId!=noImagefound;
    }
    public int getAudioResourceId(){
        return mMiworkPronumciation;
    }
}