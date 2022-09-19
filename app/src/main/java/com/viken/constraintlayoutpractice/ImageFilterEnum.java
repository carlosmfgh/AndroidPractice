package com.viken.constraintlayoutpractice;

public enum ImageFilterEnum {

    EVERYDAY(0),
    PENETRATION(1),
    HIRES(2),
    NONE(3),
    STEEL(4);

    private int mImageFilterValue;
    ImageFilterEnum(int imageFilterValue) {
        this.mImageFilterValue = imageFilterValue;
    }

    public int getImageFilterValue() {

        return mImageFilterValue;
    }

    static public ImageFilterEnum getImageFilterValue(int id) {


        switch (id) {
            case R.id.everyday:
                return EVERYDAY;

            case R.id.penetration:
                return PENETRATION;

            case R.id.hiRes:
                return HIRES;

            case R.id.steel:
                return STEEL;

            default:
            case R.id.noFilter:
                return NONE;
        }
    }

    public void setImageFilterValue(int imageFilterValue) {
        this.mImageFilterValue = imageFilterValue;
    }
}
