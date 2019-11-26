package com.fff.diyexception;

/**
 * @PackageName：com.fff.diyexcepution
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/26 22:24
 */
public class DiyException extends Exception {
    private String message;


    public DiyException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
