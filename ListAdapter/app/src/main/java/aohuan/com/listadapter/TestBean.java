package aohuan.com.listadapter;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class TestBean {
    private String name;
    private String icon;

    public TestBean(String name, String icon) {
        this.icon = icon;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
