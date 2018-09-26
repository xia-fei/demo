package java8;

import java.util.List;

/**
 * @author 夏飞
 */
public class ListWarp {
    private String name;
   private List<ListWarp> children;

    public String getName() {
        return name;
    }

    public ListWarp(String name) {
        this.name = name;
    }

    public List<ListWarp> getChildren() {
        return children;
    }

    public void setChildren(List<ListWarp> children) {
        this.children = children;
    }
}
