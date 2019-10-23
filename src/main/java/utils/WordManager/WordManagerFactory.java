package utils.WordManager;

/**
 * Word manager factory
 */
public class WordManagerFactory {

    /**
     * factory instance
     */
    private static WordManagerFactory instance;

    /**
     * Singleton
     *
     * @return word manager factory
     */
    public static WordManagerFactory getInstance() {
        if (instance == null) {
            instance = new WordManagerFactory();
        }
        return instance;
    }

    /**
     * Get good word manager for given paramaters
     *
     * @param isInternal      isInternal or External
     * @param pathForExternal path if external
     * @return the expected wordManager
     */
    public WordManager getWordManager(boolean isInternal, String pathForExternal) {
        WordManager retWordManager;
        if (isInternal) {
            retWordManager = new WordManagerInternal();
        } else {
            retWordManager = new WordManagerExternal(pathForExternal);
        }
        return retWordManager;
    }
}
