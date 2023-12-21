package resourcesimports;

import javafx.scene.image.Image;

public class UserInterfaceIcons {
    public static final Image goBack = loadImage("/UserInterfaceIcons/BackIcon.png");
    public static final Image goBackOnHover = loadImage("/UserInterfaceIcons/BackIconOnHover.png");
    public static final Image goBackOnClick = loadImage("/UserInterfaceIcons/BackIconOnClick.png");
    public static final Image profile = loadImage("/UserInterfaceIcons/Profile.png");
    public static final Image profileOnHover = loadImage("/UserInterfaceIcons/ProfileOnHover.png");
    public static final Image profileOnClick = loadImage("/UserInterfaceIcons/ProfileOnClick.png");
    public static final Image shoppingCart = loadImage("/UserInterfaceIcons/ShoppingCart.png");
    public static final Image shoppingCartOnHover = loadImage("/UserInterfaceIcons/ShoppingCartHover.png");
    public static final Image shoppingCartOnClick = loadImage("/UserInterfaceIcons/ShoppingCartOnClick.png");
    public static final Image Star1 = loadImage("/UserInterfaceIcons/StarOutline_01.png");
    public static final Image Star2 = loadImage("/UserInterfaceIcons/StarOutline_02.png");
    public static final Image Star3 = loadImage("/UserInterfaceIcons/StarOutline_03.png");
    public static final Image Star4 = loadImage("/UserInterfaceIcons/StarOutline_04.png");
    public static final Image Star5 = loadImage("/UserInterfaceIcons/StarOutline_05.png");
    public static final Image Star1Selected = loadImage("/UserInterfaceIcons/Star_01.png");
    public static final Image Star2Selected = loadImage("/UserInterfaceIcons/Star_02.png");
    public static final Image Star3Selected = loadImage("/UserInterfaceIcons/Star_03.png");
    public static final Image Star4Selected = loadImage("/UserInterfaceIcons/Star_04.png");
    public static final Image Star5Selected = loadImage("/UserInterfaceIcons/Star_05.png");


    private static Image loadImage(String path) {
        return new Image(UserInterfaceIcons.class.getResource(path).toExternalForm());
    }
}
