package pendu.engine;

import utils.DrawUtils;

/**
 * Game engine for hard difficulty mode.
 */
public class HardGameEngine extends AbstractGameEngine {

    private final static int HANG_SIZE = 10;

    /**
     * Constructor.
     *
     * @param wordTofind word to find.
     */
    HardGameEngine(String wordTofind) {
        super(wordTofind);
    }

    @Override
    protected void init() {
        nbFail = 0;
        nbFailAuthorized = 20;
        nbTry = 0;
    }

    /**
     * Method to check letter input
     *
     * @param readCharacter character input by user
     */
    public void checkLetter(String readCharacter) {
        // IF letter is in the word
        if (wordTofind.contains(readCharacter)) {
            for (int i = -1; (i = wordTofind.indexOf(readCharacter, i + 1)) != -1; i++) {
                // If occurence exist in word display
                // Continue loop;
                if (!currentWordState.substring(i, i + 1).contains(readCharacter)) {
                    currentWordState = currentWordState.substring(0, i) + readCharacter +
                            currentWordState.substring(i + 1);
                    break;
                }
            }
            // if word not contains '=' anymore, user won
            wordIsFind = !currentWordState.contains(CHARACTER_EMPTY_LETTER);
        } else {
            nbFail++;
        }
    }

    /**
     * display some texts to informe user.
     */
    public void displayInfo() {
        System.out.println("\nWord to find : " + currentWordState);
        System.out.println("Try number : " + nbTry + ", fails : " + nbFail);
        if (nbFail > HANG_SIZE) {
            System.out.println(DrawUtils.getDrawForThisLooseNumber(HANG_SIZE));
            System.out.println(DrawUtils.getDrawForThisLooseNumber(nbFail - HANG_SIZE));
        } else {
            System.out.println(DrawUtils.getDrawForThisLooseNumber(nbFail));
        }
    }

}
