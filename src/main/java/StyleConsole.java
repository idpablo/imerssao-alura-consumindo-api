import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Attribute.*;

public class StyleConsole {

       private Attribute[] idRating = new Attribute[]{BLACK_TEXT(), CYAN_BACK()};
       private Attribute[] star = new Attribute[]{YELLOW_TEXT(), DIM()};
       private Attribute[] text = new Attribute[]{OVERLINED(), SLOW_BLINK()};
       private Attribute[] crew = new Attribute[]{STRIKETHROUGH(), SLOW_BLINK()};

    public Attribute[] getIdRating() {
        return idRating;
    }

    public Attribute[] getStar() {
        return star;
    }

    public Attribute[] getText() {
        return text;
    }

    public Attribute[] getCrew() {
        return crew;
    }
}
