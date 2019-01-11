package demo.model;

import java.io.Serializable;
import java.util.List;

/**
* @Description 门店简介类目列表
* @Date  2018/12/27 21:07
* @auth zhouYang
*/
public class StoreCategoryRO implements Serializable {

    private static final long serialVersionUID = 484029185824482721L;
    /**
     * 图片类型
     */
    private String photoType;

    /**
     * 图片类别描述
     */
    private String photoTypeName;

    /**
     * 图片列表
     */
    private List<StorePhotoRO> photoUrls;

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public String getPhotoTypeName() {
        return photoTypeName;
    }

    public void setPhotoTypeName(String photoTypeName) {
        this.photoTypeName = photoTypeName;
    }

    public List<StorePhotoRO> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<StorePhotoRO> photoUrls) {
        this.photoUrls = photoUrls;
    }
}
