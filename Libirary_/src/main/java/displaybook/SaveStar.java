package displaybook;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class SaveStar extends DisplayStar{

    @FXML
    ImageView star_1,star_2,star_3,star_4,star_5;
    Image star_1_image,star_2_image,star_3_image,star_4_image,star_5_image;
    private boolean resetStarBlooen=true,savedStars=false;
    Button back,borrowID;

    void save_Star_1()
    {
        savedStars=true;
        resetStarBlooen = false;
        star_1_image = new Image("star_fill.png");
        star_1.setImage(star_1_image);
    }
     void save_Star_2()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_1();
        star_2_image = new Image("star_fill.png");
        star_2.setImage(star_2_image);
    }
     void save_Star_3()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_2();
        star_3_image = new Image("star_fill.png");
        star_3.setImage(star_3_image);
    }
    public void save_Star_4()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_3();
        star_4_image = new Image("star_fill.png");
        star_4.setImage(star_4_image);
        resetStarBlooen = false;
    }
    public void save_Star_5()
    {
        savedStars=true;
        resetStarBlooen = false;
        display_Star_4();
        star_5_image = new Image("star_fill.png");
        star_5.setImage(star_5_image);
        resetStarBlooen = false;
    }
}
