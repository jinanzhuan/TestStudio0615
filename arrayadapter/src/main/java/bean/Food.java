package bean;

/**
 * Created by shuwei on 2016/6/15.
 */
public class Food {
    private int image;
    private String content;

    public Food() {
    }

    public Food(int image, String content) {
        this.image = image;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Food{" +
                "image=" + image +
                ", content='" + content + '\'' +
                '}';
    }
}
