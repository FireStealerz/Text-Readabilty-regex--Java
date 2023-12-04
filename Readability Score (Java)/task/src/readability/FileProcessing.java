package readability;

import java.text.DecimalFormat;

public class FileProcessing {

    public int words;
    public int sentences;
    public int characters;
    public int syllables;
    public int polysyllables;
    private double score;
    private String ageRange;

    private double FKscore;

    private String FKageRange;

    private double SMOGscore;

    private String SMOGageRange;

    private double COLEscore;

    private String COLEageRange;

    public double getSMOGscore() {
        return SMOGscore;
    }

    private void setSMOGscore(double SMOGscore) {
        this.SMOGscore = SMOGscore;
    }

    public String getSMOGageRange() {
        return SMOGageRange;
    }

    private void setSMOGageRange(String SMOGageRange) {
        this.SMOGageRange = SMOGageRange;
    }

    public double getCOLEscore() {
        return COLEscore;
    }

    private void setCOLEscore(double COLEscore) {
        this.COLEscore = COLEscore;
    }

    public String getCOLEageRange() {
        return COLEageRange;
    }

    private void setCOLEageRange(String COLEageRange) {
        this.COLEageRange = COLEageRange;
    }

    public double getFKscore() {
        return FKscore;
    }

    private void setFKscore(double FKscore) {
        this.FKscore = FKscore;
    }

    public String getFKageRange() {
        return FKageRange;
    }

    private void setFKageRange(String FKageRange) {
        this.FKageRange = FKageRange;
    }

    double getScore() {
        return score;
    }

    private void setScore(double score) {
        this.score = score;
    }

    String getAgeRange() {
        return ageRange;
    }

    private void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

        protected int getSyllables() {
        return syllables;
    }

    protected void setSyllables(int syllables) {
        this.syllables = syllables;
    }

    protected int getPolySyllables() {
        return polysyllables;
    }

    protected void setPolySyllables(int polysyllables) {
        this.polysyllables = polysyllables;
    }

    protected int getWords() {
        return words;
    }

    protected void setWords(int words) {
        this.words = words;
    }

    protected int getSentences() {
        return sentences;
    }

    protected void setSentences(int sentences) {
        this.sentences = sentences;
    }

    protected int getCharacters() {
        return characters;
    }

    protected void setCharacters(int characters) {
        this.characters = characters;
    }

    private int sentences(String text) {
        int totalSentences;
        String[] sentences = text.split("[.?!]");
        totalSentences = sentences.length;
        return totalSentences;
    }

    private int words(String text) {
        int totalWords;
        String[] words = text.split(" ");
        totalWords = words.length;
        return  totalWords;
    }

    private int characters(String text) {
        int totalCharacters;
        //String[] characters = text.split("\\S[.?!]");
        return text.replaceAll(" |\n|\t","").split("").length;
        //return totalCharacters = characters.length;
    }

    private int syllables(String text) {
        String[] words = text.split(" ");
        int doubleSyllables = 0;
        int syllables = 0;
        int iterator = 0;
        for (String word:
             words) {
            char[] newWord = word.toCharArray();
            for (int i = 0; i < newWord.length; i++) {
                if(newWord[i] == 'a' || newWord[i] == 'e' || newWord[i] == 'i' ||
                newWord[i] == 'o' || newWord[i] == 'u' || newWord[i] == 'y'){
                    if (newWord[i] == 'e' && i == (newWord.length - 1)) {
                        continue;
                    }
                    iterator++;
                    doubleSyllables++;
                    if (doubleSyllables == 1) {
                        syllables++;
                    } else {
                        doubleSyllables = 0;
                    }
                }else doubleSyllables =0;
            }
            if (iterator == 0) {
                syllables++;
            }
            iterator = 0;
        }
        return syllables;
    }

    private int polySyllables(String text) {
        String[] words = text.split(" ");
        int doubleSyllables = 0;
        int syllables = 0;
        int iterator = 0;
        int pollySyllables = 0;
        int pollyPolly = 0;
        for (String word:
                words) {
            char[] newWord = word.toCharArray();
            for (int i = 0; i < newWord.length; i++) {
                if(newWord[i] == 'a' || newWord[i] == 'e' || newWord[i] == 'i' ||
                        newWord[i] == 'o' || newWord[i] == 'u' || newWord[i] == 'y'){
                    iterator++;
                    doubleSyllables++;
                    if (doubleSyllables == 1) {
                        syllables++;
                        pollySyllables++;
                    } else {
                        doubleSyllables = 0;
                    }
                }else doubleSyllables = 0;
            }
            if (iterator == 0) {
                syllables++;
            }
            if (newWord[newWord.length - 1] == 'e')  {
                syllables--;
                pollySyllables--;
            }
            if (pollySyllables >= 3) {
                pollyPolly++;
            }
            pollySyllables = 0;
            iterator = 0;
        }
        return pollyPolly;
    }

    public void fileProccessing(String text) {
        setSentences(sentences(text));
        setWords(words(text));
        setCharacters(characters(text));
        setSyllables(syllables(text));
        setPolySyllables(polySyllables(text));
        setScore(ari(getCharacters(),getWords(),getSentences()));
        setAgeRange(ariAge(getScore()));
        setFKscore(FKscore(getWords(),getSentences(),getSyllables()));
        setFKageRange(ariAge(getFKscore()));
        setSMOGscore(SMOGscore(getPolySyllables(),getSentences()));
        setSMOGageRange(ariAge(getSMOGscore()));
        setCOLEscore(COLE_LIAU(getCharacters(),getWords() ,getSentences()));
        setCOLEageRange(ariAge(getCOLEscore()));
    }



    private double ari(int characters, int words, int sentences) {
        double ari;
        return ari = 4.71 * characters/words + 0.5 * words/sentences - 21.43;
    }

    private double FKscore(int words, int sentences, int syllables) {
        double FKscore;
        return FKscore = 0.39 * words/sentences + 11.8 * syllables/words;
    }

    private double SMOGscore(int polysyllables, int sentences) {
        double SMOGscore;
        return SMOGscore = 1.043 * Math.sqrt((double) (polysyllables * 30) /sentences) + 3.1291;
    }

    private double COLE_LIAU(int characters,int words, int sentences) {
        double COLE_LIAU;
        return COLE_LIAU = 0.0588 * getCharacters()/getWords() * 100 - 0.296 * getSentences()/getWords() * 100 -15.8;
    }

    private static String ariAge(double ARI) {
        Math.ceil(ARI);
        if (ARI >= 1 && ARI<2) {
            return "7";
        } else if (ARI >= 2 && ARI < 3) {
            return "8";
        }else if (ARI >= 3 && ARI < 4) {
            return "9";
        }else if (ARI >= 4 && ARI < 5) {
            return "10";
        }else if (ARI >= 5 && ARI < 6) {
            return "11";
        }else if (ARI >= 6 && ARI < 7) {
            return "12";
        }else if (ARI >= 7 && ARI < 8) {
            return "13";
        }else if (ARI >= 8 && ARI < 9) {
            return "14";
        }else if (ARI >= 9 && ARI < 10) {
            return "15";
        }else if (ARI >= 10 && ARI < 11) {
            return "16";
        }else if (ARI >= 11 && ARI < 12) {
            return "17";
        }else if (ARI >= 12 && ARI < 13) {
            return "18";
        }else if (ARI >= 13 && ARI < 14) {
            return "22";
        }else if (ARI >= 14) {
            return "22";
        }
        return "ariAge could not find matching range! (bug)";
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return  "Words: " + getWords() +
                "\nSentences: " + getSentences() +
                "\nCharacters: " + getCharacters() +
                "\nSyllables: " + getSyllables() +
                "\nPolysyllables: " +  getPolySyllables() +
                "\nEnter the score you want to calculate (ARI, FK, SMOG, CL, all):\n";
    }
}
