package pendu.engine;

import utils.DrawManager;

public class SimpleGameEngine extends AbstractGameEngine {


    SimpleGameEngine(String wordTofind) {
        super(wordTofind);
    }

    @Override
    void init() {
        nbFail = 0;
        nbFailAuthorized = 10;
        nbTry = 0;
    }

    public void checkLetter(String readCharacter) {
        // IF letter is in the word
        if (wordTofind.contains(readCharacter)) {
            for (int i = -1; (i = wordTofind.indexOf(readCharacter, i + 1)) != -1; i++) {
                currentWordState = currentWordState.substring(0, i) + readCharacter + currentWordState.substring(i + 1);
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
        System.out.println(DrawManager.instance.getDrawForThisLooseNumber(nbFail));
    }


}
