package zombieGame;

public interface Scenario {

    public String getDescription();
    public void getChoices();
    public void applyChoice(int choiceIndex);
}
