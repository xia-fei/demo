package demo.model;

import java.io.Serializable;

/**
* @Description 门店图片RO
* @Date  2018/12/25 11:38
* @auth zhouYang
*/
public class StorePhotoRO implements Serializable {
    private static final long serialVersionUID = 6777481906541229777L;

    /**
     * 图片地址 缩略图 ,h_600,w_600.jpg
     */
    private String url;

    /**
     * 图片描述
     */
    private String value;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
