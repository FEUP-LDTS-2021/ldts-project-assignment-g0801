import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Menu.SelectLevelMenu
import spock.lang.Specification;

class SelectLevelMenuTest extends Specification {

    private SelectLevelMenu menu;
    private Configuration configuration;

    def setup() {
        configuration = Mock(Configuration.class)
        menu = new SelectLevelMenu(configuration);
    }

    def "Initial level menu State"() {

        expect:
            menu.getCurrentSelect() == SelectLevelMenu.Option.LOWER;
            menu.getConfiguration() == configuration;
    }

    def "Position of options in level menu"() {

        expect:
            menu.getPosElem(a) == b;

        where:
            a                                | b
            SelectLevelMenu.Option.LOWER     | 0
            SelectLevelMenu.Option.INCREASE  | 1
            SelectLevelMenu.Option.BACK      | 2
    }

    def "Getting a string with options"() {

        expect:
            menu.enumToString(a) == b;

        where:
            a                                | b
            SelectLevelMenu.Option.LOWER     | "LOWER"
            SelectLevelMenu.Option.INCREASE  | "INCREASE"
            SelectLevelMenu.Option.BACK      | "BACK"
    }

    def "Select another option"() {

        when:
            menu.setSelected(SelectLevelMenu.Option.INCREASE);
        then:
            menu.getCurrentSelect() == SelectLevelMenu.Option.INCREASE;

        when:
            menu.setSelected(SelectLevelMenu.Option.BACK);
        then:
            menu.getCurrentSelect() == SelectLevelMenu.Option.BACK;
    }

    def "Return all options"() {

        expect:
            menu.getOpt()[a] == b

        where:
            a | b
            0 | SelectLevelMenu.Option.LOWER
            1 | SelectLevelMenu.Option.INCREASE
            2 | SelectLevelMenu.Option.BACK
    }

    def "Return all string options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "LOWER"
            1 | "INCREASE"
            2 | "BACK"
    }

    def "Upper Button Click"() {

        expect:
            menu.setSelected(a);
            menu.upButton();
            menu.getCurrentSelect() == b;

        where:
            a | b
            SelectLevelMenu.Option.LOWER | SelectLevelMenu.Option.BACK
            SelectLevelMenu.Option.INCREASE | SelectLevelMenu.Option.LOWER
            SelectLevelMenu.Option.BACK | SelectLevelMenu.Option.INCREASE
    }

    def "Down Button Click"() {

        expect:
            menu.setSelected(a);
            menu.downButton();
            menu.getCurrentSelect() == b;

        where:
            a | b
            SelectLevelMenu.Option.LOWER | SelectLevelMenu.Option.INCREASE
            SelectLevelMenu.Option.INCREASE | SelectLevelMenu.Option.BACK
            SelectLevelMenu.Option.BACK | SelectLevelMenu.Option.LOWER

    }
}