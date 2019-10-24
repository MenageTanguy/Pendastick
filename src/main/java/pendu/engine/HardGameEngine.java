package pendu.engine;

import utils.DrawManager;

public class HardGameEngine extends AbstractGameEngine {

    private final static int HANG_SIZE = 10;

    HardGameEngine(String wordTofind) {
        super(wordTofind);
    }

    @Override
    void init() {
        nbFail = 0;
        nbFailAuthorized = 20;
        nbTry = 0;
    }

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

    public void displayInfo() {
        System.out.println("\nWord to find : " + currentWordState);
        System.out.println("Try number : " + nbTry + ", fails : " + nbFail);
        if (nbFail > HANG_SIZE) {
            System.out.println(DrawManager.instance.getDrawForThisLooseNumber(HANG_SIZE));
            System.out.println(DrawManager.instance.getDrawForThisLooseNumber(nbFail - HANG_SIZE));
        } else {
            System.out.println(DrawManager.instance.getDrawForThisLooseNumber(nbFail));
        }
    }

}
